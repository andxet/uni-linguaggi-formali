grammar parla;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es III 1 linguaggio Parla
  package peretti.lft.parla;
  import peretti.lft.*;
  }
  
@members{
	public enum Type { INT, BOOL };
	public enum Plur { S, P }; //Singolare o plurale
	SymbolTable<Type> st = new SymbolTable<Type>();
	void testPlur(int i, Plur p){//Controlla se e' stato utilizzato il plurale nel caso in cui in assegnamento e dichiarazione vengano coinvolte pi? variabili
		if((i>1 && p==Plur.S) || (i==1 && p==Plur.P))
			throw new IllegalArgumentException("Errore Singolare/plurale.");
	}
	
	void error(String s){
		throw new IllegalArgumentException(s);
	}
}
  
start
	: ( statement )* EOF { System.out.println("Nessun errore rilevato."); }
	;
	
statement
	: declaration
	| assignment
	| ifstatement
	| whilestatement
	| print
	;
	
please
	: ',' 'per' 'favore' ','
	;
	
integer returns [Type type, Plur plur]
	: 'intera' {$type=Type.INT; $plur=Plur.S;}
	| 'intere' {$type=Type.INT; $plur=Plur.P;}
	;
	
booleano returns [Type type, Plur plur]
	: 'booleana' {$type=Type.BOOL; $plur=Plur.S;}
	| 'booleane' {$type=Type.BOOL; $plur=Plur.P;}
	;
	
declaration
	@init{
  		ArrayList<String> ids = new ArrayList<String>();
  		Plur s=null, t=null, up=null;
  		Type ut=null;
 	}
	: 'Assumi che'
	 ('la variabile' {s=Plur.S;}| 'le variabili' {s=Plur.P;})
	 z=ID {ids.add($z.text);} (',' z=ID {ids.add($z.text);} )*
	 ('sia' {t=Plur.S;}| 'siano'{t=Plur.P;})
	 ( u=integer {ut=$u.type; up=$u.plur;}| v=booleano {ut=$v.type; up=$v.plur;})
	 '.'
	 {if(s!=t || s!=up)
	 	error("Errore Singolare/plurale.");
	  testPlur(ids.size(), s);
	  for(String id: ids)
	  	st.insert(id, ut);
	 }
	;
	
assignment
	@init{
		ArrayList<Type> ris = new ArrayList<Type>();
		Plur p=null;
	}
	: 'Metti' ( 'il valore' {p=Plur.S;}| 'i valori' {p=Plur.P;}) 'di'
	
	  s=expr { ris.add($s.type); }
	  (',' s=expr {ris.add($s.type);})*
	  
	  {testPlur(ris.size(), p); ArrayList<String> ids=new ArrayList<String>();}
	  'in'
	  
	  q=ID {if(st.lookupType($q.text)!=ris.remove(0)) error("Non posso eseguire l'assegnamento, i tipi non coincidono.");}
	  (',' q=ID {if(ris.isEmpty())
	  		error("Il numero di valori specificati non coincide con il numero degli ID.");
	  	   if(st.lookupType($q.text)!=ris.remove(0))
	  	   	error("Non posso eseguire l'assegnamento, i tipi non coincidono.");}
	  )*
	  {if(!ris.isEmpty())//Se la lista non ? vuota, sono stai dichiarati pi? valori.
	        error("Il numero di ID specificati non coincide con il numero dei tipi.");}
	  '.'
	;
	
ifstatement
	: 'Se "' r=expr {if($r.type!=Type.BOOL) error("La condizione non e' di tipo booleana.");} '"' E 'vera' please 'fai' ':' ( statement )*
	  ('Altrimenti' please 'fai' ':' ( statement )* )? 'Grazie' '.'
	;
	
whilestatement
	: 'Finch\u00e9 "' r=expr {if($r.type!=Type.BOOL) error("La condizione non e' di tipo booleana.");} '"' E 'vera' please 'fai' ':' (statement)* 'Grazie' '.'
	;
	
print
	: 'Stampa' please 'il' 'valore' 'di' expr '.'
	;
	
expr returns [Type type]
	: s=andExpr {$type=s;}
	  ('oppure' r=andExpr { if(($type != Type.BOOL) || (r != Type.BOOL))
  			error("Valore non booleano per 'oppure'."); }
	  )* 
	;
	
andExpr returns [Type type]
	: s=relExpr {$type=s;}
	  ('e' q=relExpr { if(($type != Type.BOOL) || (q != Type.BOOL))
  				error("Valore non booleano per 'e'."); }
	  )*
	;
	
relExpr returns [Type type]
	: s=addExpr {$type=s;}
	  	( E 'uguale a' t=addExpr { if($type==t) $type=Type.BOOL;
  					     else error("Confronto 'uguale a' non possibile tra due tipi diversi."); }
		| E 'diverso da' t=addExpr { if($type==t) $type=Type.BOOL;
  					     else error("Confronto 'diverso da' non possibile tra due tipi diversi."); }
		| E 'minore o uguale di' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else error("Confronto 'minore o uguale di' non possibile tra due tipi diversi."); }
		| E 'maggiore o uguale di' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else error("Confronto 'maggiore o uguale di' non possibile tra due tipi diversi."); }
		| E 'minore di' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else error("Confronto 'minore di' non possibile tra due tipi diversi."); }
		| E 'maggiore di' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else error("Confronto 'maggiore di' non possibile tra due tipi diversi."); }
		)?
	;
	
addExpr returns [Type type]
	: t=mulExpr {$type=t;}( '+' t=mulExpr { if(($type != Type.INT) || (t != Type.INT))
  							error("Valore non intero per +."); }
			      | '-' t=mulExpr { if(($type != Type.INT) || (t != Type.INT))
  							error("Valore non intero per -."); }
			      )*
	;
	
mulExpr returns [Type type]
	: t=unExpr {$type=t;}( '*' t=unExpr { if(($type != Type.INT) || (t != Type.INT))
  						error("Valore non intero per *."); }
			     | '/' t=unExpr { if(($type != Type.INT) || (t != Type.INT))
  						error("Valore non intero per /."); }
			     )*
	;
	
unExpr returns [Type type]
	: '+' t=unExpr {if(t != Type.INT) error("Valore non intero per +."); $type=t;}
	| '-' t=unExpr {if(t != Type.INT) error("Valore non intero per -."); $type=t;}
	| 'non' E 'vero' ' che' t=unExpr {if(t != Type.BOOL) error("Valore non booleano per 'not'."); $type=t;}//Vero e che sono token separati, altrimenti creava problemi con tra i due token
	| t=primary {$type=t;}
	;
	
primary returns [Type type]
	: '(' t=expr ')' {type=t;}
	| NUM {type=Type.INT;}
	| 'vero' {type=Type.BOOL;}
	| 'falso' {type=Type.BOOL;}
	| ID {$type = st.lookupType($ID.text);}
	;
	
E
	: '\u00E8'//Il locale che non e' utf-8 da' problemi in fase compilazione, utilizzo il codice unicode
	;		

ID
 : ('a'..'z'|'A'..'Z')+;
  
NUM
 : ('0'..'9')+;
 
WS
  : ( ' ' | '\t' | '\n' | '\r' ) { $channel = HIDDEN; };