package ch02.ex02_14;

public class LinkedList {

	//オブジェクトはリスト内の要素として外部からアクセスする必要があるのでアクセッサーメソッドが必要
	private Object obj;
	//次リストへのリンクが外部から要求されるのでアクセッサーメソッドが必要
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

}
