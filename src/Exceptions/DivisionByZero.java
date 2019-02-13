package Exceptions;

public class DivisionByZero extends ExecutionError{
	private static final long serialVersionUID = 1L;
	public DivisionByZero(){};
	public DivisionByZero(String instr)
	{
		super(instr);
	}
	@Override
	public String toString()
	{
		return this.mensaje;
	}
}
