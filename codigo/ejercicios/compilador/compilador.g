grammar compilador;

@header  { }
@members { }

program        : classes+ ;

    

classes          : accessmod CLASS ID 
                                     OCURLYB 
                                        member*
                                     CCURLYB ;


member         :  method | attributes; 
attributes     :  accessmod tipo ID (COMMA ID)* SEMICOLON ; //AGREGAR DECLARACIONES DE ATRIBUTO DE CLASES

                //public int metodo (int a int b){}
method         :  accessmod tipo ID '(' decl_args?  ')'
                            OCURLYB   
                            sentences*   
                            CCURLYB;

                  //int a,b,c ;
variables_local: tipo ID (COMMA ID)* SEMICOLON ;

                //  double x , int a, int b 
decl_args      : tipo ID (COMMA tipo ID)*;

sentences      :  asignacion | variables_local ; //TAREA AGREGAR DECLARACION DE VARIABLES LOCALES
asignacion     :  ID  '=' expr SEMICOLON ;

expr           :  multExpr (('+'|'-')multExpr)*;
multExpr       :  atomo ('*' atomo)*;

atomo          :  CINT
               |  CFLOAT
               |  ID 
               |  '(' expr ')';

tipo           : INT | DOUBLE | STRING ;
accessmod      : PUBLIC | PRIVATE | PROTECTED ;
INT            : 'int' ;
DOUBLE         : 'double' ;
STRING         : 'String' ;
PUBLIC         : 'public' ;
PRIVATE        : 'private ' ;
PROTECTED      : 'protected ' ;
OCURLYB        : '{' ;
CCURLYB        : '}' ;
CLASS          : 'class' ;

COMMA          : ',' ;
SEMICOLON      : ';' ;
DOT            : '.' ;
CINT           : ('0'..'9')+;
CFLOAT         : CINT DOT CINT;
ID             : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS             : (' ' | '\n' | '\t' | '\r') + {$channel=HIDDEN; } ;