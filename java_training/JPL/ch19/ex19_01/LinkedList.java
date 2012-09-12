package ch19.ex19_01;
/**
 *
 * 練習問題2.16で作成したLinkedListクラスにドキュメンテーションコメントを追加しなさ
 *い。javadocを生成して、誰かにそのクラスを使用したサンプルプログラムを書いてもらいなさい。その人が
* サンプルプログラムを書けるまで、必要ならばコメントを書き直して、同じことを繰り返しなさい。
 * @author tom
 *
 */
public class LinkedList {

	private Object obj;
	private LinkedList next;
	/**
	 * 保持する要素を返す
	 * @return 保持する要素
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 *要素を設定する。
	 * @param obj 設定する要素
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 *次の要素を返す。
	 * @return l次の要素
	 */
	public LinkedList getNext() {
		return next;
	}
	/**
	 * 次の要素を設定する。
	 * @param next 次の要素
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}
	public String toString(){
		String str = obj.toString();
		if(next != null)
		str += "\n" + next;
		return str;
	}
	/**
	 * listの長さを返す
	 * @return
	 */
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
