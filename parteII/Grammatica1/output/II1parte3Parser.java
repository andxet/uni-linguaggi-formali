// $ANTLR 3.5 /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g 2014-01-28 12:07:08

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
public class II1parte3Parser extends DebugParser {
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
		"invalidRule", "termp", "fact", "expr", "term", "start", "exprp"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public II1parte3Parser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public II1parte3Parser(TokenStream input, int port, RecognizerSharedState state) {
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

	public II1parte3Parser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return II1parte3Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g"; }



	// $ANTLR start "start"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:37:1: start : rexpr= expr EOF ;
	public final void start() throws RecognitionException {
		int rexpr =0;

		try { dbg.enterRule(getGrammarFileName(), "start");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:38:2: (rexpr= expr EOF )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:38:4: rexpr= expr EOF
			{
			dbg.location(38,9);
			pushFollow(FOLLOW_expr_in_start144);
			rexpr=expr();
			state._fsp--;
			dbg.location(38,15);
			match(input,EOF,FOLLOW_EOF_in_start146); dbg.location(39,3);
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
		dbg.location(40, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "start"



	// $ANTLR start "expr"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:42:1: expr returns [int val] : rterm= term rexprp= exprp[rterm] ;
	public final int expr() throws RecognitionException {
		int val = 0;


		int rterm =0;
		int rexprp =0;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(42, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:43:2: (rterm= term rexprp= exprp[rterm] )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:43:4: rterm= term rexprp= exprp[rterm]
			{
			dbg.location(43,9);
			pushFollow(FOLLOW_term_in_expr167);
			rterm=term();
			state._fsp--;
			dbg.location(43,21);
			pushFollow(FOLLOW_exprp_in_expr171);
			rexprp=exprp(rterm);
			state._fsp--;
			dbg.location(44,3);
			 val =rexprp; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(45, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "expr"



	// $ANTLR start "exprp"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:47:1: exprp[int i] returns [int val] : ( PLUS rterm= term rexprp= exprp[$i + rterm] | MINUS rterm= term rexprp= exprp[$i - rterm] |);
	public final int exprp(int i) throws RecognitionException {
		int val = 0;


		int rterm =0;
		int rexprp =0;

		try { dbg.enterRule(getGrammarFileName(), "exprp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(47, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:48:2: ( PLUS rterm= term rexprp= exprp[$i + rterm] | MINUS rterm= term rexprp= exprp[$i - rterm] |)
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

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:48:4: PLUS rterm= term rexprp= exprp[$i + rterm]
					{
					dbg.location(48,4);
					match(input,PLUS,FOLLOW_PLUS_in_exprp194); dbg.location(48,14);
					pushFollow(FOLLOW_term_in_exprp198);
					rterm=term();
					state._fsp--;
					dbg.location(48,26);
					pushFollow(FOLLOW_exprp_in_exprp202);
					rexprp=exprp(i + rterm);
					state._fsp--;
					dbg.location(49,3);
					 val=rexprp; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:51:4: MINUS rterm= term rexprp= exprp[$i - rterm]
					{
					dbg.location(51,4);
					match(input,MINUS,FOLLOW_MINUS_in_exprp215); dbg.location(51,15);
					pushFollow(FOLLOW_term_in_exprp219);
					rterm=term();
					state._fsp--;
					dbg.location(51,27);
					pushFollow(FOLLOW_exprp_in_exprp223);
					rexprp=exprp(i - rterm);
					state._fsp--;
					dbg.location(52,3);
					 val=rexprp; 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:53:4: 
					{
					dbg.location(53,4);
					 val=i; 
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
		dbg.location(54, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "exprp"



	// $ANTLR start "term"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:56:1: term returns [int val] : rfact= fact rtemp= termp[rfact] ;
	public final int term() throws RecognitionException {
		int val = 0;


		int rfact =0;
		int rtemp =0;

		try { dbg.enterRule(getGrammarFileName(), "term");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(56, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:57:2: (rfact= fact rtemp= termp[rfact] )
			dbg.enterAlt(1);

			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:57:4: rfact= fact rtemp= termp[rfact]
			{
			dbg.location(57,9);
			pushFollow(FOLLOW_fact_in_term252);
			rfact=fact();
			state._fsp--;
			dbg.location(57,20);
			pushFollow(FOLLOW_termp_in_term256);
			rtemp=termp(rfact);
			state._fsp--;
			dbg.location(58,3);
			 val=rtemp; 
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
			dbg.exitRule(getGrammarFileName(), "term");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "term"



	// $ANTLR start "termp"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:61:1: termp[int i] returns [int val] : ( TIMES rfact= fact rtermp= termp[rfact * i] | DIVISION rfact= fact rtermp= termp[i / rfact] |);
	public final int termp(int i) throws RecognitionException {
		int val = 0;


		int rfact =0;
		int rtermp =0;

		try { dbg.enterRule(getGrammarFileName(), "termp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:62:2: ( TIMES rfact= fact rtermp= termp[rfact * i] | DIVISION rfact= fact rtermp= termp[i / rfact] |)
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

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:62:4: TIMES rfact= fact rtermp= termp[rfact * i]
					{
					dbg.location(62,4);
					match(input,TIMES,FOLLOW_TIMES_in_termp280); dbg.location(62,15);
					pushFollow(FOLLOW_fact_in_termp284);
					rfact=fact();
					state._fsp--;
					dbg.location(62,27);
					pushFollow(FOLLOW_termp_in_termp288);
					rtermp=termp(rfact * i);
					state._fsp--;
					dbg.location(63,3);
					 val=rtermp; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:64:4: DIVISION rfact= fact rtermp= termp[i / rfact]
					{
					dbg.location(64,4);
					match(input,DIVISION,FOLLOW_DIVISION_in_termp298); dbg.location(64,18);
					pushFollow(FOLLOW_fact_in_termp302);
					rfact=fact();
					state._fsp--;
					dbg.location(64,30);
					pushFollow(FOLLOW_termp_in_termp306);
					rtermp=termp(i / rfact);
					state._fsp--;
					dbg.location(65,3);
					 val=rtermp; 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:66:4: 
					{
					dbg.location(66,4);
					val=i;
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
		dbg.location(67, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "termp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return val;
	}
	// $ANTLR end "termp"



	// $ANTLR start "fact"
	// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:69:1: fact returns [int val] : ( LPAR ris= expr RPAR | ID | NUM );
	public final int fact() throws RecognitionException {
		int val = 0;


		Token NUM1=null;
		int ris =0;

		try { dbg.enterRule(getGrammarFileName(), "fact");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(69, 0);

		try {
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:70:2: ( LPAR ris= expr RPAR | ID | NUM )
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

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:70:4: LPAR ris= expr RPAR
					{
					dbg.location(70,4);
					match(input,LPAR,FOLLOW_LPAR_in_fact332); dbg.location(70,12);
					pushFollow(FOLLOW_expr_in_fact336);
					ris=expr();
					state._fsp--;
					dbg.location(70,18);
					match(input,RPAR,FOLLOW_RPAR_in_fact338); dbg.location(71,3);
					 val=ris; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:72:4: ID
					{
					dbg.location(72,4);
					match(input,ID,FOLLOW_ID_in_fact347); dbg.location(73,3);
					 val=0; 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1parte3.g:74:4: NUM
					{
					dbg.location(74,4);
					NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_fact356); dbg.location(75,3);
					 val=Integer.parseInt((NUM1!=null?NUM1.getText():null)); 
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
		dbg.location(76, 1);

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



	public static final BitSet FOLLOW_expr_in_start144 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_start146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr167 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_expr171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_exprp194 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp198 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_exprp202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_exprp215 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp219 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_exprp_in_exprp223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fact_in_term252 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_term256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMES_in_termp280 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp284 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_termp288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIVISION_in_termp298 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp302 = new BitSet(new long[]{0x0000000000000810L});
	public static final BitSet FOLLOW_termp_in_termp306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fact332 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact336 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_RPAR_in_fact338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_fact356 = new BitSet(new long[]{0x0000000000000002L});
}
