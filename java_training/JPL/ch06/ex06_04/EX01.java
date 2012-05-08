package ch06.ex06_04;

public class EX01 {

	//信号
	enum Signal {
		RED("RED"), YELLOW("YELLOW"), BLUE("BLUE");
		String color;
		Signal(String color){
			this.color = color;
		}
		public String getColor(){return color;}
	}

	public static void main(String[] args){

		System.out.println(Signal.RED.getColor());
		System.out.println(Signal.BLUE.getColor());
		System.out.println(Signal.YELLOW.getColor());
	}


}
