package sandbox.parts;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;

public class ListTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ListTest();
	}
	ListTest(){
		super("ListTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		List l1 = new List();
		l1.add("List1");
		l1.add("List2");
		l1.add("List3");
		add(l1);
		show();
	}

}
