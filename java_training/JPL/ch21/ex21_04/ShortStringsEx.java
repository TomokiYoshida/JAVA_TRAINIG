package ch21.ex21_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * ListlteratorオブジェクトをフィルターするためにListlteratorを実装した
ShortStringsの別のバージョンを作成しなさい。そのクラスは、ShortStringsを拡張すべきですか。p537

 * @author tom
 *
 */
public class ShortStringsEx implements ListIterator<String>{
	private ListIterator<String> strings;//元の文字列
	private String nextShort; //次のが不明ならばnull
	private String previousShort; //前のが不明ならばnull
	private final int maxLen; //この長さ以下の文字列だけを返す

	public ShortStringsEx(ListIterator<String> strings,  int maxLen){
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		previousShort = null;
	}
	public boolean hasNext(){
		if(nextShort != null){//すでに見つけているｓ
			return true;
		}
		while( strings.hasNext()){
			nextShort = strings.next();
			if(nextShort.length() <= maxLen){
				return true;
			}
		}
		nextShort = null;//見つけられなかった
		return false;
	}
	public String next(){
		if(nextShort == null && !hasNext())
				throw new NoSuchElementException();
		String n = nextShort; //nextShortを記憶する
		nextShort = null; //nextShortを消費する
		return n; //nextShortを返す
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		if(previousShort != null){//すでに見つけているｓ
			return true;
		}
		while( strings.hasPrevious()){
			previousShort = strings.previous();
			if(previousShort.length() <= maxLen){
				return true;
			}
		}
		previousShort = null;//見つけられなかった
		return false;
	}
	@Override
	public String previous() {
		if(previousShort == null && !hasNext())
			throw new NoSuchElementException();
		String n = previousShort; //previousShortを記憶する
		previousShort = null; //previousShortを消費する
	return n; //previousShortを返す
	}
	@Override
	public int nextIndex() {
		return strings.nextIndex();
	}
	@Override
	public int previousIndex() {
		return strings.previousIndex();
	}
	@Override
	public void set(String e) {
		strings.set(e);
	}
	@Override
	public void add(String e) {
		strings.add(e);
	}
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("1234567890");
		list.add("12345678901234");
		list.add("1234567890123456789");
		list.add("123456");
		ShortStringsEx ss = new ShortStringsEx(list.listIterator(), 10);
		while(ss.hasNext()){
			System.out.println(ss.next());
		}
		while(ss.hasPrevious()){
			System.out.println(ss.previous());
		}
	}

}
