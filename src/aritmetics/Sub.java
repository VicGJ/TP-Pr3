//Clase que resta la cima y subcime de la pila
package aritmetics;



public class Sub extends Aritmetics{
	public Sub(){}
	
	
	public int Operation(int n2, int n1)
	{
		int resul;
		resul = n1 - n2;
		
		return resul;
	}
	public Aritmetics parseAux(String s) {
		if (s.equalsIgnoreCase("Sub")) return new Sub();
		else return null;
	}
	
	public String toString(){ return "SUB"; }
}