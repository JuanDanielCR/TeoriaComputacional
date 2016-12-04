package sources;

public class AnalisisAutomata {
	public char simbolo;
	private int estado;
	public int numero_palabras, numero_lineas, indice_linea, numero_correctas;
	public boolean isPalabra, isCorrect, isLinea;
	
	public AnalisisAutomata(){
		this.simbolo = ' ';
		this.estado = 0;
		this.numero_lineas = 0;
		this.numero_palabras = 0;
		this.numero_correctas = 0;
		this.isPalabra = false;
		this.isCorrect =  false;
	}
	
	public int analizarSimbolo(int simbolo_leido){
		isPalabra = false;
		isCorrect = false;
		isLinea = false;
		simbolo = (char)simbolo_leido;
		switch(simbolo){
			case 'w':
				if(estado == 0 || estado == 1 || estado == 12 ||estado == 15 || estado == 16 || estado == 17 || estado == 18 || estado == 135 || estado == 146){
					estado = 12;
				}else{
					estado = 0;
				}
			break;
			case 'e':
				if(estado == 0 || estado == 1 || estado == 15 || estado == 16 || estado == 17 || estado == 18 || estado == 135 || estado == 146){
					estado = 15;
				}else if(estado == 12){
					estado = 135;
				}else{
					estado =0;
				}
			break;
			case 'b':
				if(estado == 15){//e for ebay
					estado = 16;
				}else if(estado == 135){//e for web
					estado = 146;//final
					isCorrect = true;
					numero_correctas++;
				}else{
					estado = 0;
				}
			break;
			case 'a':
				if(estado == 16 || estado == 146){
					estado = 17;
				}else{
					estado = 0;
				}
			break;
			case 'y':
				if(estado == 17){
					estado = 18; //final
					isCorrect = true;
					numero_correctas++;
				}else{
					estado = 0;
				}
			break;
			case ' ':
				isPalabra = true;
				numero_palabras++;
				estado = 0;
			break;
			case '\n':
				isPalabra = true;
				isLinea = true;
				numero_lineas++;
				indice_linea = 0;
				estado = 0;
			break;
			default:
				estado = 0;
			break;
		}
		return estado;
	}
}
