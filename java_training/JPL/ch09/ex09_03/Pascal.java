package ch09.ex09_03;

public class Pascal {


	static void showPascalTriangle(int x){
		int[][] pascalArray = new int[x][];
		int[] length = new int[x];
		for(int i = 0; i < x; i ++){
			length[i] = i + 1;
			pascalArray[i] = new int[i+1];
		}
		for(int j = 0; j < x; j++){
			for(int i = 0; i < length[j]; i ++){
				if(i == 0 || i == length[j] -1 ){
					pascalArray[j][i] = 1;
				}
				else
				pascalArray[j][i] = pascalArray[j-1][i-1] + pascalArray[j-1][i];
			}
		}
		for(int j = 0; j <x; j++){
			for(int i = 0; i < length[j]; i++){
				System.out.print(pascalArray[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		System.out.println("1列");
		showPascalTriangle(1);
		System.out.println("5列");
		showPascalTriangle(5);
		System.out.println("12列");
		showPascalTriangle(12);
	}

}
