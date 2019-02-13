//Mete el numero j en la pila
package ByteCodesOneParameter;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import CPU.CPU;
import Exceptions.StackException;

public class Push extends ByteCodesOneParameter{
	public Push(){}
	public Push(int j)
	{
		super(j);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("Push") && ByteCodeParser.IsNumber(string2)) return new Push(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "Push";
	}
	@Override
	public void execute(CPU cpu)throws StackException {
		cpu.push(this.param);
		cpu.increaseProgramCounter();
		
	}


}
