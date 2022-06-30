package linklist;


abstract class LinkList<T> {
	
	abstract boolean isEmpty(); //inTest
	
	abstract int size();//inTest
	
	abstract boolean addFirst(T value);//inTest
	
	abstract boolean addLast(T value);//inTest
	
	abstract boolean add(int index, T value);//inTest
	
	abstract boolean addFirst(T[]  value);//inTest
	
	abstract boolean addLast(T[] value);//inTest
	
	abstract boolean add(int index,T[] value);//inTest
	
	abstract boolean removeFirst();//inTest
	
	abstract boolean removeLast();//inTest
	
	abstract boolean remove(int index);//inTest
	
	abstract boolean clear();//inTest

	abstract Node<T> getHead();//noTest
	
	abstract Node<T> getTail();//noTest
}
