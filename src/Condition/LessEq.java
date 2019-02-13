package Condition;

import Compile.LexicalParser;
import ConditionalJumps.ConditionalJumps;
import Term.Term;
import ConditionalJumps.IfLeq;
import Exceptions.ArrayException;

public class LessEq extends Condition{
	 public LessEq(){} 
	 public LessEq(Term t1, Term t2) {
	  super(t1, t2);
	 }

	/* protected Condition parse(String line){
	  if(line.equals("<=")) return new LessEq();
	  else return null;
	 }*/
	 
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
		 if(op.equals("<=")) {
			   parser.increaseProgramCounter();
			   this.condition = new IfLeq();
			   return new LessEq(t1, t2);
			  }
			  else return null;
	}
	@Override
	protected ConditionalJumps compileOp()throws ArrayException {
		return new IfLeq();
	}
}
