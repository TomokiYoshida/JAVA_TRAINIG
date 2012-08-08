package ch14.ex14_01;

public class Main {

	public static void main(String[] args){

		System.out.println(Thread.currentThread());
		Thread.currentThread().setName("test");
		System.out.println(Thread.currentThread());

	}


}
