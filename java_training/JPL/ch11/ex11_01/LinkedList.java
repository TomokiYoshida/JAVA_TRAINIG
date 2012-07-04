package ch11.ex11_01;

public class LinkedList<E> {

	E obj;
	LinkedList<E> next;

	public Object getObj() {
		return obj;
	}
	public void setObj(E obj) {
		this.obj = obj;
	}
	public LinkedList<E> getNext() {
		return next;
	}
	public void setNext(LinkedList<E> next) {
		this.next = next;
	}



}
