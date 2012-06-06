package ch09.ex09_02;

public class Bit {

	public static void main(String[] args){
		int a = 8;
		int count = 0;

		System.out.print("bit:");
		while(a != 0){
			if(a%2 == 1){
				count++;
				a = (a-1)/2;
				System.out.print(1 + " ");
			}
			else{
				a = a/2;
				System.out.print(0 + " ");
			}
		}
		System.out.println();
		System.out.println(count);
	}

}
