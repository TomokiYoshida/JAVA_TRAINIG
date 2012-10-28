package ch21.ex21_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * フアイルを開いて1行ずつ読み込み、各行をString.compareToを使用してソートされた
Listに保存するプログラムを書きなさい。練習問題20.4で作成した行を読み込むクラスが役立ちます。
p514
 * @author tom
 *
 */
public class FileToSortedList {

	public static void main(String[] args){
		try{
			FilterReaderEx frx = new FilterReaderEx(new FileReader(new File("resource/test.txt")));
			List<String> list = new LinkedList<String>();
			String line = null;
			if((line = frx.readLine()) != null){
				list.add(line);
			}

			while((line = frx.readLine()) != null){
				int size = list.size();
				for(int i = 0; i < size; i++){
					if(line.compareTo(list.get(i))< 0){
						list.add(i, line);
						break;
					}
					else if(i == size -1){
						list.add(line);
					}
				}
			}
			for(int i = 0; i < list.size();  i++){
				System.out.println(list.get(i));
			}
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
	}
}
