//Clase que multiplica la cima y subcime de la pila
package aritmetics;


public class Mul extends Aritmetics{
	public Mul(){}
	
	public int Operation(int n2, int n1)
	{
		int resul;
		resul = n1 * n2;
		
		return resul;
	}
	public Aritmetics parseAux(String s) {
		if (s.equalsIgnoreCase("Mul")) return new Mul();
		else return null;
	}
	
	public String toString(){ return "MUL"; }
}
