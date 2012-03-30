package ch02.ex02_12;

//必要。Ownerが複数いる場合に可変長にする必要がある
public class Vehicle {

	static int nextId = 0;
	private int speed;
	private String direction;
	private String[] ownerName;

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
}
