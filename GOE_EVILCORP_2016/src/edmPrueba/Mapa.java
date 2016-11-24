package edmPrueba;




public class Mapa {

	
	
	public static void main (String[] Args){
		
		PruebaEst<Integer, Short[]> Edm = new PruebaEst<Integer, Short[]>();
		
		short[] prueba1 = {1,2,3,4,5};
		short[] prueba2 = {5,6,7,8,9};
		short[] prueba3 = {10,20,30,40,50};
		short[] control= {1,2,3,4,5};
		
		int clave1 = 1;
		int clave2 = 2;
		int clave3 = 3;
		int cControl = 4;
		
		
		
		Edm.add(clave1, prueba1);
		Edm.add(clave2, prueba2);
		Edm.add(clave3, prueba3);
		Edm.add(cControl, control);
		
		
		System.out.println("clave: "+Edm.get(prueba1));
		
		
		
		
		
		
	}
}

