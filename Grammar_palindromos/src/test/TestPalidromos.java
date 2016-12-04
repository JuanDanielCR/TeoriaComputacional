package test;

import java.util.Random;
import java.util.Scanner;

import sources.Archivo;
import sources.Palindromo;

public class TestPalidromos {
	public static void main(String args[]){
		int flujo = 1;
		Random rdn = new Random();
		Scanner sc = new Scanner(System.in);
		Archivo archivo = Archivo.getSingleton("palindromos.txt", "historia.txt");
		System.out.println("Todo el programa corre en modo automatico");
		try{
			do{
				System.out.println("¿Usar recursion? 1-Si | 0-No");
				int answer = Integer.parseInt(sc.next());
				int random_length = rdn.nextInt(1000);
				Palindromo pal =  new Palindromo(random_length,answer, archivo);
				pal.getPalindromo();
				flujo = rdn.nextInt(2);
				System.out.println(":"+random_length);
			}while(flujo != 0);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		sc.close();
		archivo.closeBufferedStream();
		System.out.println("Listo, consulta historia.txt y palindromos.txt");
	}
}
