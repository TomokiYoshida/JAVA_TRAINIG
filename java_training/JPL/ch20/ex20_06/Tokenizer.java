package ch20.ex20_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Iterator;

public class Tokenizer {

	public static Attributed readAttrs(Reader source)
			throws IOException
			{
			StreamTokenizer in = new StreamTokenizer(source);
			AttributedImpl attrs = new AttributedImpl();
			Attr attr = null;
			in.commentChar('#'); //'#'は行の最後まで無視されるコメント
			in.ordinaryChar('/'); //コメント文字でなくす。
			while (in.nextToken() != StreamTokenizer.TT_EOF){
				if (in.ttype == StreamTokenizer.TT_WORD){
					if (attr != null){
						attr.setValue(in.sval);
						attr=null; //使い終った
			} else{
				attr = new Attr(in.sval);
				attrs.add(attr);
				}
			} else if (in.ttype == '='){
			if (attr == null)
				throw new IOException("misplaced '='1");
					} else{
					if(attr==null)//単語が期待される
					throw new IOException("Bad Attr name");
					attr.setValue(new Double(in.nval));
					attr = null;
					}
			}
				return attrs;
			}
	public static void main(String[] args){

		Tokenizer t = new Tokenizer();
		try{
			Attributed a = t.readAttrs(new FileReader(new File("resource/test4.txt")));
			for(Iterator<Attr> ite = a.attrs(); ite.hasNext();) {
			    System.out.println(ite.next());
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
