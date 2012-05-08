package ch03.ex03_01;

public class Vehicle {

	private static int nextId = 0;

	private int speed = 0;
	private int direction;
	private String[] ownerName;
	public enum ANGLE{
		LEFT, RIGHT;
	}
	public static final ANGLE TURN_LEFT = ANGLE.LEFT;
	public static final ANGLE TURN_RIGHT = ANGLE.RIGHT;

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

	public  final void turn(int angle){
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

	public static void main(String[] args){
		Vehicle v1 = new Vehicle(args);
		String[] ownerList = v1.ownerName;
		if(ownerList == null || ownerList.length == 0){
			return;
		}
		else{
			for(int i = 0; i < ownerList.length; i++){
				System.out.println(ownerList[i]);
			}
		}

		v1.turn(Vehicle.TURN_LEFT);
		System.out.println("angle = " + v1.getDirection());
		v1.turn(Vehicle.TURN_RIGHT);
		System.out.println("angle = " + v1.getDirection());
		v1.turn(180);
		System.out.println("angle = " + v1.getDirection());

	}


}
