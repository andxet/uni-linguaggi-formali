// $ANTLR 3.5 ./III1.g 2014-05-19 12:43:13

  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es II parte 4
  

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class III1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "NUM", "WS", "'('", "')'", 
		"'*'", "'+'", "','", "'-'", "'/'", "':'", "':='", "';'", "'<'", "'<='", 
		"'<>'", "'='", "'>'", "'>='", "'and'", "'begin'", "'boolean'", "'do'", 
		"'else'", "'end'", "'false'", "'if'", "'integer'", "'not'", "'or'", "'print'", 
		"'then'", "'true'", "'var'", "'while'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
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
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int ID=4;
	public static final int NUM=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public III1Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public III1Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return III1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "./III1.g"; }



	// $ANTLR start "prog"
	// ./III1.g:9:1: prog : ( decl ';' )* stmt EOF ;
	public final void prog() throws RecognitionException {
		try {
			// ./III1.g:10:3: ( ( decl ';' )* stmt EOF )
			// ./III1.g:10:5: ( decl ';' )* stmt EOF
			{
			// ./III1.g:10:5: ( decl ';' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==37) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./III1.g:10:7: decl ';'
					{
					pushFollow(FOLLOW_decl_in_prog22);
					decl();
					state._fsp--;

					match(input,16,FOLLOW_16_in_prog24); 
					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_stmt_in_prog29);
			stmt();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_prog31); 
			System.out.println("OK");
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
	// $ANTLR end "prog"



	// $ANTLR start "decl"
	// ./III1.g:13:1: decl : 'var' ID ( ',' ID )* ':' type ;
	public final void decl() throws RecognitionException {
		try {
			// ./III1.g:14:3: ( 'var' ID ( ',' ID )* ':' type )
			// ./III1.g:14:5: 'var' ID ( ',' ID )* ':' type
			{
			match(input,37,FOLLOW_37_in_decl48); 
			match(input,ID,FOLLOW_ID_in_decl50); 
			// ./III1.g:14:14: ( ',' ID )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==11) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// ./III1.g:14:15: ',' ID
					{
					match(input,11,FOLLOW_11_in_decl53); 
					match(input,ID,FOLLOW_ID_in_decl55); 
					}
					break;

				default :
					break loop2;
				}
			}

			match(input,14,FOLLOW_14_in_decl59); 
			pushFollow(FOLLOW_type_in_decl61);
			type();
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
	}
	// $ANTLR end "decl"



	// $ANTLR start "type"
	// ./III1.g:17:1: type : ( 'integer' | 'boolean' );
	public final void type() throws RecognitionException {
		try {
			// ./III1.g:18:3: ( 'integer' | 'boolean' )
			// ./III1.g:
			{
			if ( input.LA(1)==25||input.LA(1)==31 ) {
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
	// $ANTLR end "type"



	// $ANTLR start "expr"
	// ./III1.g:22:1: expr : andExpr ( 'or' andExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// ./III1.g:23:3: ( andExpr ( 'or' andExpr )* )
			// ./III1.g:23:5: andExpr ( 'or' andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_expr97);
			andExpr();
			state._fsp--;

			// ./III1.g:23:13: ( 'or' andExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==33) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ./III1.g:23:15: 'or' andExpr
					{
					match(input,33,FOLLOW_33_in_expr101); 
					pushFollow(FOLLOW_andExpr_in_expr103);
					andExpr();
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
	// $ANTLR end "expr"



	// $ANTLR start "andExpr"
	// ./III1.g:26:1: andExpr : relExpr ( 'and' relExpr )* ;
	public final void andExpr() throws RecognitionException {
		try {
			// ./III1.g:27:3: ( relExpr ( 'and' relExpr )* )
			// ./III1.g:27:5: relExpr ( 'and' relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr120);
			relExpr();
			state._fsp--;

			// ./III1.g:27:13: ( 'and' relExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==23) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ./III1.g:27:15: 'and' relExpr
					{
					match(input,23,FOLLOW_23_in_andExpr124); 
					pushFollow(FOLLOW_relExpr_in_andExpr126);
					relExpr();
					state._fsp--;

					}
					break;

				default :
					break loop4;
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
	// $ANTLR end "andExpr"



	// $ANTLR start "relExpr"
	// ./III1.g:30:1: relExpr : addExpr ( '=' addExpr | '<>' addExpr | '<=' addExpr | '>=' addExpr | '<' addExpr | '>' addExpr )? ;
	public final void relExpr() throws RecognitionException {
		try {
			// ./III1.g:31:3: ( addExpr ( '=' addExpr | '<>' addExpr | '<=' addExpr | '>=' addExpr | '<' addExpr | '>' addExpr )? )
			// ./III1.g:31:5: addExpr ( '=' addExpr | '<>' addExpr | '<=' addExpr | '>=' addExpr | '<' addExpr | '>' addExpr )?
			{
			pushFollow(FOLLOW_addExpr_in_relExpr143);
			addExpr();
			state._fsp--;

			// ./III1.g:31:13: ( '=' addExpr | '<>' addExpr | '<=' addExpr | '>=' addExpr | '<' addExpr | '>' addExpr )?
			int alt5=7;
			switch ( input.LA(1) ) {
				case 20:
					{
					alt5=1;
					}
					break;
				case 19:
					{
					alt5=2;
					}
					break;
				case 18:
					{
					alt5=3;
					}
					break;
				case 22:
					{
					alt5=4;
					}
					break;
				case 17:
					{
					alt5=5;
					}
					break;
				case 21:
					{
					alt5=6;
					}
					break;
			}
			switch (alt5) {
				case 1 :
					// ./III1.g:31:15: '=' addExpr
					{
					match(input,20,FOLLOW_20_in_relExpr147); 
					pushFollow(FOLLOW_addExpr_in_relExpr150);
					addExpr();
					state._fsp--;

					}
					break;
				case 2 :
					// ./III1.g:32:15: '<>' addExpr
					{
					match(input,19,FOLLOW_19_in_relExpr166); 
					pushFollow(FOLLOW_addExpr_in_relExpr168);
					addExpr();
					state._fsp--;

					}
					break;
				case 3 :
					// ./III1.g:33:15: '<=' addExpr
					{
					match(input,18,FOLLOW_18_in_relExpr184); 
					pushFollow(FOLLOW_addExpr_in_relExpr186);
					addExpr();
					state._fsp--;

					}
					break;
				case 4 :
					// ./III1.g:34:15: '>=' addExpr
					{
					match(input,22,FOLLOW_22_in_relExpr202); 
					pushFollow(FOLLOW_addExpr_in_relExpr204);
					addExpr();
					state._fsp--;

					}
					break;
				case 5 :
					// ./III1.g:35:15: '<' addExpr
					{
					match(input,17,FOLLOW_17_in_relExpr220); 
					pushFollow(FOLLOW_addExpr_in_relExpr223);
					addExpr();
					state._fsp--;

					}
					break;
				case 6 :
					// ./III1.g:36:15: '>' addExpr
					{
					match(input,21,FOLLOW_21_in_relExpr239); 
					pushFollow(FOLLOW_addExpr_in_relExpr242);
					addExpr();
					state._fsp--;

					}
					break;

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
	// $ANTLR end "relExpr"



	// $ANTLR start "addExpr"
	// ./III1.g:40:1: addExpr : mulExpr ( '+' mulExpr | '-' mulExpr )* ;
	public final void addExpr() throws RecognitionException {
		try {
			// ./III1.g:41:3: ( mulExpr ( '+' mulExpr | '-' mulExpr )* )
			// ./III1.g:41:5: mulExpr ( '+' mulExpr | '-' mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr272);
			mulExpr();
			state._fsp--;

			// ./III1.g:41:13: ( '+' mulExpr | '-' mulExpr )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==10) ) {
					alt6=1;
				}
				else if ( (LA6_0==12) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// ./III1.g:41:15: '+' mulExpr
					{
					match(input,10,FOLLOW_10_in_addExpr276); 
					pushFollow(FOLLOW_mulExpr_in_addExpr278);
					mulExpr();
					state._fsp--;

					}
					break;
				case 2 :
					// ./III1.g:42:15: '-' mulExpr
					{
					match(input,12,FOLLOW_12_in_addExpr294); 
					pushFollow(FOLLOW_mulExpr_in_addExpr296);
					mulExpr();
					state._fsp--;

					}
					break;

				default :
					break loop6;
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
	// $ANTLR end "addExpr"



	// $ANTLR start "mulExpr"
	// ./III1.g:46:1: mulExpr : unExpr ( '*' unExpr | '/' unExpr )* ;
	public final void mulExpr() throws RecognitionException {
		try {
			// ./III1.g:47:3: ( unExpr ( '*' unExpr | '/' unExpr )* )
			// ./III1.g:47:5: unExpr ( '*' unExpr | '/' unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr326);
			unExpr();
			state._fsp--;

			// ./III1.g:47:12: ( '*' unExpr | '/' unExpr )*
			loop7:
			while (true) {
				int alt7=3;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==9) ) {
					alt7=1;
				}
				else if ( (LA7_0==13) ) {
					alt7=2;
				}

				switch (alt7) {
				case 1 :
					// ./III1.g:47:14: '*' unExpr
					{
					match(input,9,FOLLOW_9_in_mulExpr330); 
					pushFollow(FOLLOW_unExpr_in_mulExpr332);
					unExpr();
					state._fsp--;

					}
					break;
				case 2 :
					// ./III1.g:48:14: '/' unExpr
					{
					match(input,13,FOLLOW_13_in_mulExpr347); 
					pushFollow(FOLLOW_unExpr_in_mulExpr349);
					unExpr();
					state._fsp--;

					}
					break;

				default :
					break loop7;
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
	// $ANTLR end "mulExpr"



	// $ANTLR start "unExpr"
	// ./III1.g:52:1: unExpr : ( '+' unExpr | '-' unExpr | 'not' unExpr | primary );
	public final void unExpr() throws RecognitionException {
		try {
			// ./III1.g:53:3: ( '+' unExpr | '-' unExpr | 'not' unExpr | primary )
			int alt8=4;
			switch ( input.LA(1) ) {
			case 10:
				{
				alt8=1;
				}
				break;
			case 12:
				{
				alt8=2;
				}
				break;
			case 32:
				{
				alt8=3;
				}
				break;
			case ID:
			case NUM:
			case 7:
			case 29:
			case 36:
				{
				alt8=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// ./III1.g:53:5: '+' unExpr
					{
					match(input,10,FOLLOW_10_in_unExpr387); 
					pushFollow(FOLLOW_unExpr_in_unExpr391);
					unExpr();
					state._fsp--;

					}
					break;
				case 2 :
					// ./III1.g:54:5: '-' unExpr
					{
					match(input,12,FOLLOW_12_in_unExpr397); 
					pushFollow(FOLLOW_unExpr_in_unExpr402);
					unExpr();
					state._fsp--;

					}
					break;
				case 3 :
					// ./III1.g:55:5: 'not' unExpr
					{
					match(input,32,FOLLOW_32_in_unExpr408); 
					pushFollow(FOLLOW_unExpr_in_unExpr411);
					unExpr();
					state._fsp--;

					}
					break;
				case 4 :
					// ./III1.g:56:5: primary
					{
					pushFollow(FOLLOW_primary_in_unExpr417);
					primary();
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
	// $ANTLR end "unExpr"



	// $ANTLR start "primary"
	// ./III1.g:59:1: primary : ( '(' expr ')' | ID | NUM | 'true' | 'false' );
	public final void primary() throws RecognitionException {
		try {
			// ./III1.g:60:3: ( '(' expr ')' | ID | NUM | 'true' | 'false' )
			int alt9=5;
			switch ( input.LA(1) ) {
			case 7:
				{
				alt9=1;
				}
				break;
			case ID:
				{
				alt9=2;
				}
				break;
			case NUM:
				{
				alt9=3;
				}
				break;
			case 36:
				{
				alt9=4;
				}
				break;
			case 29:
				{
				alt9=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// ./III1.g:60:5: '(' expr ')'
					{
					match(input,7,FOLLOW_7_in_primary432); 
					pushFollow(FOLLOW_expr_in_primary434);
					expr();
					state._fsp--;

					match(input,8,FOLLOW_8_in_primary436); 
					}
					break;
				case 2 :
					// ./III1.g:61:5: ID
					{
					match(input,ID,FOLLOW_ID_in_primary442); 
					}
					break;
				case 3 :
					// ./III1.g:62:5: NUM
					{
					match(input,NUM,FOLLOW_NUM_in_primary448); 
					}
					break;
				case 4 :
					// ./III1.g:63:5: 'true'
					{
					match(input,36,FOLLOW_36_in_primary454); 
					}
					break;
				case 5 :
					// ./III1.g:64:5: 'false'
					{
					match(input,29,FOLLOW_29_in_primary460); 
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
	// $ANTLR end "primary"



	// $ANTLR start "stmt"
	// ./III1.g:67:1: stmt : ( ID ':=' expr | 'print' '(' expr ')' | 'if' expr 'then' stmt ( 'else' stmt )? | 'while' expr 'do' stmt | 'begin' stmt ( ';' stmt )* 'end' );
	public final void stmt() throws RecognitionException {
		try {
			// ./III1.g:68:3: ( ID ':=' expr | 'print' '(' expr ')' | 'if' expr 'then' stmt ( 'else' stmt )? | 'while' expr 'do' stmt | 'begin' stmt ( ';' stmt )* 'end' )
			int alt12=5;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt12=1;
				}
				break;
			case 34:
				{
				alt12=2;
				}
				break;
			case 30:
				{
				alt12=3;
				}
				break;
			case 38:
				{
				alt12=4;
				}
				break;
			case 24:
				{
				alt12=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// ./III1.g:68:5: ID ':=' expr
					{
					match(input,ID,FOLLOW_ID_in_stmt475); 
					match(input,15,FOLLOW_15_in_stmt477); 
					pushFollow(FOLLOW_expr_in_stmt479);
					expr();
					state._fsp--;

					}
					break;
				case 2 :
					// ./III1.g:69:5: 'print' '(' expr ')'
					{
					match(input,34,FOLLOW_34_in_stmt485); 
					match(input,7,FOLLOW_7_in_stmt487); 
					pushFollow(FOLLOW_expr_in_stmt489);
					expr();
					state._fsp--;

					match(input,8,FOLLOW_8_in_stmt491); 
					}
					break;
				case 3 :
					// ./III1.g:70:5: 'if' expr 'then' stmt ( 'else' stmt )?
					{
					match(input,30,FOLLOW_30_in_stmt497); 
					pushFollow(FOLLOW_expr_in_stmt499);
					expr();
					state._fsp--;

					match(input,35,FOLLOW_35_in_stmt501); 
					pushFollow(FOLLOW_stmt_in_stmt503);
					stmt();
					state._fsp--;

					// ./III1.g:70:27: ( 'else' stmt )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==27) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// ./III1.g:70:28: 'else' stmt
							{
							match(input,27,FOLLOW_27_in_stmt506); 
							pushFollow(FOLLOW_stmt_in_stmt508);
							stmt();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// ./III1.g:71:5: 'while' expr 'do' stmt
					{
					match(input,38,FOLLOW_38_in_stmt516); 
					pushFollow(FOLLOW_expr_in_stmt518);
					expr();
					state._fsp--;

					match(input,26,FOLLOW_26_in_stmt520); 
					pushFollow(FOLLOW_stmt_in_stmt522);
					stmt();
					state._fsp--;

					}
					break;
				case 5 :
					// ./III1.g:72:5: 'begin' stmt ( ';' stmt )* 'end'
					{
					match(input,24,FOLLOW_24_in_stmt528); 
					pushFollow(FOLLOW_stmt_in_stmt530);
					stmt();
					state._fsp--;

					// ./III1.g:72:18: ( ';' stmt )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==16) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// ./III1.g:72:20: ';' stmt
							{
							match(input,16,FOLLOW_16_in_stmt534); 
							pushFollow(FOLLOW_stmt_in_stmt536);
							stmt();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,28,FOLLOW_28_in_stmt541); 
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
	// $ANTLR end "stmt"

	// Delegated rules



	public static final BitSet FOLLOW_decl_in_prog22 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_prog24 = new BitSet(new long[]{0x0000006441000010L});
	public static final BitSet FOLLOW_stmt_in_prog29 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_prog31 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_decl48 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_decl50 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_decl53 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_decl55 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_decl59 = new BitSet(new long[]{0x0000000082000000L});
	public static final BitSet FOLLOW_type_in_decl61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_andExpr_in_expr97 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_expr101 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_andExpr_in_expr103 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr120 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_andExpr124 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr126 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr143 = new BitSet(new long[]{0x00000000007E0002L});
	public static final BitSet FOLLOW_20_in_relExpr147 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_relExpr166 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_relExpr184 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_relExpr202 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_relExpr220 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_relExpr239 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr272 = new BitSet(new long[]{0x0000000000001402L});
	public static final BitSet FOLLOW_10_in_addExpr276 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr278 = new BitSet(new long[]{0x0000000000001402L});
	public static final BitSet FOLLOW_12_in_addExpr294 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr296 = new BitSet(new long[]{0x0000000000001402L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr326 = new BitSet(new long[]{0x0000000000002202L});
	public static final BitSet FOLLOW_9_in_mulExpr330 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr332 = new BitSet(new long[]{0x0000000000002202L});
	public static final BitSet FOLLOW_13_in_mulExpr347 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr349 = new BitSet(new long[]{0x0000000000002202L});
	public static final BitSet FOLLOW_10_in_unExpr387 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unExpr397 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_unExpr408 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_primary432 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_expr_in_primary434 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_primary436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_primary442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_primary448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_primary454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_primary460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stmt475 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_stmt477 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_expr_in_stmt479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_stmt485 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_stmt487 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_expr_in_stmt489 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_stmt491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_stmt497 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_expr_in_stmt499 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_stmt501 = new BitSet(new long[]{0x0000004441000010L});
	public static final BitSet FOLLOW_stmt_in_stmt503 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_stmt506 = new BitSet(new long[]{0x0000004441000010L});
	public static final BitSet FOLLOW_stmt_in_stmt508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_stmt516 = new BitSet(new long[]{0x00000011200014B0L});
	public static final BitSet FOLLOW_expr_in_stmt518 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_stmt520 = new BitSet(new long[]{0x0000004441000010L});
	public static final BitSet FOLLOW_stmt_in_stmt522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_stmt528 = new BitSet(new long[]{0x0000004441000010L});
	public static final BitSet FOLLOW_stmt_in_stmt530 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_16_in_stmt534 = new BitSet(new long[]{0x0000004441000010L});
	public static final BitSet FOLLOW_stmt_in_stmt536 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_28_in_stmt541 = new BitSet(new long[]{0x0000000000000002L});
}
