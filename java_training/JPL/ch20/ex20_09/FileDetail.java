package ch20.ex20_09;

import java.io.File;
import java.io.IOException;

/**
 *1つかそれ以上のパス名を渡されて、それが表すフアイルについて得られるすべての情報を表
示するメソッドを書きなさい。
 * @author tom
 *
 */
public class FileDetail {

	static void showFileDetail(String... path){
		try{
			File file = new File("./resource/test.txt");
			System.out.println("absolute path:"+file.getAbsolutePath());
			System.out.println("canonical path:"+file.getCanonicalPath());
			System.out.println("name:"+ file.getName());
			System.out.println("can read:"+ file.canRead());
			System.out.println("can write:"+ file.canWrite());
			System.out.println("freespace:"+ file.getFreeSpace());
			System.out.println("parent:"+ file.getParent());
			System.out.println("path:"+ file.getPath());
			System.out.println("total space:"+ file.getTotalSpace());
			System.out.println("usable space:"+ file.getUsableSpace());
			System.out.println("last modified:"+ file.lastModified());
			System.out.println("path separator:"+ file.pathSeparator);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args ){
		showFileDetail("./resource/test.txt");
	}

}
