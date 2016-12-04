package automata.ing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MainIng {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ArchivosIng escritor_historia=new ArchivosIng();
        PrintWriter archivo_historia;
        ArrayList<String> historia_automata;
        boolean manual_resultado;
        int modo;
        int continuar;
        int indice_palabra_manual = 0;
        Scanner sc = new Scanner(System.in);
        String manual;
        String historia_palabra="";
        archivo_historia=escritor_historia.crear_escritor("historia_ing.txt");
        ArchivosIng archivo_lectura = new ArchivosIng("archivos/dony.txt",archivo_historia);
        do{
            System.out.println("Automata -ing");
            System.out.println("Manual: 1, Automatico: 2 ");
            System.out.println("Elige:");
            modo = sc.nextInt();
            if(modo>1){
                archivo_lectura.leer_archivo();
            }else{
                AutomataIng automata_ending = new AutomataIng();
                String [] palabras;
                int seguir;
                //Manual
                do{
                    manual = JOptionPane.showInputDialog(null, "Cadena:");
                    manual+=" ";
                    archivo_lectura.index++;
                    palabras = manual.split(" ");
                    for(String ind_palabra : palabras){
                        indice_palabra_manual++;
                        manual_resultado = automata_ending.automataAnalisis(ind_palabra+" ");
                        historia_automata = automata_ending.historia;
                        for(String estado_historia:historia_automata){
                            historia_palabra += estado_historia;
                        }
                        escritor_historia.setElemento_escrito(historia_palabra);
                        historia_palabra="";
                        historia_automata.clear();
                        if(manual_resultado==true){
                            archivo_lectura.escribir_resultado("["+archivo_lectura.index+"]"+ind_palabra + ",linea: "+1+", numero palabra: "+indice_palabra_manual+" Modo manual");
                        }     
                    }
                    System.out.println("Otra palabra? 1-Si 0-No");
                    seguir = sc.nextInt();
                }while(seguir > 0);
            }
            System.out.println("Deseas continuar: 1-Si 0-No ");
            continuar = sc.nextInt();
        }while(continuar > 0); 
        escritor_historia.guardar_archivo();
        archivo_lectura.guardarOutput();
        System.out.println("Adios!");
    }   
    
}