package ch21.ex21_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 400頁のDataHandlerクラスを書き直して、1つのWeakReferenceの代わりにWeakHashMap
を使用して返されたデータを保持するようにしなさい。p522
 * @author tom
 *
 */
public class DataHandler {

	private File lastFile;
	private WeakHashMap<File, byte[]> lastData;//(おそらく)最後のデータ;
	byte[] readFile(File file){
		byte[] data;
		//最後に読んだファイル
		//データを記憶しているか調べる
		if (lastData !=null && lastData.get(file)!=null){
		data = lastData.get(file);
		System.out.println("read from HashMap");
		if (data != null)
		return data;
		}
		//記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = file;
		lastData = new WeakHashMap<File, byte[]>();
		lastData.put(file, data);
		return data;
	}
	byte[] readBytesFromFile(File file){
		byte[] bytes = new byte[(int) file.length()];
		try{
			new FileInputStream(file).read(bytes);
		}catch(IOException e){
			e.printStackTrace();
		}
		return bytes;
	}
	public static void main(String[] args){
		DataHandler dh = new DataHandler();
		dh.readFile(new File("resource/test.txt"));
		dh.readFile(new File("resource/test.txt"));

	}

}
