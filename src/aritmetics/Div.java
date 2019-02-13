//Clase que divide la cima y subcime de la pila
package aritmetics;

import Exceptions.DivisionByZero;
public class Div extends Aritmetics{
	
	public Div(){}
	

	public int Operation(int n2, int n1) throws DivisionByZero
	{
		int resul = 0;
		if(n2 == 0)
		{
			throw new DivisionByZero("Error porque:" + n2 + "es indivisible con: " + n1);
		}
		else
			resul = n1 / n2;
		return resul;
	}
	public Aritmetics parseAux(String s) {
		if (s.equalsIgnoreCase("Div")) return new Div();
		else return null;
	}
	
	public String toString(){ return "DIV"; }
}
