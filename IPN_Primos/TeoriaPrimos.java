package teoriaprimos;

import java.util.ArrayList;

public class TeoriaPrimos {
    public static void main(String[] args) {
        //Variables
        //Valor ASCII de una escuela
        int suma_ascii;
        //Valor booleano para indicar si es primo o no
        boolean primo;
        //Cadena que almacena el equivalente binario de una cadena
        String binarios;
        //Cadena booleana
        String es_primo = "No primo";
        ArrayList<String> escuelas;
        ArrayList<String> escuelas_primas;
        escuelas_primas = new ArrayList<>();
        
        //Instancias
        ArchivosPrimos archivos = new ArchivosPrimos();
        Binario binario = new Binario();
        CodigoASCII codigos = new CodigoASCII();
        NumerosPrimos numeros= new NumerosPrimos();
        
        System.out.println("Este programa corre en modo automático");
        
        //Abriendo el archivo de lectura
        archivos.crear_lector("archivos/escuelas.txt");
        System.out.println("Leyendo la ruta relativa  archivos/escuelas.txt");
        //Leyendo escuelas
        archivos.leer_elementos();
        //Guardando las escuelas y cerrando bufferedReader
        escuelas = archivos.getLineas_leidas();
        //Creando Writter para crear el archivo de salida
        archivos.crear_escritor("escuelas_primas.txt");
        //Creando la cabecera del archivo de salida
        archivos.setElemento_escrito("Escuelas del Instituto Politécnico Nacional "
                + "                                                        ASCII      Primo");
        for (String escuela : escuelas) {
            //Enviando escuela para obtener ASCII
            codigos.setCadena_entrada(escuela);
            //Recibiendo el valor de la suma en ASCII
            suma_ascii = codigos.getCadena_ascii();
            //Enviando la cadena ascci para evaluar si es primo o no
            numeros.setCadena_calculo(suma_ascii);
            //Recibiendo true / false para primo
            primo=numeros.is_primo();
            if(primo == true){
                //Enviando la cadena original para obtener el binario de un primo
                binario.setCadena_entrada(escuela);
                //Recibiendo un String con el binario de la cadena
                binarios = binario.getBinario();
                //Guardando los binarios para imprimir al final
                escuelas_primas.add(binarios);
                es_primo = "Primo";
            }
            //Enviando la cadena para crear el archivo
            archivos.setElemento_escrito(escuela, Integer.toString(suma_ascii), es_primo);
            es_primo = "No Primo";
        }
        //Guardando lo binarios que sean primos
        archivos.setElemento_escrito("Binarios primos:\n");
        for(String escuela_primaria : escuelas_primas){
            archivos.setElemento_escrito("{"+ escuela_primaria+"}\n");
        }
        //Guardando el archivo
        archivos.guardar_archivo();
        System.out.println("Resultado guardado en escuelas_primas.txt \nAdios!");
    }
}
