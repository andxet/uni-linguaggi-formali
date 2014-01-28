grammar II2parte3;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 2 es II
	}

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



start returns [int val]
	:	rexpr=expr EOF
		{ System.out.println(rexpr);}
	;
	
expr returns [int val]
	:	rterm=term {$val=rterm;}(
			PLUS rterm2=term
			{ $val=$val + rterm2; }
			|
			MINUS rterm2=term
			{ $val=$val - rterm2; }
			)*
	;
	
term returns [int val] 
	:	rfact=fact {$val=rfact;} (
			TIMES rterm=fact
			{ $val=$val*rterm; }
			|
			DIVISION rterm=fact
			{ $val=$val/rterm; }
			)*
	;

fact returns [int val]
	:	LPAR rexpr=expr RPAR
		{ $val=rexpr; }
	|	NUM
		{ $val = Integer.parseInt($NUM.text); }
	|	ID
		{ $val = 0; }
	;