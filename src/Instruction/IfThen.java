package Instruction;

import Compile.LexicalParser;
import Compile.ParsedProgram;
import Condition.Condition;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Compile.Compiler;
import Condition.ConditionParser;

public class IfThen implements Instruction{
private Condition condition;
private ParsedProgram ifBody;
public IfThen()
{};
public IfThen(Condition condition, ParsedProgram pp)
{
	this.condition = condition;
	this.ifBody = pp;
}

@Override
public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException 
, ArrayException
{
	if (words.length == 4 && words[0].equalsIgnoreCase("IF"))
	{
		Condition c = ConditionParser.parse(words[0], words[1], words[2], lexParser);
		ParsedProgram iBody = new ParsedProgram();
		lexParser.lexicalParser(iBody, "ENDIF");
		lexParser.increaseProgramCounter();
		return new IfThen(c, iBody);
	}

	 else return null;
		 
}
@Override
public void compile(Compiler compiler) throws ArrayException 
{
	this.condition.compile(compiler);
	compiler.compile(this.ifBody);
	this.condition.setJump(compiler.getSizeBcProgram());
}

public String toString(){
	String s = "if " + this.condition + System.getProperty("line.separator");
	s = s + "	" + this.ifBody;
	return s;
}
}