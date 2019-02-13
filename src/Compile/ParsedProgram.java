package Compile;

import Instruction.Instruction;
import Exceptions.ArrayException;

public class ParsedProgram {
private Instruction[] pProgram;
private static final int MAX_INSTR = 100;
private int numPp;

public ParsedProgram()
{
	this.pProgram = new Instruction[MAX_INSTR];
	this.numPp = 0;
}
public boolean addInstruction(Instruction instr) throws ArrayException
{
	boolean add = false;
	
	if(this.numPp < MAX_INSTR)
	{
		this.pProgram[this.numPp] = instr;
		add = true;
		this.numPp++;
	}
	if(add == true) return add;
	else throw new ArrayException("El programa excede el tamaño máximo.");
}
public int getNumberOfInstructions()
{
	return this.numPp;
}

public Instruction getInstruction(int i)
{ 
	return this.pProgram[i];
}
public String toString()
{
	if (this.numPp == 0) return "<vacia>";
	else 
	{
	String s="";
	for (int i=0; i < this.numPp; i++)
		{
		s = s + " "+ i + " " + this.pProgram[i] + System.getProperty("line.separator");
		}
	return s;
	}
}
public void reset()
{
	for(int i = 0; i <= this.numPp; i++)
	{
		this.pProgram[i] = null;
	}
	this.numPp = 0;
	
}
}
