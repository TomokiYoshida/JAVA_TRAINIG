package ch16.ex16_03;
import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;

/**
 * すべての宣言されているメンバーとすべての継承されているpublicのメンバーに関する情報
を表示するようにClassContentsを修正しなさい。同じものを2度表示しないようにしなさい。
 */
public class ClassContents{

	private static Set<String> members = new HashSet<String>();


	public static void main(String[]args){
		String[] rgs = {"java.io.FileNotFoundException"};
		args = rgs;
		try{
			Class<?> c = Class.forName(args [0]);
			System.out.println(c);
			showClassContents(c);
			showMembers();
			/*printMembers(c.getFields());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());*/
		} catch (ClassNotFoundException e){
			System.out.println("unknown class" + args[0]);
		}
	}
	static void showClassContents(Type type){
				if (type == null)
					return;
				// TypeをClassオブジェクトに変換する
				Class<?> cls = null;
				if (type instanceof Class<?>)
					cls = (Class<?>) type;
				else if (type instanceof ParameterizedType)
					cls = (Class<?>) ((ParameterizedType) type).getRawType();
				else
					throw new Error("Unexpected non- class type");
				printMembers(cls.getFields());
		        printMembers(cls.getConstructors());
		        printMembers(cls.getMethods());
				// スーパークラスに対して再帰
				showClassContents(cls.getGenericSuperclass());
			}
	private static void printMembers(Member[] mems) {
	for (Member m : mems) {
		if (m.getDeclaringClass() == Object.class)
			continue;
		String decl = m.toString();
		//重複チェック 荒木さんの参考にしました。。。
		members.add(decl);
/*		System.out.print(" ");
		System.out.println(strip(decl, "java.lang."));*/
	}
	}
	private static void showMembers(){
		for (String s : members) {
		System.out.print(" ");
		System.out.println(strip(s, "java.lang."));
	}
	}

	//.… stripの定義.…
	public static String strip(String a, String b){
		String str = a.replace(b, "");
		return str;
	}

}
