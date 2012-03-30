package ch02.ex02_06;


public class LinkedList {

	Object obj;
	LinkedList next;

	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public LinkedList getNext() {
		return next;
	}
	public void setNext(LinkedList next) {
		this.next = next;
	}

	public static void main(String[] args){

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
	}

}
