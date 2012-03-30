package ch02.ex02_04;

public class Vehicle {

	static int nextId = 0;
	private int speed;
	private String direction;
	private String ownerName;

	//識別番号はインスタンスごとに一意なのでfinalとする
	private final int id;
	public Vehicle(){
		nextId++;
		id= nextId;
	}

}
