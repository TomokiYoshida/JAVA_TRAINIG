package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{
	static byte key = (byte)0x12;
	public EncryptOutputStream(OutputStream out) {
		super(out);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void write(int b){
		try{
			super.write(b ^ key);
		}catch(IOException e){
		}
    }
}
