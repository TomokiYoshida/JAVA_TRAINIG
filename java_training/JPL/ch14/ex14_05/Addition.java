package ch14.ex14_05;

/**
 * 現在の値を保持し、その値に加算して新たな値を表示するメソッドを持つオブジエクトのク
ラスを作成しなさい。そのオブジェクトを生成し、複数のスレッドを生成して、各スレッドからその加算メ
ソッドを繰り返し呼び出すプログラムを作成しなさい。加算の結果が失われないようにそのクラスを作成しな
さい。
 */
public class Addition {

	private static long value = 0;
	protected static final Object lock= new Object();
	public static void addValue(long v){
		synchronized(lock){
			value += v;
			System.out.println(value);
		}
	}
	public String toString(){
		return String.valueOf(value);
	}




}
