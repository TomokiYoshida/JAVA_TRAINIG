package ch03.ex03_10;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase{


	public static void test1(){
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.obj = new String("test1");
		list2.obj = new String("test2");
		list1.next = list2;

		//リスト1を複製する
		LinkedList list3 = list1.clone();

		//リスト3の値を変更する。
		list3.obj = new String("changed");
		list3.next.obj = new String("changed2");

		//list3のobjの変更の影響をlist1のobjは受けない
		assertFalse(list3.obj.equals(list1.obj));
		//list3のnextの変更の影響をlist1のobjは受ける
		assertTrue(list3.next == list1.next);
		assertTrue(list3.next.obj == list1.next.obj);

	}



}
