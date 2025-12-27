// $ANTLR 3.5.2 compilador.g 2025-12-14 21:39:32

  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class compiladorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CFLOAT", "CINT", "ID", "WS", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "';'", "'='", "'String'", "'class'", 
		"'double'", "'int'", "'private'", "'protected'", "'public'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int CFLOAT=4;
	public static final int CINT=5;
	public static final int ID=6;
	public static final int WS=7;

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

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return compiladorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "compilador.g"; }


	  HashMap SymT = new HashMap();

	  private void pushID(String id, String tipo) {
	    Integer existe = (Integer) SymT.get(id);
	    if (existe == null) {
	      if ("int".equals(tipo)) SymT.put(id, 1);
	      else if ("double".equals(tipo)) SymT.put(id, 2);
	      else SymT.put(id, 3);
	    } else System.out.println("ID: " + id + " ya declarado");
	  }

	  private int getSymbolType(String id) {
	    Integer t = (Integer) SymT.get(id);
	    return t == null ? -1 : t;
	  }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// compilador.g:30:1: program : ( classes )+ ;
	public final compiladorParser.program_return program() throws RecognitionException {
		compiladorParser.program_return retval = new compiladorParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope classes1 =null;


		try {
			// compilador.g:30:9: ( ( classes )+ )
			// compilador.g:30:11: ( classes )+
			{
			root_0 = (Object)adaptor.nil();


			// compilador.g:30:11: ( classes )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 20 && LA1_0 <= 22)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// compilador.g:30:11: classes
					{
					pushFollow(FOLLOW_classes_in_program35);
					classes1=classes();
					state._fsp--;

					adaptor.addChild(root_0, classes1.getTree());

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

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class classes_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "classes"
	// compilador.g:32:1: classes : accessmod 'class' ID '{' ( member )* '}' ;
	public final compiladorParser.classes_return classes() throws RecognitionException {
		compiladorParser.classes_return retval = new compiladorParser.classes_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal3=null;
		Token ID4=null;
		Token char_literal5=null;
		Token char_literal7=null;
		ParserRuleReturnScope accessmod2 =null;
		ParserRuleReturnScope member6 =null;

		Object string_literal3_tree=null;
		Object ID4_tree=null;
		Object char_literal5_tree=null;
		Object char_literal7_tree=null;

		try {
			// compilador.g:32:9: ( accessmod 'class' ID '{' ( member )* '}' )
			// compilador.g:32:11: accessmod 'class' ID '{' ( member )* '}'
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_accessmod_in_classes45);
			accessmod2=accessmod();
			state._fsp--;

			adaptor.addChild(root_0, accessmod2.getTree());

			string_literal3=(Token)match(input,17,FOLLOW_17_in_classes47); 
			string_literal3_tree = (Object)adaptor.create(string_literal3);
			adaptor.addChild(root_0, string_literal3_tree);

			ID4=(Token)match(input,ID,FOLLOW_ID_in_classes49); 
			ID4_tree = (Object)adaptor.create(ID4);
			adaptor.addChild(root_0, ID4_tree);

			char_literal5=(Token)match(input,23,FOLLOW_23_in_classes51); 
			char_literal5_tree = (Object)adaptor.create(char_literal5);
			adaptor.addChild(root_0, char_literal5_tree);

			// compilador.g:32:36: ( member )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 20 && LA2_0 <= 22)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// compilador.g:32:36: member
					{
					pushFollow(FOLLOW_member_in_classes53);
					member6=member();
					state._fsp--;

					adaptor.addChild(root_0, member6.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			char_literal7=(Token)match(input,24,FOLLOW_24_in_classes56); 
			char_literal7_tree = (Object)adaptor.create(char_literal7);
			adaptor.addChild(root_0, char_literal7_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "classes"


	public static class member_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "member"
	// compilador.g:34:1: member : ( method | attributes );
	public final compiladorParser.member_return member() throws RecognitionException {
		compiladorParser.member_return retval = new compiladorParser.member_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope method8 =null;
		ParserRuleReturnScope attributes9 =null;


		try {
			// compilador.g:34:8: ( method | attributes )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= 20 && LA3_0 <= 22)) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==16||(LA3_1 >= 18 && LA3_1 <= 19)) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==ID) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==8) ) {
							alt3=1;
						}
						else if ( (LA3_3==12||LA3_3==14) ) {
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
					// compilador.g:34:10: method
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_method_in_member65);
					method8=method();
					state._fsp--;

					adaptor.addChild(root_0, method8.getTree());

					}
					break;
				case 2 :
					// compilador.g:34:19: attributes
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_attributes_in_member69);
					attributes9=attributes();
					state._fsp--;

					adaptor.addChild(root_0, attributes9.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "member"


	public static class attributes_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "attributes"
	// compilador.g:36:1: attributes : accessmod tipo ID ( ',' ID )* ';' ;
	public final compiladorParser.attributes_return attributes() throws RecognitionException {
		compiladorParser.attributes_return retval = new compiladorParser.attributes_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID12=null;
		Token char_literal13=null;
		Token ID14=null;
		Token char_literal15=null;
		ParserRuleReturnScope accessmod10 =null;
		ParserRuleReturnScope tipo11 =null;

		Object ID12_tree=null;
		Object char_literal13_tree=null;
		Object ID14_tree=null;
		Object char_literal15_tree=null;

		try {
			// compilador.g:36:12: ( accessmod tipo ID ( ',' ID )* ';' )
			// compilador.g:36:14: accessmod tipo ID ( ',' ID )* ';'
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_accessmod_in_attributes78);
			accessmod10=accessmod();
			state._fsp--;

			adaptor.addChild(root_0, accessmod10.getTree());

			pushFollow(FOLLOW_tipo_in_attributes80);
			tipo11=tipo();
			state._fsp--;

			adaptor.addChild(root_0, tipo11.getTree());

			ID12=(Token)match(input,ID,FOLLOW_ID_in_attributes82); 
			ID12_tree = (Object)adaptor.create(ID12);
			adaptor.addChild(root_0, ID12_tree);

			// compilador.g:36:32: ( ',' ID )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==12) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// compilador.g:36:33: ',' ID
					{
					char_literal13=(Token)match(input,12,FOLLOW_12_in_attributes85); 
					char_literal13_tree = (Object)adaptor.create(char_literal13);
					adaptor.addChild(root_0, char_literal13_tree);

					ID14=(Token)match(input,ID,FOLLOW_ID_in_attributes87); 
					ID14_tree = (Object)adaptor.create(ID14);
					adaptor.addChild(root_0, ID14_tree);

					}
					break;

				default :
					break loop4;
				}
			}

			char_literal15=(Token)match(input,14,FOLLOW_14_in_attributes91); 
			char_literal15_tree = (Object)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "attributes"


	public static class method_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "method"
	// compilador.g:38:1: method : accessmod tipo ID '(' ( decl_args )? ')' '{' ( sentences )* '}' ;
	public final compiladorParser.method_return method() throws RecognitionException {
		compiladorParser.method_return retval = new compiladorParser.method_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID18=null;
		Token char_literal19=null;
		Token char_literal21=null;
		Token char_literal22=null;
		Token char_literal24=null;
		ParserRuleReturnScope accessmod16 =null;
		ParserRuleReturnScope tipo17 =null;
		ParserRuleReturnScope decl_args20 =null;
		ParserRuleReturnScope sentences23 =null;

		Object ID18_tree=null;
		Object char_literal19_tree=null;
		Object char_literal21_tree=null;
		Object char_literal22_tree=null;
		Object char_literal24_tree=null;

		try {
			// compilador.g:38:8: ( accessmod tipo ID '(' ( decl_args )? ')' '{' ( sentences )* '}' )
			// compilador.g:38:10: accessmod tipo ID '(' ( decl_args )? ')' '{' ( sentences )* '}'
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_accessmod_in_method100);
			accessmod16=accessmod();
			state._fsp--;

			adaptor.addChild(root_0, accessmod16.getTree());

			pushFollow(FOLLOW_tipo_in_method102);
			tipo17=tipo();
			state._fsp--;

			adaptor.addChild(root_0, tipo17.getTree());

			ID18=(Token)match(input,ID,FOLLOW_ID_in_method104); 
			ID18_tree = (Object)adaptor.create(ID18);
			adaptor.addChild(root_0, ID18_tree);

			char_literal19=(Token)match(input,8,FOLLOW_8_in_method106); 
			char_literal19_tree = (Object)adaptor.create(char_literal19);
			adaptor.addChild(root_0, char_literal19_tree);

			// compilador.g:38:32: ( decl_args )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==16||(LA5_0 >= 18 && LA5_0 <= 19)) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// compilador.g:38:32: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_method108);
					decl_args20=decl_args();
					state._fsp--;

					adaptor.addChild(root_0, decl_args20.getTree());

					}
					break;

			}

			char_literal21=(Token)match(input,9,FOLLOW_9_in_method111); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);

			char_literal22=(Token)match(input,23,FOLLOW_23_in_method113); 
			char_literal22_tree = (Object)adaptor.create(char_literal22);
			adaptor.addChild(root_0, char_literal22_tree);

			// compilador.g:38:51: ( sentences )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==ID||LA6_0==16||(LA6_0 >= 18 && LA6_0 <= 19)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// compilador.g:38:51: sentences
					{
					pushFollow(FOLLOW_sentences_in_method115);
					sentences23=sentences();
					state._fsp--;

					adaptor.addChild(root_0, sentences23.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			char_literal24=(Token)match(input,24,FOLLOW_24_in_method118); 
			char_literal24_tree = (Object)adaptor.create(char_literal24);
			adaptor.addChild(root_0, char_literal24_tree);

			 SymT.clear(); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "method"


	public static class variables_local_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "variables_local"
	// compilador.g:40:1: variables_local : tipo id1= ID ( ',' id2= ID )* ';' ;
	public final compiladorParser.variables_local_return variables_local() throws RecognitionException {
		compiladorParser.variables_local_return retval = new compiladorParser.variables_local_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id1=null;
		Token id2=null;
		Token char_literal26=null;
		Token char_literal27=null;
		ParserRuleReturnScope tipo25 =null;

		Object id1_tree=null;
		Object id2_tree=null;
		Object char_literal26_tree=null;
		Object char_literal27_tree=null;

		try {
			// compilador.g:41:5: ( tipo id1= ID ( ',' id2= ID )* ';' )
			// compilador.g:41:7: tipo id1= ID ( ',' id2= ID )* ';'
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_tipo_in_variables_local133);
			tipo25=tipo();
			state._fsp--;

			adaptor.addChild(root_0, tipo25.getTree());

			id1=(Token)match(input,ID,FOLLOW_ID_in_variables_local137); 
			id1_tree = (Object)adaptor.create(id1);
			adaptor.addChild(root_0, id1_tree);

			 pushID((id1!=null?id1.getText():null),(tipo25!=null?input.toString(tipo25.start,tipo25.stop):null)); 
			// compilador.g:41:53: ( ',' id2= ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==12) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// compilador.g:41:54: ',' id2= ID
					{
					char_literal26=(Token)match(input,12,FOLLOW_12_in_variables_local142); 
					char_literal26_tree = (Object)adaptor.create(char_literal26);
					adaptor.addChild(root_0, char_literal26_tree);

					id2=(Token)match(input,ID,FOLLOW_ID_in_variables_local146); 
					id2_tree = (Object)adaptor.create(id2);
					adaptor.addChild(root_0, id2_tree);

					 pushID((id2!=null?id2.getText():null),(tipo25!=null?input.toString(tipo25.start,tipo25.stop):null)); 
					}
					break;

				default :
					break loop7;
				}
			}

			char_literal27=(Token)match(input,14,FOLLOW_14_in_variables_local152); 
			char_literal27_tree = (Object)adaptor.create(char_literal27);
			adaptor.addChild(root_0, char_literal27_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variables_local"


	public static class decl_args_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "decl_args"
	// compilador.g:44:1: decl_args : t1= tipo id1= ID ( ',' t2= tipo id2= ID )* ;
	public final compiladorParser.decl_args_return decl_args() throws RecognitionException {
		compiladorParser.decl_args_return retval = new compiladorParser.decl_args_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token id1=null;
		Token id2=null;
		Token char_literal28=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		Object id1_tree=null;
		Object id2_tree=null;
		Object char_literal28_tree=null;

		try {
			// compilador.g:45:5: (t1= tipo id1= ID ( ',' t2= tipo id2= ID )* )
			// compilador.g:45:7: t1= tipo id1= ID ( ',' t2= tipo id2= ID )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_tipo_in_decl_args171);
			t1=tipo();
			state._fsp--;

			adaptor.addChild(root_0, t1.getTree());

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_args175); 
			id1_tree = (Object)adaptor.create(id1);
			adaptor.addChild(root_0, id1_tree);

			 pushID((id1!=null?id1.getText():null),(t1!=null?input.toString(t1.start,t1.stop):null)); 
			// compilador.g:45:54: ( ',' t2= tipo id2= ID )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==12) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// compilador.g:45:55: ',' t2= tipo id2= ID
					{
					char_literal28=(Token)match(input,12,FOLLOW_12_in_decl_args180); 
					char_literal28_tree = (Object)adaptor.create(char_literal28);
					adaptor.addChild(root_0, char_literal28_tree);

					pushFollow(FOLLOW_tipo_in_decl_args184);
					t2=tipo();
					state._fsp--;

					adaptor.addChild(root_0, t2.getTree());

					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_args188); 
					id2_tree = (Object)adaptor.create(id2);
					adaptor.addChild(root_0, id2_tree);

					 pushID((id2!=null?id2.getText():null),(t2!=null?input.toString(t2.start,t2.stop):null)); 
					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decl_args"


	public static class sentences_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "sentences"
	// compilador.g:48:1: sentences : ( asignacion | variables_local );
	public final compiladorParser.sentences_return sentences() throws RecognitionException {
		compiladorParser.sentences_return retval = new compiladorParser.sentences_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope asignacion29 =null;
		ParserRuleReturnScope variables_local30 =null;


		try {
			// compilador.g:48:11: ( asignacion | variables_local )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==16||(LA9_0 >= 18 && LA9_0 <= 19)) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// compilador.g:48:13: asignacion
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_asignacion_in_sentences205);
					asignacion29=asignacion();
					state._fsp--;

					adaptor.addChild(root_0, asignacion29.getTree());

					}
					break;
				case 2 :
					// compilador.g:48:26: variables_local
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_variables_local_in_sentences209);
					variables_local30=variables_local();
					state._fsp--;

					adaptor.addChild(root_0, variables_local30.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sentences"


	public static class asignacion_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "asignacion"
	// compilador.g:49:1: asignacion : ID '=' expr ';' ;
	public final compiladorParser.asignacion_return asignacion() throws RecognitionException {
		compiladorParser.asignacion_return retval = new compiladorParser.asignacion_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID31=null;
		Token char_literal32=null;
		Token char_literal34=null;
		ParserRuleReturnScope expr33 =null;

		Object ID31_tree=null;
		Object char_literal32_tree=null;
		Object char_literal34_tree=null;

		try {
			// compilador.g:49:12: ( ID '=' expr ';' )
			// compilador.g:49:14: ID '=' expr ';'
			{
			root_0 = (Object)adaptor.nil();


			ID31=(Token)match(input,ID,FOLLOW_ID_in_asignacion217); 
			ID31_tree = (Object)adaptor.create(ID31);
			adaptor.addChild(root_0, ID31_tree);

			char_literal32=(Token)match(input,15,FOLLOW_15_in_asignacion219); 
			char_literal32_tree = (Object)adaptor.create(char_literal32);
			adaptor.addChild(root_0, char_literal32_tree);

			pushFollow(FOLLOW_expr_in_asignacion221);
			expr33=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr33.getTree());

			char_literal34=(Token)match(input,14,FOLLOW_14_in_asignacion223); 
			char_literal34_tree = (Object)adaptor.create(char_literal34);
			adaptor.addChild(root_0, char_literal34_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "asignacion"


	public static class expr_return extends ParserRuleReturnScope {
		public int vType;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// compilador.g:51:1: expr returns [int vType] : m1= multExpr ( ( '+' | '-' ) m2= multExpr )* ;
	public final compiladorParser.expr_return expr() throws RecognitionException {
		compiladorParser.expr_return retval = new compiladorParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set35=null;
		ParserRuleReturnScope m1 =null;
		ParserRuleReturnScope m2 =null;

		Object set35_tree=null;

		try {
			// compilador.g:52:5: (m1= multExpr ( ( '+' | '-' ) m2= multExpr )* )
			// compilador.g:52:7: m1= multExpr ( ( '+' | '-' ) m2= multExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr242);
			m1=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, m1.getTree());

			 retval.vType = (m1!=null?((compiladorParser.multExpr_return)m1).vType:0); 
			// compilador.g:53:7: ( ( '+' | '-' ) m2= multExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==11||LA10_0==13) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// compilador.g:53:9: ( '+' | '-' ) m2= multExpr
					{
					set35=input.LT(1);
					if ( input.LA(1)==11||input.LA(1)==13 ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set35));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr262);
					m2=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, m2.getTree());

					 if (retval.vType != (m2!=null?((compiladorParser.multExpr_return)m2).vType:0)) retval.vType = 3; 
					}
					break;

				default :
					break loop10;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		public int vType;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multExpr"
	// compilador.g:56:1: multExpr returns [int vType] : a1= atomo ( '*' a2= atomo )* ;
	public final compiladorParser.multExpr_return multExpr() throws RecognitionException {
		compiladorParser.multExpr_return retval = new compiladorParser.multExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal36=null;
		ParserRuleReturnScope a1 =null;
		ParserRuleReturnScope a2 =null;

		Object char_literal36_tree=null;

		try {
			// compilador.g:57:5: (a1= atomo ( '*' a2= atomo )* )
			// compilador.g:57:7: a1= atomo ( '*' a2= atomo )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_atomo_in_multExpr290);
			a1=atomo();
			state._fsp--;

			adaptor.addChild(root_0, a1.getTree());

			 retval.vType = (a1!=null?((compiladorParser.atomo_return)a1).vType:0); 
			// compilador.g:58:7: ( '*' a2= atomo )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==10) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// compilador.g:58:9: '*' a2= atomo
					{
					char_literal36=(Token)match(input,10,FOLLOW_10_in_multExpr302); 
					char_literal36_tree = (Object)adaptor.create(char_literal36);
					adaptor.addChild(root_0, char_literal36_tree);

					pushFollow(FOLLOW_atomo_in_multExpr306);
					a2=atomo();
					state._fsp--;

					adaptor.addChild(root_0, a2.getTree());

					 if (retval.vType != (a2!=null?((compiladorParser.atomo_return)a2).vType:0)) retval.vType = 3; 
					}
					break;

				default :
					break loop11;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atomo_return extends ParserRuleReturnScope {
		public int vType;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atomo"
	// compilador.g:61:1: atomo returns [int vType] : ( CINT | CFLOAT | ID | '(' expr ')' );
	public final compiladorParser.atomo_return atomo() throws RecognitionException {
		compiladorParser.atomo_return retval = new compiladorParser.atomo_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token CINT37=null;
		Token CFLOAT38=null;
		Token ID39=null;
		Token char_literal40=null;
		Token char_literal42=null;
		ParserRuleReturnScope expr41 =null;

		Object CINT37_tree=null;
		Object CFLOAT38_tree=null;
		Object ID39_tree=null;
		Object char_literal40_tree=null;
		Object char_literal42_tree=null;

		try {
			// compilador.g:62:5: ( CINT | CFLOAT | ID | '(' expr ')' )
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
			case 8:
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
					// compilador.g:62:7: CINT
					{
					root_0 = (Object)adaptor.nil();


					CINT37=(Token)match(input,CINT,FOLLOW_CINT_in_atomo332); 
					CINT37_tree = (Object)adaptor.create(CINT37);
					adaptor.addChild(root_0, CINT37_tree);

					 retval.vType = 1; 
					}
					break;
				case 2 :
					// compilador.g:63:7: CFLOAT
					{
					root_0 = (Object)adaptor.nil();


					CFLOAT38=(Token)match(input,CFLOAT,FOLLOW_CFLOAT_in_atomo342); 
					CFLOAT38_tree = (Object)adaptor.create(CFLOAT38);
					adaptor.addChild(root_0, CFLOAT38_tree);

					 retval.vType = 2; 
					}
					break;
				case 3 :
					// compilador.g:64:7: ID
					{
					root_0 = (Object)adaptor.nil();


					ID39=(Token)match(input,ID,FOLLOW_ID_in_atomo352); 
					ID39_tree = (Object)adaptor.create(ID39);
					adaptor.addChild(root_0, ID39_tree);

					 retval.vType = getSymbolType((ID39!=null?ID39.getText():null)); 
					}
					break;
				case 4 :
					// compilador.g:65:7: '(' expr ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal40=(Token)match(input,8,FOLLOW_8_in_atomo362); 
					char_literal40_tree = (Object)adaptor.create(char_literal40);
					adaptor.addChild(root_0, char_literal40_tree);

					pushFollow(FOLLOW_expr_in_atomo364);
					expr41=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr41.getTree());

					char_literal42=(Token)match(input,9,FOLLOW_9_in_atomo366); 
					char_literal42_tree = (Object)adaptor.create(char_literal42);
					adaptor.addChild(root_0, char_literal42_tree);

					 retval.vType = (expr41!=null?((compiladorParser.expr_return)expr41).vType:0); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atomo"


	public static class tipo_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tipo"
	// compilador.g:68:1: tipo : ( 'int' | 'double' | 'String' );
	public final compiladorParser.tipo_return tipo() throws RecognitionException {
		compiladorParser.tipo_return retval = new compiladorParser.tipo_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set43=null;

		Object set43_tree=null;

		try {
			// compilador.g:68:6: ( 'int' | 'double' | 'String' )
			// compilador.g:
			{
			root_0 = (Object)adaptor.nil();


			set43=input.LT(1);
			if ( input.LA(1)==16||(input.LA(1) >= 18 && input.LA(1) <= 19) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set43));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tipo"


	public static class accessmod_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "accessmod"
	// compilador.g:69:1: accessmod : ( 'public' | 'private' | 'protected' );
	public final compiladorParser.accessmod_return accessmod() throws RecognitionException {
		compiladorParser.accessmod_return retval = new compiladorParser.accessmod_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set44=null;

		Object set44_tree=null;

		try {
			// compilador.g:69:11: ( 'public' | 'private' | 'protected' )
			// compilador.g:
			{
			root_0 = (Object)adaptor.nil();


			set44=input.LT(1);
			if ( (input.LA(1) >= 20 && input.LA(1) <= 22) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set44));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "accessmod"

	// Delegated rules



	public static final BitSet FOLLOW_classes_in_program35 = new BitSet(new long[]{0x0000000000700002L});
	public static final BitSet FOLLOW_accessmod_in_classes45 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_classes47 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_classes49 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_classes51 = new BitSet(new long[]{0x0000000001700000L});
	public static final BitSet FOLLOW_member_in_classes53 = new BitSet(new long[]{0x0000000001700000L});
	public static final BitSet FOLLOW_24_in_classes56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_method_in_member65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_member69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_attributes78 = new BitSet(new long[]{0x00000000000D0000L});
	public static final BitSet FOLLOW_tipo_in_attributes80 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_attributes82 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_12_in_attributes85 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_attributes87 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_14_in_attributes91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_accessmod_in_method100 = new BitSet(new long[]{0x00000000000D0000L});
	public static final BitSet FOLLOW_tipo_in_method102 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_method104 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_method106 = new BitSet(new long[]{0x00000000000D0200L});
	public static final BitSet FOLLOW_decl_args_in_method108 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_method111 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_method113 = new BitSet(new long[]{0x00000000010D0040L});
	public static final BitSet FOLLOW_sentences_in_method115 = new BitSet(new long[]{0x00000000010D0040L});
	public static final BitSet FOLLOW_24_in_method118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_variables_local133 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_variables_local137 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_12_in_variables_local142 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_variables_local146 = new BitSet(new long[]{0x0000000000005000L});
	public static final BitSet FOLLOW_14_in_variables_local152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args171 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_decl_args175 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_decl_args180 = new BitSet(new long[]{0x00000000000D0000L});
	public static final BitSet FOLLOW_tipo_in_decl_args184 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_decl_args188 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_asignacion_in_sentences205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variables_local_in_sentences209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion217 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_asignacion219 = new BitSet(new long[]{0x0000000000000170L});
	public static final BitSet FOLLOW_expr_in_asignacion221 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_asignacion223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr242 = new BitSet(new long[]{0x0000000000002802L});
	public static final BitSet FOLLOW_set_in_expr254 = new BitSet(new long[]{0x0000000000000170L});
	public static final BitSet FOLLOW_multExpr_in_expr262 = new BitSet(new long[]{0x0000000000002802L});
	public static final BitSet FOLLOW_atomo_in_multExpr290 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_multExpr302 = new BitSet(new long[]{0x0000000000000170L});
	public static final BitSet FOLLOW_atomo_in_multExpr306 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_CINT_in_atomo332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CFLOAT_in_atomo342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atomo352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atomo362 = new BitSet(new long[]{0x0000000000000170L});
	public static final BitSet FOLLOW_expr_in_atomo364 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atomo366 = new BitSet(new long[]{0x0000000000000002L});
}
