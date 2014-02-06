// $ANTLR 3.5 /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g 2014-01-30 12:54:51

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
public class II2Parser extends DebugParser {
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
		"invalidRule", "start", "fact", "expr", "term"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public II2Parser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public II2Parser(TokenStream input, int port, RecognizerSharedState state) {
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

	public II2Parser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return II2Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g"; }



	// $ANTLR start "start"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:11:1: start : expr ;
	public final void start() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "start");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:12:2: ( expr )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:12:4: expr
			{
			dbg.location(12,4);
			pushFollow(FOLLOW_expr_in_start19);
			expr();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(13, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "start"



	// $ANTLR start "expr"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:15:1: expr : term ( PLUS term | MINUS term )* ;
	public final void expr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(15, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:16:2: ( term ( PLUS term | MINUS term )* )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:16:4: term ( PLUS term | MINUS term )*
			{
			dbg.location(16,4);
			pushFollow(FOLLOW_term_in_expr31);
			term();
			state._fsp--;
			dbg.location(16,9);
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:16:9: ( PLUS term | MINUS term )*
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

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:16:10: PLUS term
					{
					dbg.location(16,10);
					match(input,PLUS,FOLLOW_PLUS_in_expr34); dbg.location(16,15);
					pushFollow(FOLLOW_term_in_expr36);
					term();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:16:22: MINUS term
					{
					dbg.location(16,22);
					match(input,MINUS,FOLLOW_MINUS_in_expr40); dbg.location(16,28);
					pushFollow(FOLLOW_term_in_expr42);
					term();
					state._fsp--;

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
		dbg.location(17, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr"



	// $ANTLR start "term"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:19:1: term : fact ( TIMES fact | DIVISION fact )* ;
	public final void term() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(19, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:20:2: ( fact ( TIMES fact | DIVISION fact )* )
			dbg.enterAlt(1);

			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:20:4: fact ( TIMES fact | DIVISION fact )*
			{
			dbg.location(20,4);
			pushFollow(FOLLOW_fact_in_term57);
			fact();
			state._fsp--;
			dbg.location(20,9);
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:20:9: ( TIMES fact | DIVISION fact )*
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

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:20:10: TIMES fact
					{
					dbg.location(20,10);
					match(input,TIMES,FOLLOW_TIMES_in_term60); dbg.location(20,16);
					pushFollow(FOLLOW_fact_in_term62);
					fact();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:20:23: DIVISION fact
					{
					dbg.location(20,23);
					match(input,DIVISION,FOLLOW_DIVISION_in_term66); dbg.location(20,32);
					pushFollow(FOLLOW_fact_in_term68);
					fact();
					state._fsp--;

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
		dbg.location(21, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "term"



	// $ANTLR start "fact"
	// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:23:1: fact : ( LPAR expr RPAR | ID | NUM );
	public final void fact() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "fact");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(23, 0);

		try {
			// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:24:2: ( LPAR expr RPAR | ID | NUM )
			int alt3=3;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			switch ( input.LA(1) ) {
			case LPAR:
				{
				alt3=1;
				}
				break;
			case ID:
				{
				alt3=2;
				}
				break;
			case NUM:
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

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:24:4: LPAR expr RPAR
					{
					dbg.location(24,4);
					match(input,LPAR,FOLLOW_LPAR_in_fact81); dbg.location(24,9);
					pushFollow(FOLLOW_expr_in_fact83);
					expr();
					state._fsp--;
					dbg.location(24,14);
					match(input,RPAR,FOLLOW_RPAR_in_fact85); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:25:4: ID
					{
					dbg.location(25,4);
					match(input,ID,FOLLOW_ID_in_fact90); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Workspaces/lft project/parteII/Grammatica 2/II2.g:26:4: NUM
					{
					dbg.location(26,4);
					match(input,NUM,FOLLOW_NUM_in_fact95); 
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
		dbg.location(27, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fact");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "fact"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_start19 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr31 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_PLUS_in_expr34 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr36 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_MINUS_in_expr40 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr42 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_fact_in_term57 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_TIMES_in_term60 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term62 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_DIVISION_in_term66 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term68 = new BitSet(new long[]{0x0000000000000812L});
	public static final BitSet FOLLOW_LPAR_in_fact81 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact83 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_RPAR_in_fact85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_fact95 = new BitSet(new long[]{0x0000000000000002L});
}
