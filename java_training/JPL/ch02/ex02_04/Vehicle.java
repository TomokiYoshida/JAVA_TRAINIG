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
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Vehicle.nextId = nextId;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getId() {
		return id;
	}

}
