package ch03.ex03_03;

public class Y extends X{

	protected int yMask = 0xff00;
	public Y(){
		super();
		System.out.printf("%x %x %x%n",xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("%x %x %x%n",xMask, yMask, fullMask);
	}
	public static void main(String[] args){
		Y y = new Y();

	}

}
