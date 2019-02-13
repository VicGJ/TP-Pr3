package Term;

import ByteCode.ByteCode;
import ByteCodesOneParameter.Push;
import Compile.Compiler;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;

public class Number implements Term{
	private int num;
	public Number(){};
	
	public Number(int number)
	{
		this.num = number;
	}
	@Override
	public Term parse(String term) throws LexicalAnalysisException{ 
		if (term.length() == 0) return null;
		else {
			int n = 0;
			try{
				n = Integer.parseInt(term);
			}
			catch (NumberFormatException e){
				throw new LexicalAnalysisException("Error: carácter incorrecto" + e);
			}
			return new Number(n);
		}
	}
	
	public String toString()
	{
		String s = "Number" + this.num;
		return s;
	}

	@Override
	public ByteCode compile(Compiler compiler) throws ArrayException
	{
		return new Push(this.num);
	}
}
