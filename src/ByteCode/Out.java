//Saca la cima de la pila
package ByteCode;

import CPU.CPU;
import Exceptions.StackException;

public class Out implements ByteCode 
{
	public Out(){}
	public void execute(CPU cpu) throws StackException
	{
		System.out.println("Consola: " + cpu.pop());
		cpu.increaseProgramCounter();
	}
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("OUT")) return new Out();
		else return null;}
	
	public String toString(){ return "OUT"; }
}
