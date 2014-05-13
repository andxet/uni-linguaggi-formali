package main;

import parser.CalculatorParser;
import lexer.Lexer;

public class SimpleExprVal {
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		CalculatorParser par = new CalculatorParser(lex);
		System.out.println(par.start());
	}

}
