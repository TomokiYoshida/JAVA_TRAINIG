package ch11.ex11_01;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	public void testTest(){

		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		list1.setNext(list2);
		assertTrue(list1.getNext()== list2);
		String a = new String("a");
		list1.setObj(new String("a"));
		assertTrue(a.equals(list1.getObj()));

	}

}
