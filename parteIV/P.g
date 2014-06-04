grammar P;

@header {
  //Andrea Peretti, mat. 718024
  //Lab LFT
  //Es II parte 4
  }
  
@members{
	SymbolTable st = new SymbolTable();
	CodeGen code = new CodeGen();
	
	private Type typeOf(String s){//Ottengo il tipo dell'id identificato da s
		return st.lookupType(s);
	}
	
	private void checkInt(Type t){//Controllo se t ? di tipo int
		if(t != Type.INT)
			throw new IllegalArgumentException("Type error: not integer.");
	}
	
	private void checkBool(Type t){//Controllo se t ? di tipo bool
		if(t != Type.BOOL)
			throw new IllegalArgumentException("Type error: not boolean.");
	}
	
}
  
prog
  : ( decl ';' )* stmt EOF { System.out.println("Parsing:\t[OK]\n\n" + code.toJasminNH());
                             WriteFile.write(code.toJasmin()); }
  ;
  
decl
  @init{
  	ArrayList<String> ids = new ArrayList<String>();
  }
  : 'var' s0=ID 						        { ids.add($s0.text); }
  	     (',' s=ID { ids.add( $s.text ); })* ':' type
							  	     							{ for(String u : ids){
							  	     							     st.insert(u, $type.type);
							  	     							  }
							  	     							}
  ;
  
type returns [Type type]
  : 'integer' 							        { $type = Type.INT; }
  | 'boolean'							          { $type = Type.BOOL; }
  ;
  
expr returns [Type type]
@init{
  int ltrue=code.newLabel();
}
  : t0=andExpr					            { $type=$t0.type;}          
  	( 'or'                          {
                                      code.emit(OpCode.ldc, 1);
                                      code.emit(OpCode.if_icmpeq, ltrue);
                                    }
  	 t=andExpr                      { checkBool($t.type);
  	                                  checkBool($t0.type);
  	                                  int lnext = code.newLabel();
                                      code.emit(OpCode.gotoo, lnext);
                                      code.emitLabel(ltrue);
                                      code.emit(OpCode.ldc, 1);
                                      code.emitLabel(lnext);
                                      
  	                                })*
  ;
  
andExpr returns [Type type]
@init{
  int lfalse=code.newLabel();
}
  : t0=relExpr					            { $type=$t0.type;}     
  	( 'and'                         { 
                                      code.emit(OpCode.ldc, 0);
                                      code.emit(OpCode.if_icmpeq, lfalse);
                                    }
  	 t=relExpr                      { checkBool($t.type);
  	                                  checkBool($t0.type);
  	                                  int lnext = code.newLabel();
                                      code.emit(OpCode.gotoo, lnext);
                                      code.emitLabel(lfalse);
                                      code.emit(OpCode.ldc, 0);
                                      code.emitLabel(lnext);
  	                                })*
  ;
  
relExpr returns [Type type]
  : t1=addExpr					            { $type = $t1.type; }
  	        ( '='  t2=addExpr			  { if($t1.type != $t2.type)
  	                                      throw new IllegalArgumentException ( " Type error in = " );
  	                                  $type=Type.BOOL;
  	                                  int ltrue = code.newLabel();
  	                                  int lnext = code.newLabel();
																			code.emit( OpCode.if_icmpeq, ltrue );
																			code.emit( OpCode.ldc, 0);
																			code.emit( OpCode.gotoo, lnext );
																			code.emitLabel( ltrue );
																			code.emit( OpCode.ldc, 1);
																			code.emitLabel( lnext );
  	                                  
  	                                }
            | '<>' t2=addExpr			  { if($t1.type != $t2.type)
																			throw new IllegalArgumentException ( " Type error in <> " );
																		  $type=Type.BOOL;
																		  int ltrue = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit( OpCode.if_icmpne, ltrue );
                                      code.emit( OpCode.ldc, 0);
                                      code.emit( OpCode.gotoo, lnext );
                                      code.emitLabel( ltrue );
                                      code.emit( OpCode.ldc, 1);
                                      code.emitLabel( lnext );
																		}
            | '<=' t2=addExpr			  { checkInt($t1.type);
            					                checkInt($t2.type);
																		  $type=Type.BOOL;
																		  int ltrue = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit( OpCode.if_icmple, ltrue );
                                      code.emit( OpCode.ldc, 0);
                                      code.emit( OpCode.gotoo, lnext );
                                      code.emitLabel( ltrue );
                                      code.emit( OpCode.ldc, 1);
                                      code.emitLabel( lnext );
																		}
            | '>=' t2=addExpr 			{ checkInt($t1.type);
            					                checkInt($t2.type);
																		  $type=Type.BOOL;
																		  int ltrue = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit( OpCode.if_icmpge, ltrue );
                                      code.emit( OpCode.ldc, 0);
                                      code.emit( OpCode.gotoo, lnext );
                                      code.emitLabel( ltrue );
                                      code.emit( OpCode.ldc, 1);
                                      code.emitLabel( lnext );
																		}
            | '<'  t2=addExpr			  { checkInt($t1.type);
                                      checkInt($t2.type);
																		  $type=Type.BOOL;
																		  int ltrue = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit( OpCode.if_icmplt, ltrue );
                                      code.emit( OpCode.ldc, 0);
                                      code.emit( OpCode.gotoo, lnext );
                                      code.emitLabel( ltrue );
                                      code.emit( OpCode.ldc, 1);
                                      code.emitLabel( lnext );
																		}
            | '>'  t2=addExpr			  { checkInt($t1.type);
            					                checkInt($t2.type);
																		  $type=Type.BOOL;
																		  int ltrue = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit( OpCode.if_icmpgt, ltrue );
                                      code.emit( OpCode.ldc, 0);
                                      code.emit( OpCode.gotoo, lnext );
                                      code.emitLabel( ltrue );
                                      code.emit( OpCode.ldc, 1);
                                      code.emitLabel( lnext );
																		}
            )?
  ;
  
