package ch20.ex20_02;
import java.io.*;

import javax.xml.crypto.dsig.spec.XPathType.Filter;
/**
 *TranslateByteクラスをフィルターとして書き直しなさい。
 * @author tom
 *
 */
class TranslateByteFilterIputStream extends FilterInputStream{

	private byte from;
	private byte to;
	protected TranslateByteFilterIputStream(InputStream in, byte from,  byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}

	public static void main(String[] args) throws IOException {
		String[] rgs = { "b", "B"};
		args = rgs;
		byte from = (byte)args[0].charAt(0);
		byte to = (byte)args[1].charAt(0);
		TranslateByteFilterIputStream tfs = new TranslateByteFilterIputStream(System.in, from, to);
		int b = 0;
		while((b = tfs.read(System.in, System.out, from, to)) != -1){
			System.out.write(b);
		}
	}
    public int read(InputStream in, OutputStream out, byte from, byte to) throws IOException {
    	int b = super.read() ;
        return b == from ? to : b;
    }
}
