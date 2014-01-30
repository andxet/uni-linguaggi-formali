grammar math;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es III 1 linguaggio Math
  }

start:
  ( statement )* EOF
  ;
  
statement
  : ( declaration | assignment | ifwhilestatement )
  ;
  
declaration
  : '{' ('int' | 'bool')(','('int' | 'bool'))* '}' '=>' '{' ID (',' ID )* '}'
  ;
  
assignment
  : '{' expr (',' expr)* '}' '=>' '{' printorid (',' printorid )* '}'
  ;
  
print
  : 'print'
  ;
  
printorid
  : ID
  | print
  ;
  
ifwhilestatement
  : '?' '{' expr '}' '=>' ( ifstatement | whilestatement )
  ;
  
ifstatement
  : '{' ( statement )* '}' ( ':' '{' (statement)* '}' )? //: significa else
  ;
  
whilestatement
  : '*' '{' (statement)* '}'
  ;
  
expr
  : andExpr ('||' andExpr)*
  ;
  
andExpr
  : relExpr ('&&' relExpr)*
  ;
  
relExpr
  : addExpr ( '=' addExpr
            | '!=' addExpr
            | '<=' addExpr
            | '>=' addExpr
            | '<' addExpr
            | '>' addExpr)?
            
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
  | '!' unExpr | 'not' unExpr //Nel test fornito nel pdf appare 'not' al posto di '!', questa regola è stata aggiunta per riconodcere il programma di esempio euclide.math linea 3
  | primary
  ;
  
primary
  : '(' expr ')'
  | ID
  | NUM
  | 'true'
  | 'false'
  ;
  
ID
 : ('a'..'z'|'A'..'Z')+;
  
NUM
 : ('0'..'9')+;
 
WS
  : ( ' ' | '\t' | '\n' | '\r' ) { $channel = HIDDEN; };