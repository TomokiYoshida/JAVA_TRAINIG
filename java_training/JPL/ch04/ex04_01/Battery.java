package ch04.ex04_01;

public class Battery implements EnergySource {

	private int level;

	public Battery(int level){
		this.level = level;
	}
	public boolean empty(){
		if(level == 0)return true;
		else return false;
	}
	public static void main(String[] args){

		Vehicle v1 = new Vehicle(new Battery(100));
		if(v1.start()){
			System.out.println("v1 start");
		}

		v1 = new Vehicle(new Battery(0));
		if(!v1.start()){
			System.out.println("v1 stop");
		}

	}


}
