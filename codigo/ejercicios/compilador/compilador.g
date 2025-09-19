grammar compilador;

@header  { 
         import java.util.HashMap;
      }
@members { 
         HashMap SymT = new HashMap();

         private void pushID(String id, String tipo){
            System.out.println("Insertando a TS:"+id+" con tipo: "+tipo);

            Integer existe = (Integer) SymT.get(id);
                  if(existe==null)
                        if(tipo.compareTo("int")==0)      SymT.put(id,1);
                        else if(tipo.compareTo("double")==0)SymT.put(id,2);
                        else SymT.put(id,3);
                  
                  else System.out.println("ID: "+id+" ya declarado");
         }
      }

program        : classes+ ;

    

classes          : accessmod CLASS ID 
                                     OCURLYB 
                                        member*
                                     CCURLYB ;


member         :  method | attributes; 
attributes     :  accessmod tipo ID (COMMA ID)* SEMICOLON ; //AGREGAR DECLARACIONES DE ATRIBUTO DE CLASES

                //public int metodo (int a int b){}
method         :  accessmod tipo ID '(' decl_args?  ')'
                            OCURLYB   sentences*   CCURLYB;

                  //int a,b,c ;
variables_local: tipo id1=ID {pushID($id1.text,$tipo.text);} (COMMA id2=ID {pushID($id2.text,$tipo.text);})* SEMICOLON ;

                //  double x , int a, int b 
decl_args      : t1=tipo id1=ID {pushID($id1.text,$t1.text);} (COMMA t2=tipo id2=ID {pushID($id2.text,$t2.text);})*;

sentences      :  asignacion | variables_local ; //TAREA AGREGAR DECLARACION DE VARIABLES LOCALES
asignacion     :  ID  '=' expr SEMICOLON ;

expr  returns [int vType ]         
               :  m1=multExpr {$vType=$m1.vType;}
                (('+'|'-') m2=multExpr
                {
                  if($m1.vType != $m2.vType) $vType=3;
                }
                )*;

                              //atomo('*' atomo)*
multExpr returns [int vType ]
               :  a1=atomo{$vType=$a1.vType;} 
               ('*' a2=atomo
               {
                  if($a1.vType != $a2.vType) $vType=3;
               }
               
               )*;

atomo returns [int vType ]   
               :  CINT { $vType=1; }
               |  CFLOAT { $vType=2; }
               |  ID {/*buscar en la tabla de simbolos*/}
               |  '(' expr ')' { $vType=$expr.vType; } ; 

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