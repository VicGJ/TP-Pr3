//Maquina virtual capaz de ejecutar un bytecode
package CPU;

import ByteCode.ByteCode;
import Exceptions.ExecutionError;
import Exceptions.StackException;
import Practica3.ByteCodeProgram;



public class CPU 
{
	private Memory mem = new Memory();
	private OperandStack pila = new OperandStack();
	private boolean parada = false;
	private int programCounter = 0;
	private ByteCodeProgram program = new ByteCodeProgram();
	
	public CPU(ByteCodeProgram program) {
	this.program = program;
	}

	public CPU() {
		// TODO Auto-generated constructor stub
	}

	public void halt() { this.parada = true; }
	
	public String toString(){ 
		String s = System.getProperty("line.separator") +
			"Estado de la CPU: " + System.getProperty("line.separator") +
			" Memoria: " + this.mem + System.getProperty("line.separator") +
			" Pila: " + this.pila + System.getProperty("line.separator");
			return s; }
	
	public int getSizeStack() {return this.pila.getNumElems();}
	
	public int pop() throws StackException{ return this.pila.pop();}
	
	public boolean push(int i)throws StackException {
		return this.pila.push(i);}
	
	public int read(int param) {
		return this.mem.read(param);
		}

	public void write(int param, int value) {this.mem.write(param, value);}
	
	public void setProgramCounter(int jump) {this.programCounter = jump;}
	
	public void increaseProgramCounter() {this.programCounter++;}
	
	
	public void run() throws ExecutionError{
		while(!this.parada && this.programCounter < this.program.getNumberOfByteCodes()){
			int aux = this.programCounter;
			ByteCode inst = this.program.getByteCode(this.programCounter);
			try {
				inst.execute(this);
			}
			catch (ExecutionError e) {
				throw new ExecutionError("Error en el ByteCode " + inst + " (línea " + this.programCounter + "): " + e);
			}
			
			if(aux == this.programCounter)
				this.programCounter++;
			
		}
		System.out.println("El estado de la maquina tras ejecutar programa es: \n");
		System.out.println(this);
	}
}

