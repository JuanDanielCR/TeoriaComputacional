package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Scanner input = null;
	private AFN automata;
	
	public Scanning(Archivo a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		automata = new AFN(a);  
	}
	
	public void runAFN(){
		char c,limit;
		limit = System.lineSeparator().charAt(0);
		System.out.println("Ingresa:");
		Pattern p = Pattern.compile(".*?", Pattern.MULTILINE);
		input.useDelimiter(p);
		//Fill machine tape
		while(input.hasNext()){
			c = input.next().charAt(0);
			if(c==limit){
				break;
			}
			automata.transitions(c);
		}
		automata.printMatriz();
	}
	
}
