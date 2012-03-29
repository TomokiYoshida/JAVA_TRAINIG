package ch01.ex01_12;
public class Value {
	private int value;
	private boolean isEven = false;

	public Value(int value, boolean isEven){
		this.value = value;
		this.isEven = isEven;
	}

	public int getValue(){
		return value;
	}
	public boolean getIsEven(){
		return isEven;
	}
}