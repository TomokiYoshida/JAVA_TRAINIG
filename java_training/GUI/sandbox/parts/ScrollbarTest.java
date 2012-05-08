package sandbox.parts;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;

public class ScrollbarTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ScrollbarTest();
	}
	ScrollbarTest(){
		super("ListTest");
		setSize(200, 100);
		setLayout(new BorderLayout());
		Scrollbar sb1 = new Scrollbar(Scrollbar.HORIZONTAL);
		add(sb1, BorderLayout.SOUTH);
		show();
	}

}
