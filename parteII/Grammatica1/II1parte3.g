grammar II1parte3;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Grammatica 1 es II
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

	
start	
	:	rexpr=expr EOF
		{ System.out.println(rexpr); }
	;

expr returns [int val]
	:	rterm=term rexprp=exprp[rterm]
		{ val=rexprp; }
	;
	
exprp [int i] returns [int val]
	:	PLUS rterm=term rexprp=exprp[$i + rterm]
		{ val=rexprp; }
		
	|	MINUS rterm=term rexprp=exprp[$i - rterm]
		{ val=rexprp; }
	|	{ val=i; }
	;
	
term returns [int val] 
	:	rfact=fact rtemp=termp[rfact]
		{ val=rtemp; }
	;
	
termp [int i] returns [int val]	
	:	TIMES rfact=fact rtermp=termp[rfact * i]
		{ val=rtermp; }
	|	DIVISION rfact=fact rtermp=termp[i / rfact]
		{ val=rtermp; }
	|	{val=i;}
	;
	
fact returns [int val]
	:	LPAR ris=expr RPAR
		{ val=ris; }
	|	ID
		{ val=0; }
	|	NUM
		{ val=Integer.parseInt($NUM.text); }
	;