package ch02.ex03_02;

public class X {

	protected int xMask = 0x00ff;
	protected int fullMask;

	public X(){
		fullMask = xMask;
	}
	public int mask(int orig){
		return (orig & fullMask);
	}
	public static void main(String[] args) {
	}

}
