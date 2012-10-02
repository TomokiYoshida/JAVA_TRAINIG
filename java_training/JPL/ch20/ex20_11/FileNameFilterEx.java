package ch20.ex20_11;
import java.io.*;
/**
 * デイレクトリと接尾語をパラメータとして取り、その接尾語を持つすべてのフアイルを表示
するプログラムをFilenameFilterあるいはFileFilterを使用して作成しなさい。
 * @author tom
 *
 */
public class FileNameFilterEx implements FilenameFilter{

		private String prefix;

		public  void setPrefix(String prefix){
			this.prefix = prefix;
		}
		public boolean accept(File dir, String name){
			if(new File(dir, name).getName().endsWith(prefix)){
//				System.out.println(new File(dir, name).getName());
				return true;
			}
			return false;
		}
		public static void main(String[] args){
		File dir = new File("resource");
		FileNameFilterEx filter = new FileNameFilterEx();
		filter.setPrefix("txt");
		String[] files = dir.list(filter);
		System.out.println(files.length + " file(s)" );
		for (String file : files)
		System.out.println("\t" + file);
		}

}
