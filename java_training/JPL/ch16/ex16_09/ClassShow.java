package ch16.ex16_09;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;

/**指定されたクラスの完全な宣言を表示するプログラムをリフレクションを使用して作成しなさ
い。ただし、インポート文、コメント、それに、初期化子、コンストラクタ、メソッドのコードは除外します。
メンバー宣言は、ソースコードに書かれたように表示すべきです。今まで説明してきたすべてのリフレクショ
ンクラスを使用する必要があるでしょう。多くのリフレクションオブジェクトのtoStringメソッドは、欲し
い情報を正しい形式で提供しませんので、個々の情報を集めてまとめる必要があります。*/
public class ClassShow{

	private static Set<String> members = new HashSet<String>();


	public static void main(String[]args){
		String[] rgs = {"ch16.ex16_04.Sample"};
		args = rgs;
		try{
			Class<?> c = Class.forName(args [0]);
			int mod = c.getModifiers();
			if(Modifier.isPublic(mod))System.out.print("public ");
			else if(Modifier.isPrivate(mod))System.out.print("private ");
			else if(Modifier.isProtected(mod))System.out.print("protected ");
			if(Modifier.isStatic(mod))System.out.println("static ");
			if(Modifier.isFinal(mod))System.out.println("final ");
			System.out.println(strip(c.toString(), c.getPackage().getName() + "." ));
			showClassContents(c);
			showMembers(c.getPackage().getName());
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
		String decl = "";
		Annotation[] annotations = m.getAnnotations();
		if(annotations == null || annotations.length ==0){}
		else{
			for(int i = 0; i < annotations.length; i++){
				decl += annotations[i] + " ";
			}
		}
		decl += m.toString();
		members.add(decl);
	}
	}


	private static void printMembers(Method[] mems) {
	for (Method m : mems) {
		if (m.getDeclaringClass() == Object.class)
			continue;
		String decl = "";
		Annotation[] annotations = m.getAnnotations();
		if(annotations == null || annotations.length ==0){}
		else{
			for(int i = 0; i < annotations.length; i++){
				decl += annotations[i] + " ";
			}
		}
		decl += m.toString();
		members.add(decl);
	}
	}
	private static void printMembers(Constructor[] mems) {
	for (Constructor m : mems) {
		if (m.getDeclaringClass() == Object.class)
			continue;
		String decl  = "";
		Annotation[] annotations = m.getAnnotations();
		if(annotations == null || annotations.length ==0){}
		else{
			for(int i = 0; i < annotations.length; i++){
				decl += annotations[i] + " ";
			}
		}
		decl += m.toString();
		members.add(decl);
	}
	}

	private static void showMembers(String packageName){
		for (String s : members) {
		System.out.print(" ");
		System.out.println(strip(s, packageName + "."));
	}
	}

	//.… stripの定義.…
	public static String strip(String a, String b){
		String str = a.replace(b, "");
		return str;
	}
}

