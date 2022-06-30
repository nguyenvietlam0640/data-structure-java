package linklist;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LInkListTests {
	LinkList<Integer> llist = new LinkListImpl<Integer>();
	Node<Integer>  node;
	@Before
	public void setUp() {
		llist.clear();
	}
	@Test
	public void clearTest() {
		llist.addFirst(6);
		assertEquals(1, llist.size());
		llist.clear();
		assertNull(llist.getHead());
		assertNull(llist.getTail());
		assertTrue(llist.isEmpty());
	}
	@Test
	public void isEmptyTest() {
		assertTrue(llist.isEmpty());
		llist.addFirst(6);
		assertFalse(llist.isEmpty());		
	}
	@Test
	public void sizeTest() {
		assertEquals(0,llist.size());
		assertTrue(llist.addFirst(2));
		assertTrue(llist.addFirst(3));
		assertEquals(2,llist.size());	
	}
	
	@Test
	public void TestAddFirst() {
		assertTrue(llist.addFirst(6));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(6));
		assertEquals(llist.getHead(),llist.getTail());
		assertTrue(llist.addFirst(7));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(7));
		assertEquals(llist.getHead().getNextPoint(),llist.getTail());
	}
	@Test
	public void testAddLast() {
		assertTrue(llist.addLast(6));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(6));
		assertEquals(llist.getHead(),llist.getTail());
		assertTrue(llist.addLast(7));
		assertEquals(llist.getHead().getNextPoint(),llist.getTail());
		assertNull(llist.getTail().getNextPoint());
	}
	
	@Test
	public void testAdd() {
		assertFalse(llist.add(2,5));
		
		assertTrue(llist.add(0,5));
		assertEquals(llist.getHead(),llist.getTail());
		
		assertTrue(llist.addLast(7));
		node = llist.getHead();
		assertTrue(llist.add(1,6));
		assertEquals(node.getNextPoint().getValue(),Integer.valueOf(6));
		
		node = llist.getHead();
		assertTrue(llist.add(0,3));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(3));
		assertEquals(llist.getHead().getNextPoint(),node);
		
		assertTrue(llist.add(1,4));
		assertEquals(llist.getHead().getNextPoint().getValue(),
					 Integer.valueOf(4));
		assertEquals(llist.getHead().getNextPoint().getNextPoint(),node);
		
		

	}
	@Test 
	public void testRemoveFirst() {
		assertFalse(llist.removeFirst());
		
		assertTrue(llist.addFirst(1));
		assertTrue(llist.addFirst(2));
		assertTrue(llist.removeFirst());
		assertEquals(llist.getHead(),llist.getTail());
		
		assertTrue(llist.removeFirst());
		assertNull(llist.getHead());
		assertNull(llist.getTail());
	}
	@Test
	public void testRemoveLast() {
		assertFalse(llist.removeLast());
		
		assertTrue(llist.addLast(1));
		assertTrue(llist.addLast(2));
		assertTrue(llist.addLast(2));
		assertTrue(llist.removeLast());
		assertEquals(llist.getHead().getNextPoint(),llist.getTail());
		
		assertTrue(llist.removeLast());
		assertTrue(llist.removeLast());
		assertNull(llist.getHead());
		assertNull(llist.getTail());
	}
	@Test
	public void  testRemove() {
		assertFalse(llist.remove(2));
		
		assertTrue(llist.addFirst(1));
		assertTrue(llist.remove(0));
		assertNull(llist.getHead());
		assertNull(llist.getTail());
		
		assertTrue(llist.addLast(5));
		assertTrue(llist.addLast(6));
		assertTrue(llist.remove(1));
		assertNull(llist.getHead().getNextPoint());
		assertEquals(llist.getHead(),llist.getTail());
		
		node = llist.getHead();
		assertTrue(llist.addFirst(4));
		assertTrue(llist.remove(0));
		assertEquals(llist.getHead(),node);
		
		assertTrue(llist.addFirst(4));
		
		assertTrue(llist.remove(1));
		assertEquals(llist.getHead(),llist.getTail());
		assertTrue(llist.remove(0));
		assertFalse(llist.remove(0));
		assertFalse(llist.remove(3));
	}
	@Test
	public void testAddFirstWithArray() {
		Integer[] list = {4,3,2,1}; 
		
		assertTrue(llist.addFirst(list));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(4));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(1));
		assertNull(llist.getTail().getNextPoint());
		
		Integer[] newList = {6,5};
		assertTrue(llist.addFirst(newList));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(6));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(1));
		assertEquals(llist.getHead().getNextPoint().getNextPoint().getValue(),
					 Integer.valueOf(4));
		
	}
	@Test
	public void testAddLastWithArray() {
		Integer[] list = {5,4,3}; 
		
		assertTrue(llist.addLast(list));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(5));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(3));
		assertNull(llist.getTail().getNextPoint());
		
		Integer[] newList = {2,1};
		assertTrue(llist.addLast(newList));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(5));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(1));
		assertEquals(llist.getHead().getNextPoint().getNextPoint().getNextPoint().getValue(),
					 Integer.valueOf(2));
	}
	@Test
	public void testAddArray() {
		Integer[] List = {};
		assertFalse(llist.add(0, List));
		
		Integer[] list = {6,3,2}; 
		assertTrue(llist.add(0,list));
		assertEquals(llist.getHead().getValue(),Integer.valueOf(6));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(2));
		
		Integer[] newList = {5,4};
		assertTrue(llist.add(1, newList));
		assertEquals(llist.getHead().getNextPoint().getValue(),Integer.valueOf(5));
		
		Integer[] nL = {1,0};
		assertFalse(llist.add(5, nL));
		assertTrue(llist.add(4, nL));
		assertEquals(llist.getTail().getValue(),Integer.valueOf(2));
		assertEquals(7,llist.size());
	}
		
	
}
