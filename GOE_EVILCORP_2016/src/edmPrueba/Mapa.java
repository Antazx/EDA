package edmPrueba;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import arbolSuffijos.DesOfuscador;

public class Mapa {

	public static void main(String[] Args) {
		DesOfuscador programa = new DesOfuscador();

		PruebaEst<Integer, Short[]> Edm = new PruebaEst<Integer, Short[]>();
		int i;
		short[] prueba1 = { 1, 2, 3, 4, 5 };
		short[] prueba2 = { 5, 6, 7, 8, 9 };
		short[] prueba3 = {9, 10, 11, 12, 13};
		short[] control = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,24,25};
		
		
		
		int clave1 = 1;
		int clave2 = 2;
		int clave3 = 3;
		int cControl = 4;

		
		
		System.out.println("\nIntroduzca el nombre del fichero a DesOfuscar.");

		Scanner sc = new Scanner(System.in);
		String archivo = sc.nextLine();

		System.out.println("\nIntroduzca la clave a buscar.");
		String cadena = sc.nextLine();
		
		DataInputStream dis;
		
		File arch = new File(archivo);
		int n = (int) arch.length();
        short[] leido = new short[n];
        short[] trozo = new short[cadena.length()];
		try {
			dis = new DataInputStream(new FileInputStream(arch));
			 
		        byte[] tmp = new byte[n];
		        dis.read(tmp);
				//System.out.format("Se han leido %d bytes en %.3f seg.!\n", n, 0.001*(System.currentTimeMillis()-tpo));
		        for(i = 0; i < n; i++) { 
		            leido[i] = tmp[i];
		            if(leido[i] < 0) { leido[i] += 256; }
		        }
		        dis.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		short[] cadenaA = new short[cadena.length()];

		for (i = 0; i < cadena.length(); i++) {
			cadenaA[i] = ((short) cadena.codePointAt(i));
		}
		
		for (i = 0; i < 65536; i++) {
			Edm.add(i, Copia(cadenaA));
		}
		
		
		
		
		for(i=0;i<leido.length-cadenaA.length;i++){
			for (int j = 0; j < cadenaA.length; j++)
				trozo[j]=leido[i+j];
			int clave;
			if((clave =Edm.get(trozo)) != -1){
				System.out.println("ha chuscado con "+clave);
				
			}
			
		}

		for(i=0; i<4;i++){
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
