package teoriaprimos;
public class Binario {
    private String cadena_entrada;
    private String binario="";

    public void setCadena_entrada(String cadena_entrada) {
        this.cadena_entrada = cadena_entrada;
    }

    public String getBinario() { 
        //Saving the sequence of bytes into and array
        byte[] bytes = cadena_entrada.getBytes();
        //String for adding the binary equivalent
        StringBuilder binary = new StringBuilder();
        //For each byte in our array add its elements to th string
        for (byte b : bytes){
           //Saves our actual byte 
           byte indivual_byte = b;
           //iterando hasta el maximo valor de corrimientos aceptados por un byte
           for (int i = 0; i < 8; i++){
             //operador logico AND (&) entre el tamaño maximo de un tipo de dato
             //byte 2^7 == 128 y nuestro byte actual,
                if((indivual_byte & 128) == 0){
                    //Si el AND da cero agregamos un cero a la cadena
                    binary.append(0); 
                }else{ 
                    //Si el AND da uno agregamos un uno a la cadena
                    binary.append(1);
                }
                //Corrimiento de dos bits a la izquuierda
                indivual_byte = (byte) (indivual_byte << 1);
           }
        }
        binario =  binary.toString();
        return binario;
    }
}
