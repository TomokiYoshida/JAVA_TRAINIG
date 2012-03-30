package ch02.ex02_05;

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

	public static void main(String[] args){
		Vehicle v1 = new Vehicle();
		v1.setDirection("west");
		v1.setOwnerName("hoge");
		v1.setSpeed(10);

		Vehicle v2 = new Vehicle();
		v2.setDirection("east");
		v2.setOwnerName("hogehoge");
		v2.setSpeed(20);


		System.out.println("id: "+v1.id
							+"\ndirection: " + v1.direction
							+"\nowner name: " + v1.ownerName
							+"\nspeed: " + v1.speed
							);
		System.out.println("id: "+v2.id
				+"\ndirection: " + v2.direction
				+"\nowner name: " + v2.ownerName
				+"\nspeed: " + v2.speed
				);
	}

}
