package sources;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Scanning {
	private Scanner input = null;
	private static Archivo archivo;
	private String original;
	
	public Scanning(Archivo  a){
		input = new Scanner(System.in);
		input.useLocale(Locale.US);
		archivo = a;
		original = "";
	}
	
	public void getCharacter(){
		ParseTree tree = new ParseTree(); 
		char c,limit;
		limit = System.lineSeparator().charAt(0);
		System.out.println("Ingresa:");
		Pattern p = Pattern.compile(".*?", Pattern.MULTILINE);
		input.useDelimiter(p);
		while(input.hasNext()){
			System.out.println(tree.leftmost_string);
			archivo.escribirDerivacion(tree.leftmost_string.toString());
			c = input.next().charAt(0);
			original += c;
			if(c==limit){
				tree.derivate('#');
				break;
			}
			/*Derivation*/
			if(tree.derivate(c) == -1){
				System.out.println("Proceso terminado, caracter invalido");
				break;
			}
		}
		System.out.println(tree.leftmost_string);
		archivo.escribirDerivacion(tree.leftmost_string.toString());
		archivo.escribirDerivacion("Manual original: "+original);
		archivo.escribirDerivacion("---------------------------------");
	}
	
}
