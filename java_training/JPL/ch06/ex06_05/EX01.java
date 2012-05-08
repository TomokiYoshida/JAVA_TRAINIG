package ch06.ex06_05;

public abstract class EX01 {

	//信号
	enum Signal {
		RED{
			String getColor(){
				return "RED";
			}
		},
		BLUE{
			String getColor(){
				return "BLUE";
			}
		},
		YELLOW{
			String getColor(){
				return "YELLOW";
			}
		};
		abstract String getColor();

	}

	//enumにする必要がないので,定数固有メソッドは推奨されない。
	public static void main(String[] args){

		System.out.println(Signal.RED.getColor());
		System.out.println(Signal.BLUE.getColor());
		System.out.println(Signal.YELLOW.getColor());
	}


}
