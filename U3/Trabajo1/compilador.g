grammar compilador;

@header  {
         import java.util.HashMap;
      }
@members {
         HashMap SymT = new HashMap();
         HashMap<String, Integer> methodCalls = new HashMap<>(); // Track method calls
         HashMap<String, String> methodDeclarations = new HashMap<>(); // Track method declarations
         HashMap<String, Double> constVals = new HashMap<>(); // Track constant values for variables

         private void pushID(String id, String tipo){
            System.out.println("Insertando a TS:"+id+" con tipo: "+tipo);

            Integer existe = (Integer) SymT.get(id);
                  if(existe==null)
                        if(tipo.compareTo("int")==0)      SymT.put(id,1);
                        else if(tipo.compareTo("double")==0)SymT.put(id,2);
                        else SymT.put(id,3);

                  else System.out.println("ID: "+id+" ya declarado");
         }

         private void declareMethod(String methodName, String returnType) {
            methodDeclarations.put(methodName, returnType);
            methodCalls.put(methodName, 0); // Initialize call count
         }

         private void recordMethodCall(String methodName) {
            Integer calls = methodCalls.get(methodName);
            if (calls != null) {
               methodCalls.put(methodName, calls + 1);
            } else {
               // If method was not declared yet, record the call so we don't lose it
               methodCalls.put(methodName, 1);
            }
         }

         private void setConstValue(String varName, double val) {
            constVals.put(varName, val);
         }

         private void removeConstValue(String varName) {
            constVals.remove(varName);
         }

         private void analyzeMethodUsage() {
            System.out.println("\n=== Análisis de Uso de Métodos (Optimización UNFOLDING) ===");
            for (String method : methodDeclarations.keySet()) {
                int calls = methodCalls.get(method);
                if (calls == 0) {
                    System.out.println("⚠️  ADVERTENCIA: El método '" + method + "' nunca es llamado y puede ser eliminado");
                } else if (calls == 1) {
                    System.out.println("✓ OPTIMIZACIÓN: El método '" + method + "' es llamado una sola vez - considera inlinearlo");
                }
            }
            System.out.println("================================================\n");

            // Clear method maps for the next class to avoid cross-class accumulation
            methodCalls.clear();
            methodDeclarations.clear();
         }

         private int getSymbolType(String id) {
            Integer type = (Integer) SymT.get(id);
            if (type == null) {
                System.out.println("❌ ERROR: Variable '" + id + "' no fue declarada");
                return 3; // default to type 3 (error/undefined)
            }
            return type;
         }



      }

program        : classes+ ;



classes          : accessmod CLASS ID
                                     OCURLYB
                                        member*
                                     CCURLYB 
                                     { analyzeMethodUsage(); } ; // Analyze method usage at end of class


member         :  method | attributes;
attributes     :  accessmod tipo id1=ID ( '=' e1=expr { pushID($id1.text,$tipo.text); if ($e1.isConst) System.out.println("📊 BTA (Binding Time Analysis): Línea " + $id1.getLine() + " puede ser reducida a: " + $e1.constVal); } )?
                         (COMMA id2=ID ( '=' e2=expr { pushID($id2.text,$tipo.text); if ($e2.isConst) System.out.println("📊 BTA (Binding Time Analysis): Línea " + $id2.getLine() + " puede ser reducida a: " + $e2.constVal); } )?)* SEMICOLON ; //DECLARACIONES DE ATRIBUTO DE CLASES

                //public int metodo (int a int b){}
method         : accessmod tipo id=ID '(' decl_args?  ')'
                        { declareMethod($id.text, $tipo.text); }
                        OCURLYB   sentences*   CCURLYB { SymT.clear(); constVals.clear(); }  ;

                  //int a,b,c ;
variables_local: tipo id1=ID ( '=' e1=expr { pushID($id1.text,$tipo.text); if ($e1.isConst) { System.out.println("📊 BTA (Binding Time Analysis): Línea " + $id1.getLine() + " puede ser reducida a: " + $e1.constVal); setConstValue($id1.getText(), $e1.constVal); } } )?
                  (COMMA id2=ID ( '=' e2=expr { pushID($id2.text,$tipo.text); if ($e2.isConst) { System.out.println("📊 BTA (Binding Time Analysis): Línea " + $id2.getLine() + " puede ser reducida a: " + $e2.constVal); setConstValue($id2.getText(), $e2.constVal); } } )? )* SEMICOLON ;

                //  double x , int a, int b
decl_args      : t1=tipo id1=ID {pushID($id1.text,$t1.text);} (COMMA t2=tipo id2=ID {pushID($id2.text,$t2.text);})*;

sentences      :  asignacion | variables_local ; //TAREA AGREGAR DECLARACION DE VARIABLES LOCALES
asignacion     :  id=ID  '=' expr SEMICOLON
                  {
                     if ($expr.isConst) {
                        System.out.println("📊 BTA (Binding Time Analysis): Línea " + $id.getLine() + " puede ser reducida a: " + $expr.constVal);
                        setConstValue($id.getText(), $expr.constVal);
                     } else {
                        // assignment is not constant, remove any previous const value
                        removeConstValue($id.getText());
                     }
                  };

expr  returns [int vType, boolean isConst, double constVal]
                      :  m1=multExpr { $vType=$m1.vType; $isConst=$m1.isConst; $constVal=$m1.constVal; }
                        ( op=('+'|'-') m2=multExpr
                        {
                           if($vType != $m2.vType) $vType=3;
                           if ($isConst && $m2.isConst) {
                                 if ($op.getText().equals("+")) $constVal = $constVal + $m2.constVal;
                                 else $constVal = $constVal - $m2.constVal;
                                 $isConst = true;
                           } else {
                                 $isConst = false;
                           }
                        }
                        )*;

                              //atomo('*' atomo)*
multExpr returns [int vType, boolean isConst, double constVal]
            :  a1=atomo { $vType=$a1.vType; $isConst=$a1.isConst; $constVal=$a1.constVal; }
            ( '*' a2=atomo
            {
              if($vType != $a2.vType) $vType=3;
              if ($isConst && $a2.isConst) {
                 $constVal = $constVal * $a2.constVal;
                 $isConst = true;
              } else {
                 $isConst = false;
              }
            }

            )*;

atomo returns [int vType, boolean isConst, double constVal]
               :  CINT { $vType=1; $isConst=true; $constVal=Double.parseDouble($CINT.getText()); }
               |  CFLOAT { $vType=2; $isConst=true; $constVal=Double.parseDouble($CFLOAT.getText()); }
               |  id=ID '(' listaArgs? ')' { recordMethodCall($id.text); $vType=1; $isConst=false; $constVal=0; } // Method call
                |  ID { $vType=getSymbolType($ID.text); 
                   Double cv = (Double) constVals.get($ID.text);
                   if (cv != null) { $isConst = true; $constVal = cv.doubleValue(); } else { $isConst=false; $constVal=0; } }
               |  '(' e=expr ')' { $vType=$e.vType; $isConst=$e.isConst; $constVal=$e.constVal; } ; 

listaArgs      : expr (COMMA expr)*;

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
