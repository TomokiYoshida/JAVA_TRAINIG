package ch02.ex02_16;

public class LinkedList {

	private Object obj;
	private LinkedList next;

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
	public String toString(){
		String str = obj.toString();
		if(next != null)
		str += "\n" + next;
		return str;
	}
	public int getListLength(){
		int length = 1;
		LinkedList list = next;
		while(next != null){
			if(this == list)
				break;
			length++;
			list = list.next;

		}
		return length;
	}
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList list3 = new LinkedList();
		list1.setNext(list2);
		list2.setNext(list3);
		list3.setNext(list1);
		System.out.println(list1.getListLength());
		System.out.println(list2.getListLength());
		System.out.println(list3.getListLength());
	}


}
