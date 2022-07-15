package queue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class QueueTests {
	Queue<Integer> queue = new QueueImpl<Integer>();
	
	@Before 
	public void setUp() {
		queue.clear();
	}
	@Test
	public void clearTest() {
		assertTrue(queue.empty());
		assertTrue(queue.offer(5));
		assertTrue(queue.offer(6));
		assertTrue(queue.clear());
		assertTrue(queue.empty());
		assertNull(queue.getHead());
		assertNull(queue.getRear());
		
	}
	@Test
	public void emptyTests() {
		assertTrue(queue.empty());
		assertTrue(queue.offer(5));
		assertTrue(queue.offer(6));
		assertFalse(queue.empty());
		
	}
	@Test
	public void offerTest() {
		assertTrue(queue.offer(5));
		assertEquals(Integer.valueOf(5),queue.getHead().getValue());
		assertEquals(Integer.valueOf(5),queue.getRear().getValue());
		assertTrue(queue.offer(6));
		assertTrue(queue.offer(7));
		assertEquals(Integer.valueOf(5),queue.getHead().getValue());
		assertEquals(Integer.valueOf(6),
					 queue.getHead().getNextPoint().getValue());
		assertEquals(Integer.valueOf(7),queue.getRear().getValue());
	}
	
	@Test 
	public void peektest() {
		assertNull(queue.peek());
		assertTrue(queue.offer(5));
		assertEquals(Integer.valueOf(5),queue.peek());
		assertTrue(queue.offer(6));
		assertTrue(queue.remove());
		assertEquals(Integer.valueOf(6),queue.peek());
	}
	
	@Test 
	public void removetest() {
		assertFalse(queue.remove());
		assertTrue(queue.offer(5));
		assertTrue(queue.offer(6));
		assertTrue(queue.offer(7));
		assertTrue(queue.remove());
		assertEquals(Integer.valueOf(6),queue.peek());
		assertTrue(queue.remove());
		assertEquals(Integer.valueOf(7),queue.peek());
		assertTrue(queue.remove());
		assertNull(queue.getHead());
		assertNull(queue.getRear());
		
	}
}

