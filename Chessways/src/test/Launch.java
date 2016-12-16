package test;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sources.*;
public class Launch {
	private static Archivo archivo;
	private static int continua = 1;
	private static int modo;
	private static Scanner sc =  new Scanner(System.in);
	
	public static void main(String args[]){
		System.out.println("Caminos de un ajedres, b - Blanco | n - Negro");
		archivo =  new Archivo("salida.txt", "historia.txt");
		do{
			try{
				System.out.println("¿Modo? 1-Manual | 2-Automatico");
				modo = sc.nextInt();
				if(modo == 1){
					Scanning sc = new Scanning(archivo);
					sc.runAutomata();
				}else if(modo == 2){
					Auto automatico = new Auto(archivo);
					automatico.runAutomata();
				}
				System.out.println("¿Continuar? 1-Si | 0-No");
				continua = sc.nextInt();
			}catch(Exception e){
				System.out.println("Ingresa un numero");
				return;
			}
		}while(continua != 0);
		archivo.closeBufferedStream();
		System.out.println("¿Animacion? 1-Si | |0-No");
		continua =  sc.nextInt();
		
		if(continua == 1){
			Thread gui = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("La animacion se carga dela rchivo salida.txt!");
					GUI g;
					try {
						g = new GUI();
						g.setVisible(true);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			});
			gui.start();
		}
		sc.close();
		System.out.println("He terminado, si tienes tiempo revisa los archivos historia.txt y salida.txt");
	}
}
