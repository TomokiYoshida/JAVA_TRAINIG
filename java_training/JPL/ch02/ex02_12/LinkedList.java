package ch02.ex02_12;

//不要。LinkedListのリストで可変長の配列を表現できる。
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
	public String toString(){
		String str = obj.toString();
		if(next != null)
		str += "\n" + next;
		return str;
	}

	public static void main(String[] args){

		Vehicle v1 = new Vehicle();
		v1.setOwnerName("hoge");
		v1.setDirection("west");
		v1.setSpeed(10);

		Vehicle v2 = new Vehicle();
		v2.setOwnerName("hogehoge", "hohohoh");
		v2.setDirection("east");
		v2.setSpeed(20);

		LinkedList l1 = new LinkedList();
		l1.setObj(v1);
		LinkedList l2 = new LinkedList();
		l2.setObj(v2);
		l1.setNext(l2);

		System.out.println(l1);
	}

}
