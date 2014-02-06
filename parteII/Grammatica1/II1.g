grammar II1;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 1 es II
	}

	
start	
	:	expr EOF
	;

expr	
	:	term exprp
	;
	
exprp	
	:	PLUS term exprp
	|	MINUS term exprp
	|
	;
	
term	
	:	fact termp
	;
	
termp	
	:	TIMES fact termp
	|	DIVISION fact termp
	|
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