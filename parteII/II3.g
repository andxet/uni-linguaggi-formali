grammar II3;

options {
  language = Java;
}

@header {
	//Andrea Peretti, mat. 718024
	//Lab LFT
	//Es II parte 3
	}


start 
  : expr EOF
  ;

expr  
  : term ( '+' term | '-' term )*
  ;
  
term  
  : fact ( '*' fact | '/' fact)*
  ;
  
fact  
  : '(' expr ')'
//  | ID
  | NUM
  ;
  
NUM : ('0'..'9')+;
  
//ID :  ('a'..'z'|'A'..'Z')+;
  
WS :  ( ' ' | '\t' | '\n' | '\r' ) { skip(); };
