package ch16.ex16_02;

import java.lang.reflect.*;

/**
 * 指定された型がネストした型かを示し、ネストした型ないどの型の中にネストしているかを示すようにTypeDescを修正しなさい。
 *
 * @author tom
 */
public class TypeDesc {
	public static void main(String[] args) {
		String[] rgs = { "ch16.ex16_02.HogeHoge" };
		args = rgs;
		TypeDesc desc = new TypeDesc();
		for (String name : args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e); // report the error
			}
		}
	}

	// デフォルトで標準出力に表示する
	private java.io.PrintStream out = System.out;
	// 型名にラベル付けするprintType ()で使用される
	private static String[] basic = { "class", "interface", "enum",
			"annotation" }, supercl = { "extends", "implements" }, iFace = {
			null, "extends" };

	private void printType(Type type, int depth, String[] labels) {
		if (type == null)// 再帰呼び出し停止:スーパータイプが存在しない
			return;
		// TypeをClassオブジェクトに変換する
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>) ((ParameterizedType) type).getRawType();
		else
			throw new Error("Unexpected non- class type");

		Object obj = new Object();
		if (cls.getGenericSuperclass() == null) {
			if (!cls.isInterface())
				return;
		}
		// この型を表示
		for (int i = 0; i < depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3 : cls.isEnum() ? 2 : cls
				.isInterface() ? 1 : 0;
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		if (cls.getEnclosingClass() != null) {
			out.print(" enclosed : " + cls.getEnclosingClass().getName());
		}
		// あれば、ジェネリック型パラメータを表示
		TypeVariable<?>[] Params = cls.getTypeParameters();
		if (Params.length > 0) {
			out.print('く');
			for (TypeVariable<?> param : Params) {
				out.print(param.getName());
				out.print(", ");
			}
			out.println("\b\b>");
		} else
			out.println();
		// このクラスが実装しているすべてのインタフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface : interfaces) {
			printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
		}
		// スーパークラスに対して再帰
		printType(cls.getGenericSuperclass(), depth + 1, supercl);
	}

	public static class Hoge {

	}
}