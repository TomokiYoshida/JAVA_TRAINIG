package sandbox;
import java.awt.Frame;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ObjectGenerate4 {

	public static void main(String[] args){
//		String className = "java.awt.Frame";
		String className = "Test";
			Class clazz = null;
		try{
			clazz = Class.forName(className);
			Object instance = clazz.newInstance();
			instance.getClass().getMethod("publicMethod", null).invoke(instance, null);
		}catch(ClassNotFoundException e){
			System.err.println(e);
		}catch(IllegalAccessException e){
			System.err.print(e);
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	}

