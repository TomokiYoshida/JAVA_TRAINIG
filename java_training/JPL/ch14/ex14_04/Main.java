package ch14.ex14_04;

public class Main implements Runnable{

	public static void main(String[] args){

		Main main = new Main();
		Thread thread1 = new Thread(main);
		thread1.start();
		for(int i = 0; i < 100; i ++){
			Addition.addValue(100);
		}
	}
	@Override
	public void run() {
		for(int i = 0; i < 100; i ++){
			Addition.addValue(100);
		}

	}

}
