package ch03.ex03_12;

public class TestSort {

	static Integer[] testData = {
						3,5,6,2,1,8
						};
	public static void main(String[] args){
		SortHarness bsort = new SimpleSortInt();
		Integer[] sorted = (Integer[])bsort.sort(testData);
		for(int i = 0; i < testData.length; i++)
			System.out.println("\t" + sorted[i]);
	}

}
