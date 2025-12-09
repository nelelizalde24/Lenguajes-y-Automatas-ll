// $ANTLR 3.5.2 compilador.g 2025-12-08 12:56:19

         import java.util.HashMap;
      

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class compiladorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CCURLYB", "CFLOAT", "CINT", "CLASS", 
		"COMMA", "DOT", "DOUBLE", "ID", "INT", "OCURLYB", "PRIVATE", "PROTECTED", 
		"PUBLIC", "SEMICOLON", "STRING", "WS", "'('", "')'", "'*'", "'+'", "'-'", 
		"'='"
	};
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int CCURLYB=4;
	public static final int CFLOAT=5;
	public static final int CINT=6;
	public static final int CLASS=7;
	public static final int COMMA=8;
	public static final int DOT=9;
	public static final int DOUBLE=10;
	public static final int ID=11;
	public static final int INT=12;
	public static final int OCURLYB=13;
	public static final int PRIVATE=14;
	public static final int PROTECTED=15;
	public static final int PUBLIC=16;
	public static final int SEMICOLON=17;
	public static final int STRING=18;
	public static final int WS=19;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public compiladorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public compiladorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return compiladorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "compilador.g"; }


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



	      


	// $ANTLR start "program"
	// compilador.g:77:1: program : ( classes )+ ;
	public final void program() throws RecognitionException {
		try {
			// compilador.g:77:16: ( ( classes )+ )
			// compilador.g:77:18: ( classes )+
			{
			// compilador.g:77:18: ( classes )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= PRIVATE && LA1_0 <= PUBLIC)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// compilador.g:77:18: classes
					{
					pushFollow(FOLLOW_classes_in_program29);
					classes();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "classes"
	// compilador.g:81:1: classes : accessmod CLASS ID OCURLYB ( member )* CCURLYB ;
	public final void classes() throws RecognitionException {
		try {
			// compilador.g:81:18: ( accessmod CLASS ID OCURLYB ( member )* CCURLYB )
			// compilador.g:81:20: accessmod CLASS ID OCURLYB ( member )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_classes50);
			accessmod();
			state._fsp--;

			match(input,CLASS,FOLLOW_CLASS_in_classes52); 
			match(input,ID,FOLLOW_ID_in_classes54); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_classes93); 
			// compilador.g:83:41: ( member )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= PRIVATE && LA2_0 <= PUBLIC)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// compilador.g:83:41: member
					{
					pushFollow(FOLLOW_member_in_classes135);
					member();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,CCURLYB,FOLLOW_CCURLYB_in_classes175); 
			 analyzeMethodUsage(); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "classes"



	// $ANTLR start "member"
	// compilador.g:88:1: member : ( method | attributes );
	public final void member() throws RecognitionException {
		try {
			// compilador.g:88:16: ( method | attributes )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= PRIVATE && LA3_0 <= PUBLIC)) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==DOUBLE||LA3_1==INT||LA3_1==STRING) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==ID) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==20) ) {
							alt3=1;
						}
						else if ( (LA3_3==COMMA||LA3_3==SEMICOLON||LA3_3==25) ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// compilador.g:88:19: method
					{
					pushFollow(FOLLOW_method_in_member235);
					method();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:88:28: attributes
					{
					pushFollow(FOLLOW_attributes_in_member239);
					attributes();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "member"



	// $ANTLR start "attributes"
	// compilador.g:89:1: attributes : accessmod tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON ;
	public final void attributes() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope tipo1 =null;

		try {
			// compilador.g:89:16: ( accessmod tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON )
			// compilador.g:89:19: accessmod tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON
			{
			pushFollow(FOLLOW_accessmod_in_attributes251);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_attributes253);
			tipo1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_attributes257); 
			// compilador.g:89:41: ( '=' e1= expr )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==25) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// compilador.g:89:43: '=' e1= expr
					{
					match(input,25,FOLLOW_25_in_attributes261); 
					pushFollow(FOLLOW_expr_in_attributes265);
					e1=expr();
					state._fsp--;

					 pushID((id1!=null?id1.getText():null),(tipo1!=null?input.toString(tipo1.start,tipo1.stop):null)); if ((e1!=null?((compiladorParser.expr_return)e1).isConst:false)) System.out.println("📊 BTA (Binding Time Analysis): Línea " + id1.getLine() + " puede ser reducida a: " + (e1!=null?((compiladorParser.expr_return)e1).constVal:0.0)); 
					}
					break;

			}

			// compilador.g:90:26: ( COMMA id2= ID ( '=' e2= expr )? )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMA) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// compilador.g:90:27: COMMA id2= ID ( '=' e2= expr )?
					{
					match(input,COMMA,FOLLOW_COMMA_in_attributes298); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_attributes302); 
					// compilador.g:90:40: ( '=' e2= expr )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==25) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// compilador.g:90:42: '=' e2= expr
							{
							match(input,25,FOLLOW_25_in_attributes306); 
							pushFollow(FOLLOW_expr_in_attributes310);
							e2=expr();
							state._fsp--;

							 pushID((id2!=null?id2.getText():null),(tipo1!=null?input.toString(tipo1.start,tipo1.stop):null)); if ((e2!=null?((compiladorParser.expr_return)e2).isConst:false)) System.out.println("📊 BTA (Binding Time Analysis): Línea " + id2.getLine() + " puede ser reducida a: " + (e2!=null?((compiladorParser.expr_return)e2).constVal:0.0)); 
							}
							break;

					}

					}
					break;

				default :
					break loop6;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributes319); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attributes"



	// $ANTLR start "method"
	// compilador.g:93:1: method : accessmod tipo id= ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB ;
	public final void method() throws RecognitionException {
		Token id=null;
		ParserRuleReturnScope tipo2 =null;

		try {
			// compilador.g:93:16: ( accessmod tipo id= ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB )
			// compilador.g:93:18: accessmod tipo id= ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_method354);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_method356);
			tipo2=tipo();
			state._fsp--;

			id=(Token)match(input,ID,FOLLOW_ID_in_method360); 
			match(input,20,FOLLOW_20_in_method362); 
			// compilador.g:93:43: ( decl_args )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==DOUBLE||LA7_0==INT||LA7_0==STRING) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// compilador.g:93:43: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_method364);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,21,FOLLOW_21_in_method368); 
			 declareMethod((id!=null?id.getText():null), (tipo2!=null?input.toString(tipo2.start,tipo2.stop):null)); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_method420); 
			// compilador.g:95:35: ( sentences )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= DOUBLE && LA8_0 <= INT)||LA8_0==STRING) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:95:35: sentences
					{
					pushFollow(FOLLOW_sentences_in_method424);
					sentences();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			match(input,CCURLYB,FOLLOW_CCURLYB_in_method429); 
			 SymT.clear(); constVals.clear(); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "method"



	// $ANTLR start "variables_local"
	// compilador.g:98:1: variables_local : tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON ;
	public final void variables_local() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope tipo3 =null;

		try {
			// compilador.g:98:16: ( tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON )
			// compilador.g:98:18: tipo id1= ID ( '=' e1= expr )? ( COMMA id2= ID ( '=' e2= expr )? )* SEMICOLON
			{
			pushFollow(FOLLOW_tipo_in_variables_local459);
			tipo3=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_variables_local463); 
			// compilador.g:98:30: ( '=' e1= expr )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==25) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// compilador.g:98:32: '=' e1= expr
					{
					match(input,25,FOLLOW_25_in_variables_local467); 
					pushFollow(FOLLOW_expr_in_variables_local471);
					e1=expr();
					state._fsp--;

					 pushID((id1!=null?id1.getText():null),(tipo3!=null?input.toString(tipo3.start,tipo3.stop):null)); if ((e1!=null?((compiladorParser.expr_return)e1).isConst:false)) { System.out.println("📊 BTA (Binding Time Analysis): Línea " + id1.getLine() + " puede ser reducida a: " + (e1!=null?((compiladorParser.expr_return)e1).constVal:0.0)); setConstValue(id1.getText(), (e1!=null?((compiladorParser.expr_return)e1).constVal:0.0)); } 
					}
					break;

			}

			// compilador.g:99:19: ( COMMA id2= ID ( '=' e2= expr )? )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:99:20: COMMA id2= ID ( '=' e2= expr )?
					{
					match(input,COMMA,FOLLOW_COMMA_in_variables_local497); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_variables_local501); 
					// compilador.g:99:33: ( '=' e2= expr )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==25) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// compilador.g:99:35: '=' e2= expr
							{
							match(input,25,FOLLOW_25_in_variables_local505); 
							pushFollow(FOLLOW_expr_in_variables_local509);
							e2=expr();
							state._fsp--;

							 pushID((id2!=null?id2.getText():null),(tipo3!=null?input.toString(tipo3.start,tipo3.stop):null)); if ((e2!=null?((compiladorParser.expr_return)e2).isConst:false)) { System.out.println("📊 BTA (Binding Time Analysis): Línea " + id2.getLine() + " puede ser reducida a: " + (e2!=null?((compiladorParser.expr_return)e2).constVal:0.0)); setConstValue(id2.getText(), (e2!=null?((compiladorParser.expr_return)e2).constVal:0.0)); } 
							}
							break;

					}

					}
					break;

				default :
					break loop11;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_variables_local519); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "variables_local"



	// $ANTLR start "decl_args"
	// compilador.g:102:1: decl_args : t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* ;
	public final void decl_args() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		try {
			// compilador.g:102:16: (t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* )
			// compilador.g:102:18: t1= tipo id1= ID ( COMMA t2= tipo id2= ID )*
			{
			pushFollow(FOLLOW_tipo_in_decl_args552);
			t1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_args556); 
			pushID((id1!=null?id1.getText():null),(t1!=null?input.toString(t1.start,t1.stop):null));
			// compilador.g:102:63: ( COMMA t2= tipo id2= ID )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// compilador.g:102:64: COMMA t2= tipo id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_decl_args561); 
					pushFollow(FOLLOW_tipo_in_decl_args565);
					t2=tipo();
					state._fsp--;

					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_args569); 
					pushID((id2!=null?id2.getText():null),(t2!=null?input.toString(t2.start,t2.stop):null));
					}
					break;

				default :
					break loop12;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decl_args"



	// $ANTLR start "sentences"
	// compilador.g:104:1: sentences : ( asignacion | variables_local );
	public final void sentences() throws RecognitionException {
		try {
			// compilador.g:104:16: ( asignacion | variables_local )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==ID) ) {
				alt13=1;
			}
			else if ( (LA13_0==DOUBLE||LA13_0==INT||LA13_0==STRING) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// compilador.g:104:19: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_sentences587);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:104:32: variables_local
					{
					pushFollow(FOLLOW_variables_local_in_sentences591);
					variables_local();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "sentences"



	// $ANTLR start "asignacion"
	// compilador.g:105:1: asignacion : id= ID '=' expr SEMICOLON ;
	public final void asignacion() throws RecognitionException {
		Token id=null;
		ParserRuleReturnScope expr4 =null;

		try {
			// compilador.g:105:16: (id= ID '=' expr SEMICOLON )
			// compilador.g:105:19: id= ID '=' expr SEMICOLON
			{
			id=(Token)match(input,ID,FOLLOW_ID_in_asignacion607); 
			match(input,25,FOLLOW_25_in_asignacion610); 
			pushFollow(FOLLOW_expr_in_asignacion612);
			expr4=expr();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion614); 

			                     if ((expr4!=null?((compiladorParser.expr_return)expr4).isConst:false)) {
			                        System.out.println("📊 BTA (Binding Time Analysis): Línea " + id.getLine() + " puede ser reducida a: " + (expr4!=null?((compiladorParser.expr_return)expr4).constVal:0.0));
			                        setConstValue(id.getText(), (expr4!=null?((compiladorParser.expr_return)expr4).constVal:0.0));
			                     } else {
			                        // assignment is not constant, remove any previous const value
			                        removeConstValue(id.getText());
			                     }
			                  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "asignacion"


	public static class expr_return extends ParserRuleReturnScope {
		public int vType;
		public boolean isConst;
		public double constVal;
	};


	// $ANTLR start "expr"
	// compilador.g:116:1: expr returns [int vType, boolean isConst, double constVal] : m1= multExpr (op= ( '+' | '-' ) m2= multExpr )* ;
	public final compiladorParser.expr_return expr() throws RecognitionException {
		compiladorParser.expr_return retval = new compiladorParser.expr_return();
		retval.start = input.LT(1);

		Token op=null;
		ParserRuleReturnScope m1 =null;
		ParserRuleReturnScope m2 =null;

		try {
			// compilador.g:117:23: (m1= multExpr (op= ( '+' | '-' ) m2= multExpr )* )
			// compilador.g:117:26: m1= multExpr (op= ( '+' | '-' ) m2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr672);
			m1=multExpr();
			state._fsp--;

			 retval.vType =(m1!=null?((compiladorParser.multExpr_return)m1).vType:0); retval.isConst =(m1!=null?((compiladorParser.multExpr_return)m1).isConst:false); retval.constVal =(m1!=null?((compiladorParser.multExpr_return)m1).constVal:0.0); 
			// compilador.g:118:25: (op= ( '+' | '-' ) m2= multExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= 23 && LA14_0 <= 24)) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// compilador.g:118:27: op= ( '+' | '-' ) m2= multExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 23 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr712);
					m2=multExpr();
					state._fsp--;


					                           if(retval.vType != (m2!=null?((compiladorParser.multExpr_return)m2).vType:0)) retval.vType =3;
					                           if (retval.isConst && (m2!=null?((compiladorParser.multExpr_return)m2).isConst:false)) {
					                                 if (op.getText().equals("+")) retval.constVal = retval.constVal + (m2!=null?((compiladorParser.multExpr_return)m2).constVal:0.0);
					                                 else retval.constVal = retval.constVal - (m2!=null?((compiladorParser.multExpr_return)m2).constVal:0.0);
					                                 retval.isConst = true;
					                           } else {
					                                 retval.isConst = false;
					                           }
					                        
					}
					break;

				default :
					break loop14;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		public int vType;
		public boolean isConst;
		public double constVal;
	};


	// $ANTLR start "multExpr"
	// compilador.g:132:1: multExpr returns [int vType, boolean isConst, double constVal] : a1= atomo ( '*' a2= atomo )* ;
	public final compiladorParser.multExpr_return multExpr() throws RecognitionException {
		compiladorParser.multExpr_return retval = new compiladorParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a1 =null;
		ParserRuleReturnScope a2 =null;

		try {
			// compilador.g:133:13: (a1= atomo ( '*' a2= atomo )* )
			// compilador.g:133:16: a1= atomo ( '*' a2= atomo )*
			{
			pushFollow(FOLLOW_atomo_in_multExpr823);
			a1=atomo();
			state._fsp--;

			 retval.vType =(a1!=null?((compiladorParser.atomo_return)a1).vType:0); retval.isConst =(a1!=null?((compiladorParser.atomo_return)a1).isConst:false); retval.constVal =(a1!=null?((compiladorParser.atomo_return)a1).constVal:0.0); 
			// compilador.g:134:13: ( '*' a2= atomo )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==22) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// compilador.g:134:15: '*' a2= atomo
					{
					match(input,22,FOLLOW_22_in_multExpr841); 
					pushFollow(FOLLOW_atomo_in_multExpr845);
					a2=atomo();
					state._fsp--;


					              if(retval.vType != (a2!=null?((compiladorParser.atomo_return)a2).vType:0)) retval.vType =3;
					              if (retval.isConst && (a2!=null?((compiladorParser.atomo_return)a2).isConst:false)) {
					                 retval.constVal = retval.constVal * (a2!=null?((compiladorParser.atomo_return)a2).constVal:0.0);
					                 retval.isConst = true;
					              } else {
					                 retval.isConst = false;
					              }
					            
					}
					break;

				default :
					break loop15;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atomo_return extends ParserRuleReturnScope {
		public int vType;
		public boolean isConst;
		public double constVal;
	};


	// $ANTLR start "atomo"
	// compilador.g:147:1: atomo returns [int vType, boolean isConst, double constVal] : ( CINT | CFLOAT |id= ID '(' ( listaArgs )? ')' | ID | '(' e= expr ')' );
	public final compiladorParser.atomo_return atomo() throws RecognitionException {
		compiladorParser.atomo_return retval = new compiladorParser.atomo_return();
		retval.start = input.LT(1);

		Token id=null;
		Token CINT5=null;
		Token CFLOAT6=null;
		Token ID7=null;
		ParserRuleReturnScope e =null;

		try {
			// compilador.g:148:16: ( CINT | CFLOAT |id= ID '(' ( listaArgs )? ')' | ID | '(' e= expr ')' )
			int alt17=5;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt17=1;
				}
				break;
			case CFLOAT:
				{
				alt17=2;
				}
				break;
			case ID:
				{
				int LA17_3 = input.LA(2);
				if ( (LA17_3==20) ) {
					alt17=3;
				}
				else if ( (LA17_3==COMMA||LA17_3==SEMICOLON||(LA17_3 >= 21 && LA17_3 <= 24)) ) {
					alt17=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 20:
				{
				alt17=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// compilador.g:148:19: CINT
					{
					CINT5=(Token)match(input,CINT,FOLLOW_CINT_in_atomo903); 
					 retval.vType =1; retval.isConst =true; retval.constVal =Double.parseDouble(CINT5.getText()); 
					}
					break;
				case 2 :
					// compilador.g:149:19: CFLOAT
					{
					CFLOAT6=(Token)match(input,CFLOAT,FOLLOW_CFLOAT_in_atomo925); 
					 retval.vType =2; retval.isConst =true; retval.constVal =Double.parseDouble(CFLOAT6.getText()); 
					}
					break;
				case 3 :
					// compilador.g:150:19: id= ID '(' ( listaArgs )? ')'
					{
					id=(Token)match(input,ID,FOLLOW_ID_in_atomo949); 
					match(input,20,FOLLOW_20_in_atomo951); 
					// compilador.g:150:29: ( listaArgs )?
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( ((LA16_0 >= CFLOAT && LA16_0 <= CINT)||LA16_0==ID||LA16_0==20) ) {
						alt16=1;
					}
					switch (alt16) {
						case 1 :
							// compilador.g:150:29: listaArgs
							{
							pushFollow(FOLLOW_listaArgs_in_atomo953);
							listaArgs();
							state._fsp--;

							}
							break;

					}

					match(input,21,FOLLOW_21_in_atomo956); 
					 recordMethodCall((id!=null?id.getText():null)); retval.vType =1; retval.isConst =false; retval.constVal =0; 
					}
					break;
				case 4 :
					// compilador.g:151:20: ID
					{
					ID7=(Token)match(input,ID,FOLLOW_ID_in_atomo980); 
					 retval.vType =getSymbolType((ID7!=null?ID7.getText():null)); 
					                   Double cv = (Double) constVals.get((ID7!=null?ID7.getText():null));
					                   if (cv != null) { retval.isConst = true; retval.constVal = cv.doubleValue(); } else { retval.isConst =false; retval.constVal =0; } 
					}
					break;
				case 5 :
					// compilador.g:154:19: '(' e= expr ')'
					{
					match(input,20,FOLLOW_20_in_atomo1002); 
					pushFollow(FOLLOW_expr_in_atomo1006);
					e=expr();
					state._fsp--;

					match(input,21,FOLLOW_21_in_atomo1008); 
					 retval.vType =(e!=null?((compiladorParser.expr_return)e).vType:0); retval.isConst =(e!=null?((compiladorParser.expr_return)e).isConst:false); retval.constVal =(e!=null?((compiladorParser.expr_return)e).constVal:0.0); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atomo"



	// $ANTLR start "listaArgs"
	// compilador.g:156:1: listaArgs : expr ( COMMA expr )* ;
	public final void listaArgs() throws RecognitionException {
		try {
			// compilador.g:156:16: ( expr ( COMMA expr )* )
			// compilador.g:156:18: expr ( COMMA expr )*
			{
			pushFollow(FOLLOW_expr_in_listaArgs1025);
			expr();
			state._fsp--;

			// compilador.g:156:23: ( COMMA expr )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==COMMA) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// compilador.g:156:24: COMMA expr
					{
					match(input,COMMA,FOLLOW_COMMA_in_listaArgs1028); 
					pushFollow(FOLLOW_expr_in_listaArgs1030);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop18;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "listaArgs"


	public static class tipo_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "tipo"
	// compilador.g:158:1: tipo : ( INT | DOUBLE | STRING );
	public final compiladorParser.tipo_return tipo() throws RecognitionException {
		compiladorParser.tipo_return retval = new compiladorParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// compilador.g:158:16: ( INT | DOUBLE | STRING )
			// compilador.g:
			{
			if ( input.LA(1)==DOUBLE||input.LA(1)==INT||input.LA(1)==STRING ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tipo"



	// $ANTLR start "accessmod"
	// compilador.g:159:1: accessmod : ( PUBLIC | PRIVATE | PROTECTED );
	public final void accessmod() throws RecognitionException {
		try {
			// compilador.g:159:16: ( PUBLIC | PRIVATE | PROTECTED )
			// compilador.g:
			{
			if ( (input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "accessmod"

	// Delegated rules



	public static final BitSet FOLLOW_classes_in_program29 = new BitSet(new long[]{0x000000000001C002L});
	public static final BitSet FOLLOW_accessmod_in_classes50 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLASS_in_classes52 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_classes54 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_OCURLYB_in_classes93 = new BitSet(new long[]{0x000000000001C010L});
	public static final BitSet FOLLOW_member_in_classes135 = new BitSet(new long[]{0x000000000001C010L});
	public static final BitSet FOLLOW_CCURLYB_in_classes175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_method_in_member235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_member239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_attributes251 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_attributes253 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_attributes257 = new BitSet(new long[]{0x0000000002020100L});
	public static final BitSet FOLLOW_25_in_attributes261 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_attributes265 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_COMMA_in_attributes298 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_attributes302 = new BitSet(new long[]{0x0000000002020100L});
	public static final BitSet FOLLOW_25_in_attributes306 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_attributes310 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_SEMICOLON_in_attributes319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_method354 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_method356 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_method360 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_method362 = new BitSet(new long[]{0x0000000000241400L});
	public static final BitSet FOLLOW_decl_args_in_method364 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_method368 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_OCURLYB_in_method420 = new BitSet(new long[]{0x0000000000041C10L});
	public static final BitSet FOLLOW_sentences_in_method424 = new BitSet(new long[]{0x0000000000041C10L});
	public static final BitSet FOLLOW_CCURLYB_in_method429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_variables_local459 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local463 = new BitSet(new long[]{0x0000000002020100L});
	public static final BitSet FOLLOW_25_in_variables_local467 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_variables_local471 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_COMMA_in_variables_local497 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local501 = new BitSet(new long[]{0x0000000002020100L});
	public static final BitSet FOLLOW_25_in_variables_local505 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_variables_local509 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_SEMICOLON_in_variables_local519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args552 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args556 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_COMMA_in_decl_args561 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_decl_args565 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args569 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_asignacion_in_sentences587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variables_local_in_sentences591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion607 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_asignacion610 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_asignacion612 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_asignacion614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr672 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_set_in_expr704 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_multExpr_in_expr712 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_atomo_in_multExpr823 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_multExpr841 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_atomo_in_multExpr845 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_CINT_in_atomo903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atomo925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo949 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_atomo951 = new BitSet(new long[]{0x0000000000300860L});
	public static final BitSet FOLLOW_listaArgs_in_atomo953 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_atomo956 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_atomo1002 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_atomo1006 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_atomo1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_listaArgs1025 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_COMMA_in_listaArgs1028 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_listaArgs1030 = new BitSet(new long[]{0x0000000000000102L});
}
