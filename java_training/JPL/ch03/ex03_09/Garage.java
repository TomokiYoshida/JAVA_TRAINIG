package ch03.ex03_09;

public class Garage implements Cloneable{


	Vehicle[] vehicleList;

	Garage(Vehicle[] vehicleList){
		this.vehicleList = vehicleList;
	}

	public Garage clone(){
		try{
			Garage garage = (Garage) super.clone();
			if(this.vehicleList == null) return garage;
			garage.vehicleList = new Vehicle[vehicleList.length];
			for(int i = 0; i < this.vehicleList.length; i++){
				garage.vehicleList[i] = new Vehicle(this.vehicleList[i]);
			}
			return garage;
		}
		catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}

	}

	/**
	 * @param args
	 */

	//garageのcloneの作成
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Vehicle v1 = new Vehicle("test1");
		Vehicle v2 = new Vehicle("test2");
		Vehicle[] vList = {v1, v2};

		Garage g1 = new Garage(vList);
		Garage g2 = g1.clone();

		for(int i = 0; i < g1.vehicleList.length; i++){
			System.out.println(g1.vehicleList[i]);
			System.out.println(g2.vehicleList[i]);
		}
	}

}
