package ch02.ex02_10;

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
	public static int getMaxId(){
		return nextId ;
	}

	public Vehicle(String ownerName){
	nextId++;
	id= nextId;
	this.ownerName = ownerName;
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

	public String toString(){
		return "id: "+ id
		+"\ndirection: " + direction
		+"\nowner name: " + ownerName
		+"\nspeed: " + speed;
	}

	public static void main(String[] args){
		Vehicle v1 = new Vehicle("hoge");
		v1.setDirection("west");
		v1.setSpeed(10);

		Vehicle v2 = new Vehicle("hogehoge");
		v2.setDirection("east");
		v2.setSpeed(20);

		System.out.println(v1);
		System.out.println(v2);
	}

}
