package practica2;



import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Edm<Integer, Short[]> Edm = new Edm<Integer, Short[]>();

		DesOfuscador programa = new DesOfuscador();

		System.out.println("\nIntroduzca el nombre del fichero a DesOfuscar.");

		Scanner sc = new Scanner(System.in);
		String archivo = sc.nextLine();

		System.out.println("\nIntroduzca la clave a buscar.");
		String clave = sc.nextLine();

		long comienzo, fin;

		comienzo = System.currentTimeMillis();

		int i, posicion = 0;

		// esto para que
		String cadena = clave;
		String fichero = archivo;

		short[] cadenaA = new short[cadena.length()];

		for (i = 0; i < cadena.length(); i++) {
			cadenaA[i] = ((short) cadena.codePointAt(i));
		}

		ArrayList<Short> txt = programa.leer(fichero);

		short[] leido = new short[txt.size()];
		short[] ofuscado = new short[txt.size()];

		for (i = 0; i < txt.size(); i++) {
			leido[i] = txt.get(i);
		}

		short[] trozo = new short[cadenaA.length + 596];
		short[] trozo_ofus = new short[cadenaA.length + 596];
		short[] copia = new short[cadenaA.length];
		for (i = 0; i < 65536; i++) {

			ofuscado = programa.algoritmo(programa.copia(cadenaA), i);
			Edm.add(i, ofuscado);
			// posicion = programa.buscar(leido, ofuscado);

		}
		for (i = 0; i < leido.length-cadenaA.length; i++){
			for (int j = 0; j < cadenaA.length; j++)
				copia[j]=leido[i+j];
			if(Edm.get(copia)!=null){
				System.out.println("*** Posicion: = "+i+", Clave: "+clave+" ***");
				trozo=creaTrozo(leido, i);
				programa.algoritmo(trozo, posicion-95);
				System.out.println(programa.vec2str(trozo, 0, trozo.length));
			}
		}
		
		
		/*
		for (int pos = 0; pos < (leido.length - ofuscado.length); pos++) {

			for (int a = 0; a < cadenaA.length; a++) {
				copiaT[a] = leido[pos+a];
			}

			if (Edm.get(copiaT) != null) {

				trozo = programa.cortar(leido, pos, cadenaA.length+596);
				trozo_ofus = programa.algoritmo(programa.copia(trozo), i);
				System.out.println("clave: " + Edm.get(copiaT));
				System.out.println(programa.vec2str(trozo_ofus, 0, trozo_ofus.length));

			}

		}*/
		
		fin = System.currentTimeMillis();
		
		System.out.println("\nTiempo en finalizar: " +(fin-comienzo) +" milisegundos.");
		
	}
	public static short[] creaTrozo(short[] mensaje, int posicion){		
		short [] trozo = new short [595];
		for (int i = 0; i < trozo.length; i++){
			trozo [i] = mensaje[i+posicion-95];
		}
		return trozo;
	}

}