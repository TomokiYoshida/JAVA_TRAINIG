package ch16.ex16_04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 16.4:指定された型に適用されていて得られるすべてのアノテーションを表示するプログラムを書き
なさい。(リテンションポリシーがRUNTIMEを持つアノテーションだけが得られます
 * @author tom
 *
 */
public class ShowAnnotation {

	public static void main(String[]args){
		String[] rgs = {"ch16.ex16_04.Sample"};
		args = rgs;
		try{
			Class<?> clazz = Class.forName(args [0]);
			System.out.println(clazz);
			//System.out.println(clazz.getAnnotations()
			dump(clazz.toString(), clazz.getDeclaredAnnotations());

			Constructor[] cs = clazz.getConstructors();
			if(cs == null || cs.length ==0){}
			else{
				for(int i = 0; i < cs.length; i++)
				dump(cs[i].getName(), cs[i].getDeclaredAnnotations());
			}
			Field[] fs = clazz.getDeclaredFields();
			if(fs == null || fs.length ==0){}
			else{
				for(int i = 0; i < fs.length; i++)
					dump(fs[i].getName(), fs[i].getDeclaredAnnotations());
			}
			Method[] ms = clazz.getDeclaredMethods();
			if(ms == null || ms.length ==0){}
			else{
				for(int i = 0; i < ms.length; i++){
					dump(ms[i].getName(), ms[i].getDeclaredAnnotations());
					Annotation[][] ma = ms[i].getParameterAnnotations();
					if(ma == null ||ma.length == 0 || ma[0] == null ){}
					else{
						for(int j = 0 ; j < ma.length; j++)
						dump("param" + j, ma[j]);
					}
				}
			}

		} catch (ClassNotFoundException e){
			System.out.println("unknown class" + args[0]);
		}
	}
	public static void dump(String message, Annotation[] as) {
		System.out.println(message);
		for (Annotation a : as) {
			System.out.println(a);
		}
	}
}
