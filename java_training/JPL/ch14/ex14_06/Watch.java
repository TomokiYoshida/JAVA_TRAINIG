package ch14.ex14_06;


/**15秒間隔でメッセージを表示する別のスレッドを持ち、実行開始からの経過時間を表示する
プログラムを作成しなさい。メッセージ表示スレッドは、時間表示スレッドから1秒経過するごとに通知さ
れるようにしなさい。時間表示スレッドを修正することなく、7秒間隔で異なるメッセージを表示する別のス
レッドを追加しなさい。
**/
public class Watch implements Runnable {

	private static long time = 0;
	private static long interval = 15;
	private static Object lock = new Object();
	private static boolean flag = true;
	public Watch(){
		Thread t1 = new Thread(this);
		t1.start();
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
	}
	public static void main(String[] args){
		new Watch();

	}

	public  synchronized void showMessage(){
		while(flag){
			try{
				wait();
			}catch(InterruptedException e){

			}
		}
		System.out.println("message: "  + time + "seconds.");
		flag = true;
	}
	public  synchronized void showTime(){
		flag = false;
		notifyAll();
	}


	public void run() {
		while(true){
			showMessage();

		}
	}
	 public class MyRunnable implements Runnable{
		 public void run(){
			 while(true){
				 try{
					 //System.out.println(time);
					 if((time % interval) == 0){
						 showTime();
					 }
					 Thread.sleep(1000);
					 time ++;
				 }catch(InterruptedException e){
				 }
			 }
		 }
	 }

}
