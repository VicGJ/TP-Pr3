//Son menor o no
package ConditionalJumps;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;

public class IfLe extends ConditionalJumps{
	public IfLe(){}
	public IfLe(int c){super(c);}
	@Override
	protected boolean compare(int n2, int n1) {
		if(n1 < n2)
			return true;
		else
			return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("IfLe") && ByteCodeParser.IsNumber(string2)) return new IfLe(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "IfLe";
	}

}
