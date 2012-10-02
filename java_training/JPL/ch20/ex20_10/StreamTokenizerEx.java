package ch20.ex20_10;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 *入カファイルを単語に分解して、そのファイル内で各単語の出現数を数えて表示するために
StreamTokenizerオブジェクトを使用するプログラムを作成しなさい。単語とその出現数を管理するために
HashMapを使用しなさい。
 * @author tom
 *
 */
public class StreamTokenizerEx {

	static Map<String, Integer> map = new HashMap<String, Integer>();
		public static void readAttrs(Reader source)
				throws IOException
				{
				StreamTokenizer in = new StreamTokenizer(source);
				while (in.nextToken() != StreamTokenizer.TT_EOF){
					if (in.ttype == StreamTokenizer.TT_WORD){
						String word = in.sval;
						if(map.get(word) != null){
							map.put(word, map.get(word)+1);
						}
						else{
							map.put(word,1);
						}
					} else if (in.ttype == ' '){

					}
				}
				}
		public static void main(String[] args){

			StreamTokenizerEx t = new StreamTokenizerEx();
			try{
				t.readAttrs(new FileReader(new File("resource/test5.txt")));
				System.out.println(map);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
}
