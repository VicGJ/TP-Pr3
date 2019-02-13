//Guarda la cima de la pila en la posicion j de la memoria
package ByteCodesOneParameter;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import CPU.CPU;
import Exceptions.StackException;
public class Store extends ByteCodesOneParameter {

	public Store(){}
	public Store(int j)
	{super(j);}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("Store") && ByteCodeParser.IsNumber(string2)) return new Store(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "Store";
	}

	@Override
	public  void execute(CPU cpu)throws StackException {
		int value  = cpu.pop();
		cpu.write(this.param, value);
		cpu.increaseProgramCounter();
	}


}
