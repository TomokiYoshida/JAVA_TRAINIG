package ch13.ex13_05;

public class SplitString {

	public static String split(String str){
		String ans = null;
		int splitSize = 3;
		int index = str.length()%splitSize;
		if(index == 0)index=splitSize;
		ans = str.substring(0,  index);
		//1,234 index = 1
		for(int i = 0; index < str.length(); i++ ){
			ans += ",";
			ans += str.substring(index, index + splitSize);
			index += splitSize;
		}
		return ans;
	}
	public static void main(String[] args){
		String str = "1234567890123456789";
		System.out.println(split(str));
		str = "1234";
		System.out.println(split(str));
		str = "123";
		System.out.println(split(str));
		str = "1";
		System.out.println(split(str));
		str = "12";
		System.out.println(split(str));
	}
}
