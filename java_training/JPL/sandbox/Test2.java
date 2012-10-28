package sandbox;

public class Test2 {

	public static void main(String[] args){
		short x = -10;
		for(int i =0 ; i< 10; i++){
			x>>>= 1;
			System.out.println(Integer.toBinaryString(x));
			//最終的に-1に
		}

	}

}
