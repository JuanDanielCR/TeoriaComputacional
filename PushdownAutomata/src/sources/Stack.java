package sources;

public interface Stack<E> {
	/**
	 * Return the number of elements on the stack
	 * */
	int size();
	/**
	 * Tests if the stack is empty
	 * */
	boolean isEmpty();
	/**
	 * Inserts an element at the top of the stack
	 * */
	void push(E e);
	/**
	 * Returns but doesn't remove the top element
	 * */
	E top();
	/**
	 * Returns and remove the last element
	 * */
	E pop();
}
