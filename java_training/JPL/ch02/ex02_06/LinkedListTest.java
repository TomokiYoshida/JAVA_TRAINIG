package ch02.ex02_06;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	public void testTest(){
		Vehicle v1 = new Vehicle();
		v1.setOwnerName("hoge");
		v1.setDirection("west");
		v1.setSpeed(10);

		Vehicle v2 = new Vehicle();
		v2.setOwnerName("hogehoge");
		v2.setDirection("east");
		v2.setSpeed(20);

		LinkedList l1 = new LinkedList();
		l1.setObj(v1);
		LinkedList l2 = new LinkedList();
		l2.setObj(v2);
		l1.setNext(l2);

		assertTrue(l1.getNext()== l2);

	}

}
