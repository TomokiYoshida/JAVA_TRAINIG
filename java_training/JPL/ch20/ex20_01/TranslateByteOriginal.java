package ch20.ex20_01;
import java.io.*;
/**
 *TranslateByteプログラムをメソッドに書き直して、InputStrealnの内容をoutputStreanl
に変換するようにしなさい。変換マッピングとストリームはメソッドのパラメータとして渡します。本章で述
べられる各InputStrealllとOutputStreanlについて、その型のストリームに対して操作を行うために、変換
メソッドを使用する新たなmainメソッドを書きなさい。もし入力と出力で一対となるストリームならば、1
つのmainメソッドで両方を扱うことができます
 * @author tom
 *
 */
class TranslateByteOriginal{
	public static void main(String[]args)
	throws IOException
	{
		String[] rgs = { "b", "B"};
		args = rgs;
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		int b;
		while ((b = System.in.read()) != -1)
		System.out.write(b == from ? to : b);
	}
}
