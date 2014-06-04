import java.util.ArrayList;

public class CodeGen {
	int label;
	ArrayList<Instruction> instr = new ArrayList<Instruction>();
	
	public CodeGen(){
		label=1;
	}
	
	public void emit ( OpCode opCode ) {
		instr.add(new Instruction(opCode));
	}
	
	public void emit ( OpCode opCode , int operand ) {
		instr.add(new Instruction(opCode, operand));
	}
	
	public void emitLabel (int operand ) {
		instr.add(new Instruction(OpCode.Label, operand));
	}
	
	public int newLabel () {
		return label++;
	}
	
	public String toJasmin () {
		String code = header;
		for(Instruction i : instr)
			code = code + i.toJasmin() + "\n";
		return code + footer;
	}
	
	public String toJasminNH () {
		String code = "";
		for(Instruction i : instr)
			code = code + i.toJasmin() + "\n";
		return code;
	}
	
	private static final String header = ".class public "
			+ "Out"
			+ "\n"
			+ ".super java/lang/Object\n"
			+ "\n"
			+ ".method public <init>()V\n"
			+ "  aload_0\n"
			+ "  invokenonvirtual java/lang/Object/<init>()V\n"
			+ "  return\n"
			+ ".end method\n"
			+ "\n"
			+ ".method public static printBool(I)V\n"
			+ "  .limit stack 3\n"
			+ "  getstatic java/lang/System/out Ljava/io/PrintStream;\n"
			+ "  iload_0\n"
			+ "  bipush 1\n"
			+ "  if_icmpeq Ltrue\n"
			+ "  ldc \"false\"\n"
			+ "  goto Lnext\n"
			+ "Ltrue:\n"
			+ "  ldc \"true\"\n"
			+ "Lnext:\n"
			+ "  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"
			+ "  return\n"
			+ ".end method\n"
			+ "\n"
			+ ".method public static printInt(I)V\n"
			+ "  .limit stack 2\n"
			+ "  getstatic java/lang/System/out Ljava/io/PrintStream;\n"
			+ "  iload_0\n"
			+ "  invokestatic java/lang/Integer/toString(I)Ljava/lang/String;\n"
			+ "  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"
			+ "  return\n" + ".end method\n" + "\n"
			+ ".method public static run()V\n" + "  .limit stack 1024\n"
			+ "  .limit locals 256\n";
	private static final String footer = "  return\n" 
			+ ".end method\n" + "\n"
			+ ".method public static main([Ljava/lang/String;)V\n"
			+ "  invokestatic Out/run()V\n" 
			+ "  return\n" 
			+ ".end method\n";

}