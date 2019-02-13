//Lleva a la instruccion j del programa
package ByteCodesOneParameter;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import CPU.CPU;

public class Goto extends ByteCodesOneParameter{
	public Goto(){}
	public Goto(int j)
	{super(j);}
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("Goto") && ByteCodeParser.IsNumber(string2)) return new Goto(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "Goto";
	}


	@Override
	public void execute(CPU cpu) {
		cpu.setProgramCounter(this.param);
	}

}
