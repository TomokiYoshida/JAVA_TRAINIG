package ch22.ex22_02;

import java.util.BitSet;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *練習問題22.2WhichCharsクラスは、Unicode範囲の上位の文字を記録するのに問題を抱えています。そ
れは、上位の文字は、下位の範囲に関して多くの使用されないビットを残してしまうことです。出現した文字
ごとにCharacterオブジェクトをHashsetに保存することで、この問題を解決しなさい。

p560
 * @author tom
 *
 */
public class WhichChars {

		HashSet<Character> set = new HashSet<Character>();

		public WhichChars(String str){
			for(int i = 0; i < str.length(); i++){
					set.add(str.charAt(i)); //文字に対応したビットを設定
			}
		}

		public String toString(){
		      TreeSet<Character> sorted = new TreeSet<Character>(set);
		      String str = "[";
		        for (Character ch : sorted) {
		            str += ch;
		        }
		        str+="]";
		        return str;
		}

		public static void main(String[] args){
			WhichChars wc = new WhichChars("Testing 1 2 3");
			System.out.println(wc);
		}

}
