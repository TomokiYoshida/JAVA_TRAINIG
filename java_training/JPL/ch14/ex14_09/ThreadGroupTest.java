package ch14.ex14_09;
/**
 * スレッドグループを引数に取り、そのグループ内のスレッドとスレッドグループの階層を定期
的に表示するスレッドを開始するメソッドを書きなさい。そのメソッドを、様々なグループ内でいくつかの短
命なスレッドを生成するプログラムでテストしなさい。
 * @author tom
 *
 */
public class ThreadGroupTest implements Runnable{

	public static void main(String[] args){
		ThreadGroupTest tgt = new ThreadGroupTest();

		ThreadGroup tg1 = new ThreadGroup("tg1");
		ThreadGroup tg2 = new ThreadGroup("tg2");
		Thread t1_1 = new Thread(tg1, tgt.new MyRunnable2(2000), "t11");
		Thread t1_2 = new Thread(tg1, tgt.new MyRunnable2(5000), "t22");
		Thread t1_3 = new Thread(tg1, tgt.new MyRunnable2(8000), "t33");
		Thread t2_1 = new Thread(tg2, tgt.new MyRunnable2(3000), "t21");
		Thread t2_2 = new Thread(tg2, tgt.new MyRunnable2(5000), "t22");
		Thread t2_3 = new Thread(tg2, tgt.new MyRunnable2(7000), "t23");
		t1_1.start();
		t1_2.start();
		t1_3.start();
		t2_1.start();
		t2_2.start();
		t2_3.start();
		Thread tx = new Thread(tg1,tgt.new MyRunnable(tg1), "tx");
		Thread ty = new Thread(tg2,tgt.new MyRunnable(tg2), "ty");
		tx.start();
		ty.start();
	}
	public void run(){
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){

		}
	}

	public static void showThreadGroup(ThreadGroup tg){
		System.out.println("parent group:" + tg.getParent().getName());
		System.out.println("group:" + tg.getName());

		Thread[] list = new Thread[255];
		int length = tg.enumerate(list, false);
		if(list == null  || list.length == 0)return;

		for(int i =0; i < length; i++){
			System.out.println(list[i].getName());
		}

	}
	public class MyRunnable implements Runnable {
		ThreadGroup tg = null;
		MyRunnable(ThreadGroup tg){
			this.tg = tg;
		}
		public void run(){
			while(true){
				try{
					showThreadGroup(tg);
					Thread.sleep(1000);
				}catch(InterruptedException e){

				}
			}
		}

	}
	public class MyRunnable2 implements Runnable {
		long time = 0;
		MyRunnable2(long time){
			this.time = time;
		}
		public void run(){
				try{
					Thread.sleep(time);
				}catch(InterruptedException e){

				}
		}

	}

}
