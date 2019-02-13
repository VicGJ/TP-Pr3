//Son menor o igual o no
package ConditionalJumps;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;

public class IfLeq extends ConditionalJumps{
	public IfLeq(){}
	public IfLeq(int c){super(c);}
	@Override
	protected boolean compare(int n2, int n1) {
		if(n1 <= n2)
			return true;
		else
			return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IfLeq") && ByteCodeParser.IsNumber(string2)) return new IfLeq(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "IfLeq";
	}

}
