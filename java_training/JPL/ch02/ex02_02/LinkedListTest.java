package ch02.ex02_02;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	public void testTest(){

		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.setNext(list2);
		assertTrue(list1.getNext()== list2);
		String a = new String("a");
		list1.setObj(new String("a"));
		assertTrue(a.equals((String)list1.getObj()));

	}

}
