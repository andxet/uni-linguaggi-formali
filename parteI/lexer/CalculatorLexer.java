package lexer;

import java.io.*;

public class CalculatorLexer{
	public static int line = 1;
	private char peek = ' ';

	private void readch(){
		try{
			peek = (char) System.in.read();
		} catch (IOException e){
			peek = (char) -1; //ERROR = EOF
		}
	}

	public Token scan(){
		while (peek == ' ' || peek == '\t' || peek == '\n' ){
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

		default:
			if (Character.isDigit(peek)) {
				String s = "";
				do {
					s += peek;
					readch();
				} while (Character.isDigit(peek));
				return new Token(Tag.NUM, s);

			}
			else{
				throw new IllegalArgumentException("Trovato carattere illecito");
			}
		}

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