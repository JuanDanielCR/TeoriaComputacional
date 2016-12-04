package sources;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Archivo {
	
	private static Archivo file_singleton = null;
	private PrintWriter outputStream;
	private PrintWriter outputStreamHistoria;
	
	/*Begin Singleton*/
	private Archivo(String historia, String archivo_salida){
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
	
	public void escribirSuma(String pal){
		outputStreamHistoria.write(pal);
		outputStreamHistoria.write("\n");
	}
	
	public void escribirHistoria(String stack){
		outputStream.write(stack);
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
