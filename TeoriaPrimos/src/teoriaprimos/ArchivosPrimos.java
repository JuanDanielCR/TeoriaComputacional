package teoriaprimos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ArchivosPrimos{
    private PrintWriter escritor;
    private BufferedReader buffer_lectura;
    private InputStreamReader lector;
    private FileInputStream utf;
    private String elemento_escrito;
    private String elemento_leido;
    private ArrayList lineas_leidas;
    
    public void crear_escritor(String archivo_escritura){
        try {
            escritor = new PrintWriter(archivo_escritura);
        } catch (Exception e) {
            System.out.println("Error en el rescritor");
        }
    }
    public int crear_lector(String archivo_lectura){
        try {
            utf = new FileInputStream(archivo_lectura);
            lector = new InputStreamReader(utf,"UTF-8");
            buffer_lectura = new BufferedReader(lector);
            return 1;
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error en creacion"+e.toString());
            return 0;
        }
    }
    
    public void setElemento_escrito(String elemento_guardado) {
        this.elemento_escrito = elemento_guardado;
        guardar_elemento(false);
    }
    
    public void setElemento_escrito(String escuela, String ascii, String primo){
        this.elemento_escrito = escuela;
        for(int i = escuela.length(); i<100;i++){
            this.elemento_escrito+=" ";
        }
        this.elemento_escrito += ascii;
        for(int j = 0; j<7;j++){
            this.elemento_escrito+=" ";
        }
        this.elemento_escrito += primo;
        guardar_elemento();
    }

    public ArrayList getLineas_leidas() {
        return lineas_leidas;
    }
    
    public void leer_elementos(){
        lineas_leidas= new ArrayList();
        try {
            while((elemento_leido=buffer_lectura.readLine())!=null){
                //Deleting begin of file ascii
                if (elemento_leido.charAt(0) == '\uFEFF')
                    {
                        elemento_leido = elemento_leido.substring(1);
                    }
               lineas_leidas.add(elemento_leido);
            }
            buffer_lectura.close();
        } catch (Exception e) {
            System.out.println("Error en lectura: "+ e.toString());
        }
    }
    
    private void guardar_elemento(){
        try{
            escritor.write(elemento_escrito+"");
            escritor.write(System.getProperty("line.separator"));
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
        private void guardar_elemento(boolean enter){
        try{
            escritor.write(elemento_escrito+"");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
        
    public void guardar_archivo(){
        escritor.close();
    }
}