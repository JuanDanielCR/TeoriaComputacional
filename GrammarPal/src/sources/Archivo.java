package sources;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Archivo {
	
	private static Archivo file_singleton = null;
	private PrintWriter outputStream;
	private PrintWriter outputStreamHistoria;
	
	/*Begin Singleton*/
	private Archivo(String archivo_salida, String historia){
		try {
			this.outputStream = new PrintWriter(new FileWriter(archivo_salida));
			this.outputStreamHistoria = new PrintWriter(new FileWriter(historia));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Archivo getSingleton(String salida, String historia){
		if(file_singleton == null){
			file_singleton = new Archivo(salida, historia);
		}
		return file_singleton;
	}
	/*End Singleton*/
	
	public void escribirPalindromos(String pal){
		outputStream.write(pal+"\n");
	}
	
	public void escribirHistoria(String pal){
		outputStreamHistoria.write(pal+"\n");
	}
	
	public void closeBufferedStream(){
		if(outputStream != null){
			outputStream.close();
		}
		if(outputStreamHistoria != null){
			outputStreamHistoria.close();
		}
	}
}
