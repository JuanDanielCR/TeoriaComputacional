package teoriaprimos;

public class CodigoASCII {
    private String cadena_entrada;
    private int cadena_ascii;

    public void setCadena_entrada(String cadena_entrada) {
        this.cadena_entrada = cadena_entrada;
    }

    public int getCadena_ascii() {
        cadena_ascii = 0;
        char caracter;
        for(int i = 0; i<cadena_entrada.length();i++){
            caracter = cadena_entrada.charAt(i);
            cadena_ascii = cadena_ascii + (int)caracter;
        }
        return cadena_ascii;
    }
}
