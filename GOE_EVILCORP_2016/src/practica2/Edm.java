
package practica2;

import java.util.Arrays;

/**
 * @author Mario
 *
 */
public class Edm<C, V> {
	private Entrada<C, V>[] tabla;
	private int tamaño = 65536000;

	static class Entrada<C, V> {
		C clave;
		short[] valor;
		Entrada<C, V> siguiente;

		public Entrada(C clave, short[] ofuscado, Entrada<C, V> siguiente) {
			this.clave = clave;
			this.valor = new short[ofuscado.length];
			System.arraycopy(ofuscado, 0, this.valor, 0, ofuscado.length);;
			this.siguiente = siguiente;
		}

	}

	public Edm() {
		tabla = new Entrada[tamaño];
	}

	private int hash(short[] valor) {
		
		int vHash=0;
		for(int i=0;i<valor.length;i++){
			vHash = vHash + valor[i];
		}
		return vHash % tamaño;
	}

	public void add(C nClave, short[] ofuscado) {
		if (nClave == null) {
			return;
		}
		int hash = hash(ofuscado);
		Entrada<C, V> nuevaEntrada = new Entrada<C, V>(nClave, ofuscado, null);

		if (tabla[hash] == null) {
			tabla[hash] = nuevaEntrada;
		} else {
			Entrada<C, V> anterior = null;
			Entrada<C, V> actual = tabla[hash];

			while (actual != null) {
				if (actual.clave.equals(nClave)) {
					if (anterior == null) {
						nuevaEntrada.siguiente = actual.siguiente;
						tabla[hash] = nuevaEntrada;
						return;

					} else {
						nuevaEntrada.siguiente = actual.siguiente;
						anterior.siguiente = nuevaEntrada;
						return;
					}

				}
				anterior = actual;
				actual = actual.siguiente;

			}

			anterior.siguiente = nuevaEntrada;

		}

	}
	public boolean iguales(short[] uno, short[] dos){
		return Arrays.equals(uno, dos);
	}

	public C get(short[] valor) {
		int hash = hash(valor);
		if (tabla[hash] == null) {
			return null;
		} else {
			Entrada<C, V> temp = tabla[hash];
			while (temp != null) {
				if (iguales(temp.valor,valor))
					return temp.clave;
					temp = temp.siguiente; 
			}
			return null; 
		}
	}

}
