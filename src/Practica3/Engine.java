//Engine: Es el interprete de comandos
package Practica3;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import CPU.CPU;
import Comando.Command;
import Comando.CommandParser;
import Compile.LexicalParser;
import Compile.ParsedProgram;
import Compile.SourceProgram;
import Compile.Compiler;
import Exceptions.ArrayException;
import Exceptions.BadFormatByteCode;
import Exceptions.ExecutionError;
import Exceptions.LexicalAnalysisException;


public class Engine 
{
private SourceProgram sProgram;
private ParsedProgram pProgram;
private ByteCodeProgram bcProgram;
private boolean end;
private Scanner in = new Scanner(System.in);


public Engine()
{
	this.bcProgram = new ByteCodeProgram();
	this.sProgram = new SourceProgram();
	this.pProgram = new ParsedProgram();
	this.end = false;
}
public void compile() throws LexicalAnalysisException, ArrayException
{
	this.bcProgram = new ByteCodeProgram();
	this.pProgram = new ParsedProgram();
	this.lexicalAnalysis();
	this.generateByteCode();
	
}
private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException {
	LexicalParser lexParser = new LexicalParser(this.sProgram);
	try{
		lexParser.lexicalParser(this.pProgram, "END");
	}
	catch(ArrayException e){
		this.pProgram = new ParsedProgram();
		throw e;
	}
	catch(LexicalAnalysisException e){
		this.pProgram = new ParsedProgram();
		throw e;
	}
}
private void generateByteCode() throws ArrayException 
{
	Compiler compiler = new Compiler(this.bcProgram); // Mirar si hace falta el constructor en compiler con bcProgram
	try{
		compiler.compile(this.pProgram);
	}
	catch(ArrayException e){
		this.pProgram = new ParsedProgram();
		this.bcProgram = new ByteCodeProgram();
		throw e;
	}
}


//Ejecutar el comando LOADFICH:
@SuppressWarnings("resource")
public void load(String fichero) throws FileNotFoundException, ArrayException
{
	this.sProgram = new SourceProgram();
	Scanner sc = new Scanner("");
	
	try 
	{
	File fich = new File(fichero);
	sc = new Scanner(fich);
	String line = "";
	
	while(!line.equalsIgnoreCase("end")) {
	 line = sc.nextLine();
	 this.sProgram.addSourceProgram(line);
	} 
	
	} catch(FileNotFoundException e) {
	System.out.println("Excepcion: Fichero no Encontrado...");
	} finally {
	sc.close();
	}
}


public void start()
{
	String line = "";
	
	while(!end) {
		Command command = null;
		line = in.nextLine();
		command = CommandParser.parse(line);
		if(command == null) System.out.println("Error: Comando incorrecto"); 
		else {
			System.out.println("Comienza la ejecución de " + command);
			try{
				command.execute(this);
			}
			catch(Exception e){
				System.out.println("Error de ejecución del comando " + command.toString() + ":" + e);
			}
			System.out.println(sProgram);
			System.out.println(bcProgram);
		}
		
	}
	System.out.println("Fin de la ejecución... ");
}
public void executeCommandRun() throws ExecutionError
{
	CPU cpu = new CPU(this.bcProgram);
	cpu.run();
}
//OK
public boolean showHelp() 
{
	CommandParser.showHelp();
	return true;
}
//OK
public boolean endExecution()
{ 
	return this.end = true; 
}
/*public ByteCode addByteCodeInstruction(ByteCode bc) 
{
	return this.bcProgram.addBCInstruction(bc);
}*/

public boolean replaceByteCode(int replace) throws BadFormatByteCode, ArrayException
{
	boolean ok = false;
	
	String line = "";
	line = in.nextLine();
	ByteCode bc = ByteCodeParser.parse(line);
	if(bc != null)
	{
		this.bcProgram.replace(replace, bc);
		ok = true;
	}
	if(ok == true) return ok;
	else throw new ArrayException("Posicion No Valida");
}
/*public boolean readByteCodeProgram() throws BadFormatByteCode
{
	boolean ok = false;
	String line;
	line = in.nextLine();
	
	while(!line.equalsIgnoreCase("End"))
	{
		ByteCode bc = ByteCodeParser.parse(line);
		if(bc!= null)
		{
			bcProgram.addBCInstruction(bc);
			ok = true;
		}
		line = in.nextLine();
	}
	return ok;
}*/

public void resetProgram() 
{
	this.bcProgram.reset();
}
}
