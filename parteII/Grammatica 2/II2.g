grammar II2;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 2 es II
	}



start
	:	expr
	;
	
expr
	:	term (PLUS term | MINUS term)*
	;	
	
term
	:	fact (TIMES fact | DIVISION fact)*
	;

fact
	:	LPAR expr RPAR
	|	ID
	|	NUM
	;
	
PLUS
	:	'+';
	
MINUS
	:	'-';
	
TIMES	
	:	'*';
	
DIVISION
	:	'/';
	
LPAR
	:	'(';
	
RPAR
	:	')';
	
NUM
	:	('0'..'9')+;
	
ID
	:	('a'..'z'|'A'..'Z')+;
	
WS
	:	( ' ' | '\t' | '\n' | '\r' ) { $channel = HIDDEN; };