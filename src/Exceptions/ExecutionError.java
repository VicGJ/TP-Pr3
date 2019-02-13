package Exceptions;

public class ExecutionError extends Exception{
	private static final long serialVersionUID = 1L;
	protected String mensaje;
	public ExecutionError(){};
	public ExecutionError(String instr)
	{
		this.mensaje = instr;
	}
	
	public String toString()
	{
		return this.mensaje;
	}
}
