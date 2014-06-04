import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, Type> typeMap = new HashMap<String, Type>();
	private HashMap<String, Integer> addrMap = new HashMap<String, Integer>();
	Integer offset;
	
	SymbolTable(){
		offset = 0;
	}
	
	public void insert(String s, Type t){
		if(!typeMap.containsKey(s) && !addrMap.containsKey(s)){
			typeMap.put(s, t);
			addrMap.put(s, offset++);
		}
		else
			throw new IllegalArgumentException("Variabile duplicata " + s);
	}
	
	public Type lookupType(String s){
		if(typeMap.containsKey(s))
			return typeMap.get(s);
		else
			throw new IllegalArgumentException("Variabile sconosciuta "+s);
	}
	
	public int lookupAddr(String s){
		if(addrMap.containsKey(s))
			return addrMap.get(s);
		else
			throw new IllegalArgumentException("Variabile sconosciuta " + s);
	}
}
