import org.antlr.runtime.*;

//import parser.*;

public class pcc {
	public static void main ( String [] args ) throws Exception {
		ANTLRFileStream fileInput;
		ANTLRInputStream input;
		PLexer lexer;
		if(args.length == 1){
			String file = args[0];
			System.out.println("Lettura dal file: " + file);
			fileInput = new ANTLRFileStream(file);
			lexer = new PLexer (fileInput);
		}else{
			System.out.println("Modalità interattiva");
			input = new ANTLRInputStream(System.in);
			lexer = new PLexer (input);
		}
		CommonTokenStream tokens = new CommonTokenStream ( lexer );
		PParser parser = new PParser ( tokens );
		parser.prog();
	}
}
