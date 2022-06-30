package linklist;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkListImpl<Integer> list= new LinkListImpl<Integer>();
		
		
		Integer[] list1 = {6,3,2}; 
		list.add(0,list1);
	
		
		Integer[] newList = {5,4};
		list.add(1, newList);
		
		Integer[] nL = {1,0};
		list.add(4, nL);
		Node<Integer> currentNode = list.getHead();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			
		
		System.out.println(currentNode.getValue());
		currentNode = currentNode.getNextPoint();}
		System.out.println(list.size());
	}

}
