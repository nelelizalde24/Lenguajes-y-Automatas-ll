// $ANTLR 3.5.2 ejercicio1.g 2025-09-04 10:54:31

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ejercicio1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "';'", "'='", "'call'"
	};
	public static final int EOF=-1;
	public static final int T__6=6;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int ID=4;
	public static final int WS=5;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ejercicio1Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ejercicio1Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ejercicio1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "ejercicio1.g"; }



	// $ANTLR start "programa"
	// ejercicio1.g:3:1: programa : ( intruccion )+ ;
	public final void programa() throws RecognitionException {
		try {
			// ejercicio1.g:3:12: ( ( intruccion )+ )
			// ejercicio1.g:3:14: ( intruccion )+
			{
			// ejercicio1.g:3:14: ( intruccion )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID||LA1_0==8) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ejercicio1.g:3:14: intruccion
					{
					pushFollow(FOLLOW_intruccion_in_programa12);
					intruccion();
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
	// $ANTLR end "programa"



	// $ANTLR start "intruccion"
	// ejercicio1.g:4:1: intruccion : ( llamada | asignacion );
	public final void intruccion() throws RecognitionException {
		try {
			// ejercicio1.g:4:12: ( llamada | asignacion )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==8) ) {
				alt2=1;
			}
			else if ( (LA2_0==ID) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ejercicio1.g:4:15: llamada
					{
					pushFollow(FOLLOW_llamada_in_intruccion22);
					llamada();
					state._fsp--;


					                        System.out.println("Llamada");

					                        
					}
					break;
				case 2 :
					// ejercicio1.g:7:29: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_intruccion28);
					asignacion();
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
	// $ANTLR end "intruccion"



	// $ANTLR start "llamada"
	// ejercicio1.g:8:1: llamada : 'call' ID ';' ;
	public final void llamada() throws RecognitionException {
		try {
			// ejercicio1.g:8:12: ( 'call' ID ';' )
			// ejercicio1.g:8:14: 'call' ID ';'
			{
			match(input,8,FOLLOW_8_in_llamada41); 
			match(input,ID,FOLLOW_ID_in_llamada43); 
			match(input,6,FOLLOW_6_in_llamada45); 
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
	// $ANTLR end "llamada"



	// $ANTLR start "asignacion"
	// ejercicio1.g:9:1: asignacion : ID '=' ID ';' ;
	public final void asignacion() throws RecognitionException {
		try {
			// ejercicio1.g:9:12: ( ID '=' ID ';' )
			// ejercicio1.g:9:14: ID '=' ID ';'
			{
			match(input,ID,FOLLOW_ID_in_asignacion53); 
			match(input,7,FOLLOW_7_in_asignacion55); 
			match(input,ID,FOLLOW_ID_in_asignacion57); 
			match(input,6,FOLLOW_6_in_asignacion59); 
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

	// Delegated rules



	public static final BitSet FOLLOW_intruccion_in_programa12 = new BitSet(new long[]{0x0000000000000112L});
	public static final BitSet FOLLOW_llamada_in_intruccion22 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asignacion_in_intruccion28 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_llamada41 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_llamada43 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_6_in_llamada45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion53 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_asignacion55 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_asignacion57 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_6_in_asignacion59 = new BitSet(new long[]{0x0000000000000002L});
}
