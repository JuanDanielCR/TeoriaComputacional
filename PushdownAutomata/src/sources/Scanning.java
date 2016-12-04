package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Scanner input = null;
	private Archivo archivo;
	private PushdownAutomata automata;
	
	public Scanning(Archivo a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		automata = new PushdownAutomata(a);  
		archivo = a;
	}
	
	public void runStack(){
		char c,limit;
		limit = System.lineSeparator().charAt(0);
		System.out.println("Ingresa:");
		Pattern p = Pattern.compile(".*?", Pattern.MULTILINE);
		input.useDelimiter(p);
		while(input.hasNext()){
			c = input.next().charAt(0);
			automata.setCharacter(c);
			archivo.escribirCaracter(c);
			if(c==limit){
				automata.setCharacter('#');
				automata.transition();
				if(automata.getEstado() == 'a'){
					System.out.println("Cadena Balanceada");
				}else{
					System.out.println("Cadena no Balanceada");
				}
				break;
			}
			if(automata.transition() == 'N'){
				System.out.println("Cadena no balanceada");
				break;
			}
			
		}
		archivo.escribirHistoria('\n');
		archivo.escribirCaracter('\n');
		archivo.escribirPila("---------------------------");
	}
	
}
