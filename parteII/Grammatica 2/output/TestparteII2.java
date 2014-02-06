import org.antlr.runtime.*;

public class TestparteII2 {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        II2Lexer lexer = new II2Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        II2Parser parser = new II2Parser(tokens);
        parser.start();
    }
	
}
