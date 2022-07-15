package queue;

import linklist.Node;

abstract class Queue<T>{
	
	abstract Node<T> getHead();
	
	abstract Node<T> getRear();
	
	abstract boolean empty();
	
	abstract boolean clear();
	
	abstract boolean offer(T value);
	
	abstract T peek();
	
	abstract boolean remove();
	
	
	
	
}
