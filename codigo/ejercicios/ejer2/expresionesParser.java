// $ANTLR 3.5.2 expresiones.g 2025-09-10 12:00:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class expresionesParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CFLOAT", "CINT", "DOT", "ID", 
		"SEMICOLON", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'='"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int CFLOAT=4;
	public static final int CINT=5;
	public static final int DOT=6;
	public static final int ID=7;
	public static final int SEMICOLON=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public expresionesParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public expresionesParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return expresionesParser.tokenNames; }
	@Override public String getGrammarFileName() { return "expresiones.g"; }

	  java.util.Set<String> idsUnicos = new java.util.HashSet<>();




	// $ANTLR start "instrucciones"
	// expresiones.g:6:1: instrucciones : ( asignacion )+ ;
	public final void instrucciones() throws RecognitionException {
		try {
			// expresiones.g:6:16: ( ( asignacion )+ )
			// expresiones.g:6:19: ( asignacion )+
			{
			// expresiones.g:6:19: ( asignacion )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// expresiones.g:6:19: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_instrucciones17);
					asignacion();
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


			                    System.out.println("Identificadores encontrados:");
			                    for (String id : idsUnicos) {
			                        System.out.println("ID : " + id);
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
	// $ANTLR end "instrucciones"



	// $ANTLR start "asignacion"
	// expresiones.g:11:1: asignacion : ID '=' expr SEMICOLON ;
	public final void asignacion() throws RecognitionException {
		Token ID1=null;

		try {
			// expresiones.g:11:16: ( ID '=' expr SEMICOLON )
			// expresiones.g:11:19: ID '=' expr SEMICOLON
			{
			ID1=(Token)match(input,ID,FOLLOW_ID_in_asignacion32); 
			match(input,15,FOLLOW_15_in_asignacion35); 
			pushFollow(FOLLOW_expr_in_asignacion37);
			expr();
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion39); 

			        idsUnicos.add(ID1.getText());
			    
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
	// expresiones.g:15:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// expresiones.g:15:16: ( multExpr ( ( '+' | '-' ) multExpr )* )
			// expresiones.g:15:19: multExpr ( ( '+' | '-' ) multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr60);
			multExpr();
			state._fsp--;

			// expresiones.g:15:28: ( ( '+' | '-' ) multExpr )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 13 && LA2_0 <= 14)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// expresiones.g:15:29: ( '+' | '-' ) multExpr
					{
					if ( (input.LA(1) >= 13 && input.LA(1) <= 14) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr68);
					multExpr();
					state._fsp--;

					}
					break;

				default :
					break loop2;
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
	// expresiones.g:16:1: multExpr : atomo ( '*' atomo )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// expresiones.g:16:16: ( atomo ( '*' atomo )* )
			// expresiones.g:16:19: atomo ( '*' atomo )*
			{
			pushFollow(FOLLOW_atomo_in_multExpr84);
			atomo();
			state._fsp--;

			// expresiones.g:16:25: ( '*' atomo )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==12) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// expresiones.g:16:26: '*' atomo
					{
					match(input,12,FOLLOW_12_in_multExpr87); 
					pushFollow(FOLLOW_atomo_in_multExpr89);
					atomo();
					state._fsp--;

					}
					break;

				default :
					break loop3;
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
	// expresiones.g:18:1: atomo : ( CINT | CFLOAT | ID | '(' expr ')' );
	public final void atomo() throws RecognitionException {
		Token ID2=null;

		try {
			// expresiones.g:18:16: ( CINT | CFLOAT | ID | '(' expr ')' )
			int alt4=4;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt4=1;
				}
				break;
			case CFLOAT:
				{
				alt4=2;
				}
				break;
			case ID:
				{
				alt4=3;
				}
				break;
			case 10:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// expresiones.g:18:19: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atomo109); 
					}
					break;
				case 2 :
					// expresiones.g:19:19: CFLOAT
					{
					match(input,CFLOAT,FOLLOW_CFLOAT_in_atomo129); 
					}
					break;
				case 3 :
					// expresiones.g:20:19: ID
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_atomo149); 

					                    idsUnicos.add(ID2.getText());
					                    
					}
					break;
				case 4 :
					// expresiones.g:23:19: '(' expr ')'
					{
					match(input,10,FOLLOW_10_in_atomo171); 
					pushFollow(FOLLOW_expr_in_atomo173);
					expr();
					state._fsp--;

					match(input,11,FOLLOW_11_in_atomo175); 
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

	// Delegated rules



	public static final BitSet FOLLOW_asignacion_in_instrucciones17 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_ID_in_asignacion32 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_asignacion35 = new BitSet(new long[]{0x00000000000004B0L});
	public static final BitSet FOLLOW_expr_in_asignacion37 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_SEMICOLON_in_asignacion39 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr60 = new BitSet(new long[]{0x0000000000006002L});
	public static final BitSet FOLLOW_set_in_expr63 = new BitSet(new long[]{0x00000000000004B0L});
	public static final BitSet FOLLOW_multExpr_in_expr68 = new BitSet(new long[]{0x0000000000006002L});
	public static final BitSet FOLLOW_atomo_in_multExpr84 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_multExpr87 = new BitSet(new long[]{0x00000000000004B0L});
	public static final BitSet FOLLOW_atomo_in_multExpr89 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_CINT_in_atomo109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atomo129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_atomo171 = new BitSet(new long[]{0x00000000000004B0L});
	public static final BitSet FOLLOW_expr_in_atomo173 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_atomo175 = new BitSet(new long[]{0x0000000000000002L});
}
