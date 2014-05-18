grammar II4;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Grammatica 2 es II
  }



start returns [int val]
  : rexpr=expr EOF              { System.out.println(rexpr);}
  ;
  
expr returns [int val]
  : t0=term { $val=$t0.val; }   ( '+' t=term   { $val += $t.val; }
                                | '-' t=term   { $val -= $t.val; }
                                )*
  ;
  
term returns [int val] 
  : t0=fact { $val=$t0.val; }   ( '*' t=fact    { $val *= $t.val; }
                                | '/' t=fact    { $val /= $t.val; }
                                )*
  ;

fact returns [int val]
  : '(' t0=expr ')'             { $val=$t0.val; }
  | NUM                         { $val = Integer.parseInt($NUM.text); }
//  | ID                        { $val = 0; }
  ;
  
NUM : ('0'..'9')+;
  
WS :  ( ' ' | '\t' | '\n' | '\r' ) { skip(); };