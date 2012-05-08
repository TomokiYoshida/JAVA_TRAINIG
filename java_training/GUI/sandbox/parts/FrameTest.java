package sandbox.parts;

import java.awt.Frame;

public class FrameTest extends Frame{

	public static void main(String[] args){
		new FrameTest();
	}
	FrameTest(){
		super("FrameTest");
		setSize(200,100);
		show();
	}

}
