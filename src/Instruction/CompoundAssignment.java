package Instruction;

import ByteCode.ByteCode;
import ByteCodesOneParameter.Store;
import Compile.Compiler;
import Compile.LexicalParser;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Term.Term;
import Term.TermParser;
import aritmetics.Add;
import aritmetics.Div;
import aritmetics.Mul;
import aritmetics.Sub;

public class CompoundAssignment implements Instruction {
private String varName;
private String operator;
private Term t1;
private Term t2;

public CompoundAssignment()
{
	this.varName = null;
	this.operator = null;
	this.t1 = null;
	this.t2 = null;
}
public CompoundAssignment(String varName,Term t1, String operator, Term t2)
{
	this.varName = varName;
	this.operator = operator;
	this.t1 = t1;
	this.t2 = t2;
}
@Override
public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException 
  //throws LexicalAnalysisException 
{
 
 if (words.length != 5 || !words[1].equals("=") || !isOperator(words[3]))
  return null;

 else {
  TermParser.parse(words[0]); 
  Term t1aux = TermParser.parse(words[2]);
  Term t2aux = TermParser.parse(words[4]);
  lexParser.increaseProgramCounter();
  
  return new CompoundAssignment(words[0] , t1aux, words[3], t2aux);
 }
}
private boolean isOperator(String op) {
	if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) 
		   return true;
		 else return false;
}
public String toString()
{
	return "Compound Assignment";
}
@Override
public void compile(Compiler compiler) throws ArrayException 
{
	compiler.addByteCode(this.t1.compile(compiler));
	compiler.addByteCode(this.t2.compile(compiler));
	int index = compiler.getIndex(this.varName);
	ByteCode bs = new Store(index);
	
	if(this.operator.equals("+"))
	{
		compiler.addByteCode(new Add());
	}
	else if(this.operator.equals("-"))
	{
		compiler.addByteCode(new Sub());
	}
	else if(this.operator.equals("/"))
	{
		compiler.addByteCode(new Div());
	}
	else if(this.operator.equals("*"))
	{
		compiler.addByteCode(new Mul());
	}
	compiler.addByteCode(bs);
}
}