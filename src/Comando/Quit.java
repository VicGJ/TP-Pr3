//Sale del programa
package Comando;

import Practica3.Engine;

public class Quit implements Command
{
	public Quit(){}
	public void execute(Engine engine)
	{
		engine.endExecution();
	}
	@Override
	public Command parse(String[] s)
	{
		if (s.length!=1 || !s[0].equalsIgnoreCase("QUIT")) return null;
		else return new Quit();
	}
	@Override
	public String textHelp()
	{
		return " QUIT: Permite salir del programa " +
		System.getProperty("line.separator");
	}
	public String toString()
	{
		return "QUIT";
	}
}
