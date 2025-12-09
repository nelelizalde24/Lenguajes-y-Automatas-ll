import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        exprLexer lexer = new exprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        exprParser parser = new exprParser(tokens);
        parser.prog();

    }
}
