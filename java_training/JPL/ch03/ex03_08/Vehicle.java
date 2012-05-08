package ch03.ex03_08;

//final フィールドのidが存在するため、cloneできない,変わりにコピーコンストラクタを用意する
public class Vehicle {

	static int nextId = 0;

	int speed = 0;
	int direction;
	String[] ownerName;
	public enum ANGLE{
		LEFT, RIGHT;
	}
	static final ANGLE TURN_LEFT = ANGLE.LEFT;
	static final ANGLE TURN_RIGHT = ANGLE.RIGHT;

	private final int id;

	{
		nextId++;
		id= nextId;
	}

	public Vehicle(String... ownerName){
		this.ownerName = ownerName;
	}

	public Vehicle(){
	}
	public int getSpeed() {
		return speed;
	}

	public void changeSpeed(int speed) {
		this.speed = speed;
	}

	public void stop(){
		this.speed = 0;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction % 360;
	}

	public  void turn(int angle){
		direction = (direction + angle)%360;
	}
	public void turn(ANGLE angle){

		switch(angle){
		 case LEFT:
		 	direction = (direction - 90 )%360;
		 	break;
		 case RIGHT:
			direction = (direction + 90)%360;
		}
	}

	public String[] getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String... ownerName) {
		this.ownerName = ownerName;
	}

	public int getId() {
		return id;
	}
	public String toString(){
		String str =  "id: "+ id
		+"\ndirection: " + direction + "\nowner name:";
		for(int i = 0; i < ownerName.length; i++)
		str += " " +ownerName[i];
		str += "\nspeed: " + speed;
		return str;
	}
	public Vehicle(Vehicle vehicle){
		this.direction = vehicle.direction;
		this.ownerName = vehicle.ownerName;
		this.speed = vehicle.speed;
	}




}
