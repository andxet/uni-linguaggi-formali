grammar III1;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es II parte 4
  }
  
prog
  : ( decl ';' )* stmt EOF {System.out.println("OK");}
  ;
  
decl
  : 'var' ID (',' ID)* ':' type
  ;
  
type
  : 'integer'
  | 'boolean'
  ;
  
expr
  : andExpr ( 'or' andExpr)*
  ;
  
andExpr
  : relExpr ( 'and' relExpr)*
  ;
  
relExpr
  : addExpr ( '='  addExpr
            | '<>' addExpr
            | '<=' addExpr
            | '>=' addExpr
            | '<'  addExpr
            | '>'  addExpr
            )?
  ;
  
addExpr
  : mulExpr ( '+' mulExpr
            | '-' mulExpr
            )*
  ;
  
mulExpr
  : unExpr ( '*' unExpr
           | '/' unExpr
           )*
  ;        
   
unExpr
  : '+'   unExpr
  | '-'    unExpr
  | 'not'  unExpr
  | primary
  ;
  
primary
  : '(' expr ')'
  | ID
  | NUM
  | 'true'
  | 'false'
  ;
  
stmt
  : ID ':=' expr
  | 'print' '(' expr ')'
  | 'if' expr 'then' stmt ('else' stmt)?
  | 'while' expr 'do' stmt
  | 'begin' stmt ( ';' stmt )* 'end'
  ;
  
NUM : ('0'..'9')+;
  
ID :  ('a'..'z'|'A'..'Z')+;
  
WS :  ( ' ' | '\t' | '\n' | '\r' ) { skip(); };
  
  
  
  
  
  
  
  
  
  