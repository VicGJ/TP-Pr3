package Instruction;


import Compile.LexicalParser;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;

public class ParserInstruction {
	private final static Instruction[] instr = {new CompoundAssignment(), new While(), new SimpleAssignment(), new Return(), new Write() };
	public ParserInstruction(){};
	
	public static Instruction parse(String line, LexicalParser parser) throws LexicalAnalysisException, ArrayException
	{
		
		String[] words = line.split(" ");
		for (int i = 0; i < instr.length; i++) {
			Instruction b = instr[i].lexParse(words, parser);
			if (b != null)
				return b;
		}
		throw new LexicalAnalysisException("Instrucción incorrecta");
	}
}
