package ch03.ex03_12;

import java.util.List;

abstract class SortHarness {
	protected Object[] values;
	public final Object[] sort(Object[] data){

		values = data;
		doSort();
		return values;
	}
	/**拡張したクラスが要素を比較するため*/
	protected abstract int compare(int i, int j);

	/**拡張したクラスが要素の数を知るため*/
	protected final int getDataLength(){
		return values.length;
	}

	/**拡張したクラスが要素を交換するため*/
	protected final void swap(int i, int j){
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	/**拡張したクラスが実装を変えることもできる*/
	protected void doSort(){
		for(int i = 0; i < getDataLength(); i++){
			for(int j = i + 1; j < getDataLength(); j++){
				if(compare(i, j) > 0)
					swap(i, j);
			}
		}
	}

}
