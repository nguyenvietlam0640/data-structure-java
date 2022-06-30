package linklist;

//import static org.junit.Assert.assertTrue;

public class LinkListImpl<T> extends LinkList<T> {
	private Node<T> head = null;
	private Node<T> tail=null;
	
	private boolean indexInRange(int index) {
		if (index ==0 && this.isEmpty()==true) {
			return true;
		}
		else if (index<0 || index>=this.size()) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public Node<T> getHead() {
		return this.head;
	}
	
	@Override
	public Node<T> getTail() {
		return this.tail;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null && this.tail == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (this.isEmpty()==true) {
		}
		else{
			Node<T> currentNode = this.head; 
			while(currentNode!=null) {	
				currentNode = currentNode.getNextPoint();
				size++;
			}
		}
		return size;
	}

	@Override
	public boolean addFirst(T value) {
		try {
			if (this.isEmpty()==true) {
				Node<T> node = new Node<T>(value,null);
				this.head = node;
				this.tail = node;
			}
			else {
				Node<T> node = new Node<T>(value,this.head);
				this.head = node;
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean addLast(T value) {
		try {
			if (this.isEmpty()==true) {
				Node<T> node = new Node<T>(value,null);
				this.head = node;
				this.tail = node;
			}
			else {
				Node<T> node = new Node<T>(value,null);
				this.tail.setNextPoint(node);
				this.tail = node;	
			}
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean add(int index, T value) {
		try{
			if (this.indexInRange(index)==false) {
				return false;
			}
			else {
				if (index==0) {
					return this.addFirst(value);
				}
				else {
					int i = 1;
					Node<T> currentNode = this.head;
					while (i<index) {
						currentNode = currentNode.getNextPoint();
						i++;
					}
					Node<T> node = new Node<T>(value,currentNode.getNextPoint());
					currentNode.setNextPoint(node);
					
					return true;
				}
				
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean addFirst(T[] value) {
		try {
			if (value.length==0) {
				return false;
			}
			else {
				for(int index=value.length-1;index>=0;index--) {
					this.addFirst(value[index]);	
				}
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	boolean addLast(T[] value) {
		try {
			if (value.length==0) {
				return false;
			}
			else {
				for(int index=0;index<value.length;index++) {
					this.addLast(value[index]);	
				}
				return true;
			}		
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean add(int index,T[] value) {
		try{
			if (this.indexInRange(index)==false) {
				return false;
			}
			else if(value.length==0) {
				return false;
			}
			else {
				for(int i=value.length-1;i>=0;i--) {
					this.add(index,value[i]);
				}
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeFirst() {
		try {
			if (this.isEmpty()==true) {
				return false;
			}
			else{
				if (this.head ==this.tail) {
					this.clear();
				}
				else {
					this.head = this.head.getNextPoint();
				}
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeLast() {
		try {
			if (this.isEmpty()==true) {
				return false;
			}
			else{
				if (this.head ==this.tail) {
					this.clear();
				}
				else {
					Node<T> currentNode = this.head;
					while(currentNode.getNextPoint()!=this.tail) {
						currentNode = currentNode.getNextPoint();
					}
					this.tail= currentNode;
					this.tail.setNextPoint(null);
				}
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean remove(int index) {
		try{
			if (this.indexInRange(index)==false) {
				return false;
			}
			else {
				if (index==0) {
					if(this.isEmpty()!=true) {
						return this.removeFirst();
					}
					else {
						return false;
					}
				}
				else {
					int i = 1;
					Node<T> currentNode = this.head;
					while (i<index) {
						currentNode = currentNode.getNextPoint();
						i++;
					}
					Node<T> nextNode = (currentNode.getNextPoint().
										getNextPoint());
					if (currentNode.getNextPoint()==this.tail) {
						this.tail = currentNode;
					}
					currentNode.setNextPoint(nextNode);
					return true;
				}	
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean clear() {
		try {
			this.head = null;
			this.tail = null;
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
