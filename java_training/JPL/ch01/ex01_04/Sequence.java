package ch01.ex01_04;

/**
 * maxまでの素数を出力する
 * @author tomoki
 *
 */
class Sequence {

	public static void main(String[] args) {

		int max = 100;
		boolean[] primeList = new boolean[max];

		//2以下の場合はそのまま終了
		if(max < 2){
			return;
		}
		else{
			//全てtrueで初期化
			for(int i = 2; i < max; i++){
				primeList[i-1] = true;
			}
		}
		for(int i = 2; i < max; i ++){
			//倍数は全て素数でないので除去
			if(primeList[i-1]){
				for(int j = 2; i*j < max + 1; j++){
					primeList[i*j-1] = false;
				}
			}
		}
		//素数を表示
		for(int i = 1; i < max; i++){
			if(primeList[i]){
				System.out.println(i+1);
			}
		}




	}

}
