package ch14.ex14_02;

import java.awt.PrintJob;

public class PrintServer implements Runnable{

	private final PrintQueue requests = new PrintQueue();
	private final Thread mainThread;
	public PrintServer(){
			new Thread(this).start();
			mainThread = Thread.currentThread();
			mainThread.setName("main");
	}
	public void print(PrintJob job){
		requests.add(job);
	}
	public void run(){
		if(Thread.currentThread() != mainThread){
			System.out.println("not main thread : thread name:" + Thread.currentThread().getName());
			return;
		}
		System.out.println("print start : thread name:" + Thread.currentThread().getName());
		try{
		for(;;)
			realPrint(requests.remove());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	private void realPrint(PrintJob job){
		System.out.println("printing");
		//印刷の実際の処理
	}

	public static void main(String[] args){
		PrintServer server = new PrintServer();
		server.print(null);
		server.run();
	}

}
