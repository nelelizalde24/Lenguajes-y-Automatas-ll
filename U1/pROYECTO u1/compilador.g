

// Consolidated ANTLR v3 grammar (classic .g)
grammar compilador;

options { output=AST; }

@header {
  import java.util.HashMap;
}

@members {
  HashMap SymT = new HashMap();

  private void pushID(String id, String tipo) {
    Integer existe = (Integer) SymT.get(id);
    if (existe == null) {
      if ("int".equals(tipo)) SymT.put(id, 1);
      else if ("double".equals(tipo)) SymT.put(id, 2);
      else SymT.put(id, 3);
    } else System.out.println("ID: " + id + " ya declarado");
  }

  private int getSymbolType(String id) {
    Integer t = (Integer) SymT.get(id);
    return t == null ? -1 : t;
  }
}

program : classes+ ;

classes : accessmod 'class' ID '{' member* '}' ;

member : method | attributes ;

attributes : accessmod tipo ID (',' ID)* ';' ;

method : accessmod tipo ID '(' decl_args? ')' '{' sentences* '}' { SymT.clear(); } ;

variables_local
    : tipo id1=ID { pushID($id1.text,$tipo.text); } (',' id2=ID { pushID($id2.text,$tipo.text); })* ';'
    ;

decl_args
    : t1=tipo id1=ID { pushID($id1.text,$t1.text); } (',' t2=tipo id2=ID { pushID($id2.text,$t2.text); })*
    ;

sentences : asignacion | variables_local ;
asignacion : ID '=' expr ';' ;

expr returns [int vType]
    : m1=multExpr { $vType = $m1.vType; }
      ( ('+'|'-') m2=multExpr { if ($vType != $m2.vType) $vType = 3; } )*
    ;

multExpr returns [int vType]
    : a1=atomo { $vType = $a1.vType; }
      ( '*' a2=atomo { if ($vType != $a2.vType) $vType = 3; } )*
    ;

atomo returns [int vType]
    : CINT { $vType = 1; }
    | CFLOAT { $vType = 2; }
    | ID { $vType = getSymbolType($ID.text); }
    | '(' expr ')' { $vType = $expr.vType; }
    ;

tipo : 'int' | 'double' | 'String' ;
accessmod : 'public' | 'private' | 'protected' ;

// Lexer
CINT : ('0'..'9')+ ;
CFLOAT : CINT '.' CINT ;
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

WS : (' ' | '\n' | '\t' | '\r')+ { $channel = HIDDEN; } ;
