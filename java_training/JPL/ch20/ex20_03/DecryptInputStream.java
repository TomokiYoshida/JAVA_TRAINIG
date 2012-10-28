package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
バイトを何らかの値とXORするなど、どのようなアルゴリズムでも良いので、バイトを暗号
化する一組のFilterストリームクラスであるDecrypt lnPutStreamとEncryptOutputStreamを作成しな
さい。DecryptlnputStrealnは、EncryptOutputStrealnクラスが生成したバイトを復号化します。p454
 * @author tom
 *
 */
public class DecryptInputStream extends FilterInputStream{
	static byte key = (byte)0x12;
	DecryptInputStream(InputStream in){
		super(in);
	}
		public int read(){
			try{
				return super.read() ^ key;
			}catch(IOException e){

			}	return -1;

		}
		public static void main(String[] args){
			String[] rgs = { "b", "B"};
			args = rgs;
			DecryptInputStream dis = new DecryptInputStream(System.in);
			EncryptOutputStream out = new EncryptOutputStream(System.out);
			int b;
			while((b = dis.read()) != -1){
				out.write(b);
			}
		}
}
