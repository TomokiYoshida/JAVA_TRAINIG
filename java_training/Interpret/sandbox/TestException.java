package sandbox;

public class TestException {

	public String publicField = "public field";
    String packageField  = "packgae field";
	protected String protectedField = "protected field";
	private String privateField = "private field";
	public static String publicStaticField = "public static field";
	static String packageStaticField  = "packgae static field";
	protected static String protectedStaticField = "protected static field";
	private static String privateStaticField = "private static field";

	public void publicMethod(){
		System.out.println("public method");
	}
	public void publicMethodStr(String str){
		System.out.println("public method:" + str);
	}
	void packageMethod()throws Exception{
		System.out.println("-->package method with Exception");
		throw new Exception("-->exception");
	}
	void packageMethodStr(String str){
		System.out.println("-->package method:" + str);
	}
	protected void protectedMethod(){
		System.out.println("-->protected method");
	}
	protected void protectedMethodStr(String str){
		System.out.println("-->protected method:" + str);
	}
	private void privateMethod(){
		System.out.println("-->private method");
	}
	private void privateMethodStr(String str){
		System.out.println("-->private method:" + str);
	}
	public static void publicStaticMethod(){
		System.out.println("-->public method");
	}
	public static void publicStaticMethodStr(String str){
		System.out.println("-->public static method:" + str);
	}
	static  void packageStaticMethod(){
		System.out.println("-->package static method");
	}
	static void packageStaticMethodStr(String str){
		System.out.println("-->package static method:" + str);
	}
	protected static void protectedStaticMethod(){
		System.out.println("-->protected static method");
	}
	protected static void protectedStaticMethodStr(String str){
		System.out.println("-->protected static method:" + str);
	}
	private static  void privateStaticMethod(){
		System.out.println("-->private static method");
	}
	private static void  privateStaticMethodStr(String str){
		System.out.println("-->private static method:" + str);
	}


}
