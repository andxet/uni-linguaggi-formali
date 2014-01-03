package main;

import parser.CalculatorParser;
import lexer.CalculatorLexer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculatorLexer lex = new CalculatorLexer();
		CalculatorParser par = new CalculatorParser(lex);
		try{
			par.start();
			System.out.println("La stringa rispetta la grammatica.");
		}catch (Error e){
			System.err.println(e.getMessage() + "\n La stringa non rispetta la grammatica.");			
		}
	}

}
