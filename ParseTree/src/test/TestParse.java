package test;

import java.util.Scanner;

import sources.Archivo;
import sources.Auto;
import sources.Scanning;

public class TestParse {
	private static int continua;
	private static int modo;
	private static Archivo archivo = Archivo.getSingleton("historia.txt");
	private static Auto automatico;
	private static Scanning sc;
	private static Scanner sc_flujo = new Scanner(System.in);
	
	public static void main(String args[]){
		System.out.println("Balanceo de parentesis: (())()");
		do{
			try{
				System.out.println("¿Modo? 1-Manual | 0-Automatico");
				modo = sc_flujo.nextInt();
				if(modo == 1){
					sc = new Scanning(archivo);
					sc.getCharacter();
				}else{
					automatico = new Auto(archivo, sc_flujo);
					automatico.runParseTree();
				}
				System.out.println("Continuar? 1-Si | 0-No");
				continua = sc_flujo.nextInt();
			}catch(Exception e){
				System.out.println("Algo inesperado ocurrio");
			}
		}while(continua != 0);
		
		archivo.closeBufferedStream();
		sc_flujo.close();
		System.out.println("Adios, deberias abrir historia.txt");
	}
}
