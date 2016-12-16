package test;

import java.util.Scanner;

import sources.Archivo;
import sources.Auto;
import sources.Scanning;

public class TestMaquinaTuring {
	private static Archivo a = Archivo.getSingleton("output.txt", "historia.txt");
	private static Auto automatico;
	private static Scanning sc;
	private static Scanner cont =  new Scanner(System.in);
	private static int flujo = 1;
	private static int modo = 1;
	
	public static void main(String []args){
		System.out.println("Maquina de Turing, suma de 0 y 1");
		try{
			do{
				System.out.println("¿Modo? 1-Manual | 0-Automatico");
				modo = cont.nextInt();
				if(modo == 1){
					sc =  new Scanning(a);
					sc.runMachine();
				}else{
					automatico =  new Auto(a);
					automatico.runMachine();
				}
				System.out.println("Continuar? 1-Si | 0-No");
				flujo =  cont.nextInt();
			}while(flujo != 0);	
		}catch(Exception e){
			e.printStackTrace();
		}
		cont.close();
		a.closeBufferedStream();
	}
}
