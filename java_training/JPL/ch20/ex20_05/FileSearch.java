package ch20.ex20_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *指定されたファイルを読み込んで、指定された単語を検索するプログラムを作成しなさい。単
語が発見された全ての行を、行の前に行番号を付けて表示しなさい。
 * @author tom
 *
 */
public class FileSearch {

	static String searchLine(File file, String word){
		StringBuilder s = new StringBuilder();
		try{
			BufferedReader  br = new BufferedReader(new FileReader(file));
			for(int i = 0; ; i++){
				String line = br.readLine();
				if(line == null)break;
				if((line.indexOf(word)) != -1){
					s.append(i + ":" + line + "\n");
				}
			}
			return s.toString();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		System.out.println(searchLine(new File("resource/test.txt"), "test"));

	}

}
