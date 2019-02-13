package Instruction;

import ByteCode.ByteCode;
import ByteCodesOneParameter.Store;
import Compile.LexicalParser;
import Compile.Compiler;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Term.Term;
import Term.TermParser;

public class SimpleAssignment implements Instruction
{
	private String varName;
	private Term rhs;
	
	public SimpleAssignment()
	{
		this.varName = null;
		this.rhs = null;
	}
	public SimpleAssignment(String varName, Term rhs)
	{
		this.varName = varName;
		this.rhs = rhs;
	}
	 @Override
	 public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException 
	 {
	  if (words.length != 3 || !words[1].equals("=")) return null;
	  
	  else {
	  
	   TermParser.parse(words[0]);
	   Term termAux2 = TermParser.parse(words[2]);
	   lexParser.increaseProgramCounter();
	   
	   return new SimpleAssignment(words[0] , termAux2);
	  }
	 }
	@Override
	public void compile(Compiler compiler) throws ArrayException 
	{
		compiler.addByteCode(this.rhs.compile(compiler));
		int index = compiler.getIndex(this.varName);
		ByteCode bs = new Store(index);
		compiler.addByteCode(bs);
	}
	
	public String toString()
	{
		return "Simple Assignment";
	}
}