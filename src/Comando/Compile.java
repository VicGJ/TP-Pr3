package Comando;

import Exceptions.ArrayException;
import Exceptions.LexicalAnalysisException;
import Practica3.Engine;

public class Compile implements Command{
	public Compile(){};
	
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException
	{
		engine.compile();
	}

	public Command parse(String[] s)
	{
		if (s[0].equalsIgnoreCase("Compile") && s.length == 1) return new Compile();
		else return null;
	}

	public String textHelp()
	{
		return " COMPILE: realiza el análisis léxico del programa fuente, generando un nuevo programa " +
				System.getProperty("line.separator");
	}
	public String toString()
	{
		return "Compile";
	}
}

