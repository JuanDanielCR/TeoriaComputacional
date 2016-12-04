package sources;

public class DoublyLinkedList<E> {
	private Node<E> header;
	private Node<E> trailer;
	private Node<E> actual;
	private int size = 0;
	/**Constructor*/
	public DoublyLinkedList(){
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	/**Accesors*/
	public int getSize() {return size;}
	public boolean isEmpty(){return size==0;}
	public E getFirst(){
		if(isEmpty())return null;
		return header.getNext().getElement();
	}
	public E getLast(){
		if(isEmpty())return null;
		return trailer.getPrev().getElement();
	}
	public E getActual(){
		return actual.getElement();
	};
	public E getNext(){
		return actual.next.getElement();
	}
	/**Update methods*/
	public void addFirst(E e){
		addBetween(e,header,header.getNext());
	}
	public void addLast(E e){
		addBetween(e,trailer.getPrev(),trailer);
	}
	private void addBetween(E e, Node<E>predecessor, Node<E>sucessor){
		Node<E> newest = new Node<>(e,predecessor,sucessor);
		predecessor.setNext(newest);
		sucessor.setPrev(newest);
		size++;
	}
	public void updateActual(E transition){
		actual.element = transition;
	}
	public void setActual(char action){
		if(action == '0'){
			actual = header.next;
		}else if(action == 'L'){
			actual = actual.prev;
		}else if(action == 'R'){
			actual = actual.next;
		}
	}
	public String showElements(){
		String list = "";
		Node<E> aux = header.next;
		while(aux.next != null){
			list += aux.getElement();
			aux = aux.next;
		}
		return list;
	}
	/**Our node nested class*/
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e, Node<E> prev, Node<E> next){
			this.element = e;
			this.prev = prev;
			this.next = next;
		}
		public E getElement() {return element;}
		public Node<E> getPrev() {return prev;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> next) {this.next = next;}
		public void setPrev(Node<E> prev) {this.prev = prev;}
	}
}
