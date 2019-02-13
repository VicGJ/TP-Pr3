package Condition;

import Compile.LexicalParser;
import ConditionalJumps.ConditionalJumps;
import ConditionalJumps.IfNeq;
import Exceptions.ArrayException;
import Term.Term;

public class NotEqual extends Condition{
	 public NotEqual(){} 
	 public NotEqual(Term t1, Term t2) {
	  super(t1, t2);
	 }

	/* protected Condition parse(String line){
	  if(line.equals("!=")) return new NotEqual();
	  else return null;
	 }*/
	 
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser) {
		 if(op.equals("!=")) {
			   parser.increaseProgramCounter();
			   this.condition = new IfNeq();
			   return new NotEqual(t1, t2);
			  }
			  else return null;
	}
	@Override
	protected ConditionalJumps compileOp() throws ArrayException{
		return new IfNeq();
	}
}
