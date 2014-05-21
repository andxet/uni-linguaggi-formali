grammar P;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es II parte 4
  }
  
@members{
	SymbolTable st = new SymbolTable();
	
	private Type typeOf(String s){//Ottengo il tipo dell'id identificato da s
		return st.lookupType(s);
	}
	
	private void checkInt(Type t){//Controllo se t ? di tipo int
		if(t != Type.INT)
			throw new IllegalArgumentException("Type error: not integer.");
	}
	
	private void checkBool(Type t){//Controllo se t ? di tipo bool
		if(t != Type.BOOL)
			throw new IllegalArgumentException("Type error: not boolean.");
	}
	
}
  
prog
  : ( decl ';' )* stmt EOF {System.out.println("Parsing:\t[OK]");}
  ;
  
decl
  @init{
  	ArrayList<String> ids = new ArrayList<String>();
  }
  : 'var' s0=ID 						{ ids.add($s0.text); }
  	     (',' s=ID { ids.add( $s.text ); })* ':' type
  	     							{ for(String u : ids){
  									st.insert(u, $type.type);
  									}
  								}
  ;
  
type returns [Type type]
  : 'integer' 							{ $type = Type.INT; }
  | 'boolean'							{ $type = Type.BOOL; }
  ;
  
expr returns [Type type]
  : t0=andExpr					{ $type=$t0.type; }
  	( 'or' t=andExpr { checkBool($t.type); checkBool($t0.type); })*
  ;
  
andExpr returns [Type type]
  : t0=relExpr					{ $type=$t0.type; }
  	( 'and' t=relExpr { checkBool($t.type); checkBool($t0.type); })*
  ;
  
relExpr returns [Type type]
  : t1=addExpr					{ $type = $t1.type; }
  	    ( '='  t2=addExpr			{ if($t1.type != $t2.type)
							throw new IllegalArgumentException ( " Type error in = " );
				  		  $type=Type.BOOL;
						}
            | '<>' t2=addExpr			{ if($t1.type != $t2.type)
							throw new IllegalArgumentException ( " Type error in <> " );
						  $type=Type.BOOL;
						}
            | '<=' t2=addExpr			{ checkInt($t1.type);
            					  checkInt($t2.type);
						  $type=Type.BOOL;
						}
            | '>=' t2=addExpr 			{ checkInt($t1.type);
            					  checkInt($t2.type);
						  $type=Type.BOOL;
						}
            | '<'  t2=addExpr			{ checkInt($t1.type);
            					  checkInt($t2.type);
						  $type=Type.BOOL;
						}
            | '>'  t2=addExpr			{ checkInt($t1.type);
            					  checkInt($t2.type);
						  $type=Type.BOOL;
						}
            )?
  ;
  
addExpr returns [Type type]
  : t0=mulExpr 						{ $type = $t0.type; }
  	    ( '+' t=mulExpr				{ checkInt($t0.type); checkInt($t.type); }
            | '-' t=mulExpr				{ checkInt($t0.type); checkInt($t.type); }
            )*
  ;
  
mulExpr returns [Type type]
  : t0=unExpr 						{ $type = $t0.type; }
  	    ( '*' t=unExpr				{ checkInt($t0.type); checkInt($t.type); }
            | '/' t=unExpr				{ checkInt($t0.type); checkInt($t.type); }
            )*
  ;        
   
unExpr returns [Type type]
  : '+'   t=unExpr					{ checkInt($t.type);  $type=$t.type; }
  | '-'   t=unExpr					{ checkInt($t.type);  $type=$t.type; }
  | 'not' t=unExpr					{ checkBool($t.type); $type=$t.type; }
  | t=primary						{ 		      $type=$t.type; }
  ;
  
primary returns [Type type]
  : '(' t=expr ')'					{ $type = $t.type; }
  | ID							{ $type = typeOf($ID.text); }
  | NUM							{ $type = Type.INT; }
  | 'true'						{ $type = Type.BOOL; }
  | 'false'						{ $type = Type.BOOL; }
  ;
  
stmt
  : t0=ID ':=' t1=expr					{ if($t1.type != typeOf($t0.text))
								throw new IllegalArgumentException ( "Can't assign to variable different type data ");
							}
  | 'print' '(' expr ')'
  | 'if' t=expr 					{ checkBool($t.type); }
  	'then' stmt ('else' stmt)?
  | 'while' t=expr					{ checkBool($t.type); }
  	'do' stmt
  | 'begin' stmt ( ';' stmt )* 'end'
  ;
  
NUM : ('0'..'9')+;
  
ID :  ('a'..'z'|'A'..'Z')+;
  
WS :  ( ' ' | '\t' | '\n' | '\r' ) { skip(); };
  
  
  
  
  
  
  
  
  
  