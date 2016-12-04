package sources;

import java.util.ArrayList;

public class Combinaciones {
	private Tree<Integer> tree; 
	private Node<Integer> root;
	private Node<Integer> parent = null;
	private Node<Integer> child = null;
	private int aux_size;
	public char input;
	ArrayList<Integer> estados = new ArrayList<Integer>();
	int estado;
	
	public Combinaciones(Archivo a){
		tree = new Tree<>(a);
		root = new Node<Integer>(1,tree);
		tree.addRoot(root);
		this.estado = 1;
	}
	
	public int ejecutar(){
		aux_size = tree.tree_size;
		travelTree(root);
		return estado;
	}
	public void mostrar(){
		tree.travelTree(root);
	}
	
	public void travelTree(Node<Integer> node){
		if(node.getLevel() == aux_size){
			parent = node;
			transitions();
		}
		if(!(node.getChilds().isEmpty())){
			for(int i=0; i<node.getChilds().size();i++){
				travelTree(node.getChilds().get(i));
			}
		}
	}
	
	public void transitions(){
		estado = parent.getContent();
		switch(input){
			case 'n':
				if(estado == 1 || estado == 3 || estado == 7 || estado == 9){
					estados.add(5);
					llenarNuevosNodos();
				}else if(estado == 5){
					estados.add(1); estados.add(3);	estados.add(7); estados.add(9);
					llenarNuevosNodos();
				}else if(estado == 2){
					estados.add(1);	estados.add(3);	estados.add(5);
					llenarNuevosNodos();
				}else if(estado == 4){
					estados.add(1);	estados.add(5);	estados.add(7);
					llenarNuevosNodos();
				}else if(estado == 6){
					estados.add(3);	estados.add(5);	estados.add(9);
					llenarNuevosNodos();
				}else if(estado == 8){
					estados.add(7);	estados.add(7);	estados.add(9);
					llenarNuevosNodos();
				}
				estados.clear();
			break;
			case 'b':
				if(estado == 1){
					estados.add(2);	estados.add(4);
					llenarNuevosNodos();
				}else if(estado == 2 || estado == 8){
					estados.add(4);	estados.add(6);
					llenarNuevosNodos();
				}else if(estado == 3){
					estados.add(2);	estados.add(6);
					llenarNuevosNodos();
				}else if(estado == 4 || estado == 6){
					estados.add(2);	estados.add(8);
					llenarNuevosNodos();
				}else if(estado == 5){
					estados.add(2);	estados.add(4);	estados.add(6); estados.add(8);
					llenarNuevosNodos();
				}else if(estado == 7){
					estados.add(4);	estados.add(8);
					llenarNuevosNodos();
				}else if(estado == 9){
					estados.add(6);	estados.add(8);
					llenarNuevosNodos();
				}
				estados.clear();
			break;
			default:
				estado = -1;
			return;
		}
	}
	
	public void llenarNuevosNodos(){
		for(int i = 0; i<estados.size(); i++){
			child = new Node<Integer>(estados.get(i), tree);
			parent.addChild(child);
		}
	}
}
