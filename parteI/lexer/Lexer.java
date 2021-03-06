package lexer;

import java.io.*;

public class Lexer{
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
		//while (peek == ' ' || peek == '\t' || peek == '\n'){//La consegna dice che i ritorni a capo vanno ignorati, nel debug viene utilizzata la linea di sopra in modo che i ritorni a capo vengano trattati come token EOF. Per seguire la consegna, questa riga deve essere decommentata al posto di quella sopra.
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
			//Deccommentare il seguente per rendere riconoscibili gli ID
			/*else if(Character.isLetter(peek)){
				StringBuffer b = new StringBuffer();
				do{
					b.append(peek); 
					readch();
				} while (Character.isLetterOrDigit(peek));
				return new Token(Tag.ID, b.toString());
			}*/
			else error(peek);
			return null;
		}

	}
	
	private void error(char s){
		throw new IllegalArgumentException("Trovato carattere illecito: " + s);
	}
}