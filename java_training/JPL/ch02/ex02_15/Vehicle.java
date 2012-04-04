package ch02.ex02_15;

//必要。Ownerが複数いる場合に可変長にする必要がある
public class Vehicle {

	//nextIdはclass内部でのみ使用されるのでアクセッサーメソッドは不要
	private static int nextId = 0;
	//その他のclass外部からも使用される可能性のあるものに関してはsetter/getterを使用する。
	private int speed = 0;
	private String direction;
	private String[] ownerName;

	//finalフィールドのidはgetterのみを持つ。
	private final int id;
	public Vehicle(){
		nextId++;
		id= nextId;
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
