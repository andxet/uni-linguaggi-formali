import org.antlr.runtime.*;

public class TestparteI {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        parteII2Lexer lexer = new parteII2Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parteII2Parser parser = new parteII2Parser(tokens);
        parser.start();
    }
	
}
