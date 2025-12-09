grammar MiLenguaje;

// Regla inicial (punto de entrada)
prog:   stat+ ;

stat:   asign ';' 
    |   expr ';' 
    ;

asign:  ID '=' expr ;

expr:   expr ('*'|'/') expr 
    |   expr ('+'|'-') expr 
    |   INT 
    |   ID 
    |   '(' expr ')' 
    ;

// Tokens léxicos
ID  :   [a-zA-Z]+ ;
INT :   [0-9]+ ;
WS  :   [ \t\r\n]+ -> skip ;
