package parser;

import lexer.*;

public class CalculatorParser {
	
	private CalculatorLexer lex;
	private Token look;
	
	public CalculatorParser(CalculatorLexer l){
		lex = l;
		move();
	}
	
	void move(){
		look = lex.scan();
		System.err.println("token = " + look);
	}
	
	void error(String s){
		throw new Error("Near line: " + lex.line + ": " + s);
	}
	
	void match(Tag t) {
		if (look.tag.equals(t)) {
			if (look.tag != Tag.EOF) move();
		} else error("syntax error");
	}
	
	public void start(){
		expr();
		match(Tag.EOF);
	}
	
	private void expr(){
		term();
		exprp();
	}
	
	private void exprp(){
		if (look.tag == Tag.PLUS){
			match(Tag.PLUS);
			term();
			exprp();
			return;
		}
		if (look.tag == Tag.MINUS){
			match(Tag.MINUS);
			term();
			exprp();
			return;
		}
	}
	
	private void term(){
		fact();
		termp();
	}
	
	private void termp(){
		if(look.tag == Tag.TIMES){
			match(Tag.TIMES);
			fact();
			termp();
			return;
		}
		if(look.tag == Tag.DIVISON){
			match(Tag.DIVISON);
			fact();
			termp();
			return;
		}
	}
	
	private void fact(){
		if(look.tag == Tag.LPAR){
			match(Tag.LPAR);
			expr();
			match(Tag.RPAR);
			return;
		}
		if(look.tag == Tag.NUM){
			match(Tag.NUM);
			return;
		}
		/*
		if(look.tag == Tag.ID){
			match(Tag.ID);
			return;
		}
		*/
		//Tutti non terminali... se non c'è un match, si è verificato un errore
		error("syntax error");
	}

}
