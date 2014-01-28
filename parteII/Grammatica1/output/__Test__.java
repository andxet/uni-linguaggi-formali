import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        II1parte3Lexer lex = new II1parte3Lexer(new ANTLRFileStream("/Users/andrea/Documents/workspace/lft project1/parteII/Grammatica1/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        II1parte3Parser g = new II1parte3Parser(tokens, 49100, null);
        try {
            g.start();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}