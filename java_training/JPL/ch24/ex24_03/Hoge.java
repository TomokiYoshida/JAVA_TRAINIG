package ch24.ex24_03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *練習問題24.3:文字列引数を取り、その文字列を解析して日付に変換して、その日付を可能なすべてのスタイ
ルで表示するプログラムを書きなさい。日付の解析はどの程度寛大ですか。p621
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