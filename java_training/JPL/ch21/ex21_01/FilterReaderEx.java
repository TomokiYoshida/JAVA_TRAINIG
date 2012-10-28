package ch21.ex21_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *1行全体が揃うまで待つメソッドを使用して、1度に1行の入力を返すFilterReaderのサブ
クラスを作成しなさい。
 * @author tom
 *
 */
public class FilterReaderEx extends FilterReader{

	public FilterReaderEx(Reader in){
		super(in);
	}
	public String readLine()throws IOException {
		StringBuilder s = new StringBuilder();
		int c = 0;
		while((c = super.read()) != -1){

		if((char)c == '\n'){
			return s.toString();
		}
		if((char)c == '\r'){
			c = super.read();
			if((char)c == '\n'){
				return s.toString();
			}
		}
		s.append((char)c);
		//win
		}
		if(s.toString().length() == 0)return null;
		return s.toString();
	}
	public static void main(String[] args){
		try{
		FilterReaderEx frx = new FilterReaderEx(new FileReader(new File("resource/test.txt")));
		System.out.println(frx.readLine());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
