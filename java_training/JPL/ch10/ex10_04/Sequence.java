package ch10.ex10_04;

/**
 * maxまでの素数を出力する
 * @author tomoki
 *
 */
class Sequence {

	//一度だけ使用したいときはdo whileを使用する。
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
		int i = 2;
		while(i < max) {
			//倍数は全て素数でないので除去
			if(primeList[i-1]){
				for(int j = 2; i*j < max + 1; j++){
					primeList[i*j-1] = false;
				}
			}
			i ++;
		}
		//素数を表示
		while(i < max){
			if(primeList[i]){
				System.out.println(i+1);
			}
			i++;
		}




	}

}
