import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class WriteFile {
	public static void write(String s){
		try {
			PrintWriter writer = new PrintWriter("Out.j", "UTF-8");
			writer.println(s);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
