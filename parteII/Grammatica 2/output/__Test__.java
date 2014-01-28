import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        II2parte3Lexer lex = new II2parte3Lexer(new ANTLRFileStream("/Users/andrea/Documents/workspace/lft project1/parteII/Grammatica 2/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        II2parte3Parser g = new II2parte3Parser(tokens, 49100, null);
        try {
            g.start();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}