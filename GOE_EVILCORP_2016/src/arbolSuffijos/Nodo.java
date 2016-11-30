
/**
 * Anta Alonso, Guillermo
 * Gomez Fernandez, Mario
 */

package arbolSuffijos;

import java.util.ArrayList;

public class Nodo {

	@SuppressWarnings("unused")
	private Nodo padre;
	private ArrayList<Nodo> hijos;
	private short caracter;
	private int clave;

	public Nodo() {
		this.padre = null;
		hijos = new ArrayList<Nodo>();
		this.caracter = -1;
		this.clave = -1;
	}

	public Nodo(Nodo padre, short letra) {
		this.padre = padre;
		hijos = new ArrayList<Nodo>();
		this.caracter = letra;
		this.clave = -1;
	}

	public Nodo(Nodo padre, short letra, int clave) {
		this.padre = padre;
		hijos = new ArrayList<Nodo>();
		this.caracter = letra;
		this.clave = clave;
	}

	public short getCaracter() {
		return caracter;
	}

	public int getClave() {
		return clave;
	}

	public Nodo getNodoCaracter(short caracter) {

		for (int i = 0; i < hijos.size(); i++) {
			if (hijos.get(i).getCaracter() == caracter)
				return hijos.get(i);
		}
		return null;
	}
	
	public void setClave(int clave){
		this.clave = clave;
	}
	
	public void añadeHijo(Nodo hijo) {
		hijos.add(hijo);
	}
}
