package stack;
import linklist.Node;
public class StackImpl<T> extends Stack<T> {
	private Node<T> head = null;
	private Node<T> rear = null;

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return this.head == null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		try {
			return this.head.getValue();	
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public T pop() {
		if (this.head!=null){
			T top = this.head.getValue();
			this.head = this.head.getNextPoint();
			
			if (this.head ==null) {
				this.rear = null;
			}
			return top ;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean push(T value) {
		// TODO Auto-generated method stub
		try {
			if (this.rear == null) {
				Node<T> node = new Node<T>(value,null);
				this.head = node;
				this.rear = this.head;
			}
			else {
				Node<T> node = new Node<T>(value,this.head);
				this.head = node;
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public int search(T value) {
		// TODO Auto-generated method stub
		if (this.head == null) {
			return -1;
		}
		else {
			int index= 0;
			Node<T> currentNode = this.head;
			while(index>=0) {
				if (value == currentNode.getValue()) {
					break;
				}
				else {
					currentNode = currentNode.getNextPoint();
					index++;
					if (currentNode == null) {
						return -1;
					}
				}
			}
		return index;
		}
	}

	@Override
	protected Node<T> getHead() {
		// TODO Auto-generated method stub
			return this.head;
	}

	@Override
	protected Node<T> getRear() {
		// TODO Auto-generated method stub
		return this.rear;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head = null;
		this.rear = null;
	}
	
}