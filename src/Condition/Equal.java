package Condition;

import Compile.LexicalParser;
import ConditionalJumps.ConditionalJumps;
import ConditionalJumps.IfEq;
import Exceptions.ArrayException;
import Term.Term;

public class Equal extends Condition{
	 public Equal(){} 
	 public Equal(Term t1, Term t2) {
	  super(t1, t2);
	 }

	/* protected Condition parse(String line){
	  if(line.equals("==")) return new Equal();
	  else return null;
	 }*/
	 
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
		 if(op.equals("=")) {
			   parser.increaseProgramCounter();
			   this.condition = new IfEq();
			   return new Equal(t1, t2);
			  }
			  else return null;
	}
	@Override
	protected ConditionalJumps compileOp()throws ArrayException {
		return new IfEq();
	}
}
