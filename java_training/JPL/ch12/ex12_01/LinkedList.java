package ch12.ex12_01;


//再帰からすぐに抜けられるのでnullでなくexcpetionを返す。ObjectNotFoundには探していたオブジェクトの文字列をを返す。
public class LinkedList<E> {

	E obj;
	LinkedList<E> next;

	public Object getObj() {
		return obj;
	}
	public void setObj(E obj) {
		this.obj = obj;
	}
	public LinkedList<E> getNext()  {
		return next;
	}
	public void setNext(LinkedList<E> next) {
		this.next = next;
	}
	public E find(E target)throws ObjectNotFoundExcpeption{
		if(target.equals(obj))return obj;
		else if(next == null){
			throw new ObjectNotFoundExcpeption(target.toString());
		}
		else{
			return next.find(target);
		}

	}



}
