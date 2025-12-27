import java.util.*;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class SemanticAnalyzer3 {
    private final SymTG symtg = new SymTG();
    private SymTG.ClassInfo currentClass = null;
    private SymT currentSymT = null;
    private final List<String> errors = new ArrayList<>();

    public List<String> analyze(CommonTree root) {
        errors.clear();
        visit(root);
        return errors;
    }

    private void visit(Tree t) {
        if (t == null) return;
        String node = t.toString();
        switch (node) {
            case "CLASS": handleClass((CommonTree)t); break;
            case "FIELD": handleField((CommonTree)t); break;
            case "METHOD": handleMethod((CommonTree)t); break;
            case "BLOCK": handleBlock((CommonTree)t); break;
            case "LOCALDECL": handleLocalDecl((CommonTree)t); break;
            case "ASSIGN": handleAssign((CommonTree)t); break;
            case "IF":
            case "IFCOND": handleIf((CommonTree)t); break;
            case "WHILE":
            case "WHILECOND": handleWhile((CommonTree)t); break;
            case "EXPR":
            case "BINOP":
            case "IDNODE":
            case "DOUBLE_LIT":
            case "INT_LIT":
            case "BOOL_LIT":
                // expressions handled when parent needs them
                break;
            default:
                // recurse children
                for (int i = 0; i < t.getChildCount(); i++) visit(t.getChild(i));
        }
    }

    private void handleClass(CommonTree t) {
        if (t.getChildCount() < 1) return;
        CommonTree idn = (CommonTree)t.getChild(0);
        String name = idn.getText();
        if (!symtg.addClass(name)) {
            int line = getLine(idn);
            errors.add("Error: Redeclaración de clase '"+name+"' línea "+line);
        }
        currentClass = symtg.getClass(name);
        // visit members
        for (int i=1;i<t.getChildCount();i++) visit(t.getChild(i));
        currentClass = null;
    }

    private void handleField(CommonTree t) {
        if (currentClass == null) return;
        // children: type, VARS
        CommonTree type = (CommonTree)t.getChild(0);
        CommonTree vars = (CommonTree)t.getChild(1);
        String tname = type.getText();
        for (int i=0;i<vars.getChildCount();i++) {
            String id = vars.getChild(i).getText();
            if (currentClass.fields.containsKey(id)) {
                errors.add("Error: Redeclaración de atributo '"+id+"' línea "+getLine(vars.getChild(i)) );
            } else currentClass.fields.put(id, tname);
        }
    }

    private void handleMethod(CommonTree t) {
        // children: ID, typeOrVoid, paramList?, block
        if (currentClass == null) return;
        CommonTree idn = (CommonTree)t.getChild(0);
        String name = idn.getText();
        if (currentClass.methods.containsKey(name)) {
            errors.add("Error: Redeclaración de método '"+name+"' línea "+getLine(idn));
            return;
        }
        String ret = t.getChild(1).getText();
        SymTG.MethodInfo mi = new SymTG.MethodInfo(ret);
        currentClass.methods.put(name, mi);
        currentSymT = new SymT();
        // params if present
        int idx = 2;
        if (t.getChild(idx).getText().equals("PARAMLIST")) {
            CommonTree plist = (CommonTree)t.getChild(idx);
            for (int i=0;i<plist.getChildCount();i++) {
                CommonTree p = (CommonTree)plist.getChild(i);
                String ptype = p.getChild(0).getText();
                String pid = p.getChild(1).getText();
                mi.paramTypes.add(ptype);
                if (!currentSymT.add(pid, ptype)) {
                    errors.add("Error: Redeclaración de parámetro/local '"+pid+"' en método '"+name+"' línea "+getLine(p));
                }
            }
            idx++;
        }
        // block
        visit(t.getChild(idx));
        currentSymT = null;
    }

    private void handleBlock(CommonTree t) {
        for (int i=0;i<t.getChildCount();i++) {
            visit(t.getChild(i));
        }
    }

    private void handleLocalDecl(CommonTree t) {
        if (currentSymT == null) return;
        CommonTree type = (CommonTree)t.getChild(0);
        CommonTree vars = (CommonTree)t.getChild(1);
        String tname = type.getText();
        for (int i=0;i<vars.getChildCount();i++) {
            String id = vars.getChild(i).getText();
            if (!currentSymT.add(id, tname)) {
                errors.add("Error: Redeclaración de variable local '"+id+"' línea "+getLine(vars.getChild(i)));
            }
        }
        // rhs expr may be present as child 2
        if (t.getChildCount()>=3) visit(t.getChild(2));
    }

    private void handleAssign(CommonTree t) {
        // children: ID expr
        CommonTree idn = (CommonTree)t.getChild(0);
        CommonTree expr = (CommonTree)t.getChild(1);
        String id = idn.getText();
        String lhsType = lookupIdType(id);
        // check declared
        if (lhsType == null) errors.add("Error: Uso de variable no declarada '"+id+"' línea "+getLine(idn));
        String rhsType = inferExprType(expr);
        if (lhsType!=null && rhsType!=null && !lhsType.equals(rhsType)) {
            errors.add("Error: Asignación de tipo '"+rhsType+"' a ID de tipo '"+lhsType+"' línea "+getLine(idn));
        }
        visit(expr);
    }

    private void handleIf(CommonTree t) {
        // IFCOND: expr statement (statement)?
        CommonTree expr = (CommonTree)t.getChild(0);
        String et = inferExprType(expr);
        if (et==null || !et.equals("boolean")) errors.add("Error: Condición de if no booleana línea "+getLine(expr));
        visit(t.getChild(1));
        if (t.getChildCount()>2) visit(t.getChild(2));
    }

    private void handleWhile(CommonTree t) {
        CommonTree expr = (CommonTree)t.getChild(0);
        String et = inferExprType(expr);
        if (et==null || !et.equals("boolean")) errors.add("Error: Condición de while no booleana línea "+getLine(expr));
        visit(t.getChild(1));
    }

    private String inferExprType(CommonTree expr) {
        if (expr==null) return null;
        String node = expr.getText();
        if (node.equals("INT_LIT")) return "int";
        if (node.equals("DOUBLE_LIT")) return "double";
        if (node.equals("BOOL_LIT")) return "boolean";
        if (node.equals("IDNODE")) {
            String id = expr.getChild(0).getText();
            return lookupIdType(id);
        }
        if (node.equals("BINOP") || node.equals("EXPR")) {
            String left = inferExprType((CommonTree)expr.getChild(0));
            String right = inferExprType((CommonTree)expr.getChild(1));
            if (left==null || right==null) return null;
            if (left.equals("double") || right.equals("double")) {
                if ((left.equals("int")||left.equals("double")) && (right.equals("int")||right.equals("double"))) return "double";
            }
            if (left.equals(right)) return left;
            return null;
        }
        // default: try children
        for (int i=0;i<expr.getChildCount();i++) {
            String t = inferExprType((CommonTree)expr.getChild(i));
            if (t!=null) return t;
        }
        return null;
    }

    private String lookupIdType(String id) {
        if (currentSymT!=null && currentSymT.contains(id)) return currentSymT.lookup(id);
        if (currentClass!=null && currentClass.fields.containsKey(id)) return currentClass.fields.get(id);
        return null;
    }

    private int getLine(Tree n) {
        if (n instanceof CommonTree) {
            CommonTree ct = (CommonTree)n;
            if (ct.getToken()!=null) return ct.getToken().getLine();
        }
        return -1;
    }
}
