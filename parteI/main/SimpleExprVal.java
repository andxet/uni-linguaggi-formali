package main;

import parser.CalculatorParser;
import lexer.CalculatorLexer;

public class SimpleExprVal {
	public static void main(String[] args) {
		CalculatorLexer lex = new CalculatorLexer();
		CalculatorParser par = new CalculatorParser(lex);
		System.out.println(par.start());
	}

}
