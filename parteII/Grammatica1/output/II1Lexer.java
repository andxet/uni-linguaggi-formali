// $ANTLR 3.5 /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g 2014-01-28 11:12:01

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class II1Lexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public II1Lexer() {} 
	public II1Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public II1Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g"; }

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:10:2: ( '+' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:10:4: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:13:2: ( '-' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:13:4: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:16:2: ( '*' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:16:4: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "DIVISION"
	public final void mDIVISION() throws RecognitionException {
		try {
			int _type = DIVISION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:19:2: ( '/' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:19:4: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVISION"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:22:2: ( '(' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:22:4: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:25:2: ( ')' )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:25:4: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:28:2: ( '1' .. '9' ( '0' .. '9' )* | '0' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			else if ( (LA2_0=='0') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:28:4: '1' .. '9' ( '0' .. '9' )*
					{
					matchRange('1','9'); 
					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:28:12: ( '0' .. '9' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;
				case 2 :
					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:28:24: '0'
					{
					match('0'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:31:2: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:31:4: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:31:4: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:34:2: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:34:4: ( ' ' | '\\t' | '\\n' | '\\r' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:8: ( PLUS | MINUS | TIMES | DIVISION | LPAR | RPAR | NUM | ID | WS )
		int alt4=9;
		switch ( input.LA(1) ) {
		case '+':
			{
			alt4=1;
			}
			break;
		case '-':
			{
			alt4=2;
			}
			break;
		case '*':
			{
			alt4=3;
			}
			break;
		case '/':
			{
			alt4=4;
			}
			break;
		case '(':
			{
			alt4=5;
			}
			break;
		case ')':
			{
			alt4=6;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt4=7;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt4=8;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt4=9;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:10: PLUS
				{
				mPLUS(); 

				}
				break;
			case 2 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:15: MINUS
				{
				mMINUS(); 

				}
				break;
			case 3 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:21: TIMES
				{
				mTIMES(); 

				}
				break;
			case 4 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:27: DIVISION
				{
				mDIVISION(); 

				}
				break;
			case 5 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:36: LPAR
				{
				mLPAR(); 

				}
				break;
			case 6 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:41: RPAR
				{
				mRPAR(); 

				}
				break;
			case 7 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:46: NUM
				{
				mNUM(); 

				}
				break;
			case 8 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:50: ID
				{
				mID(); 

				}
				break;
			case 9 :
				// /Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/II1.g:1:53: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
