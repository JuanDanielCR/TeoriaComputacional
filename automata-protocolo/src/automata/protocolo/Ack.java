package automata.protocolo;
import java.util.ArrayList;

public class Ack {
    public ArrayList<String> historia = new ArrayList<>();
    private int q;
    public boolean calcularParidad(String cadena){
        q=0;
        historia.clear();
        for(int i=0; i < cadena.length(); i++){
            switch(cadena.charAt(i)){
                case '0':
                    if(q==0){
                        q=1;
                    }else if(q==1){
                        q=0;
                    }else if(q==2){
                        q=3;
                    }else if(q==3){
                        q=2;
                    }
                break;
                case '1':
                    if(q==0){
                        q=2;
                    }else if(q==2){
                        q=0;
                    }else if(q==1){
                        q=3;
                    }else if(q==3){
                        q=1;
                    }
                break;
                default:
                    q=4;
                    System.out.println("Simbolo no válido");
                break;
            }
            if(q==0){
                historia.add("q0");
            }else if(q==1){
                historia.add("q1");
            }else if(q==2){
                historia.add("q2");
            }else if(q==3){
                historia.add("q3");
            }else if(q==4){
                historia.add("X");
            }  
        }
        //if not redundant
        return q==0;
    }
}