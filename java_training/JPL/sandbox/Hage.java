package sandbox;
/**
 * Babbleを複数回実行して、結果を調べなさい。常に同じ結果ですか。可能なら、異なるシステム
 * @author tom
 *
 */
public class Hage implements Runnable{

	static Integer integer = new Integer(0);
	public static void main(String[] args){
		Hage hage = new Hage();
		Thread t1 = new Thread(hage);
		t1.start();
		for(int i = 0 ; i < 10000; i ++){
			integer +=1;
		System.out.println(integer);
		}
	}

	public void run(){
		synchronized (integer) {
			for(int i = 0 ; i < 10000; i ++){
				integer++;
				System.out.println(integer);
			}
		}
	}
}
