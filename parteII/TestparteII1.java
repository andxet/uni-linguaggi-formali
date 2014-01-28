import org.antlr.runtime.*;

public class TestparteII1 {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        parteII1Lexer lexer = new parteII1Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parteII1Parser parser = new parteII1Parser(tokens);
        parser.start();
    }
	
}
