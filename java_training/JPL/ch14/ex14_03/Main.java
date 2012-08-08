package ch14.ex14_03;

public class Main implements Runnable{
	static Addition a = new Addition();
	public static void main(String[] args){

		Main main = new Main();
		Thread thread1 = new Thread(main);
		thread1.start();
		for(int i = 0; i < 10; i ++){
			a.addValue(100);
		}
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++){
			a.addValue(100);
		}

	}

}
