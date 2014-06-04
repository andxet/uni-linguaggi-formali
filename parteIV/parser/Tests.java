import static java.lang.System.out;

public class Tests {

	public static void main(String[] args) {
		//testST();
		//testInstr();
		//testInstr2();
		//testInstr3();
		testInstr4();
	}
	
	private static void testST(){
		SymbolTable st = new SymbolTable();
		st.insert("ciao", Type.INT);
		st.insert("ok", Type.INT);
		st.insert("b1", Type.BOOL);
		st.insert("b2", Type.BOOL);
		
		out.println("Variabile ciao:");
		out.println(st.lookupAddr("ciao"));
		out.println(st.lookupType("ciao"));
		
		out.println("Variabile b1:");
		out.println(st.lookupAddr("b1"));
		out.println(st.lookupType("b2"));
		
		out.println("Variabile errata err:");
		try{
			out.println(st.lookupAddr("err"));
		}catch (IllegalArgumentException e){
			out.println("Errore: " + e.getMessage());
		}
		
		try{
			out.println(st.lookupType("err"));
		}catch (IllegalArgumentException e){
			out.println("Errore: " + e.getMessage());
		}
	}
	
	private static void testInstr(){
		CodeGen code = new CodeGen();
		code.emit(OpCode.ldc, 10);
		code.emit(OpCode.ldc, 20);
		code.emit(OpCode.ldc, 30);
		code.emit(OpCode.imul);
		int l2 = code.newLabel();
		code.emit(OpCode.if_icmplt, l2);
		code.emit(OpCode.ldc, 0);
		int l3 = code.newLabel();
		code.emit(OpCode.gotoo, l3);
		code.emitLabel(l2);
		code.emit(OpCode.ldc, 1);
		code.emitLabel(l3);
		code.emit(OpCode.bprint);
		WriteFile.write(code.toJasmin());
		out.println(code.toJasminNH());
		
	}
	
	private static void testInstr2(){
		CodeGen code = new CodeGen();
		code.emit(OpCode.ldc, 10);
		code.emit(OpCode.ldc, 20);
		int l2 = code.newLabel();
		code.emit(OpCode.if_icmpeq, l2);
		code.emit(OpCode.ldc, 0);
		int l3 = code.newLabel();
		code.emit(OpCode.gotoo, l3);
		code.emitLabel(l2);
		code.emit(OpCode.ldc, 1);
		code.emitLabel(l3);
		code.emit(OpCode.ldc, 0);
		int l1 = code.newLabel();
		code.emit(OpCode.if_icmpeq, l1);
		code.emit(OpCode.ldc, 30);
		code.emit(OpCode.ldc, 0);
		code.emit(OpCode.idiv);
		code.emit(OpCode.ldc, 15);
		int l4 = code.newLabel();
		code.emit(OpCode.if_icmpgt, l4);
		code.emit(OpCode.ldc, 0);
		int l5 = code.newLabel();
		code.emit(OpCode.gotoo, l5);
		code.emitLabel(l4);
		code.emit(OpCode.ldc, 1);
		code.emitLabel(l5);
		int l6 = code.newLabel();
		code.emit(OpCode.gotoo, l6);
		code.emitLabel(l1);
		code.emit(OpCode.ldc, 0);
		code.emitLabel(l6);
		code.emit(OpCode.bprint);
		WriteFile.write(code.toJasmin());
		out.println(code.toJasminNH());
	}
	
	private static void testInstr3(){
		CodeGen code = new CodeGen();
		code.emit(OpCode.ldc, 10);
		code.emit(OpCode.ldc, 20);
		code.emit(OpCode.ldc, 30);
		code.emit(OpCode.imul);
		code.emit(OpCode.iadd);
		code.emit(OpCode.iprint);
		WriteFile.write(code.toJasmin());
		out.println(code.toJasminNH());
		
	}
	
	private static void testInstr4(){
		CodeGen code = new CodeGen();
		code.emit(OpCode.ldc, 1);
		code.emit(OpCode.ldc, 0);
		code.emit(OpCode.ldc, 0);
		code.emit(OpCode.ior);
		code.emit(OpCode.ior);
		code.emit(OpCode.iprint);
		WriteFile.write(code.toJasmin());
		out.println(code.toJasminNH());
		
	}

}
