package sandbox;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class SimpleClassDesc {

	public static void main(String[] args){
		String className = "java.io.FileNotFoundException";
		Class type = null;
		try{
			type = Class.forName(className);
		}catch(ClassNotFoundException e){
			System.err.println(e);
		}
		System.out.println("class " + type.getSimpleName());
		Class superclass = type.getSuperclass();
		if(superclass != null)
				System.out.println(" extends " + superclass.getCanonicalName());
		else System.out.println();

		Method[] methods = type.getDeclaredMethods();
		for(Method m : methods)
			if(Modifier.isPublic(m.getModifiers()))
				System.out.println(" " + m);
	}

}
