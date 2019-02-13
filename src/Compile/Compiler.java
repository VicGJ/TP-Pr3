package Compile;

import ByteCode.ByteCode;
import Exceptions.ArrayException;
import Instruction.Instruction;
import Practica3.ByteCodeProgram;

public class Compiler
{
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVars;
	
	public Compiler()
	{
		this.bcProgram = new ByteCodeProgram();
		this.varTable = new String[100];
		this.numVars = 0;
	}
	public Compiler(ByteCodeProgram bc)
	{
		this.bcProgram = bc;
		this.numVars = 0;
		this.varTable = new String[100];
	}
	
	public void compile(ParsedProgram pProgram) throws ArrayException
	{
		int i = 0;
			while (i < pProgram.getNumberOfInstructions())
			{
				Instruction instr = pProgram.getInstruction(i);
				instr.compile(this);
				i++;
			}
	}
	public ByteCode addByteCode(ByteCode b) throws ArrayException
	{
		return bcProgram.addBCInstruction(b);
	}
	public int getIndex(String varName) 
	{
		int i = 0;
		boolean found = false;
		
		while(i < varTable.length && !found)
		{
			if(varName.equals(varTable[i]))
			{
				found = true;
			}
			else i++;
		}
		if(found)
		{
			return i;
		}
		else
		{
			this.varTable[this.numVars] = varName;
			this.numVars++;
			return numVars - 1;
		}
		
	}
	public int getSizeBcProgram()
	{
		return bcProgram.getNumberOfByteCodes();
	}
}
