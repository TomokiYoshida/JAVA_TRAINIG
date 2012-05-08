package ch04.ex04_02;

public class TestSort {

	static Integer[] testData = {
						3,5,6,2,1,8
						};
	public static void main(String[] args){
		SortHarness<Integer[]> bsort = new SimpleSortInt();
		Integer[] sorted = (Integer[])bsort.sort(testData);
		for(int i = 0; i < testData.length; i++)
			System.out.println("\t" + sorted[i]);
	}

}
