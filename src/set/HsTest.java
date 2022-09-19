package set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HsTest {
	HashSet hashSet = new HashSet();
	@Before
	public void before() {
		hashSet.clear();
	}
	@Test
	public void testClear() {
		hashSet.add(7);
		hashSet.add(1);
		hashSet.clear();
		for(int index=0;index<hashSet.size;index++) { 
		assertNull(hashSet.arr.get(index));
		}
	}
	@Test
	public void testRemove() {
		hashSet.add(7);
		hashSet.add(1);
		hashSet.remove(7);
		assertFalse(hashSet.contains(7));
		
	}
	@Test
	public void testAdd() {
		assertTrue(hashSet.add(7));
		assertTrue(hashSet.contains(7));
		assertTrue(hashSet.add(1));
		assertTrue(hashSet.contains(1));
		assertFalse(hashSet.add(7));
	}
	@Test
	public void testContains() {
		hashSet.add(0);
		assertTrue(hashSet.contains(0));
		assertFalse(hashSet.contains(6));
	}
	@Test
	public void testEmpty() {
		
		assertTrue(hashSet.empty());
		hashSet.add(0);
		
		assertFalse(hashSet.empty());
	}
	
}
