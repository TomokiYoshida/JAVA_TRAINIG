package ch12.ex12_01;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	public void testTest(){

		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		LinkedList<String> list3 = new LinkedList<String>();
		LinkedList<String> list4 = new LinkedList<String>();
		list1.setNext(list2);
		list2.setNext(list3);
		list3.setNext(list4);
		//ループは今回考慮しない

		list1.setObj(new String("a"));
		list2.setObj(new String("b"));
		list3.setObj(new String("c"));
		list4.setObj(new String("d"));
		try{
			list1.find("d");
		}catch(ObjectNotFoundExcpeption e){
			fail();
		}
		try{
			list1.find("xx");
			fail();
		}catch(ObjectNotFoundExcpeption e){
			e.printStackTrace();
			assertTrue(true);
		}

	}

}
