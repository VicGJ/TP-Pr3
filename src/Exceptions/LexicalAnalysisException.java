package Exceptions;

public class LexicalAnalysisException extends Exception{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public LexicalAnalysisException(){};
	public LexicalAnalysisException(String instr)
	{
		this.mensaje = instr;
	}
	
	public String toString()
	{
		return this.mensaje;
	}
}
