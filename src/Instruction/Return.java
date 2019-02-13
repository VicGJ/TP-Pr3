package Instruction;

import Compile.Compiler;
import Compile.LexicalParser;
import Exceptions.ArrayException;
import ByteCode.Halt;

public class Return implements Instruction {
 public Return() {}
 
 @Override
 public Instruction lexParse(String[] words, LexicalParser lexParser) {
  
  if(words.length == 1 && words[0].equalsIgnoreCase("RETURN"))
	  {
	  lexParser.increaseProgramCounter();
	  return new Return();}
  else return null;
 }

 @Override
 public void compile(Compiler compiler) throws ArrayException 
 {
  compiler.addByteCode(new Halt());
 }
}
