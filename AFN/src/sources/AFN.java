package sources;

import java.util.ArrayList;

public class AFN {
	public boolean valido = false;
	private Archivo archivo;
	private ArrayList<ArrayList<String>> matriz =  new ArrayList<>();
	private String estado = "q0";
	private char input;
	private ArrayList<String> inicial =  new ArrayList<>();
	
	public AFN(Archivo a){
		archivo = a;
		estado = "q0";
		matriz =  new ArrayList<>();
		inicial.add(estado);
		matriz.add(inicial);		
	}
	public char getInput(){
		return input;
	}
	public void setInput(char a){
		input = a;
	}

	public void transitions(char input){
		int original = matriz.size();
		switch(input){
			case '0':
				archivo.escribirCadena("0");
				//bucle para aumentar dos estados q0, q1 a cada estado anterior
				for(int i=0; i<original; i++){
					//ends in X -> ignore
					if((matriz.get(i).get((matriz.get(i).size()-1))!="X")){
						//ends in q1 -> put an X
						if(matriz.get(i).get((matriz.get(i).size()-1))=="q1"||matriz.get(i).get((matriz.get(i).size()-1))=="q2"){
							matriz.get(i).add("X");
						//end in q0 -> put q0 and q1
						}else{
							for(int j = 0; j<2;j++){
								//put q0 at first
								if(j==0){
									matriz.get(i).add("q0");
								}else{
								//copy an put q1, replacing the last q0
									ArrayList<String>copy = new ArrayList<String>(matriz.get(i));
									copy.set(copy.size()-1, "q1");
									matriz.add(copy);
								}
							}	
						}
					}
				}
			break;
			case '1':
				archivo.escribirCadena("1");
				for(int i=0; i<matriz.size(); i++){
					//ends in X -> ignore
					if((matriz.get(i).get((matriz.get(i).size()-1))!="X")){
						//end in q1 -> put q2
						if(matriz.get(i).get((matriz.get(i).size()-1))=="q1"){
							matriz.get(i).add("q2");
						//end in q0 -> put q0
						}else if(matriz.get(i).get((matriz.get(i).size()-1))=="q0"){
							matriz.get(i).add("q0");
						}else{
							matriz.get(i).add("X");
						}
					}
				}
			break;
			default:
				estado = "N";
				System.out.println("Tu cadena contiene algo raro: "+input);
			break;	
		}
	}
	public void printMatriz(){
		for(int i = 0; i<matriz.size();i++){
			for(int j=0; j< matriz.get(i).size(); j++){
				archivo.escribirHistoria(matriz.get(i).get(j));
				if(matriz.get(i).get(matriz.get(i).size()-1)=="q2"){
					valido = true;
				}
			}
			archivo.escribirHistoria("\n");
		}
		if(valido){
			archivo.escribirCadena(" La palabra es: valida" + "\n");
			System.out.println("La palabra es: valida");
		}else{
			archivo.escribirCadena(" La palabra es: invalida" + "\n");
			System.out.println("La palabra es: invalida");
		}
		archivo.escribirHistoria("------------------------------------------------------");
		archivo.escribirHistoria("\n");
	}
}
