package sandbox.parts;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;

public class CheckboxTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CheckboxTest();
	}
	CheckboxTest(){
		super("CheckboxsTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		Checkbox t1 = new Checkbox("OK?");
		add(t1);
		show();
	}

}
