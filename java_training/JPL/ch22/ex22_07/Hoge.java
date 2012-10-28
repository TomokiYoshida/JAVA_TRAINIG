package ch22.ex22_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *期待されるデータのセル数を引数として渡せるようにreadCSVTableを書き直しなさい。
 * @author tom
 *TODO
 *p570
 */
public class Hoge {
	static final String LINE_SEPARATOR_PATTERN =
			"\r\n|[\n\r\u2028\u2029\u0085]";

	public static List<String> readCSV(Readable source)
			throws IOException {
			Scanner in = new Scanner(source);
			in.useDelimiter(",|" + LINE_SEPARATOR_PATTERN);
			List<String> vals = new ArrayList<String>();
			while (in.hasNext())
			vals.add(in.next());
			IOException ex = in.ioException();
			if (ex!= null){
				throw ex;
			}
			return vals;
	}

	public static void main(String[] args){

	}

}
