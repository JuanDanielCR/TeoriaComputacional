package sources;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Archivo {
	
	private static Archivo file_singleton = null;
	private PrintWriter outputStream;
	private PrintWriter outputStreamHistoria;
	private PrintWriter outputStreamCaracter;
	
	/*Begin Singleton*/
	private Archivo(String historia, String archivo_salida, String caracter){
		try {
			this.outputStream = new PrintWriter(new FileWriter(archivo_salida));
			this.outputStreamHistoria = new PrintWriter(new FileWriter(historia));
			this.outputStreamCaracter = new PrintWriter(new FileWriter(caracter));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Archivo getSingleton(String salida, String historia, String caracter){
		if(file_singleton == null){
			file_singleton = new Archivo(salida, historia, caracter);
		}
		return file_singleton;
	}
	/*End Singleton*/
	
	public void escribirPila(String stack){
		outputStream.write(stack);
		outputStream.write("\n");
	}
	
	public void escribirHistoria(char pal){
		outputStreamHistoria.write(pal);
	}
	public void escribirCaracter(char caracter){
		outputStreamCaracter.write(caracter);
	}
	
	public void closeBufferedStream(){
		if(outputStream != null){
			outputStream.close();
		}
		if(outputStreamHistoria != null){
			outputStreamHistoria.close();
		}
		if(outputStreamCaracter != null){
			outputStreamCaracter.close();
		}
	}
}
