package ch16.ex16_05;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 個々のメンバーに対して得られるアノテーション情報を含むようにClassContentsを拡張し
なさい。
 * @author tom
 *
 */
	public class ClassContents{

		private static Set<String> members = new HashSet<String>();


		public static void main(String[]args){
			String[] rgs = {"ch16.ex16_04.Sample"};
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
		private static void printMembers(Field[] mems) {
		for (Field m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){}
			else{
				for(int i = 0; i < annotations.length; i++){
//					System.out.println(annotations[i]);
					decl += " " + annotations[i];
				}
			}
			members.add(decl);
		}
		}
		private static void printMembers(Method[] mems) {
		for (Method m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){}
			else{
				for(int i = 0; i < annotations.length; i++){
//					System.out.println(annotations[i]);
					decl += " " + annotations[i];
				}
			}
			members.add(decl);
		}
		}
		private static void printMembers(Constructor[] mems) {
		for (Constructor m : mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			Annotation[] annotations = m.getAnnotations();
			if(annotations == null || annotations.length ==0){}
			else{
				for(int i = 0; i < annotations.length; i++){
//					System.out.println(annotations[i]);
					decl += " " + annotations[i];
				}
			}
			members.add(decl);
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
