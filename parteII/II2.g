grammar II2;

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Es II parte 2
	}
	
start	
	:	rexpr=expr EOF                         { System.out.println(rexpr); }
	;

expr returns [int val]
	:	rterm=term rexprp=exprp[rterm]         { val=rexprp; }
	;
	
exprp [int i] returns [int val]
	:	'+' rterm=term rexprp=exprp[$i + rterm]{ val=rexprp; }	
	|	'-' rterm=term rexprp=exprp[$i - rterm]{ val=rexprp; }
	|	                                       { val=i; }
	;
	
term returns [int val] 
	:	rfact=fact rtemp=termp[rfact]          { val=rtemp; }
	;
	
termp [int i] returns [int val]	
	:	'*' rfact=fact rtermp=termp[rfact * i] { val=rtermp; }
	|	'/' rfact=fact rtermp=termp[i / rfact] { val=rtermp; }
	|	                                       { val=i;}
	;
	
fact returns [int val]
	:	'(' ris=expr ')'                       { val=ris; }
//	|	ID         		                       { val=0; }
	|	NUM                                    { val=Integer.parseInt($NUM.text); }
	;
	
NUM	:	('0'..'9')+;
	
ID
	:	('a'..'z'|'A'..'Z')+;
	
WS
	:	( ' ' | '\t' | '\n' | '\r' )           { skip (); } ;