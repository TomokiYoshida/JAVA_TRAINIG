package sandbox;
import java.awt.Frame;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ObjectGenerate {

	public static void main(String[] args){
//		String className = "java.awt.Frame";
		String className = "Test";
			Class type = null;
		try{
			type = Class.forName(className);
		}catch(ClassNotFoundException e){
			System.err.println(e);
		}
//		Frame frame = new Frame();
//		frame.setVisible(true);
		System.out.println("class " + type.getSimpleName());
		Class superclass = type.getSuperclass();
		if(superclass != null)
				System.out.println(" extends " + superclass.getCanonicalName());
		else System.out.println();

		//methodの表示
		Method[] methods = type.getDeclaredMethods();
		System.out.println("--------------------public method");
		for(Method m : methods)
			if(Modifier.isPublic(m.getModifiers()))
				System.out.println(" " + m);
		System.out.println("--------------------end");
		Field[] fields = type.getDeclaredFields();
		for(Field f : fields)
				System.out.println(" " + f);
		}
	}

