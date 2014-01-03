package lexer;

public class Tag {
	private final int tag;
	private final String tagName[] = {"LPAR", "RPAR", "PLUS", "MINUS", "NUM", "EOF", "TIMES", "DIVISION"};
	
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
	public static Tag TIMES = new Tag(6);
	public static Tag DIVISON = new Tag(7);

	public boolean equals(Tag i){
		return i.tag == tag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClass() != Tag.class)
			return false;
		Tag a = (Tag) arg0;
		return a.tag == tag;
	}
	
	
}
