package Instruction;

import Compile.LexicalParser;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Compile.Compiler;

public interface Instruction 
{
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException;
	void compile(Compiler compiler) throws ArrayException;
}