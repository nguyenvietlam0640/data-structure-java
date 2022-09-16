package stack;

import linklist.Node;

public abstract class Stack<T> {
	
	public abstract boolean empty();
	
	public abstract T peek();
	
	public abstract T pop();
	
	public abstract boolean push(T value);
	
	public abstract int search(T value);
	
	protected abstract Node<T> getHead();
	
	protected abstract Node<T> getRear();
	
	public abstract void clear();
}
