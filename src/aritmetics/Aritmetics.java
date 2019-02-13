//Clase que maneja operaciones entre la cima y subcima de la pila
package aritmetics;

import ByteCode.ByteCode;
import CPU.CPU;
import Exceptions.DivisionByZero;
import Exceptions.ExecutionError;

public abstract class Aritmetics implements ByteCode 
{
	public Aritmetics(){}
	
	public void execute(CPU cpu) throws ExecutionError{
		int op1 = cpu.pop();
		int op2 = cpu.pop();
		int sol =  this.Operation(op1, op2);
		cpu.push(sol);
}
	public ByteCode parse(String[] words)
	{
		if (words.length!=1) return null;
		else return this.parseAux(words[0]);
	}
	abstract protected int Operation(int n2, int n1) throws DivisionByZero;
	abstract public ByteCode parseAux(String s1);
}