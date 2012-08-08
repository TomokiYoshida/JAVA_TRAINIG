package ch14.ex14_03;

/**
 * 現在の値を保持し、その値に加算して新たな値を表示するメソッドを持つオブジエクトのク
ラスを作成しなさい。そのオブジェクトを生成し、複数のスレッドを生成して、各スレッドからその加算メ
ソッドを繰り返し呼び出すプログラムを作成しなさい。加算の結果が失われないようにそのクラスを作成しな
さい。
 */
public class Addition {

	private long value = 0;

	synchronized public void addValue(long v){
		value += v;
		System.out.println(value);
	}
	public String toString(){
		return String.valueOf(value);
	}




}
