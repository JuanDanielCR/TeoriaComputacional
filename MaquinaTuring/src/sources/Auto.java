package sources;

import java.util.Random;

public class Auto {
	
	private Archivo archivo;
	private String estado;
	private Random rdn;
	private int longitud;
	private MaquinaTuring machine;
	
	public Auto(Archivo a){
		rdn = new Random();
		longitud = 0;
		machine =  new MaquinaTuring(a);
		archivo = a;
	}
	
	public void runMachine(){
		longitud = rdn.nextInt(1000-1)+1;
		System.out.println("Longitud: "+longitud);
		for(int i = 0; i < longitud; i++){
			if(rdn.nextInt(2) == 1){
				machine.llenarCinta('1');
			}else{
				machine.llenarCinta('0');
			}
		}
		machine.iniciarCinta();
		estado = machine.getEstado();
		//Execute transitions
		while(estado !="q5" && estado!="N"){
			estado = machine.transition(machine.getInput());
			System.out.println(estado);
			archivo.escribirHistoria(estado);
			if(estado == "N"){
				System.out.println("Formato invalido");
			}
		}
		archivo.escribirHistoria("\n");
		//final tape
		machine.mostrarCinta();
	}
}
