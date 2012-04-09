package ch02.ex03_02;

public class Y extends X{

	protected int yMask = 0xff00;

	public Y(){
		fullMask |= yMask;
	}

}
