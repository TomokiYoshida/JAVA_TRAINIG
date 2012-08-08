package ch14.ex14_02;

public class SingleLinkQueue <E>{

	protected Cell<E> head;
	protected Cell<E> tail;

	public int size(){
		int size = 0;
		if(head == null){
			return 0;
		}
		while(head.getNext() != null){
			size++;
		}
		return size;
	}
	public void add(E item){
		Cell<E> cell = new Cell<E>(item);
		if(tail == null)
			head = tail = cell;
		else{
			tail.setNext(cell);
			tail = cell;
		}
	}
	public E remove(){
		if(head == null)
			return null;
		Cell<E> cell = head;
		head = head.getNext();
		if(head == null)
			tail = null;
		return cell.getElement();
	}

}
