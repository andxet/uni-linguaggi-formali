public class Instruction{
	private OpCode opCode ;
	private Integer operand ;

	public Instruction ( OpCode opCode ) {
		this.opCode = opCode;
	}
	
	public Instruction ( OpCode opCode , int operand ) {
		this.opCode = opCode;
		this.operand = operand;
	}
	
	public String toString() {
		if (operand == null)
			return "" + opCode;
		else
			return opCode + " " + operand;
	}
	
	public String toJasmin () {
		switch (opCode) {
			case iprint: return "  invokestatic Out/printInt(I)V";
			case bprint: return "  invokestatic Out/printBool(I)V";
			case Label: return "L" + operand + ":";
			case gotoo: return "  goto L" + operand;
			case ifeq:
			case ifne:
			case if_icmpeq:
			case if_icmpne:
			case if_icmpge:
			case if_icmpgt:
			case if_icmple:
			case if_icmplt: return "  " + opCode + " L" + operand;
			default: return "  " + toString();
		}
	}
}