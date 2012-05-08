package sandbox.layout;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import sandbox.parts.TextAreaTest;

public class GridLayoutTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new GridLayoutTest();
	}
	GridLayoutTest(){
		super("GridLayoutTest");
		setSize(200, 100);
		setLayout(new GridLayout(2,4));//行、列
		TextField t1 = new TextField("1");
		TextField t2 = new TextField("2");
		TextField t3 = new TextField("3");
		TextField t4 = new TextField("4");
		TextField t5 = new TextField("5");
		TextField t6 = new TextField("6");
		TextField t7 = new TextField("7");
		TextField t8 = new TextField("8");
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		show();
	}

}
