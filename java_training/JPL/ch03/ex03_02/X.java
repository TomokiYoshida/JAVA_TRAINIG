package ch03.ex03_02;

public class X {

	protected int xMask = 0x00ff;
	protected int fullMask;
	{
		System.out.printf("%x %x %x%n",xMask, 00, fullMask);
	}
	public X(){
		fullMask = xMask;

	}
	public int mask(int orig){
		return (orig & fullMask);
	}

}
