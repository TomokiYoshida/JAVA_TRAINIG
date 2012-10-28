package ch21.ex21_07;

import java.io.*;
import java.util.*;

/**
 * 463頁のプログラムConcatを書き直して、1度に1つのFilelnputStreamオブジェクトだ
 * けをオープンするEnumerationの実装を使用するようにしなさい。
 * TODO 不明
 * @author tom
 *
 */
public class Concat{
	public static void main(String[] args) throws IOException {
		String[] rgs = {"resource/cat1.txt", "resource/cat2.txt"};
		args = rgs;
		InputStream in;// 文字を読み込むべきストリーム
		if (args.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs = new ArrayList<InputStream>(args.length);
			for (String arg : args) {
				fileIn = new FileInputStream(arg);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			Enumeration<InputStream> files = Collections.enumeration(inputs);
			in = new SequenceInputStream(files);

		}
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		while ((line = br.readLine()) != null)
			System.out.println(line);
	}
	// ...

}