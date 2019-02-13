//Para la ejecucion
package ByteCode;

import CPU.CPU;

public class Halt implements ByteCode 
{
	public Halt(){}
	public void execute(CPU cpu)
	{
		cpu.halt();
		cpu.increaseProgramCounter();
	}
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("Halt")) return new Halt();
		else return null;}
	
	public String toString(){ return "HALT"; }
}
