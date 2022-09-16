package stack;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StackTests {
	StackImpl<Integer> stack = new StackImpl<Integer>(); 
	@Before
	public void first() {
		stack.clear();
	}
	@Test 
	public void testClear() {
		assertNull(stack.getHead());
		assertNull(stack.getRear());
		assertTrue(stack.push(6));
		assertTrue(stack.push(9));
		stack.clear();
		assertNull(stack.getHead());
		assertNull(stack.getRear());
	}
	@Test
	public void testEmpty() {
		assertTrue(stack.empty());
		assertTrue(stack.push(6));
		assertTrue(stack.push(9));
		assertFalse(stack.empty());
		stack.clear();
		assertTrue(stack.empty());	
	}
	@Test 
	public void testPop() {
		assertNull(stack.pop());
		assertTrue(stack.push(6));
		assertEquals(Integer.valueOf(6),stack.pop());
		assertNull(stack.getHead());
		assertNull(stack.getRear());
		assertTrue(stack.push(7));
		assertTrue(stack.push(8));
		assertTrue(stack.push(9));
		assertEquals(Integer.valueOf(9),stack.pop());
		assertNull(stack.getRear().getNextPoint());
		assertEquals(Integer.valueOf(8),stack.pop());
		assertEquals(stack.getHead().getValue(),Integer.valueOf(7));
		assertEquals(stack.getRear().getValue(),Integer.valueOf(7));
		assertTrue(stack.push(8));
		assertEquals(stack.getHead().getValue(),Integer.valueOf(8));
		assertEquals(stack.getRear().getValue(),Integer.valueOf(7));
	}
	@Test 
	public void testPush() {
		assertTrue(stack.push(6));
		assertEquals(stack.getHead().getValue(),Integer.valueOf(6));
		assertEquals(stack.getRear().getValue(),Integer.valueOf(6));
		stack.clear();
		assertTrue(stack.push(7));
		assertTrue(stack.push(8));
		assertTrue(stack.push(9));
		assertEquals(stack.getHead().getValue(),Integer.valueOf(9));
		assertEquals(stack.getRear().getValue(),Integer.valueOf(7));
		assertNull(stack.getRear().getNextPoint());
	}
	@Test
	public void testPeek() {
		assertNull(stack.peek());
		assertTrue(stack.push(7));
		assertTrue(stack.push(8));
		assertTrue(stack.push(9));
		assertEquals(stack.peek(),Integer.valueOf(9));
		assertEquals(stack.getHead().getValue(),Integer.valueOf(9));
		assertEquals(stack.getRear().getValue(),Integer.valueOf(7));
	}
	@Test
	public void testSearch() {
		assertEquals(-1,stack.search(8));
		assertTrue(stack.push(7));
		assertTrue(stack.push(8));
		assertTrue(stack.push(9));
		assertEquals(0,stack.search(9));
		assertEquals(2,stack.search(7));
		assertEquals(-1,stack.search(10));
		stack.clear();
		assertTrue(stack.push(6));
		assertEquals(0,stack.search(6));
	}
}
