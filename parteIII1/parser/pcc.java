import org.antlr.runtime.*;

//import parser.*;

public class pcc {
	public static void main ( String [] args ) throws Exception {
		ANTLRFileStream fileInput;
		ANTLRInputStream input;
		III1Lexer lexer;
		if(args.length == 1){
			String file = args[0];
			System.out.println("Lettura dal file: " + file);
			fileInput = new ANTLRFileStream(file);
			lexer = new III1Lexer (fileInput);
		}else{
			System.out.println("Modalità interattiva");
			input = new ANTLRInputStream(System.in);
			lexer = new III1Lexer (input);
		}
		CommonTokenStream tokens = new CommonTokenStream ( lexer );
		III1Parser parser = new III1Parser ( tokens );
		parser.prog();
	}
}
