package ch04.ex04_01;

public class GasTank implements EnergySource {

	private int amount;

	public GasTank(int amount){
		this.amount = amount;
	}
	public boolean empty(){
		if(amount == 0)return true;
		else return false;
	}
	public static void main(String[] args){

		Vehicle v1 = new Vehicle(new GasTank(100));
		if(v1.start()){
			System.out.println("v1 start");
		}

		v1 = new Vehicle(new GasTank(0));
		if(!v1.start()){
			System.out.println("v1 stop");
		}

	}


}
