grammar expresiones;

@members {  java.util.Set<String> idsUnicos = new java.util.HashSet<>();

}
instrucciones  :  asignacion+ {
                    System.out.println("Identificadores encontrados:");
                    for (String id : idsUnicos) {
                        System.out.println("ID : " + id);
                    }};
asignacion     :  ID  '=' expr SEMICOLON {
        idsUnicos.add($ID.getText());
    };

expr           :  multExpr (('+'|'-')multExpr)*;
multExpr       :  atomo ('*' atomo)*;

atomo          :  CINT
               |  CFLOAT
               |  ID {
                    idsUnicos.add($ID.getText());
                    }
               |  '(' expr ')';


SEMICOLON      : ';' ;
DOT            : '.' ;
CINT           : ('0'..'9')+;
CFLOAT         : CINT DOT CINT;
ID             : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS             : (' ' | '\n' | '\t' | '\r') + {$channel=HIDDEN; } ;
