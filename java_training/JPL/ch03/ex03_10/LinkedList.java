package ch03.ex03_10;

public class LinkedList implements Cloneable {

	String obj;
	LinkedList next;

	public LinkedList clone(){
		try{
			LinkedList linkedList = (LinkedList) super.clone();
			if(this.next == null) return linkedList;
			else{
				linkedList.next = this.next;
			}
			return linkedList;
		}
		catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}

	public String toString(){
		String str = obj.toString();
		if(next != null)
		str += "->" + next;
		return str;
	}
	public static void main(String[] args){
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		list1.obj = new String("test1");
		list2.obj = new String("test2");
		list1.next = list2;
		System.out.println("list1:" + list1);

		//リスト1を複製する
		LinkedList list3 = list1.clone();
		System.out.println("list3:" + list3);
		System.out.println("値を変更");
		//リスト3の値を変更する。
		list3.obj = new String("changed");
		list3.next.obj = new String("changed2");
		System.out.println("list1:" + list1);
		System.out.println("list3:" + list3);

	}


}
