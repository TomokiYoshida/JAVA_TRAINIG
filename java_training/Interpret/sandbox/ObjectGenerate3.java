package sandbox;
import java.awt.Frame;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ObjectGenerate3{

	public static void main(String[] args){
		ObjectGenerate3 og2 = new ObjectGenerate3();
		og2.generateObject("TestException");
	}
		public void generateObject(String className){
			Class type = null;
		try{
			type = Class.forName(className);
		}catch(ClassNotFoundException e){
			System.err.println(e);
		}
//		Frame frame = new Frame();
//		frame.setVisible(true);
		try{
			type.newInstance();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}
		System.out.println("class " + type.getSimpleName());
		Class superclass = type.getSuperclass();
		if(superclass != null)
				System.out.println(" extends " + superclass.getCanonicalName());
		else System.out.println();

		Object object = null;
		try{
			object = type.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		//methodの表示
		Method[] methods = type.getDeclaredMethods();
		System.out.println("--------------------method");
		for(Method m : methods){
			System.out.print(m.getName());
			m.setAccessible(true);
			if( m.isAccessible()) {
				Class[] params = m.getParameterTypes();
				try{
					if(params == null  || params.length == 0){
						//引数なしメソッドの実行
						m.invoke(object, null);
					}else{//引数ありメソッドの実行
							Object[] paramsObjList = new Object[params.length];
							for(int i =0; i < params.length; i++){
								paramsObjList[i] = params[i].newInstance();
							}
							m.invoke(object, paramsObjList);
						for(int i = 0; i < params.length; i++){
							System.out.println(params[i].getCanonicalName());
						}
					}
				}catch(InstantiationException e){
					e.printStackTrace();
				}catch(InvocationTargetException e){
					e.printStackTrace();
				}catch(IllegalAccessException e){
					e.printStackTrace();
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		}
		System.out.println("--------------------end");
		Field[] fields = type.getDeclaredFields();
		try{
			for(Field f : fields){
				 f.setAccessible(true);
				 System.out.println(f.get(object));
				System.out.println(" " + f);
				f.set(object, "test");
			}
			for(Field f : fields){
				 System.out.println(f.get(object));
			}

/*		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(InvocationTargetException e){
			e.printStackTrace();
	*/	}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		}
}

