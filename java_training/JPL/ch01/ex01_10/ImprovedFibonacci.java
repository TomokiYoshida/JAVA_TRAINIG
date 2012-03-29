package ch01.ex01_10;

class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		Value[] values = new Value[MAX_INDEX];
		int index = 1;
		values[0] = new Value(lo, false);
		for( int i = 2; i <= MAX_INDEX; i++ ){
			if(hi % 2 == 0)
				values[index] = new Value(hi, true);
			else
				values[index] = new Value(hi, false);
			index ++;
			hi = lo + hi;
			lo = hi - lo;
		}
		for(int i = 0; i < MAX_INDEX; i ++){
			if(values[i].getIsEven())
				System.out.println(i + ": " +values[i].getValue() + " *");
			else
				System.out.println(i + ": " +values[i].getValue() + "");
		}
	}
}
