//Lleva a cabo instrucciones del programa
package Practica3;

import ByteCode.ByteCode;
import Exceptions.ArrayException;

//Almacena una secuencia de Bytecodes
public class ByteCodeProgram 
{
	private static final int MAX_INSTR = 100;
	private ByteCode[] bcprogram;
	private int numBc;
	
	public ByteCodeProgram()
	{
		this.bcprogram = new ByteCode[ByteCodeProgram.MAX_INSTR];
		this.numBc = 0;
	}
	public ByteCode addBCInstruction(ByteCode instr) throws ArrayException
	{
		if(this.numBc < MAX_INSTR)
		{
			this.bcprogram[this.numBc] = instr;
			this.numBc++;
			return this.bcprogram[this.numBc - 1];
		}
		else throw new ArrayException("Número máximo de instrucciones alcanzado.");
		
	}
	public int getNumberOfByteCodes()
	{
		return this.numBc;
	}
	public ByteCode getByteCode(int i)
	{ 
		return this.bcprogram[i];
	}
	public String toString()
	{
		if (this.numBc == 0) return "<vacia>";
		else 
		{
		String s="";
		for (int i=0; i < this.numBc; i++)
			{
			s = s + " "+ i + " " + this.bcprogram[i] + System.getProperty("line.separator");
			}
		return s;
		}
	}
	public void reset()
	{
		for(int i = 0; i <= this.numBc; i++)
		{
			this.bcprogram[i] = null;
		}
		this.numBc = 0;
		
	}
	public void replace(int replace, ByteCode bc)
	{
		this.bcprogram[replace] = bc;
	}
}