package automata.ing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ArchivosIng {
    
    private String historia_palabra="";
    private ArrayList<String> historia_automata;
    private Charset encoding;
    private InputStream input;
    private Reader reader;
    private String palabra;
    private String elemento_escrito;
    private boolean automata_result;
    private int linea;
    private int indice_linea;
    public int index;
    private PrintWriter writer;
    private PrintWriter escritor;
    
    //Constructor modo automatico
    public ArchivosIng(String file, PrintWriter escriba) throws FileNotFoundException{
        //utf-8
        encoding = Charset.defaultCharset();
        input = new FileInputStream(file);
        reader = new InputStreamReader(input, encoding);
        writer = new PrintWriter("output.txt");
        palabra = "";
        indice_linea = 1;
        linea = 0;
        index =0;
        escritor =  escriba;
    }

    ArchivosIng() {
        index=0;
    }
    public void leer_archivo() throws FileNotFoundException, IOException{ 
        System.out.println("Leyendo archivos/dony.txt");
        AutomataIng automata_ending = new AutomataIng();
        int caracter_leido;
        while ((caracter_leido = reader.read()) != -1) {
            char caracter_final = (char) caracter_leido;
            if (caracter_leido == '\uFEFF'){
                    continue;
               }
            //Espacio blanco o salto de linea
            if(caracter_leido != 32 && caracter_leido != 13){
                palabra += caracter_final;
            }else{
                //Nueva linea
                if(caracter_leido == 13){
                    linea++;
                }
                indice_linea++;
                //Ejecutando el automata
                automata_result=automata_ending.automataAnalisis(palabra+' ');
                if(automata_result == true){
                    index++;
                    //Palabra intermedia
                    if(caracter_leido==32){
                        escribir_resultado("["+index+"]"+palabra+", linea: "+(linea+1)+", numero palabra: "+(indice_linea-palabra.length()));
                        //Palabra al final
                    }else{
                        escribir_resultado("["+index+"]"+palabra+", linea: "+(linea)+", numero palabra: "+(indice_linea));  
                    }
                }
                //Borrando la palabra
                palabra = "";
                //Guardando historia
                historia_automata = automata_ending.historia;
                for(String estado_historia:historia_automata){
                    historia_palabra += estado_historia;
                }
                setElemento_escrito(historia_palabra);
                historia_palabra="";
                historia_automata.clear();
            }                
        }
        //Last word in a file
        if(automata_result=automata_ending.automataAnalisis(palabra+' ')==true){
            index++;
            escribir_resultado("["+index+"]"+palabra+", linea: "+(linea)+", numero palabra: "+(indice_linea));
        }

        reader.close(); 
        System.out.println("Revisa el resultado en output.txt");
    }
    public void escribir_resultado(String palabra_escrita){
        writer.write(palabra_escrita+"");
        writer.write(System.getProperty("line.separator"));
    }
    public void guardarOutput(){
        escribir_resultado("Total palabras:"+Integer.toString(index));
        writer.close();
    }
    //Print History
     public PrintWriter crear_escritor(String archivo_escritura){
        try {
            return escritor = new PrintWriter(archivo_escritura);
        } catch (Exception e) {
            System.out.println("Error en el rescritor");
            return null;
        }
    }
    public void setElemento_escrito(String elemento_guardado) {
        this.elemento_escrito = elemento_guardado;
        guardar_elemento();
    }
        
    private void guardar_elemento(){
        try{
            escritor.write(elemento_escrito+"");
            escritor.write(System.getProperty("line.separator"));
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
        
    public void guardar_archivo(){
        escritor.close();
    }
}