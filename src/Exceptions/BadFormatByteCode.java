package Exceptions;

public class BadFormatByteCode extends Exception{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public BadFormatByteCode(){};
	public BadFormatByteCode(String instr)
	{
		this.mensaje = instr;
	}
	
	public String toString()
	{
		return this.mensaje;
	}
}
