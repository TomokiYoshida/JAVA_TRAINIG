package ch20.ex20_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.sound.sampled.Line;

/**
 *%%で始まる行で分割されているエントリーを持つファイルを読み込み、各エントリーの開始
位置を持つテーブルファイルを作成するプログラムを書きなさい。そして、そのテーブルを使用してランダ
ムにエントリーを表示するプログラムを作成しなさい(579頁の「MathとstrictMath」で説明されている
Math.randomメソッドを参照)。p476
 * @author tom
 *
 */
public class TableFile {
	static long[] setIndex(RandomAccessFile file, String word){
		File ifile = new File("resource/index.txt");
		FileWriter fw = null;
		BufferedWriter bw =null;
		long[] table =new long[100];
		long[] table2 = {};
		try{
			fw = new FileWriter(ifile);
			bw = new BufferedWriter(fw);
			String line = null;
			int i = 0;
			while((line = file.readLine()) != null){
				if((line.indexOf(word)) != -1){
					table[i] = file.getFilePointer();
					i++;
					bw.write(String.valueOf(file.getFilePointer()));
				}
			}
			table2 = new long[i];

		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(bw !=null){
					try{
						bw.flush();
						bw.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
		}

		for(int i = 0; i < table2.length; i++){
			table2[i] = table[i];
		}
		return table2;
	}
	public static void main(String[] args){
		try{
			File file1 = new File("resource/hogehoge.txt");
			RandomAccessFile rf1 = new RandomAccessFile(file1, "r");
			long[] table = setIndex(rf1, "%%");
/*			for(int i = 0; i < table.length; i++){
				System.out.println(table[i]);
			}*/
			for(int i = 0 ; i < 5; i ++){
			int index = (int) Math.floor (Math.random () * table.length);
			System.out.print(index + ":");
			if(index == table.length -1){
				rf1.seek(table[index]);
				byte[] b = new byte[(int) ((int)(rf1.length())- table[index])];
				rf1.read(b) ;
				System.out.println(new String(b , "UTF-8"));
			}
			else { rf1.seek(table[index]);
			//%%分を引く
			byte[] b = new byte[(int)(table[index+1] - table[index])-6];
				rf1.read(b) ;
				System.out.println(new String(b , "UTF-8"));
			}
			}
		}catch(EOFException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}


}
