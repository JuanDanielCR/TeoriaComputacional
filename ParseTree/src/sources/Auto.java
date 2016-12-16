package sources;

import java.util.Random;
import java.util.Scanner;

public class Auto {
	private static Archivo archivo;
	private Random rdn;
	private int longitud;
	private String cadena;
	private ParseTree tree;
	
	public Auto(Archivo a, Scanner s){
		archivo = a;
		rdn = new Random();
		longitud = 0;
		cadena = "";
		tree =  new ParseTree();
	}
	
	public void runParseTree(){
		longitud = rdn.nextInt(1000-1)+1;
		System.out.println("Longitud: "+longitud);
		for(int i = 0; i < longitud; i++){
			int aux = rdn.nextInt(2);
			if(aux == 0){
				cadena += "(";
			}else{
				cadena += ")";
			}
		}
		System.out.println(cadena);
		for(int i = 0; i < longitud; i++){
			archivo.escribirDerivacion(tree.leftmost_string.toString());
			if(tree.derivate(cadena.charAt(i)) == -1){
				System.out.println("Proceso terminado, caracter invalido");
				break;
			}
		}
		archivo.escribirDerivacion(tree.leftmost_string.toString());
		archivo.escribirDerivacion("Automatico original: "+cadena);
		archivo.escribirDerivacion("---------------------------------");
	}
}
