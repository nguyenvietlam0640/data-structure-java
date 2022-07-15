package queue;
import linklist.Node;
public class QueueImpl<T> extends Queue<T>{
	private Node<T> head = null;
	private Node<T> rear = null;
	@Override
	public boolean empty() { 
		return this.head == null;
	}

	@Override
	public boolean clear() {
		try{
			this.head = null;		
			this.rear = null;
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean offer(T value) {
		try{
			if(this.head ==null) {
				Node<T> node = new Node<T>(value,null);
				this.head = node;
				this.rear = node;
			}
			else {
				Node<T> node = new Node<T>(value,null);
				this.rear.setNextPoint(node);
				this.rear = node;
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public T peek() {
		try{
			return this.head.getValue();
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean remove() {
		try {
			this.head = this.head.getNextPoint();
			if(this.head == null) {
				this.rear = null;
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}	
	}

	@Override
	public Node<T> getHead() {
		return this.head;
	}

	@Override
	public Node<T> getRear() {
		return this.rear;
	}

}
