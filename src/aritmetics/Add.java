//Clase que suma la cima y subcime de la pila
package aritmetics;

public class Add extends Aritmetics{

	public Add(){}
	
	public int Operation(int n2, int n1)
	{
		int resul;
		resul = n1 + n2;
		return resul;
	}
	public Aritmetics parseAux(String s) {
		if (s.equalsIgnoreCase("Add")) return new Add();
		else return null;
	}
	
	public String toString(){ return "ADD"; }
}
