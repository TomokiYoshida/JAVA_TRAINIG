package ch22.ex22_06;

import java.util.Random;

/**
 *nextGaussianを検査するプログラムを作成して、膨大な数の呼び出し結果をグラフ(*文字
の棒グラフ)で表示しなさい。
 * @author tom
 * p565
 *
 */
public class Hoge {

	public static void main(String[] args){
		int number = 10000;
		Random ran = new Random();
		double[] values = new double[number];
		for(int i = 0 ; i < number; i ++)
			values[i] = ran.nextGaussian();

		for(double min = -1.00, max= -0.99; max < 1.0; min+=0.01, max+=0.01){
			System.out.printf("%.2f -> %.2f",min, max);
			for(int i = 0; i < number; i++){
				if(values[i] >= min && values[i] < max){
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
