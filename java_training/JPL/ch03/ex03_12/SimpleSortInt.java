package ch03.ex03_12;

public class SimpleSortInt extends SortHarness{
	protected int compare(int i, int j){
		return  ((Integer)values[i] < (Integer)values[j] ? -1: 1);
	}


}
