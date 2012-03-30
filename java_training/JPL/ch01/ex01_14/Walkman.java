package ch01.ex01_14;

public class Walkman {

	private static int sequenceNumber = 0;
	private int serialNumber;
	private Terminal terminal = new Terminal();
	private Tape tape;

	public static int getSequenceNumber(){
		sequenceNumber++;
		return sequenceNumber;
	}
	public Terminal getTerminal(){
		return terminal;
	}


}
