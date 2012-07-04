package ch13.ex13_06;

public class SplitString {

	public static String split(String str, String kugiri, int splitSize){
		String ans = null;
		int index = str.length()%splitSize;
		if(index == 0)index=splitSize;
		ans = str.substring(0,  index);
		//1,234 index = 1
		for(int i = 0; index < str.length(); i++ ){
			ans += kugiri;
			ans += str.substring(index, index + splitSize);
			index += splitSize;
		}
		return ans;
	}
	public static void main(String[] args){
		String str = "1234567890123456789";
		System.out.println(split(str, "!", 2));
		System.out.println(split(str, "?", 4));
}
}
