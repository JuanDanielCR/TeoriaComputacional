package sources;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Archivo {
	
	private PrintWriter outputStream, historiaStream;
	
	public Archivo(String archivo_salida, String archivo_historia){
		try {
			this.outputStream = new PrintWriter(new FileWriter(archivo_salida));
			this.historiaStream = new PrintWriter(new FileWriter(archivo_historia));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribirHistoria(StringBuilder combinacion){
		historiaStream.write(combinacion+"\n");
	}
	
	public void escribirSalida(StringBuilder combinacion){
		outputStream.write(combinacion+"\n");
	}
	
	public void closeBufferedStream(){
		if(outputStream != null){
			outputStream.close();
		}
		if(historiaStream != null){
			historiaStream.close();
		}
	}
}
