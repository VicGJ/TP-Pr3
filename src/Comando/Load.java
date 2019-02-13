package Comando;


import java.io.IOException;

import Exceptions.ArrayException;
import Practica3.Engine;

public class Load implements Command{
	String nombre;
	public Load()
	{};
	public Load(String nombre)
	{
		this.nombre =  nombre;
	}
	@Override
	public void execute(Engine engine) throws ArrayException, IOException
	{
		engine.load(this.nombre);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
		{
			return new Load(s[1]);
		}
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "LOAD: Carga un fichero";
	}
	public String toString()
	{
		String s = "LOAD: " + this.nombre;
		return s;
	}

}
