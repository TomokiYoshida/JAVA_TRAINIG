package sandbox;

public class Hoya extends Hoge {
	public int c = 1;

	int getC(){
		return c;
	}

	public static void main(String[] args){
		Hoge hoya = new Hoya();
		int i = hoya.c;
		System.out.println(i);
		Hoya hoya2 = new Hoya();
		i = hoya2.c;
		System.out.println(i);

		//メソッドはオーバライドされる
		System.out.println(hoya.getC());
		System.out.println(hoya2.getC());
	}

}
