package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *第3章のAttrクラスヘ、DataOutputStreamにオブジェクトの内容を書き込むメソッドを
追加しなさい。また、DatalnputStreamから状態を読み込むコンストラクタを追加しなさい。
 * @author tom
 */
public class Attr {

	private final String name;
	private Object value = null;

	public Attr(String name){
		this.name = name;
	}
	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}
	public Attr(DataInputStream in)throws IOException{
		name = in.readUTF();
		value = in.readUTF();
	}

	public String getName(){
		return name;
	}
	public Object getValue(){
		return value;
	}
	public Object setValue(Object newValue){
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	public String toString(){
		return name + "='" + value + "'";
	}
	public void writeData(DataOutputStream dos)	throws IOException{
				dos.writeUTF(name);
				dos.writeUTF(value.toString());
	}
	public static void main(String[] args){
		try{
			Attr attr = new Attr("hoge" , "hage");
			attr.writeData(new DataOutputStream(new FileOutputStream(new File("resource/test3.txt"))));

			Attr attr2 = new Attr(new DataInputStream(new FileInputStream(new File("resource/test3.txt"))));
			System.out.println(attr2);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}