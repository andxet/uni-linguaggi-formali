/**
 * Questo programma effettua un test del lexer, controlla se una stringa è corretta senza valutarla
**/
package main;

import parser.CalculatorParser;
import lexer.Lexer;

public class ParserTest {
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		CalculatorParser par = new CalculatorParser(lex);
		try{
			par.start();
			System.out.flush();
			System.out.println("La stringa rispetta la grammatica.");
		}catch (Error e){
			System.out.flush();
			System.err.println(e.getMessage() + "\n La stringa non rispetta la grammatica.");			
		}
	}

}
