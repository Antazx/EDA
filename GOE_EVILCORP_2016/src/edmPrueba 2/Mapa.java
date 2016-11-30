package edmPrueba;

import arbolSuffijos.DesOfuscador;

public class Mapa {

	public static void main(String[] Args) {
		DesOfuscador programa = new DesOfuscador();

		PruebaEst<Integer, Short[]> Edm = new PruebaEst<Integer, Short[]>();

		short[] prueba1 = { 1, 2, 3, 4, 5 };
		short[] prueba2 = { 5, 6, 7, 8, 9 };
		short[] prueba3 = {9, 10, 11, 12, 13};
		short[] control = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,24,25};
		
		short[] trozo = new short[prueba1.length];

		int clave1 = 1;
		int clave2 = 2;
		int clave3 = 3;
		int cControl = 4;

		for (int i = 0; i < 4; i++) {
			Edm.add(i, programa.algoritmo(Copia(prueba3), i));
		}
		
		
		for(int i=0;i<control.length-prueba1.length;i++){
			for (int j = 0; j < prueba1.length; j++)
				trozo[j]=control[i+j];
			if(Edm.get(programa.algoritmo(Copia(trozo), 1)) != -1){
				System.out.println("ha chuscado con "+Edm.get(programa.algoritmo(Copia(trozo), 1)));
				
			}
			
		}

		for(int i=0; i<4;i++){
			System.out.println("clave: " + Edm.get(programa.algoritmo(Copia(prueba3), i)));
		}

	}
	
	public static short[] Copia(short[] cadena){
		short[] copia = new short[cadena.length];
		
		for(int i=0;i<cadena.length;i++){
			copia[i]=cadena[i];
		}
		
		return copia;
	}
	
}
