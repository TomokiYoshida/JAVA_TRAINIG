package ch22.ex22_02;

import java.util.BitSet;

/**
 *練習問題22.2WhichCharsクラスは、Unicode範囲の上位の文字を記録するのに問題を抱えています。そ
れは、上位の文字は、下位の範囲に関して多くの使用されないビットを残してしまうことです。出現した文字
ごとにCharacterオブジェクトをHashsetに保存することで、この問題を解決しなさい。
p560
 * @author tom
 *
 */
public class WhichCharsOriginal {

		private BitSet used = new BitSet();

		public WhichCharsOriginal(String str){
			for(int i = 0; i < str.length(); i++)
					used.set(str.charAt(i)); //文字に対応したビットを設定
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
			WhichCharsOriginal wc = new WhichCharsOriginal("Testing 1 2 3");
			System.out.println(wc);
		}

}
