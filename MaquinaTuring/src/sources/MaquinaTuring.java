package sources;

public class MaquinaTuring {
	private Archivo archivo;
	private DoublyLinkedList<Character> cinta;
	private String estado = "q0";
	
	public MaquinaTuring(Archivo a){
		archivo =  a;
		cinta =  new DoublyLinkedList<>();
	}
	public void llenarCinta(char elemento){
		cinta.addLast(elemento);
	}
	public String getEstado(){
		return estado;
	}
	public char getInput(){
		if(cinta.getActual()!=null)
			return cinta.getActual();
		return 'X';
	}
	public String transition(char input){
		switch(input){
			case '0':
				if(estado == "q0"){
					estado = "q1"; cinta.updateActual('0'); cinta.setActual('R'); 
				}else if(estado == "q1"){
					estado = "q2"; cinta.updateActual('0');	cinta.setActual('R');
				}else if(estado == "q2"){
					estado = "q5"; cinta.updateActual('0'); cinta.setActual('R');
					imprimirCinta();
				}else if(estado == "q3"){
					estado = "q4"; cinta.updateActual('1'); cinta.setActual('R');
				}else if(estado == "q4"){
					estado = "q2"; cinta.updateActual('0'); cinta.setActual('R');					
				}
			break;
			case '1':
				if(estado == "q0"){
					estado = "N"; 
				}else if(estado == "q1"){
					estado = "q1"; cinta.updateActual('1'); cinta.setActual('R'); 
				}else if(estado == "q2"){
					estado = "q3"; cinta.updateActual('0'); cinta.setActual('L');
				}else if(estado == "q3"){
					estado = "N";
				}else if(estado == "q4"){
					estado = "q1"; cinta.updateActual('0'); cinta.setActual('L');
				}
			break;
			default:
				estado = "N";
				System.out.println("¿Qué intentas hacer? Repite tu cadena");
			break;
		}
		return estado;
	}
	public void mostrarCinta(){
		System.out.println(cinta.showElements());
	}
	public void iniciarCinta(){
		cinta.setActual('0');
	}
	public char cintaNext(){
		return cinta.getNext();
	}
	public void imprimirCinta(){
		archivo.escribirSuma(cinta.showElements());
	}
}
