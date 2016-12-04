package sources;

import java.util.Random;

public class Auto {
	private Random rdn;
	private int longitud;
	private String cadena;
	private AFN automata;
	
	public Auto(Archivo a){
		rdn = new Random();
		longitud = 0;
		cadena = "";
		automata =  new AFN(a);
	}
	
	public void runAFN(){
		longitud = rdn.nextInt(1000-1)+1;
		System.out.println("Longitud: "+longitud);
		for(int i = 0; i < longitud; i++){
			cadena += rdn.nextInt(2);
		}
		System.out.println(cadena);
		for(int i = 0; i < longitud; i++){
			automata.transitions(cadena.charAt(i));
		}
		automata.printMatriz();
	}
}
