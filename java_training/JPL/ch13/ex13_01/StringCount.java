package ch13.ex13_01;

public class StringCount {


	public int count(String str, char ch){

		int ix = str.indexOf(ch);
		if(ix < 0 )
			return 0;
		else{
			return count(str.substring(ix+1),ch) + 1;
		}
	}

	public static void main(String[] args){
		StringCount sc = new StringCount();
		System.out.println(sc.count("abcdefgabdcaaa",'a'));

		System.out.println(sc.count("a",'a'));
		System.out.println(sc.count("b",'a'));
	}

}
