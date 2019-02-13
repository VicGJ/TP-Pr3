package Compile;

import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Instruction.Instruction;
import Instruction.ParserInstruction;

public class LexicalParser 
{
	private SourceProgram sProgram;
	private int programCounter;
	
	public LexicalParser()
	{
		this.sProgram = new SourceProgram();
		this.programCounter= 0;
	}
	public LexicalParser(SourceProgram sp)
	{
		this.sProgram = sp;
		this.programCounter = 0;
	}
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException, ArrayException
	{
		boolean stop = false;
		while (this.programCounter < sProgram.getNumberOfSourceProgram() && !stop){
			String instr = sProgram.getSourceProgram(this.programCounter);
			instr = instr.trim();
			if (instr.equalsIgnoreCase(stopKey)){
				stop = true;
			}
			else {
				Instruction instruction = null;
				try {
					instruction = ParserInstruction.parse(instr,this);
					pProgram.addInstruction(instruction);
				}
				catch(LexicalAnalysisException e){
					throw new LexicalAnalysisException("Error sintáctico en la línea " + this.programCounter + " ('" + instr + "'): " + e);
				}
				catch(ArrayException e){
					throw e;
				}
			}
		}
	}
	
	public void increaseProgramCounter()
	{
		this.programCounter++;
	}
}
