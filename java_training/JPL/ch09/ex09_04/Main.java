package ch09.ex09_04;

public class Main {

	public static void main(String[] args){

		//3 = 11 -> 3<<2L = 1100 =12 bit演算子のほうがあとに評価されるので6
		int a = 3 << 2L -1;
		System.out.println(a);

		//ビット演算を先に行う
		long b = (3L << 2) -1;
		System.out.println(b);

		// ?
		//10< 12 == 6 > 17;

		//? 1010 000000000000  00000000000000110
		// 10 << 12  = 6 >>17;
		double c = 13.5e-1 % Float.POSITIVE_INFINITY;
		System.out.println(c);

		double d = Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY;
		System.out.println(d);

		//NANなので一致しない
		double e = 0.0 / (-0.0);
		double f = -0.0 / 0.0;
		if(e == f)
		System.out.println("e==f");
		System.out.println(e);
		System.out.println(f);

		int g = Integer.MAX_VALUE + Integer.MIN_VALUE;
		System.out.println(g);

		long h = Long.MAX_VALUE + 5;
		System.out.println(h);

		byte j = (short) 5 * (byte) 10;
		System.out.println(j);

		int i = 3;
		double k  = (i < 15? 1.72e3f : 0);
		System.out.println(k);
		System.out.println(i+++i+++--i);

	}

}
