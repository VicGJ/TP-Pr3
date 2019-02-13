package Condition;

import ConditionalJumps.ConditionalJumps;
import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Term.Term;
import Term.TermParser;
import Compile.LexicalParser;
import Compile.Compiler;

public abstract class Condition {
	 private Term t1;
	 private Term t2;
	 protected ConditionalJumps condition;
	 
	 //Otros métodos abstractos:
	 abstract protected Condition parseOp(Term t1, String op, Term t2, LexicalParser parser);
	 abstract protected ConditionalJumps compileOp() throws ArrayException;
	 
	 //------------------------------Constructores--------------------------------
	 public Condition(){}
	 
	 public Condition(Term t1, Term t2) {
	  this.t1 = t1;
	  this.t2 = t2;
	 }
	 
	 public Condition parse(String t1, String op, String t2, LexicalParser parser) throws LexicalAnalysisException
	 {
	  this.t1 = TermParser.parse(t1);
	  this.t2 = TermParser.parse(t2);
	  return parseOp(this.t1, op, this.t2, parser);
	 }

	 public void compile(Compiler compiler) throws ArrayException
	 {
		 compiler.addByteCode(this.t1.compile(compiler));
		 compiler.addByteCode(this.t2.compile(compiler));
		 this.condition = this.compileOp();
		 compiler.addByteCode(this.condition);
	 }
	public void setJump(int jump)
	{
		this.condition.change(jump);
	}
}
