package sources;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Archivo {
	
	private static Archivo file_singleton = null;
	private PrintWriter outputStream;
	
	/*Begin Singleton*/
	private Archivo(String historia){
		try {
			this.outputStream = new PrintWriter(new FileWriter(historia));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Archivo getSingleton(String historia){
		if(file_singleton == null){
			file_singleton = new Archivo(historia);
		}
		return file_singleton;
	}
	/*End Singleton*/
	
	public void escribirDerivacion(String derivate){
		outputStream.write(derivate);
		outputStream.write("\n");
	}
	
	public void closeBufferedStream(){
		if(outputStream != null){
			outputStream.close();
		}
	}
}
