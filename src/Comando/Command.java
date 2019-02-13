//Dirige otras clases que heredan de esta
package Comando;


import java.io.IOException;

import Exceptions.ArrayException;
import Exceptions.BadFormatByteCode;
import Exceptions.ExecutionError;
import Exceptions.LexicalAnalysisException;
import Practica3.Engine;

//Command: Encapsula los distintos comandos de la aplicacion
public interface Command 
{
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException, BadFormatByteCode, IOException, ExecutionError;
	
	public Command parse(String[] s);
	
	public String textHelp();
	
}
