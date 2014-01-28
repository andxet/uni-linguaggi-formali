// $ANTLR 3.5 /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g 2014-01-28 11:12:01

	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 1 es II
	

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class II1Parser extends DebugParser {
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
		"invalidRule", "termp", "term", "expr", "start", "exprp", "fact"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public II1Parser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public II1Parser(TokenStream input, int port, RecognizerSharedState state) {
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

	public II1Parser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return II1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g"; }



	// $ANTLR start "start"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:37:1: start : expr EOF ;
	public final void start() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "start");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:38:2: ( expr EOF )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:38:4: expr EOF
			{
			dbg.location(38,4);
			pushFollow(FOLLOW_expr_in_start147);
			expr();
			state._fsp--;
			dbg.location(38,9);
			match(input,EOF,FOLLOW_EOF_in_start149); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(39, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "start"



	// $ANTLR start "expr"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:41:1: expr : term exprp ;
	public final void expr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(41, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:42:2: ( term exprp )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:42:4: term exprp
			{
			dbg.location(42,4);
			pushFollow(FOLLOW_term_in_expr161);
			term();
			state._fsp--;
			dbg.location(42,9);
			pushFollow(FOLLOW_exprp_in_expr163);
			exprp();
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
		dbg.location(43, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr"



	// $ANTLR start "exprp"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:45:1: exprp : ( PLUS term exprp | MINUS term exprp |);
	public final void exprp() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "exprp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(45, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:46:2: ( PLUS term exprp | MINUS term exprp |)
			int alt1=3;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt1=1;
				}
				break;
			case MINUS:
				{
				alt1=2;
				}
				break;
			case EOF:
			case RPAR:
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:46:4: PLUS term exprp
					{
					dbg.location(46,4);
					match(input,PLUS,FOLLOW_PLUS_in_exprp176); dbg.location(46,9);
					pushFollow(FOLLOW_term_in_exprp178);
					term();
					state._fsp--;
					dbg.location(46,14);
					pushFollow(FOLLOW_exprp_in_exprp180);
					exprp();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:47:4: MINUS term exprp
					{
					dbg.location(47,4);
					match(input,MINUS,FOLLOW_MINUS_in_exprp185); dbg.location(47,10);
					pushFollow(FOLLOW_term_in_exprp187);
					term();
					state._fsp--;
					dbg.location(47,15);
					pushFollow(FOLLOW_exprp_in_exprp189);
					exprp();
					state._fsp--;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:49:2: 
					{
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
		dbg.location(49, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "exprp"



	// $ANTLR start "term"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:51:1: term : fact termp ;
	public final void term() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(51, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:52:2: ( fact termp )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:52:4: fact termp
			{
			dbg.location(52,4);
			pushFollow(FOLLOW_fact_in_term205);
			fact();
			state._fsp--;
			dbg.location(52,9);
			pushFollow(FOLLOW_termp_in_term207);
			termp();
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
		dbg.location(53, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "term"



	// $ANTLR start "termp"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:55:1: termp : ( TIMES fact termp | DIVISION fact termp |);
	public final void termp() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "termp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(55, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:56:2: ( TIMES fact termp | DIVISION fact termp |)
			int alt2=3;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			switch ( input.LA(1) ) {
			case TIMES:
				{
				alt2=1;
				}
				break;
			case DIVISION:
				{
				alt2=2;
				}
				break;
			case EOF:
			case MINUS:
			case PLUS:
			case RPAR:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:56:4: TIMES fact termp
					{
					dbg.location(56,4);
					match(input,TIMES,FOLLOW_TIMES_in_termp220); dbg.location(56,10);
					pushFollow(FOLLOW_fact_in_termp222);
					fact();
					state._fsp--;
					dbg.location(56,15);
					pushFollow(FOLLOW_termp_in_termp224);
					termp();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:57:4: DIVISION fact termp
					{
					dbg.location(57,4);
					match(input,DIVISION,FOLLOW_DIVISION_in_termp229); dbg.location(57,13);
					pushFollow(FOLLOW_fact_in_termp231);
					fact();
					state._fsp--;
					dbg.location(57,18);
					pushFollow(FOLLOW_termp_in_termp233);
					termp();
					state._fsp--;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:59:2: 
					{
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
		dbg.location(59, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "termp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "termp"



	// $ANTLR start "fact"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:61:1: fact : ( LPAR expr RPAR | ID | NUM );
	public final void fact() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "fact");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:62:2: ( LPAR expr RPAR | ID | NUM )
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

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:62:4: LPAR expr RPAR
					{
					dbg.location(62,4);
					match(input,LPAR,FOLLOW_LPAR_in_fact249); dbg.location(62,9);
					pushFollow(FOLLOW_expr_in_fact251);
					expr();
					state._fsp--;
					dbg.location(62,14);
					match(input,RPAR,FOLLOW_RPAR_in_fact253); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:63:4: ID
					{
					dbg.location(63,4);
					match(input,ID,FOLLOW_ID_in_fact258); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:64:4: NUM
					{
					dbg.location(64,4);
					match(input,NUM,FOLLOW_NUM_in_fact263); 
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
		dbg.location(65, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fact");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "fact"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_start147 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_start149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr161 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_expr163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_exprp176 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp178 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_exprp180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_exprp185 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp187 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_exprp189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fact_in_term205 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_term207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMES_in_termp220 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp222 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_termp224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIVISION_in_termp229 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp231 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_termp233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fact249 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact251 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_RPAR_in_fact253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_fact263 = new BitSet(new long[]{0x0000000000000002L});
}
