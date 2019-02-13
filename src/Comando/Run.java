//Ejecuta el programa
package Comando;

import Exceptions.ExecutionError;
import Practica3.Engine;

public class Run implements Command
{
	public Run(){}
	public void execute(Engine engine) throws ExecutionError
	{
		engine.executeCommandRun();
	}
	@Override
	public Command parse(String[] s)
	{
		if (s.length==1 && s[0].equalsIgnoreCase("RUN")) return new Run();
		else return null;
	}
	@Override
	public String textHelp()
	{
		return " RUN: Permite iniciar el programa " +
		System.getProperty("line.separator");
	}
	public String toString()
	{
		return "RUN";
	}
}
