package ch22.ex22_05;
/**
 *6面サイコロの個数が指定されると、可能性のある合計値ごとの理論的確率を計算できます。
たとえば、2個の6面サイコロでは、合計が7になる確率は、1/6です。プログラムを作成して、特定の個数
の6面サイコロでの合計値の理論的分布を、1から6までの数を発生するRandomを使用して膨大な数のサイ
コロを「振った」結果と比較しなさい。どの乱数発生メソッドを使用するかは、問題となりますか。
 * @author tom
 * p565
 *
 */
public class Hoge {

	public void calc(){
		int total = (int)(Math.pow(6,  2));
		int[] rate = new int[total];

		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6 ; j++){
				rate[(i+1) + (j+ 1)-1]++;
			}
		}
		for(int i = 1; i < 12 ; i++){
			System.out.println((i + 1) +":" + rate[i] +  "/" + total);
		}
	}
	public void realDice(){
	int total = (int)(Math.pow(6,  2));
	int[] rate = new int[total];

	for(int i = 0; i < 10000; i ++){
	  int x = (int)(Math.random() * 6 );
	  int y = (int)(Math.random() * 6);
		rate[(x+1) + (y+ 1)-1]++;
	}
	for(int i = 1; i < 12 ; i++){
		System.out.println((i + 1) +":" + (double)rate[i]/10000);
	}
	}
	public static void main(String[] args){
			Hoge hoge = new Hoge();
			hoge.calc();
			hoge.realDice();
	}


}
