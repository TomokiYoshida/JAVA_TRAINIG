package ch24.ex24_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *練習問題24.1:GlobalHelloを、例として挙げたロケールで動かしてみなさい。ListResourceBundle、
.propertiesフアイル、それにResourceBundleのサブクラスを作成して、ロケールをいくつか追加しな
さい。p610
 * @author tom
 */
public class Hoge {
	public static Process userProg(String cmd)
			throws IOException
			{
			Process proc = Runtime.getRuntime().exec(cmd);
			plugTogether(System.in, proc.getOutputStream());
			plugTogether(System.out, proc.getInputStream());
			plugTogether(System.err, proc.getErrorStream());
			return proc;
			}
	//TODO
	// ... plugTogether の定義 ...
	public static void plugTogether(InputStream in, OutputStream out){

	}
	// ... plugTogether の定義 ...
	public static void plugTogether(OutputStream out, InputStream in2){

	}
}