addExpr returns [Type type]
  : t0=mulExpr 						          { $type = $t0.type;
                                    }
  	    ( '+' t=mulExpr				      { checkInt($t0.type); checkInt($t.type);
			                                code.emit(OpCode.iadd);
			  	                          }
        | '-' t=mulExpr				      { checkInt($t0.type); checkInt($t.type);
                                      code.emit(OpCode.isub);
                                    }
        )*
  ;
  
mulExpr returns [Type type]
  : t0=unExpr 						          { $type = $t0.type;
                                    }
  	    ( '*' t=unExpr		          { checkInt($t0.type); checkInt($t.type);
  	    						                  code.emit(OpCode.imul); 
  	    						                }
        | '/' t=unExpr		          { checkInt($t0.type); checkInt($t.type);
            						              code.emit(OpCode.idiv); 
            						            }
        )*
  ;        
   
unExpr returns [Type type]
  : '+'   t=unExpr					        { checkInt($t.type);  $type=$t.type; 
                              				  /*code.emit(OpCode.ineg);*/ }//Tratto questo operatore come la moltiplicazione x1, quindi non devo fare nulla.
  | '-'   t=unExpr					        { checkInt($t.type);  $type=$t.type; 
  							                      code.emit(OpCode.ineg); }
  | 'not' t=unExpr					        { checkBool($t.type); $type=$t.type;
										  							  code.emit(OpCode.ldc, 0);
										  							  int l1 = code.newLabel();
										  							  int l2 = code.newLabel();
										  							  code.emit(OpCode.if_icmpeq, l1);//to l1 if false
										  							  code.emit(OpCode.ldc, 0);
										  							  code.emit(OpCode.gotoo, l2);
						  							          code.emitLabel(l1);
						  							          code.emit(OpCode.ldc, 1);
						  							          code.emitLabel(l2);
						  							        }
  | t=primary						            { $type=$t.type; }
  ;
  
primary returns [Type type]
  : '(' t=expr ')'					        { $type = $t.type; }
  | ID							                { $type = typeOf($ID.text);
                      					      code.emit(OpCode.iload, st.lookupAddr($ID.text));}
  | NUM							                { $type = Type.INT;
                      					      code.emit(OpCode.ldc, Integer.parseInt($NUM.text));}
  | 'true'						              { $type = Type.BOOL;
                      					      code.emit(OpCode.ldc, 1); }
  | 'false'						              { $type = Type.BOOL;
                      					      code.emit(OpCode.ldc, 0); }
  ;
  
stmt
	: t0=ID ':=' t1=expr	    				{ if($t1.type != typeOf($t0.text))
		                                      throw new IllegalArgumentException ( "Can't assign to variable different type data ");
		                                  code.emit(OpCode.istore, st.lookupAddr($t0.text));
		                                }
  | 'print' '(' t=expr ')'  				{ if($t.type == Type.INT)
                                				  code.emit(OpCode.iprint);
                              				else if($t.type == Type.BOOL)
                              				    code.emit(OpCode.bprint);
                              			}
  | 'if' t=expr 					          { checkBool($t.type);
                                      code.emit(OpCode.ldc, 0);
                                      int lfalse = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emit(OpCode.if_icmpeq, lfalse);
                                    }
  	'then' stmt                     {
  	                                  code.emit(OpCode.gotoo, lnext);
  	                                  code.emitLabel(lfalse);
  	                                }
  	             (options{greedy=true;}: 'else' stmt)?//Attiva il comportamento greedy, ossia l'else apparterra' sempre all'if più vicino, e non prima.
  	                                {
  	                                  code.emitLabel(lnext);
  	                                }
  | 'while'                         { int lbegin = code.newLabel();
                                      int lnext = code.newLabel();
                                      code.emitLabel(lbegin);
                                    }
            t=expr					        { checkBool($t.type);
                                      code.emit(OpCode.ldc, 0);
                                      code.emit(OpCode.if_icmpeq, lnext);
                                    }
  	'do' stmt                       {
  	                                  code.emit(OpCode.gotoo, lbegin);
  	                                  code.emitLabel(lnext);
  	                                }
  | 'begin' stmt ( ';' stmt )* 'end'
  ;
  
NUM : ('0'..'9')+;
  
ID :  ('a'..'z'|'A'..'Z')+;
  
WS :  ( ' ' | '\t' | '\n' | '\r' ) { skip(); };
  
  
  
  
  
  
  
  
  
  