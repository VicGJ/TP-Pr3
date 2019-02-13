package Compile;

import Exceptions.ArrayException;

public class SourceProgram
{
private String[] sProgram;
private static final int MAX_INSTR = 100;
private int numSp;

public SourceProgram()
{
	this.sProgram = new String[MAX_INSTR];
	this.numSp = 0;
}
public boolean addSourceProgram(String instr) throws ArrayException
{
	boolean add = false;
	
	if(this.numSp < MAX_INSTR)
	{
		this.sProgram[this.numSp] = instr;
		add = true;
		this.numSp++;
	}
	if(add == true) return add;
	else throw new ArrayException("El programa excede el tamaño máximo.");
}
public int getNumberOfSourceProgram()
{
	return this.numSp;
}

public String getSourceProgram(int i)
{ 
	return this.sProgram[i];
}
public String toString()
{
	if (this.numSp == 0) return "<vacia>";
	else 
	{
	String s="";
	for (int i=0; i < this.numSp; i++)
		{
		s = s + " "+ i + " " + this.sProgram[i] + System.getProperty("line.separator");
		}
	return s;
	}
}
public void reset()
{
	for(int i = 0; i <= this.numSp; i++)
	{
		this.sProgram[i] = null;
	}
	this.numSp = 0;
	
}
}