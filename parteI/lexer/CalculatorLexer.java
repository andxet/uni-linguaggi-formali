package lexer;

import java.io.*;

public class CalculatorLexer{
	public int line = 1; //Perchè static?
	private char peek = ' ';

	private void readch(){
		try{
			peek = (char) System.in.read();
		} catch (IOException e){
			peek = (char) -1; //ERROR = EOF
		}
	}

	public Token scan(){
		while (peek == ' ' || peek == '\t'){
		//while (peek == ' ' || peek == '\t' || peek == '\n'){//La consegna dice che i ritorni a capo vanno ignorati, nel debug viene utilizzata la linea di sopra in modo che i ritorni a capo vengano trattati come token EOF. Per seguire la consegna, questa rica deve essere decommentata al posto di quella sopra.
			if (peek == '\n') line++;
			readch();
		}

		switch (peek) {
		case '(':
			peek = ' ';
			return new Token(Tag.LPAR, "(");

		case ')':
			peek = ' ';
			return new Token(Tag.RPAR, ")");

		case '+':
			peek = ' ';
			return new Token(Tag.PLUS, "+");

		case '-':
			peek = ' ';
			return new Token(Tag.MINUS, "-");
			
		case '*':
			peek = ' ';
			return new Token(Tag.TIMES, "*");
			
		case '/':
			peek = ' ';
			return new Token(Tag.DIVISON, "/");
			
		case '\n':
			peek = ' ';
			return new Token(Tag.EOF, "CR-LF");

		default:
			if (Character.isDigit(peek)) {
				String s = "";
				do {
					s += peek;
					readch();
				} while (Character.isDigit(peek));
				return new Token(Tag.NUM, s);

			}
			else error(peek);
			return null;
		}

	}
	
	private void error(char s){
		throw new Error("Trovato carattere illecito: " + s);
	}

	/*
	 * Appena trova un carattere illecito il programma esce
	 */
	public static void main(String[] args) {
		CalculatorLexer lex = new CalculatorLexer ();

		Token tok;
		try{
			do {
				tok = lex.scan();
				System.out.println("Scan: " + tok);
			} while (tok.tag != Tag.EOF);
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Questa versione non chiude il programma quando trova un carattere illecito
	 */
//	public static void main(String[] args) {
//		CalculatorLexer lex = new CalculatorLexer ();
//
//		Token tok;
//
//		do {
//			try{
//				tok = lex.scan();
//			}catch (IllegalArgumentException e){
//				System.out.println(e.getMessage());
//			}
//			System.out.println("Scan: " + tok);
//		} while (tok.tag != Tag.EOF);
//
//	}
}