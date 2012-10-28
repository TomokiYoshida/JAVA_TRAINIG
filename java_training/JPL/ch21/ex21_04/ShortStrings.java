package ch21.ex21_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ListlteratorオブジェクトをフィルターするためにListlteratorを実装した
ShortStringsの別のバージョンを作成しなさい。そのクラスは、ShortStringsを拡張すべきですか。p537
 * @author tom
 *
 */
public class ShortStrings implements Iterator<String>{
	private Iterator<String> strings;//元の文字列
	private String nextShort; //次のが不明ならばnull
	private final int maxLen; //この長さ以下の文字列だけを返す

	public ShortStrings(Iterator<String> strings,  int maxLen){
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
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
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		list.add("1234567890");
		list.add("12345678901234");
		list.add("1234567890123456789");
		list.add("123456");
		ShortStrings ss = new ShortStrings(list.iterator(), 10);
		while(ss.hasNext()){
			System.out.println(ss.next());
		}

	}

}
