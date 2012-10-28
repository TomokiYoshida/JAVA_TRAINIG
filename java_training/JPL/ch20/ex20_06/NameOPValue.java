package ch20.ex20_06;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 *name op value形式の入力を受け取るプログラムを作成しなさい。nameは自分で選んだ3
個の単語の1つで、opは+、一、=のどれかで、valueは数です。名前付値に各演算子を適用しなさい。入力
がなくなったら、3つの値を表示しなさい。もし、興味があれば、Attributedlmplで使用されたHashMap
を使用してみなさい。そうすれば、任意の個数の名前付定数を使用できます。p470
->
 * @author tom
 *
 */
public class NameOPValue {

		private Map<String, Double> map = new HashMap<String, Double>();

		public NameOPValue(){
			map.put("x", 0.0);
			map.put("y", 0.0);
			map.put("z", 0.0);
		}
		class NameOPValueEntity{
			String name;
			String name2;
			char op;
			double val;
		}
		void execute(NameOPValueEntity e){
			if(e.name2 != null){
				System.out.println(e.name + e.op + e.name2);
			}
			else{
				System.out.println(e.name + e.op + e.val);
			}
			if(e.op == '='){
				if(e.name2 != null){
					map.put(e.name, map.get(e.name2));
				}else{
					map.put(e.name, e.val);
				}
			}
			else if(e.op == '+'){
				if(e.name2 != null){
					Double x = map.get(e.name);
					map.put(e.name, map.get(e.name2)+ x);
				}
				Double x = map.get(e.name);
				map.put(e.name, e.val + x);
			}
			else if(e.op == '-'){
				if(e.name2 != null){
					Double x = map.get(e.name);
					map.put(e.name, map.get(e.name2)-x);
				}
				Double x = map.get(e.name);
				map.put(e.name, e.val - x);
			}
		}

		public void calc(Reader reader) {
			try{
			StreamTokenizer in = new StreamTokenizer(reader);

			List<NameOPValueEntity> entityList = new ArrayList<NameOPValueEntity>();
			int index = 0;
			boolean opExisted = false;
			while (in.nextToken() != StreamTokenizer.TT_EOF){
				if (in.ttype == StreamTokenizer.TT_WORD){
					String val = in.sval;
					if(opExisted){
						entityList.get(index).name2 = val;
						opExisted = false;
						index++;
					}
					else{
						entityList.add(new NameOPValueEntity());
						entityList.get(index).name = val;
					}
				}else if(in.ttype == StreamTokenizer.TT_NUMBER){

					entityList.get(index).val = in.nval;
					opExisted = false;
					index++;
				}
				else if (in.ttype == '='){
					entityList.get(index).op = '=';
					opExisted = true;

				}
				else if (in.ttype == '+'){
					entityList.get(index).op = '+';
					opExisted = true;
				}
				else if (in.ttype == '-'){
					entityList.get(index).op = '-';
					opExisted = true;
				}

			}
			for(int i = 0; i < entityList.size(); i++){
				execute(entityList.get(i));
			}

			}catch(IOException e){
				e.printStackTrace();
			}

		}

		/*nameopvalue.txt
		 * x=10
			y=20
			z=30
			x+y
			y+z
		 */
		public static void main(String[] args){
			NameOPValue nov = new  NameOPValue();
			try{
				nov.calc(new FileReader(new File("resource/nameopvalue.txt")));
				System.out.println("x:" + nov.map.get("x"));
				System.out.println("y:" + nov.map.get("y"));
				System.out.println("z:" + nov.map.get("z"));

			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}
}
