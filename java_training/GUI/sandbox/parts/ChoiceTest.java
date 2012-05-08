package sandbox.parts;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;

public class ChoiceTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChoiceTest();
	}
	ChoiceTest(){
		super("ChoiceTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		Choice c1 = new Choice();
		c1.add("choice1");
		c1.add("choice2");
		c1.add("choice3");
		add(c1);
		show();
	}

}
