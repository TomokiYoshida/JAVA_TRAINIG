package ch04.ex04_02;

public class SimpleSortInt implements SortHarness<Integer[]>{

	private Integer[] values;

	public Integer[] sort(Integer[] data){
		values = data;
		doSort();
		return values;
	}
	protected int compare(int i, int j){
		return  ((Integer)values[i] < (Integer)values[j] ? -1: 1);
	}
	protected void swap(int i, int j){
		Integer tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	protected void doSort(){
		for(int i = 0; i < values.length; i++){
			for(int j = i + 1; j < values.length; j++){
				if(compare(i, j) > 0)
					swap(i, j);
			}
		}
	}
	
}
