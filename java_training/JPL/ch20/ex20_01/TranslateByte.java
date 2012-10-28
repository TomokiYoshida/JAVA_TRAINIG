package ch20.ex20_01;
import java.io.*;
/**
 *TranslateByteプログラムをメソッドに書き直して、InputStreamの内容をoutputStream
に変換するようにしなさい。変換マッピングとストリームはメソッドのパラメータとして渡します。本章で述
べられる各InputStreamとOutputStreamについて、その型のストリームに対して操作を行うために、変換
メソッドを使用する新たなmainメソッドを書きなさい。もし入力と出力で一対となるストリームならば、1
つのmainメソッドで両方を扱うことができます p444
 * @author tom
 *
 */
class TranslateByte{

	public static void main(String[] args) throws IOException {
		String[] rgs = { "b", "B"};
		args = rgs;
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		TranslateByte tb = new TranslateByte();
		tb.translateByte(System.in, System.out, from, to);
	}
    public void translateByte(InputStream in, OutputStream out, byte from, byte to) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b == from ? to : b);
        }
    }
}
