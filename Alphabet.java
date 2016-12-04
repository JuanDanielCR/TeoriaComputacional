import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Alphabet{
  //using static because we will call them from static main()
  private static Scanner sc; //Object for input elements
  private static PrintWriter writer; //Object for writting on file
  private static int potencia_final; //Our final number of alpahbets for our universe
  private static int potencia; //Index for making each alphabet
  private static String[] simbolos;//Array which stores our symbols
  private static boolean is_automatico = false;// Manual/Automatic

  public static void main(String[] args) {
    try{
      int continua = 0;
      //Uisng 0,1 as our symbols for our universe
      simbolos = new String[]{"0","1"};
      sc = new Scanner(System.in);
      writer = new PrintWriter("combinatorics.txt", "UTF-8");
      do{
        is_automatico = seleccionarModo();
        if(is_automatico == false){
          ejecutarManual();
        }else{
          ejecutarAutomatico();
        }
        System.out.println("Su resultado fue guardado en combinatorics.txt ¿Desea continuar? 1: Si, 0: No");
        continua =  sc.nextInt();
      }while(continua==1);
    }catch (Exception e) {
      System.out.println("Error: "+e.toString());
    }
    writer.close();
    System.out.println("Adios!");
  }
  
/*MODO.- Use for selecting our executing mode*/
  private static boolean seleccionarModo(){
    int seleccion = 1;
    boolean modo=false;
    System.out.println("Manual: 1, Automatico: 2 ");
    System.out.println("Elige:");
    seleccion = sc.nextInt();
    if(seleccion == 1){
      modo = false;
      System.out.println("Manual Activado");
    }else if (seleccion == 2) {
      modo = true;
      System.out.println("Automatico Activado");
    }else{
      System.out.println("Manual Activado");
    }
    return modo;
  }
/*AUTOMATICO*/
  private static int ejecutarAutomatico(){
    double aleatorio = 0;
    do{
      //0 - represents automatic in function llenarUniverso()
      llenarUniverso(0);
      //0.0 < aleatorio < 1.0
      aleatorio = Math.random();
    }while(aleatorio < 0.5);
    System.out.println("Fin modo Automatico");
    return 1;
  }
/*MANUAL*/
  private static int ejecutarManual(){
    //1 - represents automatic in function llenarUniverso()
    llenarUniverso(1);
    return 0;
  }

/*UNIVERSO*/
  private static int llenarUniverso(int tipo){
    //manual mode
    if(tipo == 1){
      System.out.println("Elige la potencia final (1-1000): ");
      potencia_final = sc.nextInt();
    }else{
      //potencia aleatoria
      Random r = new Random();
      potencia_final = r.nextInt(1000-0)+0;
      System.out.println("Aleatorio potencia: " + potencia_final);
    }
    //adding empty conjunt symbol
    writer.print("{"+(char)216+"}"); 
    llenarSubconjunto();
    return 1;
  }

  private static int llenarSubconjunto(){
    //String for saving the combination
    StringBuilder combinacion = new StringBuilder("");
    //Selecting 
    int modo_calculo=0;
    System.out.println("Modo de calculo (0)-Recursiva, (1)-Binario: ");
    
    modo_calculo = sc.nextInt();
      if(modo_calculo==0){
        //creating each subconjunt in each iteration
        for(int i = 0; i < potencia_final; i++){
          //passing to the subconjunt
          int potencia_actual = i+1;
          crearCombinacionRecursiva(potencia_actual,combinacion);
        }
      }else{
        //sending maximum number of subcojunt in one time
        crearCombinacionBinario(potencia_final, combinacion);
      }
    return 1;
  }

//Binary mode for combinations only for a universe with [0,1]
  private static void crearCombinacionBinario(int potencia, StringBuilder combinacion){
    //Creating each subconjunt separated in each for iteration
    for(int potencia_actual = 1;potencia_actual<=potencia;potencia_actual++){
      //Creating combinations for actual combination
      for (int i = 0; i < Math.pow(2, potencia_actual); i++) {
        //Getting our combination using the binary of a number
        combinacion.insert(0, Integer.toBinaryString(i));
        //Filling with 0 the empty spaces created by the binary of out number
        for(int j = combinacion.length(); j < potencia_actual; j++) {
          combinacion.insert( 0, '0' );
        }
        guardarCombinacion(combinacion);
        //free our String Builder
        int largo_combinacion = combinacion.length();
        for(int k = 0; k < largo_combinacion; k++) {
            combinacion.deleteCharAt(0);
        }
      }
    }
  }

//Recursivity mode for combinations
  private static void crearCombinacionRecursiva(int ancho_combinatoria, StringBuilder salida) {
    //Saving on file the combinacion created when the width of the actual combination is reached
    if (ancho_combinatoria == 0) {
      guardarCombinacion(salida);
    } else {
      //Filling our combination with our valid symbols
      for (int i = 0; i < (simbolos.length); i++) {
        //add symbol to the String
        salida.append(simbolos[i]);
        //Recursivity for filling our combination until width is reached
        crearCombinacionRecursiva(ancho_combinatoria - 1, salida);
        //Filling first with 0 (simbolos[0]), when first recursion finish, erase last 0 an fill now with 1.
        salida.deleteCharAt(salida.length() - 1);
      }
    }
  }
//Function for saving combinations into a file
  private static int guardarCombinacion(StringBuilder combinacion_individual){
    writer.print(",{"+combinacion_individual +"}");
    return 1;
  }
}
