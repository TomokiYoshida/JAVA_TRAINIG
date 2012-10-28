package ch20.ex20_02;
import java.io.*;
/**
 *TranslateByteクラスをフィルターとして書き直しなさい。p454
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
