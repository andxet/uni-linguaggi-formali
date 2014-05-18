grammar II1;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Es II parte 1
	}

	
start	
	:	expr EOF
	;

expr	
	:	term exprp
	;
	
exprp	
	:	'+' term exprp
	|	'-' term exprp
	|
	;
	
term	
	:	fact termp
	;
	
termp	
	:	'*' fact termp
	|	'/' fact termp
	|
	;
	
fact	
	:	'(' expr ')'
//	|	ID
	|	NUM
	;
	
NUM :	('0'..'9')+;
	
//ID :	('a'..'z'|'A'..'Z')+;
	
WS :	( ' ' | '\t' | '\n' | '\r' ) { skip(); };