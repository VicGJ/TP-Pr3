//Heredan las instrucciones de salto
package ConditionalJumps;


import ByteCodesOneParameter.ByteCodesOneParameter;
import CPU.CPU;
import Exceptions.StackException;

abstract public class ConditionalJumps extends ByteCodesOneParameter
{
	public ConditionalJumps(){}
	
	public ConditionalJumps(int j)
	{
		super(j); 
	}
	
	@Override
	public void execute(CPU cpu) throws StackException
	{
		int c = cpu.pop();
		int sc = cpu.pop();
		if(!this.compare(c, sc)) 
			cpu.setProgramCounter(this.param);
	}
	
	abstract protected boolean compare(int n1, int n2);
	public void change(int j)
	{
		this.param = j;
	}
}