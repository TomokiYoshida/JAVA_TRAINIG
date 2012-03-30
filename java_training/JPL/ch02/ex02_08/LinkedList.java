package ch02.ex02_08;


public class LinkedList {

	Object obj;
	LinkedList next;

	public LinkedList(){

	}
	public LinkedList(Object obj){
		this.obj = obj;
	}

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


}
