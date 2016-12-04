package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Scanner input = null;
	private Combinaciones automata;
	
	public Scanning(Archivo a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		automata = new Combinaciones(a);
	}
	
	public void runAutomata(){
		char caracter,limit;
		limit = System.lineSeparator().charAt(0);
		System.out.println("Ingresa:");
		Pattern p = Pattern.compile(".*?", Pattern.MULTILINE);
		input.useDelimiter(p);
		while(input.hasNext()){
			caracter = input.next().charAt(0);
			if(caracter==limit){
				break;
			}
			automata.input = caracter;
			if( automata.ejecutar() == -1){
				System.out.println("Proceso terminado, se encontro un caracter un invalido");
				break;
			}
			System.out.println("...");
		}
		automata.mostrar();
	}
	
}
