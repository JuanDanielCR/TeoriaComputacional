package automata.ing;

import java.util.ArrayList;

public class AutomataIng {
    public ArrayList<String> historia = new ArrayList<>();
    //Automata
    public boolean automataAnalisis(String palabra){
        int q=0;
        historia.clear();
        for(int i=0; i < palabra.length(); i++){
            switch(palabra.charAt(i)){
                case 'i':
                    q=1;
                break;
                case 'n':
                    if(q==1){ q=2;}else{q=0;}
                break;
                case 'g':
                    if(q==2){ q=3; }else{ q=0;}
                break;
                case ' ':
                    if(q==3){ q=4;}
                break;
                case '.':
                    if(q==3){ q=4;}
                break;
                case ',':
                    if(q==3){ q=4;}
                break;
                case '?':
                    if(q==3){ q=4;}
                break;
                default:
                    q = 0;
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
                historia.add("q4");
            }       
        }
        return q == 4;
    }
}