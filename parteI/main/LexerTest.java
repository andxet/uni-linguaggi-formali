package main;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;

public class LexerTest {
	/*
	 * Appena trova un carattere illecito il programma esce
	 */
	public static void main(String[] args) {
		Lexer lex = new Lexer ();

		Token tok;
		try{
			do {
				tok = lex.scan();
				System.out.println("Scan: " + tok);
			} while (tok.tag != Tag.EOF);
		}catch (IllegalArgumentException e){
			System.out.flush();
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
//			System.out.flush();
//			System.out.println("Scan: " + tok);
//		} while (tok.tag != Tag.EOF);
//
//	}
}
