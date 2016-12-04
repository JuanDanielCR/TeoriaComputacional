package sources;

import java.util.Random;

public class Auto {
	private Random rdn;
	private int longitud;
	private int aux;
	private String cadena;
	private Combinaciones automata;
	
	public Auto(Archivo a){
		rdn = new Random();
		longitud = 0;
		cadena = "";
		automata = new Combinaciones(a);
	}
	
	public void runAutomata(){
		longitud = rdn.nextInt(1000-1)+1;
		System.out.println("Longitud: "+longitud);
		for(int i = 0; i < longitud; i++){
			aux = rdn.nextInt(2);
			if(aux == 0){
				cadena += "b";
			}else{
				cadena += "n";
			}
		}
		System.out.println(cadena);
		for(int i = 0; i < longitud; i++){
			automata.input = cadena.charAt(i);
			if( automata.ejecutar() == -1){
				System.out.println("Proceso terminado, se encontro un caracter un invalido");
				break;
			}
			System.out.println("...");
		}
		automata.mostrar();
	}
}
