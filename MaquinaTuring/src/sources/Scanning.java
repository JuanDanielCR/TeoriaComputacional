package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Archivo archivo;
	private Scanner input = null;
	private MaquinaTuring machine;
	
	public Scanning(Archivo a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		machine = new MaquinaTuring(a);
		archivo = a;
	}
	
	public void runMachine(){
		char c,limit;
		String estado;
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
			machine.llenarCinta(c);
		}
		machine.iniciarCinta();
		estado = machine.getEstado();
		//Execute transitions
		while(estado !="q5" && estado!="N"){
			estado = machine.transition(machine.getInput());
			archivo.escribirHistoria(estado);
			if(estado == "N"){
				System.out.println("Formato invalido");
			}
		}
		archivo.escribirHistoria("\n");
		//final tape
		machine.mostrarCinta();
	}
	
}
