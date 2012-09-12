package ch17.ex17_02;
import java.lang.ref.*;
import java.io.File;import java.io.FileInputStream;
import java.io.IOException;
/**
 * DataHallldlerを修正してlastFileも弱く保存されるようにしなさい。
 * @author tom
 *
 */
public class DataHandler {

	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;//(おそらく)最後のデータ;
	byte[] readFile(File file){
		byte[] data;
		//最後に読んだファイル
		//データを記憶しているか調べる
		if (file.equals(lastFile)){
		data = lastData.get();
		if (data != null)
		return data;
		}
		//記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
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

	}

}
