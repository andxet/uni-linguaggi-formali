grammar math;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es III 1 linguaggio Math
  package peretti.lft.math;
  import peretti.lft.*;
  }
  

@members{
	public enum Type { INT, BOOL };
	SymbolTable<Type> st = new SymbolTable<Type>();
}


start:
  ( statement )* EOF { System.out.println("Nessun errore rilevato."); }
  ;
  
statement
  : ( declaration | assignment | ifwhilestatement )
  ;
  
declaration
  @init{
  	ArrayList<Type> tipi = new ArrayList<Type>();
  }
  : '{' ('int' {tipi.add(Type.INT);} | 'bool' {tipi.add(Type.BOOL);}) (',' ('int' {tipi.add(Type.INT);} | 'bool' {tipi.add(Type.BOOL);}))* '}'//Elenco dei tipi
    '=>' 
    '{' q=ID {st.insert($q.text, tipi.remove(0));}//Eleco degli id. Inserisco il primo id
              (',' q=ID {if(!tipi.isEmpty())//Se non ci sono meno ID dei tipi specificati, inserisco l'id nella tabella
                            st.insert($q.text, tipi.remove(0));
                         else
                            throw new IllegalArgumentException("Il numero di tipi specificati non coincide con il numero degli ID.");}
              )*
    '}' 
    {if(!tipi.isEmpty())//Se la lista non ? vuota, sono stai dichiarati pi? tipi.
        throw new IllegalArgumentException("Il numero di ID specificati non coincide con il numero dei tipi.");}
  ;
  
assignment
  @init{
    ArrayList<Type> valori = new ArrayList<Type>();
    String type;
  }
  : '{' t=expr {valori.add(t);}(',' t=expr {valori.add(t);})* '}'
    '=>'
    '{' {t=valori.remove(0);} printorid[t] (',' {if(!valori.isEmpty())//Se non ci sono meno valori degli ID specificati, continuo
                            				t=valori.remove(0);
                         			else
                            				throw new IllegalArgumentException("Il numero di valori specificati non coincide con il numero degli ID.");}
                            		   printorid[t] )* '}'
    {if(!valori.isEmpty())//Se la lista non ? vuota, sono stai dichiarati pi? valori.
        throw new IllegalArgumentException("Il numero di ID specificati non coincide con il numero dei tipi.");}
  ;
  
print
  : 'print'
  ;
  
printorid[Type type]
  : ID {if(st.lookupType($ID.text)!=$type) throw new IllegalArgumentException("Non posso eseguire l'assegnamento, i tipi non coincidono.");}
  | print
  ;
  
ifwhilestatement
  : '?'
    '{' t=expr {if(t!=Type.BOOL) throw new IllegalArgumentException("Valore non booleano per il condizionale.");}
    '}'
    '=>' ( ifstatement | whilestatement )
  ;
  
ifstatement
  : '{' ( statement )* '}'
    ( ':' '{' (statement)* '}' )? //: significa else
  ;
  
whilestatement
  : '*' '{' (statement)* '}'
  ;
  
expr returns [Type type]
  : t=andExpr { $type=t; }
    ('||' t=andExpr { if(($type != Type.BOOL) || (t != Type.BOOL))
  			throw new IllegalArgumentException("Valore non booleano per ||."); }
    )*
  ;
  
andExpr returns [Type type]
  : t=relExpr {$type=t;}
    ('&&' t=relExpr { if(($type != Type.BOOL) || (t != Type.BOOL))
  			throw new IllegalArgumentException("Valore non booleano per &&."); }
    )*
  ;
  
relExpr returns [Type type]
  : t=addExpr {$type=t;} 
  	( '=' t=addExpr { if($type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '=' non possibile tra due tipi diversi."); }
        | '!=' t=addExpr { if($type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '!=' non possibile tra due tipi diversi."); }
        | '<=' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '<=' non possibile tra due tipi diversi."); }
        | '>=' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '>=' non possibile tra due tipi diversi."); }
        | '<' t=addExpr { if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '<' non possibile tra due tipi diversi."); }
        | '>' t=addExpr{ if($type==Type.INT && $type==t) $type=Type.BOOL;
  					     else throw new IllegalArgumentException("Confronto '>' non possibile tra due tipi diversi."); }
        )?
            
  ;
  
addExpr returns [Type type]
  : t=mulExpr {$type=t;}('+' t=mulExpr { if(($type != Type.INT) || (t != Type.INT))
  						throw new IllegalArgumentException("Valore non intero per +."); }
  			|'-' t=mulExpr { if(($type != Type.INT) || (t != Type.INT))
  						throw new IllegalArgumentException("Valore non intero per -."); }
  			 )*
  ;
  
mulExpr returns [Type type]
  : t=unExpr {$type=t;} ('*' t=unExpr { if(($type != Type.INT) || (t != Type.INT))
  						throw new IllegalArgumentException("Valore non intero per *."); }
  			|'/' t=unExpr { if(($type != Type.INT) || (t != Type.INT))
  						throw new IllegalArgumentException("Valore non intero per /."); }
  			 )*
  ;
  
unExpr returns [Type type]
  : '+' t=unExpr {if(t != Type.INT) throw new IllegalArgumentException("Valore non intero per +."); $type=t;}
  | '-' t=unExpr {if(t != Type.INT) throw new IllegalArgumentException("Valore non intero per -."); $type=t;}
  | '!' t=unExpr {if(t != Type.BOOL) throw new IllegalArgumentException("Valore non booleano per !."); $type=t;}
  | 'not' t=unExpr {if(t != Type.BOOL) throw new IllegalArgumentException("Valore non booleano per 'not'.");$type=t;} //Nel test fornito nel pdf appare 'not' al posto di '!', questa regola ? stata aggiunta per riconodcere il programma di esempio euclide.math linea 3
  | t=primary {$type=t;}
  ;
  
primary returns [Type type]
  : '(' t=expr ')' {$type=t;}
  | ID {$type = st.lookupType($ID.text);}
  | NUM {$type = Type.INT;}
  | 'true' {$type = Type.BOOL;}
  | 'false' {$type = Type.BOOL;}
  ;
  
  
ID
 : ('a'..'z'|'A'..'Z')+;
  
NUM
 : ('0'..'9')+;
 
WS
  : ( ' ' | '\t' | '\n' | '\r' ) { $channel = HIDDEN; };