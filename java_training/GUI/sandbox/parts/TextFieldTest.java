package sandbox.parts;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

public class TextFieldTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new TextFieldTest();
	}
	TextFieldTest(){
		super("TextFieldTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		TextField t1 = new TextField("Hello World");
		add(t1);
		show();
	}

}
