package Term;

import ByteCode.ByteCode;
import Compile.Compiler;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;

public interface Term
{
	Term parse(String term) throws LexicalAnalysisException; 
	ByteCode compile(Compiler compiler) throws ArrayException;
}