package ch21.ex21_06;

import java.util.ArrayList;

/**
 *ArrayListを使用してスタックを実装しなさい。スタック固有の異なるメソッドを提供する
ために、そのスタックのクラスは、ArrayListのサブクラスとすべきですか。それともArrayListを内部で
使用すべきですか。
ArrayListのサブクラスとすると、他のコレクションで使えないので
ArrayListを内部で使用するべき。
 * @author tom
 *
 */
public class Stack<E> {

		private ArrayList<E> stack;
		private final int DEFAULT_CAPACITY = 10;
		private int sp = 0; /* Stack Pointer */

		public Stack() {
			stack = new ArrayList<E>(DEFAULT_CAPACITY);
		}
		public void push(E item) {
			stack.add(item);
			sp++;
		}
		public E pop() {
			sp--;
			if(sp < 0){
				sp = 0;
				return null;
			}
			else{
				E e = stack.get(sp);
				stack.remove(sp);
				return e;
			}
		}
		public static void main(String[] args){
			Stack stack = new Stack();
			stack.push(100);
			stack.push(200);
			stack.push(300);
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}
}
