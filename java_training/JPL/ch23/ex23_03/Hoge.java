package ch23.ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 *練習問題23.3:コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを
作成しなさい。出力中に特定の文字列が現れたらそのコマンドを終了させるようにしなさい。
 * @author tom
 * p592
 *
 */
public class Hoge {
	public static void main(String[] args) throws IOException{
		String[] rgs = {"java"};
		args = rgs;

		InputStream is = Runtime.getRuntime().exec(args[0]).getInputStream();
		printInputStream(is, "client");
		is = Runtime.getRuntime().exec(args[0]).getInputStream();
		printInputStream(is, "server");

	}

	public static void printInputStream(InputStream is, String finalStr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			for (int i = 1;; i++) {
				String line = br.readLine();
				if(line.indexOf(finalStr) != -1){
					System.out.println(i+":" + line.substring(0, line.indexOf(finalStr)));
					break;
				}
				if (line == null) break;
				System.out.println(i + ":"  +line);
			}
		} finally {
			br.close();
		}
	}
}