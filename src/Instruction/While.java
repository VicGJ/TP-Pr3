package Instruction;

import ByteCodesOneParameter.Goto;
import Compile.LexicalParser;
import Compile.ParsedProgram;
import Compile.Compiler;
import Condition.Condition;
import Condition.ConditionParser;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;

public class While implements Instruction{
private Condition condition;
private ParsedProgram whileBody;

public While(){};
public While(Condition condition, ParsedProgram whileBody)
{
	this.whileBody = whileBody;
	this.condition = condition;
}
@Override
public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException, ArrayException 
{
	if(words.length != 4 && !words[0].equalsIgnoreCase("WHILE")) return null;
	else
	{
		Condition c = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		ParsedProgram wBody = new ParsedProgram();
		lexParser.lexicalParser(wBody, "ENDWHILE");
		lexParser.increaseProgramCounter();
		return new While(c, wBody);
	}

}
@Override
public void compile(Compiler compiler) throws ArrayException 
{
	int i = compiler.getSizeBcProgram();
	this.condition.compile(compiler);
	compiler.compile(this.whileBody);
	int jump = compiler.getSizeBcProgram();
	this.condition.setJump(jump+1);
	compiler.addByteCode(new Goto(i));
	
}
}
