package set;

public abstract class Set {
	public abstract boolean add (int value);
	
	public abstract void remove (int value);
	
	public abstract boolean contains (int value);
	
	public abstract boolean empty();
	
	public abstract void clear();
}
