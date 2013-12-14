package lexer;

public class Token {

	public Tag tag;
	public String lessema;

	public Token(Tag tag, String s) {
		this.tag = tag;
		this.lessema = s;
	}
	
	@Override
	public String toString() {
		return "<" + tag + ",\"" + lessema + "\">";
	}

}
