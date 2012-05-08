package ch03.ex03_06;

public class Battery extends EnergySource {

	private int level;

	public Battery(int level){
		this.level = level;
	}
	boolean empty(){
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
