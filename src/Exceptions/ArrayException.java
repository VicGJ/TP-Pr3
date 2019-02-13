package Exceptions;

public class ArrayException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public ArrayException(){};
	public ArrayException(String instr)
	{
		this.mensaje = instr;
	}
	
	public String toString()
	{
		return this.mensaje;
	}
	
}
