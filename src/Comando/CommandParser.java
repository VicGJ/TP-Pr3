//ComandoParser: Parsea un string para hacerlo comando o null, si no es válido
package Comando;



public class CommandParser
{
	private final static Command[] commands = {new Help(),new Quit(), new Replace(),new Run(), new Load(), new Compile()};
	
	public static Command parse(String line)
	{
		String[] words;
		line = line.trim();
		words = line.split(" +");
		boolean found = false;
		int i=0;
		Command c = null;
		
		while (i < commands.length && !found)
		{
			c = commands[i].parse(words);
			if (c!=null) found=true;
			else i++;
		}
		return c;
	}
	public static void showHelp()
	{
		for (int i=0; i < CommandParser.commands.length; i++)
		System.out.println(CommandParser.commands[i].textHelp());
	}
}