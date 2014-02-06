
import org.antlr.runtime.*;

public class TestparteII1 {

    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        II1Lexer lexer = new II1Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        II1Parser parser = new II1Parser(tokens);
        parser.start();
    }
	
}
