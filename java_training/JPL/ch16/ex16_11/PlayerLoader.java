package ch16.ex16_11;

import java.io.FileInputStream;
import java.io.IOException;

public class PlayerLoader extends ClassLoader{
	public Class<?> findClass(String name)
		throws ClassNotFoundException
		{
			try{
				byte[] buf =bytesForClass(name);
				return defineClass(name, buf, 0, buf.length);
			}catch(IOException e){
				throw new ClassNotFoundException(e.toString());
			}

		}
		static byte[] bytesForClass(String name) throws IOException{
				FileInputStream in = null;
				try{
					in = streamFor(name +  ".class");
					int length = in.available(); // バイト数を得る
					if(length == 0)
						throw new ClassNotFoundException(name);
						byte[] buf = new byte[length];
						in.read(buf);
						return buf;
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}finally{
					if(in != null)
						in.close();
				}
				return null;
		}
		static FileInputStream streamFor(String name)throws IOException{

			return new FileInputStream("resource/" + name);

		}
}
