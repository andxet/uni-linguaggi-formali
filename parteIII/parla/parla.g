grammar parla;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es III 1 linguaggio Math
  }
  
start
	: ( statement )* EOF
	;
	
statement
	: declaration
	| assignment
	| ifstatement
	| whilestatement
	| print
	;
	
please
	: ',' 'per favore' ','
	;
	
integer
	: 'intera'
	| 'intere'
	;
	
booleano
	: 'booleana'
	| 'booleane'
	;
	
declaration
	: 'Assumi che' ('la variabile' | 'le variabili') ID (',' ID)* ('sia' | 'siano') ( integer | booleano ) '.'
	;
	
assignment
	: 'Metti' ( 'il valore' | 'i valori' ) 'di' expr (',' expr)* 'in' ID (',' ID)* '.'
	;
	
ifstatement
	: 'Se "' expr '"' E 'vera' please 'fai' ':' ( statement )*
	  ('Altrimenti' please 'fai' ':' ( statement )* )? 'Grazie' '.'
	;
	
whilestatement
	: 'Finch\u00e9 "' expr '"' E 'vera' please 'fai' ':' (statement)* 'Grazie' '.'
	;
	
print
	: 'Stampa' please 'il valore' 'di' expr '.'
	;
	
expr
	: andExpr ('oppure' andExpr)*
	;
	
andExpr
	: relExpr ('e' relExpr)*
	;
	
relExpr
	: addExpr ( E 'uguale a' addExpr
		  | E 'diverso da' addExpr
		  | E 'minore o uguale di' addExpr
		  | E 'maggiore o uguale di' addExpr
		  | E 'minore di' addExpr
		  | E 'maggiore di' addExpr
		  )?
	;
	
addExpr
	: mulExpr ('+' mulExpr | '-' mulExpr)*
	;
	
mulExpr
	: unExpr ('*' unExpr | '/' unExpr)*
	;
	
unExpr
	: '+' unExpr
	| '-' unExpr
	| 'non' E 'vero che' unExpr
	| primary
	;
	
primary
	: '(' expr ')'
	| ID
	| NUM
	| 'vero'
	| 'falso'
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