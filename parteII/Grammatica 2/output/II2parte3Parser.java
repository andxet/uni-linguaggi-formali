// $ANTLR 3.5 /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g 2014-01-30 12:55:35

	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 2 es II
	

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class II2parte3Parser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIVISION", "ID", "LPAR", "MINUS", 
		"NUM", "PLUS", "RPAR", "TIMES", "WS"
	};
	public static final int EOF=-1;
	public static final int DIVISION=4;
	public static final int ID=5;
	public static final int LPAR=6;
	public static final int MINUS=7;
	public static final int NUM=8;
	public static final int PLUS=9;
	public static final int RPAR=10;
	public static final int TIMES=11;
	public static final int WS=12;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "term", "expr", "start", "fact"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public II2parte3Parser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public II2parte3Parser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public II2parte3Parser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return II2parte3Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g"; }



	// $ANTLR start "start"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:11:1: start returns [int val] : rexpr= expr EOF ;
	public final int start() throws RecognitionException {
		int val = 0;


		int rexpr =0;

		try { dbg.enterRule(getGrammarFileName(), "start");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:12:2: (rexpr= expr EOF )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:12:4: rexpr= expr EOF
			{
			dbg.location(12,9);
			pushFollow(FOLLOW_expr_in_start25);
			rexpr=expr();
			state._fsp--;
			dbg.location(12,15);
			match(input,EOF,FOLLOW_EOF_in_start27); dbg.location(13,3);
			 System.out.println(rexpr);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(14, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "start"



	// $ANTLR start "expr"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:16:1: expr returns [int val] : rterm= term ( PLUS rterm2= term | MINUS rterm2= term )* ;
	public final int expr() throws RecognitionException {
		int val = 0;


		int rterm =0;
		int rterm2 =0;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(16, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:17:2: (rterm= term ( PLUS rterm2= term | MINUS rterm2= term )* )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:17:4: rterm= term ( PLUS rterm2= term | MINUS rterm2= term )*
			{
			dbg.location(17,9);
			pushFollow(FOLLOW_term_in_expr49);
			rterm=term();
			state._fsp--;
			dbg.location(17,15);
			val =rterm;dbg.location(17,28);
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:17:28: ( PLUS rterm2= term | MINUS rterm2= term )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=3;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==PLUS) ) {
					alt1=1;
				}
				else if ( (LA1_0==MINUS) ) {
					alt1=2;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:18:4: PLUS rterm2= term
					{
					dbg.location(18,4);
					match(input,PLUS,FOLLOW_PLUS_in_expr57); dbg.location(18,15);
					pushFollow(FOLLOW_term_in_expr61);
					rterm2=term();
					state._fsp--;
					dbg.location(19,4);
					 val =val + rterm2; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:21:4: MINUS rterm2= term
					{
					dbg.location(21,4);
					match(input,MINUS,FOLLOW_MINUS_in_expr76); dbg.location(21,16);
					pushFollow(FOLLOW_term_in_expr80);
					rterm2=term();
					state._fsp--;
					dbg.location(22,4);
					 val =val - rterm2; 
					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(24, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "expr"



	// $ANTLR start "term"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:26:1: term returns [int val] : rfact= fact ( TIMES rterm= fact | DIVISION rterm= fact )* ;
	public final int term() throws RecognitionException {
		int val = 0;


		int rfact =0;
		int rterm =0;

		try { dbg.enterRule(getGrammarFileName(), "term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(26, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:27:2: (rfact= fact ( TIMES rterm= fact | DIVISION rterm= fact )* )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:27:4: rfact= fact ( TIMES rterm= fact | DIVISION rterm= fact )*
			{
			dbg.location(27,9);
			pushFollow(FOLLOW_fact_in_term110);
			rfact=fact();
			state._fsp--;
			dbg.location(27,15);
			val =rfact;dbg.location(27,29);
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:27:29: ( TIMES rterm= fact | DIVISION rterm= fact )*
			try { dbg.enterSubRule(2);

			loop2:
			while (true) {
				int alt2=3;
				try { dbg.enterDecision(2, decisionCanBacktrack[2]);

				int LA2_0 = input.LA(1);
				if ( (LA2_0==TIMES) ) {
					alt2=1;
				}
				else if ( (LA2_0==DIVISION) ) {
					alt2=2;
				}

				} finally {dbg.exitDecision(2);}

				switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:28:4: TIMES rterm= fact
					{
					dbg.location(28,4);
					match(input,TIMES,FOLLOW_TIMES_in_term119); dbg.location(28,15);
					pushFollow(FOLLOW_fact_in_term123);
					rterm=fact();
					state._fsp--;
					dbg.location(29,4);
					 val =val*rterm; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:31:4: DIVISION rterm= fact
					{
					dbg.location(31,4);
					match(input,DIVISION,FOLLOW_DIVISION_in_term138); dbg.location(31,18);
					pushFollow(FOLLOW_fact_in_term142);
					rterm=fact();
					state._fsp--;
					dbg.location(32,4);
					 val =val/rterm; 
					}
					break;

				default :
					break loop2;
				}
			}
			} finally {dbg.exitSubRule(2);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(34, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "term"



	// $ANTLR start "fact"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:36:1: fact returns [int val] : ( LPAR rexpr= expr RPAR | NUM | ID );
	public final int fact() throws RecognitionException {
		int val = 0;


		Token NUM1=null;
		int rexpr =0;

		try { dbg.enterRule(getGrammarFileName(), "fact");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(36, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:37:2: ( LPAR rexpr= expr RPAR | NUM | ID )
			int alt3=3;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			switch ( input.LA(1) ) {
			case LPAR:
				{
				alt3=1;
				}
				break;
			case NUM:
				{
				alt3=2;
				}
				break;
			case ID:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:37:4: LPAR rexpr= expr RPAR
					{
					dbg.location(37,4);
					match(input,LPAR,FOLLOW_LPAR_in_fact168); dbg.location(37,14);
					pushFollow(FOLLOW_expr_in_fact172);
					rexpr=expr();
					state._fsp--;
					dbg.location(37,20);
					match(input,RPAR,FOLLOW_RPAR_in_fact174); dbg.location(38,3);
					 val =rexpr; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:39:4: NUM
					{
					dbg.location(39,4);
					NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_fact183); dbg.location(40,3);
					 val = Integer.parseInt((NUM1!=null?NUM1.getText():null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2parte3.g:41:4: ID
					{
					dbg.location(41,4);
					match(input,ID,FOLLOW_ID_in_fact192); dbg.location(42,3);
					 val = 0; 
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
		dbg.location(43, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fact");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "fact"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_start25 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_start27 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr49 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_PLUS_in_expr57 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr61 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_MINUS_in_expr76 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr80 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_fact_in_term110 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_TIMES_in_term119 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term123 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_DIVISION_in_term138 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term142 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_LPAR_in_fact168 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact172 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_RPAR_in_fact174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_fact183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact192 = new BitSet(new long[]{0x0000000000000002L});
}
