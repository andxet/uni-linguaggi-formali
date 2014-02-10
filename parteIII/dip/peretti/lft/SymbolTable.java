package peretti.lft;

import java.util.HashMap;

public class SymbolTable<E> {
	private HashMap<String, E> typeMap = new HashMap<String, E>();
	
	public void insert(String s, E t){
		if(!typeMap.containsKey(s))
			typeMap.put(s, t);
		else
			throw new IllegalArgumentException("Variabile duplicata " + s);
	}
	
	public E lookupType(String s){
		if(typeMap.containsKey(s))
			return typeMap.get(s);
		else
			throw new IllegalArgumentException("Variabile sconosciuta "+s);
	}
}
