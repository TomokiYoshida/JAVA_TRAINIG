package ch04.ex04_03;

public class LinkedListInteger implements LinkedList<Integer> {

	private Integer obj;
	private LinkedList<Integer> next;

	public Integer getObj() {
		return obj;
	}
	public void setObj(Integer obj) {
		this.obj = obj;
	}
	public LinkedList<Integer> getNext() {
		return next;
	}
	public void setNext(LinkedList<Integer> next) {
		this.next = next;
	}
	public String toString(){
		String str = obj.toString();
		if(next != null)
		str += "\n" + next;
		return str;
	}

	public static void main(String[] args){
		LinkedList<Integer> list1 = new LinkedListInteger();
		LinkedList<Integer> list2 = new LinkedListInteger();
		LinkedList<Integer> list3 = new LinkedListInteger();
		list1.setObj(1);
		list2.setObj(2);
		list3.setObj(3);

		list1.setNext(list2);
		list2.setNext(list3);

		System.out.println(list1);
	}


}
