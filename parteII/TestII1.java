import org.antlr.runtime.*;

public class TestII1 {
	public static void main ( String [] args ) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream ( System.in );
		II4Lexer lexer = new II4Lexer (input );
		CommonTokenStream tokens = new CommonTokenStream ( lexer );
		II4Parser parser = new II4Parser ( tokens );
		parser.start();
	}
}
