package sources;
/**
 * Implementing a stack with Java generics framework
 * */
public class LinkedStack<E> implements Stack<E> {
	private Node<E> head = null;
	@SuppressWarnings("unused")
	private Node<E> tail = null;
	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public E top() {
		if(isEmpty()) return null;
		return head.getElement();
	}
	@Override
	public void push(E e) {
		head =  new Node<E>(e, head);
		if(size == 0)
			tail =  head;
		size++;
	}
	@Override
	public E pop() {
		if(isEmpty()){
			return null;
		}
		E answer = head.getElement();
		head = head.next;
		size --;
		if(size == 0){
			tail = null;
		}
		return answer;
	}
	public String print(){
		String pila = "";
		Node<E> aux;
		aux = head;
		while(aux != null){
			pila += aux.getElement();
			aux = aux.getNext();
		}
		return pila;
	}
	
	/**Nested node*/
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next){
			this.element =  element;
			this.next =  next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
	}
}
