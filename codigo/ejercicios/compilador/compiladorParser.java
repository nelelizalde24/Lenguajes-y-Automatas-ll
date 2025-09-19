// $ANTLR 3.5.2 compilador.g 2025-09-19 11:01:18
 
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

	         private void pushID(String id, String tipo){
	            System.out.println("Insertando a TS:"+id+" con tipo: "+tipo);

	            Integer existe = (Integer) SymT.get(id);
	                  if(existe==null)
	                        if(tipo.compareTo("int")==0)      SymT.put(id,1);
	                        else if(tipo.compareTo("double")==0)SymT.put(id,2);
	                        else SymT.put(id,3);
	                  
	                  else System.out.println("ID: "+id+" ya declarado");
	         }
	      


	// $ANTLR start "program"
	// compilador.g:22:1: program : ( classes )+ ;
	public final void program() throws RecognitionException {
		try {
			// compilador.g:22:16: ( ( classes )+ )
			// compilador.g:22:18: ( classes )+
			{
			// compilador.g:22:18: ( classes )+
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
					// compilador.g:22:18: classes
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
	// compilador.g:26:1: classes : accessmod CLASS ID OCURLYB ( member )* CCURLYB ;
	public final void classes() throws RecognitionException {
		try {
			// compilador.g:26:18: ( accessmod CLASS ID OCURLYB ( member )* CCURLYB )
			// compilador.g:26:20: accessmod CLASS ID OCURLYB ( member )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_classes54);
			accessmod();
			state._fsp--;

			match(input,CLASS,FOLLOW_CLASS_in_classes56); 
			match(input,ID,FOLLOW_ID_in_classes58); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_classes98); 
			// compilador.g:28:41: ( member )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= PRIVATE && LA2_0 <= PUBLIC)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// compilador.g:28:41: member
					{
					pushFollow(FOLLOW_member_in_classes141);
					member();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,CCURLYB,FOLLOW_CCURLYB_in_classes181); 
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
	// compilador.g:32:1: member : ( method | attributes );
	public final void member() throws RecognitionException {
		try {
			// compilador.g:32:16: ( method | attributes )
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
						else if ( (LA3_3==COMMA||LA3_3==SEMICOLON) ) {
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
					// compilador.g:32:19: method
					{
					pushFollow(FOLLOW_method_in_member200);
					method();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:32:28: attributes
					{
					pushFollow(FOLLOW_attributes_in_member204);
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
	// compilador.g:33:1: attributes : accessmod tipo ID ( COMMA ID )* SEMICOLON ;
	public final void attributes() throws RecognitionException {
		try {
			// compilador.g:33:16: ( accessmod tipo ID ( COMMA ID )* SEMICOLON )
			// compilador.g:33:19: accessmod tipo ID ( COMMA ID )* SEMICOLON
			{
			pushFollow(FOLLOW_accessmod_in_attributes217);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_attributes219);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_attributes221); 
			// compilador.g:33:37: ( COMMA ID )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// compilador.g:33:38: COMMA ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_attributes224); 
					match(input,ID,FOLLOW_ID_in_attributes226); 
					}
					break;

				default :
					break loop4;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_attributes230); 
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
	// compilador.g:36:1: method : accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB ;
	public final void method() throws RecognitionException {
		try {
			// compilador.g:36:16: ( accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB )
			// compilador.g:36:19: accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_method266);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_method268);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_method270); 
			match(input,20,FOLLOW_20_in_method272); 
			// compilador.g:36:41: ( decl_args )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==DOUBLE||LA5_0==INT||LA5_0==STRING) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// compilador.g:36:41: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_method274);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,21,FOLLOW_21_in_method278); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_method308); 
			// compilador.g:37:39: ( sentences )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= DOUBLE && LA6_0 <= INT)||LA6_0==STRING) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// compilador.g:37:39: sentences
					{
					pushFollow(FOLLOW_sentences_in_method312);
					sentences();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			match(input,CCURLYB,FOLLOW_CCURLYB_in_method317); 
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
	// compilador.g:40:1: variables_local : tipo id1= ID ( COMMA id2= ID )* SEMICOLON ;
	public final void variables_local() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo1 =null;

		try {
			// compilador.g:40:16: ( tipo id1= ID ( COMMA id2= ID )* SEMICOLON )
			// compilador.g:40:18: tipo id1= ID ( COMMA id2= ID )* SEMICOLON
			{
			pushFollow(FOLLOW_tipo_in_variables_local343);
			tipo1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_variables_local347); 
			pushID((id1!=null?id1.getText():null),(tipo1!=null?input.toString(tipo1.start,tipo1.stop):null));
			// compilador.g:40:62: ( COMMA id2= ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// compilador.g:40:63: COMMA id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_variables_local352); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_variables_local356); 
					pushID((id2!=null?id2.getText():null),(tipo1!=null?input.toString(tipo1.start,tipo1.stop):null));
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_variables_local362); 
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
	// compilador.g:43:1: decl_args : t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* ;
	public final void decl_args() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		try {
			// compilador.g:43:16: (t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* )
			// compilador.g:43:18: t1= tipo id1= ID ( COMMA t2= tipo id2= ID )*
			{
			pushFollow(FOLLOW_tipo_in_decl_args395);
			t1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_args399); 
			pushID((id1!=null?id1.getText():null),(t1!=null?input.toString(t1.start,t1.stop):null));
			// compilador.g:43:63: ( COMMA t2= tipo id2= ID )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:43:64: COMMA t2= tipo id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_decl_args404); 
					pushFollow(FOLLOW_tipo_in_decl_args408);
					t2=tipo();
					state._fsp--;

					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_args412); 
					pushID((id2!=null?id2.getText():null),(t2!=null?input.toString(t2.start,t2.stop):null));
					}
					break;

				default :
					break loop8;
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
	// compilador.g:45:1: sentences : ( asignacion | variables_local );
	public final void sentences() throws RecognitionException {
		try {
			// compilador.g:45:16: ( asignacion | variables_local )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==DOUBLE||LA9_0==INT||LA9_0==STRING) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// compilador.g:45:19: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_sentences430);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:45:32: variables_local
					{
					pushFollow(FOLLOW_variables_local_in_sentences434);
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
	// compilador.g:46:1: asignacion : ID '=' expr SEMICOLON ;
	public final void asignacion() throws RecognitionException {
		try {
			// compilador.g:46:16: ( ID '=' expr SEMICOLON )
			// compilador.g:46:19: ID '=' expr SEMICOLON
			{
			match(input,ID,FOLLOW_ID_in_asignacion448); 
			match(input,25,FOLLOW_25_in_asignacion451); 
			pushFollow(FOLLOW_expr_in_asignacion453);
			expr();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion455); 
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



	// $ANTLR start "expr"
	// compilador.g:48:1: expr returns [int vType ] : m1= multExpr ( ( '+' | '-' ) m2= multExpr )* ;
	public final int expr() throws RecognitionException {
		int vType = 0;


		int m1 =0;
		int m2 =0;

		try {
			// compilador.g:49:16: (m1= multExpr ( ( '+' | '-' ) m2= multExpr )* )
			// compilador.g:49:19: m1= multExpr ( ( '+' | '-' ) m2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr496);
			m1=multExpr();
			state._fsp--;

			vType =m1;
			// compilador.g:50:17: ( ( '+' | '-' ) m2= multExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 23 && LA10_0 <= 24)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// compilador.g:50:18: ( '+' | '-' ) m2= multExpr
					{
					if ( (input.LA(1) >= 23 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr525);
					m2=multExpr();
					state._fsp--;


					                  if(m1 != m2) vType =3;
					                
					}
					break;

				default :
					break loop10;
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
		return vType;
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// compilador.g:57:1: multExpr returns [int vType ] : a1= atomo ( '*' a2= atomo )* ;
	public final int multExpr() throws RecognitionException {
		int vType = 0;


		int a1 =0;
		int a2 =0;

		try {
			// compilador.g:58:16: (a1= atomo ( '*' a2= atomo )* )
			// compilador.g:58:19: a1= atomo ( '*' a2= atomo )*
			{
			pushFollow(FOLLOW_atomo_in_multExpr623);
			a1=atomo();
			state._fsp--;

			vType =a1;
			// compilador.g:59:16: ( '*' a2= atomo )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==22) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:59:17: '*' a2= atomo
					{
					match(input,22,FOLLOW_22_in_multExpr643); 
					pushFollow(FOLLOW_atomo_in_multExpr647);
					a2=atomo();
					state._fsp--;


					                  if(a1 != a2) vType =3;
					               
					}
					break;

				default :
					break loop11;
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
		return vType;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atomo"
	// compilador.g:66:1: atomo returns [int vType ] : ( CINT | CFLOAT | ID | '(' expr ')' );
	public final int atomo() throws RecognitionException {
		int vType = 0;


		int expr2 =0;

		try {
			// compilador.g:67:16: ( CINT | CFLOAT | ID | '(' expr ')' )
			int alt12=4;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt12=1;
				}
				break;
			case CFLOAT:
				{
				alt12=2;
				}
				break;
			case ID:
				{
				alt12=3;
				}
				break;
			case 20:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// compilador.g:67:19: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atomo729); 
					 vType =1; 
					}
					break;
				case 2 :
					// compilador.g:68:19: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_atomo751); 
					 vType =2; 
					}
					break;
				case 3 :
					// compilador.g:69:19: ID
					{
					match(input,ID,FOLLOW_ID_in_atomo773); 
					/*buscar en la tabla de simbolos*/
					}
					break;
				case 4 :
					// compilador.g:70:19: '(' expr ')'
					{
					match(input,20,FOLLOW_20_in_atomo795); 
					pushFollow(FOLLOW_expr_in_atomo797);
					expr2=expr();
					state._fsp--;

					match(input,21,FOLLOW_21_in_atomo799); 
					 vType =expr2; 
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
		return vType;
	}
	// $ANTLR end "atomo"


	public static class tipo_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "tipo"
	// compilador.g:72:1: tipo : ( INT | DOUBLE | STRING );
	public final compiladorParser.tipo_return tipo() throws RecognitionException {
		compiladorParser.tipo_return retval = new compiladorParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// compilador.g:72:16: ( INT | DOUBLE | STRING )
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
	// compilador.g:73:1: accessmod : ( PUBLIC | PRIVATE | PROTECTED );
	public final void accessmod() throws RecognitionException {
		try {
			// compilador.g:73:16: ( PUBLIC | PRIVATE | PROTECTED )
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
	public static final BitSet FOLLOW_accessmod_in_classes54 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CLASS_in_classes56 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_classes58 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_OCURLYB_in_classes98 = new BitSet(new long[]{0x000000000001C010L});
	public static final BitSet FOLLOW_member_in_classes141 = new BitSet(new long[]{0x000000000001C010L});
	public static final BitSet FOLLOW_CCURLYB_in_classes181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_method_in_member200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_member204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_attributes217 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_attributes219 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_attributes221 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_COMMA_in_attributes224 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_attributes226 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_SEMICOLON_in_attributes230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_method266 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_method268 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_method270 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_method272 = new BitSet(new long[]{0x0000000000241400L});
	public static final BitSet FOLLOW_decl_args_in_method274 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_method278 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_OCURLYB_in_method308 = new BitSet(new long[]{0x0000000000041C10L});
	public static final BitSet FOLLOW_sentences_in_method312 = new BitSet(new long[]{0x0000000000041C10L});
	public static final BitSet FOLLOW_CCURLYB_in_method317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_variables_local343 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local347 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_COMMA_in_variables_local352 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local356 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_SEMICOLON_in_variables_local362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args395 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args399 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_COMMA_in_decl_args404 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_decl_args408 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args412 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_asignacion_in_sentences430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variables_local_in_sentences434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion448 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_asignacion451 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_asignacion453 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_asignacion455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr496 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_set_in_expr517 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_multExpr_in_expr525 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_atomo_in_multExpr623 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_multExpr643 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_atomo_in_multExpr647 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_CINT_in_atomo729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atomo751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_atomo795 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_atomo797 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_atomo799 = new BitSet(new long[]{0x0000000000000002L});
}
