package ch24.ex24_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *練習問題24.2:6つの異なるロケールと6つの異なる通貨を選択して、各ロケールで各通貨に対する通貨記号
を示す表を表示しなさい。p611
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