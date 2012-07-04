package ch13.ex13_02;

public class StringCount {


	public int count(String str, String target){

		int ix = str.indexOf(target);
		int length = target.length();
		if(ix < 0 )
			return 0;
		else{
			return count(str.substring(ix+ length),target) + 1;
		}
	}

	public static void main(String[] args){
		StringCount sc = new StringCount();
		System.out.println(sc.count("abcdefgabdcaaa","ab"));

		System.out.println(sc.count("a","a"));
		System.out.println(sc.count("b","a"));
	}

}
