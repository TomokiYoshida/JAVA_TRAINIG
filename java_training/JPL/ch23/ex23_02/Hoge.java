package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *練習問題23.2:コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを
作成しなさい。各出力行の前には行番号を表示しなさい。
 * @author tom
 * p592
 */
public class Hoge {
	public static void main(String[] args) throws IOException{
		String[] rgs = {"java"};
		args = rgs;

		InputStream is = Runtime.getRuntime().exec(args[0]).getInputStream();

		printInputStream(is);

	}

	public static void printInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			for (int i = 1;; i++) {
				String line = br.readLine();
				if (line == null) break;
				System.out.println(i + ":"  +line);
			}
		} finally {
			br.close();
		}
	}
}