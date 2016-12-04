package sources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedStreams {
	private BufferedReader inputStream = null;
	private PrintWriter outputStream = null;

	//BufferedWriter outputStream = null;
	int c;
	public BufferedStreams(String input, String output){
		try{
			this.c =0;
			inputStream = new BufferedReader(new FileReader(input));
			outputStream = new PrintWriter(new FileWriter(output));
			//outputStream = new BufferedWriter(new FileWriter(output));		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyBufferedChars(){
		try{
			while((c = inputStream.read())!=-1){
				outputStream.write(c);
				outputStream.flush();
			}
		}catch(IOException e ){
			e.printStackTrace();
		}
	}
	
	public void closeBufferedStream(){
		try{
			if(inputStream != null){
				inputStream.close();
			}
			if(outputStream != null){
				outputStream.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
