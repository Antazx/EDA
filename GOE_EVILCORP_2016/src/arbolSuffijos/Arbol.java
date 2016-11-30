/**
 * Anta Alonso, Guillermo
 * Gomez Fernandez, Mario
 */
package arbolSuffijos;

public class Arbol {

	private Nodo raiz;

	public Arbol() {

		this.raiz = new Nodo();
	}

	public void insertarCadena(short[] cadena, int clave) {

		Nodo padre = raiz;
		Nodo hijo = raiz;

		for (int i = 0; i < cadena.length; i++) {
			if ((hijo = padre.getNodoCaracter(cadena[i])) == null) {
				hijo = new Nodo(padre, cadena[i]);
				if (i == cadena.length - 1)
					hijo.setClave(clave);
				padre.añadeHijo(hijo);
				padre = hijo;
			} else {
				padre = hijo;
			}
		}
	}

	public int buscarCadena(short[] palabra) {

		Nodo actual = raiz;

		for (int i = 0; i < palabra.length; i++)
			if ((actual = actual.getNodoCaracter(palabra[i])) == null)
				return -1;
	
		return actual.getClave();
	}
}
