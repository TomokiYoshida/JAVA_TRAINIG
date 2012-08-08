import java.awt.Frame;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Reflection {

	/**
	 * classの有無を確認
	 */
	public static void  classNameExists(String className) throws ClassNotFoundException{
		Class  clazz = Class.forName(className);
	}
	static Map<String, String> primitiveWrapperMap = new HashMap<String, String>();
	static Map<String, Class> primitiveClassMap = new HashMap<String, Class>();
	static{
		primitiveWrapperMap.put("byte", "java.lang.Byte");
		primitiveWrapperMap.put("short", "java.lang.Short");
		primitiveWrapperMap.put("int", "java.lang.Integer");
		primitiveWrapperMap.put("long", "java.lang.Long");
		primitiveWrapperMap.put("float", "java.lang.Float");
		primitiveWrapperMap.put("double", "java.lang.Doublle");
		primitiveWrapperMap.put("char", "java.lang.Character");
		primitiveWrapperMap.put("boolean", "java.lang.Boolean");

		primitiveClassMap.put("byte", byte.class);
		primitiveClassMap.put("short", short.class);
		primitiveClassMap.put("int", int.class);
		primitiveClassMap.put("long", long.class);
		primitiveClassMap.put("float", float.class);
		primitiveClassMap.put("double", double.class);
		primitiveClassMap.put("char", char.class);
		primitiveClassMap.put("boolean", boolean.class);
	}


	public static boolean updateField(Object object ,String className, String paramType, String paramName, String paramValue)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, SecurityException, NoSuchFieldException{

		if(paramValue == null || paramValue.equals("") || paramValue.length() == 0 || paramValue == null)return false;

			Object  value;
			Class objClass = Class.forName(className);
			Class paramClass;
			//mapにオブジェクトがあるか確認
			Object obj = InterpretTabPanel .objMap.get(paramValue);
			if(obj != null){
				paramClass = Class.forName(paramType);
				value = obj;
			}else{
				if(primitiveWrapperMap.get(paramType) != null){
					paramClass = primitiveClassMap.get(paramType);
					// int -> Integer
					Class wrapperClass = Class.forName( primitiveWrapperMap.get(paramType));
					//Integer x = new Integer("10");
					Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValue);
					//Integer.intValue();
					Method m  = wrapperObj.getClass().getMethod(paramType + "Value", null );
					m.setAccessible(true);
					value =	m.invoke(wrapperObj, null);
				}else{
					paramClass = Class.forName(paramType);
					Constructor constructor = paramClass.getConstructor(String.class);
					constructor.setAccessible(true);
					value = constructor.newInstance(paramValue);
				}
			}
			Field f = object.getClass().getDeclaredField(paramName);
			f.setAccessible(true);
			f.set(object, value);
			return true;
	}

	/***
	 * メソッドを実行
	 * @param object
	 * @param methodName
	 * @param params
	 * @param paramValues
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 */
	public static void executeMethod(Object object , String methodName, String[] params, String[] paramValues)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{

		if(params == null )return;
		Class[] paramClasses = new Class[params.length];
		Object[] values  = new Object[params.length];
		for(int i = 0; i < params.length; i ++){
			Object obj = InterpretTabPanel .objMap.get(paramValues[i]);
			if(obj != null){
				paramClasses[i] = Class.forName(params[i]);
				values[i] = obj;
			}else{
				if(primitiveWrapperMap.get(params[i]) != null){
					paramClasses[i] = primitiveClassMap.get(params[i]);
					// int -> Integer
					Class wrapperClass = Class.forName( primitiveWrapperMap.get(params[i]));
					//Integer x = new Integer("10");
					Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
					//Integer.intValue();
					Method m  = wrapperObj.getClass().getMethod(params[i] + "Value", null );
					m.setAccessible(true);
					values[i]  =	m.invoke(wrapperObj, null);;
					}else{
					paramClasses[i] = Class.forName(params[i]);
					Constructor constructor = paramClasses[i].getConstructor(String.class);
					constructor.setAccessible(true);
					values[i] = constructor.newInstance(paramValues[i]);
				}
			}
		}
		Method m = object.getClass().getMethod(methodName, paramClasses);
		m.setAccessible(true);
		m.invoke(object, values);
	}

	/**
	 * コンストラクタ引数ありで生成
	 * @param className
	 * @param params
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Object generateObject(String className, String[] params, String[] paramValues)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
		Class  clazz = Class.forName(className);
		if(params == null || params.length == 0)return null;
		Class[] paramClasses = new Class[params.length];
		Object[] values  = new Object[params.length];
		for(int i = 0; i < params.length; i ++){
			Object obj = InterpretTabPanel .objMap.get(paramValues[i]);
			if(obj != null){
				paramClasses[i] = Class.forName(params[i]);
				values[i] = obj;
			}else{
				if(primitiveWrapperMap.get(params[i]) != null){
					paramClasses[i] = primitiveClassMap.get(params[i]);
					// int -> Integer
					Class wrapperClass = Class.forName( primitiveWrapperMap.get(params[i]));
					//Integer x = new Integer("10");
					Object wrapperObj = wrapperClass.getConstructor(String.class).newInstance(paramValues[i]);
					//Integer.intValue();
					values[i] =wrapperObj.getClass().getMethod(params[i] + "Value", null ).invoke(wrapperObj, null);
				}else{
					paramClasses[i] = Class.forName(params[i]);
					Constructor constructor = paramClasses[i].getConstructor(String.class);
					constructor.setAccessible(true);
					values[i] = constructor.newInstance(paramValues[i]);
				}
			}
		}
		Constructor con = clazz.getConstructor(paramClasses);
		con.setAccessible(true);
		return con.newInstance(values);
	}

	/**
	 * コンストラクタ引数なしで生成
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Object generateObject(String className)throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		Class  clazz = Class.forName(className);
		return clazz.newInstance();
	}

	public static String[][] getFieldList(Object object , String className)throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
		Class  clazz = Class.forName(className);
		Field[] fields = clazz.getDeclaredFields();
		if(fields == null || fields.length == 0){
			return null;
		}
		String[][] list = new String[fields.length][3];
		String[] nameList = new String[fields.length];
		String[] typeList = new String[fields.length];
		String[] valueList = new String[fields.length];
		for(int i = 0; i < fields.length; i++){
			Field f = fields[i];
			f.setAccessible(true);
				nameList[i] = f.getName();
				Class fieldType = f.getType();
				typeList[i] =  fieldType.getCanonicalName();
				Object value = f.get(object);
				if(value != null){
					valueList[i] = value.toString();
				}
		}
		String[] sorted = Util.sort(nameList);
		int[] indexMap = Util.sortIndex(nameList);
		String[] sortedTypeList = Util.sortObject(typeList, indexMap);
		String[] sortedValueList = Util.sortObject(valueList, indexMap);
		for(int i = 0 ; i < sorted.length; i++){
			list[i][0] = sortedTypeList[i];
			list[i][1] = sorted[i];
			list[i][2] = sortedValueList[i];
		}
		return list;
	}

	public static String[] getMethodParamList(String className, int methodIndex)throws ClassNotFoundException{
		Class  clazz = Class.forName(className);
		Method[] methods = clazz.getMethods();
		if(methods == null || methods.length == 0){
			return null;
		}
		String[] list = new String[methods.length];
		for(int i = 0; i < methods.length; i++){
			Method m = methods[i];
				list[i] = m.getName() + "(";
				Class[] params = m.getParameterTypes();
				if(params == null || params.length == 0){

				}else{
					for(int j = 0 ; j < params.length; j++){
						if(j != 0)list[i]+= ",";
						list[i] += params[j].getCanonicalName();
					}
				}
				list[i] += ")";
			}

		Method  m = methods[Util.deSortIndex(list)[methodIndex]];
		Class[] params = m.getParameterTypes();
		String[] methodParams = null;
		if(params == null || params.length == 0){
			return methodParams;
		}else{
			methodParams = new String[params.length];
			for(int j = 0 ; j < params.length; j++){
				methodParams[j] = params[j].getCanonicalName();
			}
			return methodParams;
		}
	}

	public static String[] getMethodList(String className)throws ClassNotFoundException{
		Class  clazz = Class.forName(className);
		Method[] methods = clazz.getMethods();
		if(methods == null || methods.length == 0){
			return null;
		}
		String[] list = new String[methods.length];
		for(int i = 0; i < methods.length; i++){
			Method m = methods[i];
				list[i] = m.getName() + "(";
				Class[] params = m.getParameterTypes();
				if(params == null || params.length == 0){

				}else{
					for(int j = 0 ; j < params.length; j++){
						if(j != 0)list[i]+= ",";
						list[i] += params[j].getCanonicalName();
					}
				}
				list[i] += ")";
			}

		return Util.sort(list);
	}

	/**コンストラクタのリストを返す
	 *
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
		public static String[] getConstructorParamList(String className, int index)throws ClassNotFoundException{
			Class  clazz = Class.forName(className);
			Constructor[] constructors = clazz.getConstructors();
			if(constructors == null || constructors.length == 0 ){
				return null;
			}
			String[] list = new String[constructors.length];
			for(int i = 0; i < constructors.length; i++){
				list[i] = constructors[i].getName() + "(";
				Class[] params = constructors[i].getParameterTypes();
				if(params == null || params.length == 0 ){
				}
				else{
					for(int j = 0; j < params.length; j++){
						if(j != 0)list[i] += ",";
						list[i] += params[j].getCanonicalName();
					}
				}
				list[i] += ")";
			}
				String[] result = null;
				Class[] params = constructors[Util.deSortIndex(list)[index]].getParameterTypes();
				if(params == null || params.length == 0 ){
						return null;
				}
				else{
					result = new String[params.length];
					for(int j = 0; j < params.length; j++){
						result[j] = params[j].getCanonicalName();
					}
				}
				return result;
		}

	/**コンストラクタのリストを返す
	 *
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
		public static String[] getConstructorList(String className)throws ClassNotFoundException{
			Class  clazz = Class.forName(className);
			Constructor[] constructors = clazz.getConstructors();
			if(constructors == null || constructors.length == 0 ){
				return null;
			}
			String[] list = new String[constructors.length];
			for(int i = 0; i < constructors.length; i++){
				list[i] = constructors[i].getName() + "(";
				Class[] params = constructors[i].getParameterTypes();
				if(params == null || params.length == 0 ){
				}
				else{
					for(int j = 0; j < params.length; j++){
						if(j != 0)list[i] += ",";
						list[i] += params[j].getCanonicalName();
					}
				}
				list[i] += ")";
			}
			return Util.sort(list);
		}
		public static void main(String[] args){
			try{
			String className = "java.awt.Frame";
			String[]	list = getConstructorList("java.awt.Frame");
			//String[]	list = getConstructorList("java.lang.String");
			for(int i = 0; i < list.length; i++){
				//System.out.println(list[i]);
			}
			list = getMethodList(className);
			for(int i = 0; i < list.length; i++){
				System.out.println(list[i]);
			}
			String[][] slist = getFieldList(null,className);
			for(int i = 0; i < slist.length; i++){
				//System.out.println(slist[i][0]);
				//System.out.println(slist[i][1]);
			}
			String className2 = "Test";
			String[] params = {"java.lang.String"};
			String[] paramValues = {"test"};
			Test test = (Test)generateObject(className2, params, paramValues);
			String className3 = "Test";
			String[] params2 = {"int"};
			String[] paramValues2 = {"10"};
			Test test2 = (Test)generateObject(className3, params2, paramValues2);
			}catch(Exception e){
				e.printStackTrace();
			}
		}


	}

