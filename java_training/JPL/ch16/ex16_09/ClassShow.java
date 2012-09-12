package ch16.ex16_09;
import java.lang.reflect.*;

/**s指定されたクラスの完全な宣言を表示するプログラムをリフレクションを使用して作成しなさ
い。ただし、インポート文、コメント、それに、初期化子、コンストラクタ、メソッドのコードは除外します。
メンバー宣言は、ソースコードに書かれたように表示すべきです。今まで説明してきたすべてのリフレクショ
ンクラスを使用する必要があるでしょう。多くのリフレクションオブジェクトのtoStringメソッドは、欲し
い情報を正しい形式で提供しませんので、個々の情報を集めてまとめる必要があります。*/
public class ClassShow{
	public static void main(String[]args){
		try{
			Class<?> c = Class.forName(args [0]);
			System.out.println(c);
			printMembers(c.getFields());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());
		} catch (ClassNotFoundException e){
			System.out.println("unknown class" + args[0]);
		}
	}
	private static void printMembers(Member[] mems) {
	for (Member m : mems) {
		if (m.getDeclaringClass() == Object.class)
			continue;
	String decl = m.toString();
	System.out.print(" ");
	System.out.println(strip(decl, "java.lang."));
	}
	}
	//.… stripの定義.…
	public static String strip(String a, String b){
		return a + b;
	}

}
