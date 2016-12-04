package sources;

/**
 * Transitions rules:
 * δ(q,{,Zo) = {(q,XZo)}
 * δ(q,{,X) = {(q,XX)}  this two rules allows a push
 * 
 * δ(q,},X) = {(p, E)} change q to p (change the state)
 * δ(p,},X) = {(p, E)} pop
 * δ(p,E,Zo) => Accept = a
 * */
public class PushdownAutomata {
	private Archivo archivo;
	private char input_character;
	private char estado;
	private LinkedStack<Character> stack = new LinkedStack<>();
	
	public PushdownAutomata(Archivo output){
		archivo = output;
		estado = 'q';
		stack.push('Z');
		archivo.escribirPila(stack.print());
	}
	public void setCharacter(char c){
		input_character = c;
	}
	public char getEstado(){
		return estado;
	}
	public char transition(){//δ(q,w,a) - q: comes from the states, w, comes from setCharacter, a comes from stack.pop()
		switch(input_character){
			case '{':
				if(estado == 'q' && (stack.top()=='Z' || stack.top()=='X')){
					stack.push('X');
					archivo.escribirHistoria(estado);
					archivo.escribirPila(stack.print());
				}else if(estado == 'p'){
					estado = 'N';
					archivo.escribirHistoria(estado);
				}
			break;
			case '}':
				if(estado == 'q'&& stack.top()=='X' ){
					estado = 'p';
					stack.pop();
					archivo.escribirHistoria(estado);
					archivo.escribirPila(stack.print());
				}else if(estado == 'p' && stack.top()=='X'){
					stack.pop();
					archivo.escribirPila(stack.print());
					archivo.escribirHistoria(estado);
				}else{//case of an empty stack
					estado = 'N';
					archivo.escribirHistoria(estado);
				}
			break;
			case '#':
				if(estado == 'p' && stack.pop()=='Z'){
					estado ='a';
					archivo.escribirHistoria(estado);
				}else{
					estado = 'N';
					archivo.escribirHistoria(estado);
				}
			break;
			default: 
				estado = 'N';
				archivo.escribirHistoria(estado);
				archivo.escribirPila(stack.print());
			break;
		}
		return estado;
	} 
}
