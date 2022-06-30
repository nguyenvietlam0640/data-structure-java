package linklist;


public class Node<T>{
	private T value;
	private Node<T> nextPoint;
	
	public Node (T value,Node<T> nextPoint){
		this.setValue(value);
		this.setNextPoint(nextPoint);
	}
	
	protected void setValue(T value) {
		this.value = value;
	}
	
	protected void setNextPoint(Node<T> node) {
		this.nextPoint = node;	
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Node<T> getNextPoint() {
		return this.nextPoint;
	}
	
}

