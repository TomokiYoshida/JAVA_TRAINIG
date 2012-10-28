package ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

import ch22.ex22_02.WhichChars;

/**
 *練習問題22.3入力文字列に出現した文字の上位バイト(上位8ビット)ごとにBitSetオブジェクトを
HashMapに保存するようにしなさい。各BitSetオブジェクトは、特定の上位バイトを持つている文字の下位
バイトを保存します。p560
// 解けませんでした。。
 * @author tom
 *
 */
public class Hoge {
	private BitSet used = new BitSet();
	HashMap<BitSet, BitSet> map = new HashMap<BitSet, BitSet>();

	public Hoge(String str){
		for(int i = 0; i < str.length(); i++){
				used.set(str.charAt(i)); //文字に対応したビットを設定
		}
	}

	public String toString(){
		String desc =  "[";
		for(int i = used.nextClearBit(0);
				i >= 0;
				i = used.nextSetBit(i+1) ){
					desc += (char) i;
				}
				return desc + "]";
	}

	public static void main(String[] args){
		Hoge hoge = new Hoge("Testing 1 2 3");
		System.out.println(hoge);
	}
}
