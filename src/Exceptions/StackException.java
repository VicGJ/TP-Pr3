package Exceptions;

public class StackException extends ExecutionError{
	private static final long serialVersionUID = 1L;
	public StackException(){};
	public StackException(String instr)
	{
		super(instr);
	}
	@Override
	public String toString()
	{
		return this.mensaje;
	}
}
