package ch01.ex01_12;

class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;
		String[] values = new String[MAX_INDEX];
		values[0] = "1: " + lo;
		for( int i = 2; i <= MAX_INDEX; i++ ){
			if(hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			values[i-1] = i + ": " + hi + mark;
			hi = lo + hi;
			lo = hi - lo;

		}
		for(int i = 0; i < MAX_INDEX; i++){
			System.out.println(values[i]);
		}

	}

}
