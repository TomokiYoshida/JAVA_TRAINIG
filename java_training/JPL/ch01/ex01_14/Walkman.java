package ch01.ex01_14;

public class Walkman {

	private static int sequenceNumber = 0;
	private int serialNumber;

	public static int getSequenceNumber(){
		sequenceNumber++;
		return sequenceNumber;
	}


}
