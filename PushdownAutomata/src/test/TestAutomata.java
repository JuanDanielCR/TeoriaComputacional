package test;

import java.util.Scanner;

import sources.Archivo;
import sources.Auto;
import sources.Scanning;

public class TestAutomata {
	private static Archivo archivo = Archivo.getSingleton("historia.txt","pila.txt", "inputs.txt");
	private static Auto automatico;
	private static Scanning sc;
	private static int continua=0;
	private static int modo=0;
	
	public static void main (String []args){
		System.out.println("Balanceo de {} con un Automata de Pila");
		Scanner sca = new Scanner(System.in);
		try{
			do{
				System.out.println("¿Modo? 1- Manual | 2 - Automatico");
				modo = sca.nextInt();
				if(modo == 1){
					sc = new Scanning(archivo);
					sc.runStack();
				}else{
					automatico = new Auto(archivo);
					automatico.runStack();
				}
				System.out.println("Continuar? 1-Si|0-No ");
				continua = sca.nextInt();
			}while(continua != 0);
			sca.close();
			archivo.closeBufferedStream();
		}catch(Exception e){
			System.out.println("Ingresa un número");
		}
		System.out.println("Adios, recuerda abrir historia.txt y pila.txt para ver mas info.");
	}
}
