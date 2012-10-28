package ch21.ex21_05;

import java.util.AbstractList;
import java.util.ListIterator;

/**
 *ArrayBunchListに対してもっと効率的なListlteratorを実装しなさい。Listlterator
メソッドの特定の契約について注意してください。たとえば、setは、nextあるいはPreviousが呼び出さ
れるまで呼び出せないとか。p538
解けませんでした。。
 * @author tom
 *
 */
public class ArrayBunchList<E> extends AbstractList<E> {
	private final E[][] arrays;
	private final int size;

	public ArrayBunchList(E[][] arrays){
		this.arrays = arrays.clone();
		int s = 0;
		for(E[] array: arrays)
				s+= array.length;
		size = s;
	}
/*	@Override
	public ListIterator<E> listIterator(){

		return listIterator();
	}*/

	public int size(){
		return size;
	}
	public E get(int index){
		int off = 0;//コレクションの先頭からのオフセット
		for( int i = 0; i < arrays.length; i++){
			if( index < off + arrays[i].length)
				return arrays[i][index - off];
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	public E set(int index, E value){
		int off  = 0;//コレクションの先頭からのオフセット
		for(int i = 0; i < arrays.length; i++){
			if(index < off + arrays[i].length){
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	public static void main(String[] args){
		String[][] test = {{"test","value"},{"test1","value1"}};
		ArrayBunchList<String> list = new ArrayBunchList<String>(test);
		ListIterator<String> li = list.listIterator();
		while(li.hasNext()){
			System.out.println(li.next());
		}
	}
}
