//Muestra la ayuda
package Comando;

import Practica3.Engine;

public class Help implements Command
{
	public Help(){}
	public void execute(Engine engine)
	{
		engine.showHelp();
	}
	@Override
	public Command parse(String[] s)
	{
		if (s.length!=1 || !s[0].equalsIgnoreCase("HELP")) return null;
		else return new Help();
	}
	@Override
	public String textHelp()
	{
		return " HELP: Muestra una lista de comandos disponibles " +
		System.getProperty("line.separator");
	}
	public String toString()
	{
		return "HELP";
	}
}
