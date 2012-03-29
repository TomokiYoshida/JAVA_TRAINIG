package ch01.ex01_09;

class Fibonacci {

	static final int MAX = 50;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int index = 1;
		int[] values = new int[MAX];
		values[0] = lo;
		while(hi < 50){
				values[index] = hi;
				index ++;
				hi = lo + hi; //新しいhi
				lo = hi - lo; /*新しいloは、(合計 - 古いlo)すなわち、古いlo*/
		}
		for(int i = 0; values[i] != 0; i ++){
			System.out.println(values[i]);
		}

	}

}
