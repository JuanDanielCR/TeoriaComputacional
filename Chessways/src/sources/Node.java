package sources;

import java.util.ArrayList;

/**Nested class Node*/
public class Node<T>{
	private Node<T> parent;
	private ArrayList<Node<T>> childs = new ArrayList<Node<T>>();
	private T content;
	private Tree<T> tree_owner;
	private int level;
	
	//Constructor
	public Node(T content, Tree<T> owner){
		this.parent = null;
		this.content = content;
		this.tree_owner = owner;
		this.level = 1;
	}
	
	//Accesors for node
	public ArrayList<Node<T>> getChilds() { return childs; }
	public T getContent() { return content; }
	public Node<T> getParent() { return parent;	}
	public int getLevel() { return level; }
	
	//Update methods
	public void setChilds(ArrayList<Node<T>> childs) { this.childs = childs;	}
	public void setContent(T content) { this.content = content;	}
	
	//Set a children TO a node
	public void addChild(Node<T> child){
		child.parent = this; //this, refers to the current object: parent.addChild();
		child.level = this.level+1;
		this.childs.add(child);
		tree_owner.tree_size = child.level;
	}
	
}//end of nested
