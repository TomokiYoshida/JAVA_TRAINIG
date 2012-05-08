package sandbox.parts;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;

public class TextAreaTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new TextAreaTest();
	}
	TextAreaTest(){
		super("TextFieldTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		TextArea t1 = new TextArea("Hello World", 3, 20);
		add(t1);
		show();
	}

}
