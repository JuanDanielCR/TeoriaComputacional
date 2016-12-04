package test;
import java.util.Scanner;

import sources.*;
public class Launch {
	private static int continua = 0;
	private static int modo = 0;
	private static Scanner sc =  new Scanner(System.in);
	private static Scanning manual; 
	private static Archivo archivo;

	public static void main(String args[]){
		archivo = new Archivo("ebay.txt", "salida.txt", "historia.txt");
		try{
			do{
				System.out.println("¿Modo? 1-Manual | 2-Automatico | 3-Diagrama");
				modo = sc.nextInt();
				if(modo == 3){
					Thread gui = new Thread(new Runnable() {
						@Override
						public void run() {
							ViewWebay g = new ViewWebay();
							g.setVisible(true);
						}
					});
					gui.start();
				}else if(modo == 2){
					archivo.analizarArchivo();
				}else{
					manual = new Scanning(archivo);
					manual.getCharacter();
				}
				System.out.println("¿Continuar? 1-Si | 0-No");
				continua =  sc.nextInt();
			}while(continua != 0);
		}catch(Exception e){
			System.out.println("Algo salio mal, corre el programa de nuevo");
		}
		archivo.closeBufferedStream();	
		sc.close();
		System.out.println("Adios, los archivos salida.txt y historia.txt tiene info. interesante para ti");
	}
}
