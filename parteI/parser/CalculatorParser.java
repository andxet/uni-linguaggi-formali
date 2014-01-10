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
	
	public int start(){
		int expr_val;
		expr_val = expr();
		match(Tag.EOF);
		
		return expr_val;
	}
	
	private int expr(){
		int term_val, exprp_val;
		
		term_val = term();
		exprp_val = exprp(term_val);
		
		return exprp_val;
	}
	
	private int exprp(int exprp_i){
		int term_val, exprp_val;
		
		if (look.tag == Tag.PLUS){
			match(Tag.PLUS);
			term_val = term();
			exprp_val = exprp(exprp_i + term_val);
			return exprp_val;
		}
		if (look.tag == Tag.MINUS){
			match(Tag.MINUS);
			term_val = term();
			exprp_val = exprp(exprp_i - term_val);
			return exprp_val;
		}
		return exprp_i;
	}
	
	private int term(){
		int fact_val, termp_val;
		
		fact_val = fact();
		termp_val = termp(fact_val);
		
		return termp_val;
	}
	
	private int termp(int termp_i){
		int fact_val, termp_val;
		
		if(look.tag == Tag.TIMES){
			match(Tag.TIMES);
			fact_val = fact();
			termp_val = termp(termp_i * fact_val);
			return termp_val;
		}
		if(look.tag == Tag.DIVISON){
			match(Tag.DIVISON);
			fact_val = fact();
			termp_val = termp(termp_i / fact_val);
			return termp_val;
		}
		return termp_i;//epsilon
	}
	
	private int fact(){
		if(look.tag == Tag.LPAR){
			int expr_val;
			
			match(Tag.LPAR);
			expr_val = expr();
			match(Tag.RPAR);
			return expr_val;
		}
		if(look.tag == Tag.NUM){
			int fact_val = Integer.parseInt(look.lessema);
			match(Tag.NUM);
			return fact_val;
		}
		/*if(look.tag == Tag.ID){
			match(Tag.ID);
			return;
		}*/
		//Tutti non terminali... se non c'è un match, si è verificato un errore
		error("syntax error");
		return 0;
	}

}
