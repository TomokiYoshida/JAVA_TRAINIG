package ch03.ex03_11;

public class SimpleSortDouble extends SortDouble{
	static boolean flag = true;
	protected void doSort(){
		for(int i = 0; i < getDataLength(); i++){
			for(int j = i + 1; j < getDataLength(); j++){
				if(compare(i, j) > 0)
					swap(i, j);
			}
		}
		//sort内でもう一度sortを行うとメトリクスがリセットされる
	double[] testData = {
			0, 1, 2
			};
			if(flag){
				flag = false;
				sort(testData);
			}
	}
}
