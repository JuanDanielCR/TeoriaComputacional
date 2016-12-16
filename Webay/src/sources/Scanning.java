package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Scanner input = null;
	private AnalisisAutomata automata;
	private Archivo archivo;
	private int estado;
	
	public Scanning(Archivo a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		automata = new AnalisisAutomata();  
		archivo = a;
	}
	
	public void getCharacter(){
		char c,limit;
		limit = System.lineSeparator().charAt(0);
		System.out.println("Ingresa:");
		Pattern p = Pattern.compile(".*?", Pattern.MULTILINE);
		input.useDelimiter(p);
		while(input.hasNext()){
			c = input.next().charAt(0);
			if(c==limit){
				break;
			}
			estado = automata.analizarSimbolo(c);
			archivo.escribirHistoria("q"+estado);
			if(estado == 146){
				archivo.escribirSalida("Manual: Linea[1] Palabra: web \n");
			}else if(estado == 18){
				archivo.escribirSalida("Manual: Linea[1] Palabra: ebay \n");
			}
		}
		archivo.escribirHistoria("\n");
	}
	
}
