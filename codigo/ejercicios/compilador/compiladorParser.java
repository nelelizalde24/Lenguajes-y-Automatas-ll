// $ANTLR 3.5.2 compilador.g 2025-09-17 10:44:12
 

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

	 


	// $ANTLR start "program"
	// compilador.g:6:1: program : ( classes )+ ;
	public final void program() throws RecognitionException {
		try {
			// compilador.g:6:16: ( ( classes )+ )
			// compilador.g:6:18: ( classes )+
			{
			// compilador.g:6:18: ( classes )+
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
					// compilador.g:6:18: classes
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
	// compilador.g:10:1: classes : accessmod CLASS ID OCURLYB ( member )* CCURLYB ;
	public final void classes() throws RecognitionException {
		try {
			// compilador.g:10:18: ( accessmod CLASS ID OCURLYB ( member )* CCURLYB )
			// compilador.g:10:20: accessmod CLASS ID OCURLYB ( member )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_classes54);
			accessmod();
			state._fsp--;

			match(input,CLASS,FOLLOW_CLASS_in_classes56); 
			match(input,ID,FOLLOW_ID_in_classes58); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_classes98); 
			// compilador.g:12:41: ( member )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= PRIVATE && LA2_0 <= PUBLIC)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// compilador.g:12:41: member
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
	// compilador.g:16:1: member : ( method | attributes );
	public final void member() throws RecognitionException {
		try {
			// compilador.g:16:16: ( method | attributes )
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
					// compilador.g:16:19: method
					{
					pushFollow(FOLLOW_method_in_member200);
					method();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:16:28: attributes
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
	// compilador.g:17:1: attributes : accessmod tipo ID ( COMMA ID )* SEMICOLON ;
	public final void attributes() throws RecognitionException {
		try {
			// compilador.g:17:16: ( accessmod tipo ID ( COMMA ID )* SEMICOLON )
			// compilador.g:17:19: accessmod tipo ID ( COMMA ID )* SEMICOLON
			{
			pushFollow(FOLLOW_accessmod_in_attributes217);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_attributes219);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_attributes221); 
			// compilador.g:17:37: ( COMMA ID )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// compilador.g:17:38: COMMA ID
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
	// compilador.g:20:1: method : accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB ;
	public final void method() throws RecognitionException {
		try {
			// compilador.g:20:16: ( accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB )
			// compilador.g:20:19: accessmod tipo ID '(' ( decl_args )? ')' OCURLYB ( sentences )* CCURLYB
			{
			pushFollow(FOLLOW_accessmod_in_method266);
			accessmod();
			state._fsp--;

			pushFollow(FOLLOW_tipo_in_method268);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_method270); 
			match(input,20,FOLLOW_20_in_method272); 
			// compilador.g:20:41: ( decl_args )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==DOUBLE||LA5_0==INT||LA5_0==STRING) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// compilador.g:20:41: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_method274);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,21,FOLLOW_21_in_method278); 
			match(input,OCURLYB,FOLLOW_OCURLYB_in_method308); 
			// compilador.g:22:29: ( sentences )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= DOUBLE && LA6_0 <= INT)||LA6_0==STRING) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// compilador.g:22:29: sentences
					{
					pushFollow(FOLLOW_sentences_in_method341);
					sentences();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
			}

			match(input,CCURLYB,FOLLOW_CCURLYB_in_method375); 
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
	// compilador.g:26:1: variables_local : tipo ID ( COMMA ID )* SEMICOLON ;
	public final void variables_local() throws RecognitionException {
		try {
			// compilador.g:26:16: ( tipo ID ( COMMA ID )* SEMICOLON )
			// compilador.g:26:18: tipo ID ( COMMA ID )* SEMICOLON
			{
			pushFollow(FOLLOW_tipo_in_variables_local401);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_variables_local403); 
			// compilador.g:26:26: ( COMMA ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// compilador.g:26:27: COMMA ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_variables_local406); 
					match(input,ID,FOLLOW_ID_in_variables_local408); 
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_variables_local412); 
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
	// compilador.g:29:1: decl_args : tipo ID ( COMMA tipo ID )* ;
	public final void decl_args() throws RecognitionException {
		try {
			// compilador.g:29:16: ( tipo ID ( COMMA tipo ID )* )
			// compilador.g:29:18: tipo ID ( COMMA tipo ID )*
			{
			pushFollow(FOLLOW_tipo_in_decl_args443);
			tipo();
			state._fsp--;

			match(input,ID,FOLLOW_ID_in_decl_args445); 
			// compilador.g:29:26: ( COMMA tipo ID )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:29:27: COMMA tipo ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_decl_args448); 
					pushFollow(FOLLOW_tipo_in_decl_args450);
					tipo();
					state._fsp--;

					match(input,ID,FOLLOW_ID_in_decl_args452); 
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
	// compilador.g:31:1: sentences : ( asignacion | variables_local );
	public final void sentences() throws RecognitionException {
		try {
			// compilador.g:31:16: ( asignacion | variables_local )
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
					// compilador.g:31:19: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_sentences468);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// compilador.g:31:32: variables_local
					{
					pushFollow(FOLLOW_variables_local_in_sentences472);
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
	// compilador.g:32:1: asignacion : ID '=' expr SEMICOLON ;
	public final void asignacion() throws RecognitionException {
		try {
			// compilador.g:32:16: ( ID '=' expr SEMICOLON )
			// compilador.g:32:19: ID '=' expr SEMICOLON
			{
			match(input,ID,FOLLOW_ID_in_asignacion486); 
			match(input,25,FOLLOW_25_in_asignacion489); 
			pushFollow(FOLLOW_expr_in_asignacion491);
			expr();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion493); 
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
	// compilador.g:34:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// compilador.g:34:16: ( multExpr ( ( '+' | '-' ) multExpr )* )
			// compilador.g:34:19: multExpr ( ( '+' | '-' ) multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr513);
			multExpr();
			state._fsp--;

			// compilador.g:34:28: ( ( '+' | '-' ) multExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 23 && LA10_0 <= 24)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// compilador.g:34:29: ( '+' | '-' ) multExpr
					{
					if ( (input.LA(1) >= 23 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr521);
					multExpr();
					state._fsp--;

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
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// compilador.g:35:1: multExpr : atomo ( '*' atomo )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// compilador.g:35:16: ( atomo ( '*' atomo )* )
			// compilador.g:35:19: atomo ( '*' atomo )*
			{
			pushFollow(FOLLOW_atomo_in_multExpr537);
			atomo();
			state._fsp--;

			// compilador.g:35:25: ( '*' atomo )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==22) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:35:26: '*' atomo
					{
					match(input,22,FOLLOW_22_in_multExpr540); 
					pushFollow(FOLLOW_atomo_in_multExpr542);
					atomo();
					state._fsp--;

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
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atomo"
	// compilador.g:37:1: atomo : ( CINT | CFLOAT | ID | '(' expr ')' );
	public final void atomo() throws RecognitionException {
		try {
			// compilador.g:37:16: ( CINT | CFLOAT | ID | '(' expr ')' )
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
					// compilador.g:37:19: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atomo562); 
					}
					break;
				case 2 :
					// compilador.g:38:19: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_atomo582); 
					}
					break;
				case 3 :
					// compilador.g:39:19: ID
					{
					match(input,ID,FOLLOW_ID_in_atomo602); 
					}
					break;
				case 4 :
					// compilador.g:40:19: '(' expr ')'
					{
					match(input,20,FOLLOW_20_in_atomo623); 
					pushFollow(FOLLOW_expr_in_atomo625);
					expr();
					state._fsp--;

					match(input,21,FOLLOW_21_in_atomo627); 
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
	// $ANTLR end "atomo"



	// $ANTLR start "tipo"
	// compilador.g:42:1: tipo : ( INT | DOUBLE | STRING );
	public final void tipo() throws RecognitionException {
		try {
			// compilador.g:42:16: ( INT | DOUBLE | STRING )
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tipo"



	// $ANTLR start "accessmod"
	// compilador.g:43:1: accessmod : ( PUBLIC | PRIVATE | PROTECTED );
	public final void accessmod() throws RecognitionException {
		try {
			// compilador.g:43:16: ( PUBLIC | PRIVATE | PROTECTED )
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
	public static final BitSet FOLLOW_sentences_in_method341 = new BitSet(new long[]{0x0000000000041C10L});
	public static final BitSet FOLLOW_CCURLYB_in_method375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_variables_local401 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local403 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_COMMA_in_variables_local406 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_variables_local408 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_SEMICOLON_in_variables_local412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args443 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args445 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_COMMA_in_decl_args448 = new BitSet(new long[]{0x0000000000041400L});
	public static final BitSet FOLLOW_tipo_in_decl_args450 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_decl_args452 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_asignacion_in_sentences468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variables_local_in_sentences472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion486 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_asignacion489 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_asignacion491 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_asignacion493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr513 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_set_in_expr516 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_multExpr_in_expr521 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_atomo_in_multExpr537 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_multExpr540 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_atomo_in_multExpr542 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_CINT_in_atomo562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atomo582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_atomo623 = new BitSet(new long[]{0x0000000000100860L});
	public static final BitSet FOLLOW_expr_in_atomo625 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_atomo627 = new BitSet(new long[]{0x0000000000000002L});
}
