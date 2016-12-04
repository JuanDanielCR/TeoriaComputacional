package sources;

public class Tree <T>{
	protected Node<T> root = null;
	private StringBuilder combinacion;
	private Archivo output;
	public int tree_size;
	
	//Constructors
	public Tree(Archivo a){
		root = null;
		tree_size = 0;
		output = a;
		combinacion = new StringBuilder();
	}
	
	//Accesors for Tree
	public Node<T> getRoot() { return root;	}
	public int getSize() { return tree_size; }
	
	//Creating tree root
	public void addRoot(Node<T> root) throws IllegalStateException {
		if (root == null){
			this.root = root;
		}
		tree_size++;
	}
	
	//Travelling the three from the leaf to the root, PRE ORDER
	public void travelTree(Node<T> node){
		combinacion.append(node.getContent());
		if(!(node.getChilds().isEmpty())){
			for(int i=0; i<node.getChilds().size();i++){
				travelTree(node.getChilds().get(i));
				if(node.getLevel()+1==tree_size){
					//Guardar combinacion
					output.escribirHistoria(combinacion);
					if((combinacion.charAt(combinacion.length()-1)) == '9'){
						output.escribirSalida(combinacion);
					}
				}
				combinacion.deleteCharAt(combinacion.length()-1);
			}
		}
	}
}
