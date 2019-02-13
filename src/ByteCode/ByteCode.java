//Clase de la que heredan otras clases
package ByteCode;

import CPU.CPU;
import Exceptions.ExecutionError;

//ByteCode: Encapsula los distintos bytecodes de la practica
public interface ByteCode 
{
	void execute(CPU cpu) throws ExecutionError;
	ByteCode parse(String[] words);
}
