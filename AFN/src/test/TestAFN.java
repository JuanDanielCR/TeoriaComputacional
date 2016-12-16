package test;

import java.util.Scanner;

import sources.Archivo;
import sources.Auto;
import sources.GUI;
import sources.Scanning;

public class TestAFN {
	private static int continuar;
	private static int modo;
	private static Archivo file;
	private static Scanner sc; 
	private static Scanning manual;
	private static Auto automatico;
	
	public static void main(String args[]){
		System.out.println("Automata FN - Cadena de 0,1's");
		file = Archivo.getSingleton("output.txt", "historia.txt");
		sc = new Scanner(System.in);
		do{
			System.out.println("¿Modo? 2-GUI | 1-Manual | 0-Auto");
			modo = sc.nextInt();
			if(modo == 2){
				Thread t = new Thread(new Runnable(){
					@Override
					public void run(){
						GUI g = new GUI();
						g.setVisible(true);
					}
				});
				t.start();
				file.closeBufferedStream();
			}else if(modo == 1){
				manual =  new Scanning(file);
				manual.runAFN();
			}else{
				automatico =  new Auto(file);
				automatico.runAFN();
			}
			System.out.println("¿Continuar? 1-Si | |0-No");
			continuar = sc.nextInt();
		}while(continuar != 0);
		file.closeBufferedStream();
		sc.close();
		System.out.println("Revisa los archivos historia.txt y output.txt para mas informacion");
	}
}
