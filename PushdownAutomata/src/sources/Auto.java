package sources;

import java.util.Random;

public class Auto {
	private static Archivo archivo;
	private Random rdn;
	private int longitud;
	private String cadena;
	private PushdownAutomata automata;
	
	public Auto(Archivo a){
		archivo = a;
		rdn = new Random();
		longitud = 0;
		cadena = "";
		automata =  new PushdownAutomata(archivo);
	}
	
	public void runStack(){
		longitud = rdn.nextInt(1000-1)+1;
		System.out.println("Longitud: "+longitud);
		for(int i = 0; i < longitud; i++){
			int aux = rdn.nextInt(2);
			if(aux == 0){
				cadena += "{";
			}else{
				cadena += "}";
			}
		}
		System.out.println(cadena);
		cadena += "#";
		for(int i = 0; i < longitud; i++){
			automata.setCharacter(cadena.charAt(i));
			archivo.escribirCaracter(cadena.charAt(i));
			if(automata.transition() == 'N'){
				break;
			}
		}
		if(automata.transition() == 'a'){
			System.out.println("Cadena Balanceada");
		}else{
			System.out.println("Cadena no balanceada");
		}
		archivo.escribirHistoria('\n');
		archivo.escribirCaracter('\n');
		archivo.escribirPila("---------------------------");
	}
}
