package lexer;

public class Tag {
	private final int tag;
	private final String tagName[] = {"LPAR", "RPAR", "PLUS", "MINUS", "NUM", "EOF"};
	
	private Tag(int tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return tagName[this.tag];
	}

	public static Tag LPAR = new Tag(0);
	public static Tag RPAR = new Tag(1);
	public static Tag PLUS = new Tag(2);
	public static Tag MINUS = new Tag(3);
	public static Tag NUM = new Tag(4);
	public static Tag EOF = new Tag(5);
}
