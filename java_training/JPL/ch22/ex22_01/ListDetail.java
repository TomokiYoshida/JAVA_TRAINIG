package ch22.ex22_01;
/**
 *浮動小数点値の配列と、何列使用するかを指定する数字を受け取り、配列の内容を表示するメ
ソッドを書きなさい。各列のエントリーが綺麗に整列することを保証するようにしなさい。1行は80文字と
想定してください。
p557
 * @author tom
 *
 */
public class ListDetail {

	public static void showDouble(double[] list, int length){

		if(list == null || list.length == 0)return;
		String format = "%-#80." + length+"f%n";
		for(int i = 0; i < list.length; i++)
		System.out.printf(format, list[i]);

	}

	public static void main(String[] args){
/*
		System.out.println("The value of Math.PI is " +  Math.PI );
		int val = 32;
		System.out.printf("%0#10x %n", val);
		System.out.printf("%#10x %n", val);
		System.out.printf("%#5x %n", val);
		System.out.printf("%#x %n", val);
		System.out.printf("%3$d %d %2$d %<d %d %n", 1, 2, 3);
		System.out.printf("The value of Math.PI is %.3f %n" ,  Math.PI );*/


		double[] list = {1.2345678901234567890, 1.234242340522424232424};

		showDouble(list,10);
	}



}
