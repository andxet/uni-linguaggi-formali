import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, Type> typeMap = new HashMap<String, Type>();
	
	public void insert(String s, Type t){
		if(!typeMap.containsKey(s))
			typeMap.put(s, t);
		else
			throw new IllegalArgumentException("Variabile duplicata " + s);
	}
	
	public Type lookupType(String s){
		if(typeMap.containsKey(s))
			return typeMap.get(s);
		else
			throw new IllegalArgumentException("Variabile sconosciuta "+s);
	}
}
