grammar ejercicio1;

programa   : intruccion+ ;
intruccion :  llamada {
                        System.out.println("Llamada");

        } | asignacion {
                        System.out.println("Asignacion");
        } ;
llamada    : 'call' ID ';' ;
asignacion : ID '=' ID ';' ;

ID                : ('a'..'z') ('a'..'z'|'0'..'9')* ;
WS                : (' ' | '\n' | '\t' | '\r' ) + {$channel=HIDDEN; } ;
