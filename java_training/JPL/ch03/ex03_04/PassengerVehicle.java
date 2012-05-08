package ch03.ex03_04;

public class PassengerVehicle {

	private static int nextId = 0;

	private int speed = 0;
	private int direction;
	private String[] ownerName;
	private int sheetNumber = 0;
	private int useSheetNumber = 0;

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

	public PassengerVehicle(String... ownerName){
		this.ownerName = ownerName;
	}

	public PassengerVehicle(){
	}
	public PassengerVehicle(int sheetNumber, int useSheetNumber){
		this.sheetNumber = sheetNumber;
		this.useSheetNumber = useSheetNumber;

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

	public void turn(int angle){
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


	public int getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(int sheetNumber) {
		this.sheetNumber = sheetNumber;
	}

	public int getUseSheetNumber() {
		return useSheetNumber;
	}

	public void setUseSheetNumber(int useSheetNumber) {
		this.useSheetNumber = useSheetNumber;
	}

	public static void main(String[] args){
		PassengerVehicle v1 = new PassengerVehicle(3,1);
		PassengerVehicle v2 = new PassengerVehicle(4,2);
		System.out.println("sheet number : " + v1.getSheetNumber() + " use sheet number ; " + v1.getUseSheetNumber());
		System.out.println("sheet number : " + v2.getSheetNumber() + " use sheet number ; " + v2.getUseSheetNumber());


	}


}
