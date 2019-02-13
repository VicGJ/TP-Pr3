package Instruction;
import ByteCode.Out;
import ByteCodesOneParameter.Load;
import Compile.Compiler;
import Compile.LexicalParser;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;

public class Write implements Instruction
{
	 private String varName;
	 public Write(){}
	 public Write(String varName){
	  this.varName = varName;
	 }
	 
	 @Override
	 public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysisException
	 {
		 if (words[0].equals("write") && words[1].length() == 1) {
				char name = words[1].charAt(0);
				if('a'<= name && name <= 'z'){
					lexParser.increaseProgramCounter();
					return new Write(words[1]);
				}
			}
			return null;
	 }

	 @Override
	 public void compile(Compiler compiler) throws ArrayException 
	 {
	  int index = compiler.getIndex(this.varName);
	  compiler.addByteCode(new Load(index));
	  compiler.addByteCode(new Out());
	 }
}