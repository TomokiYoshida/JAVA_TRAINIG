package sandbox.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import sandbox.parts.TextAreaTest;

public class BorderLayoutTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new BorderLayoutTest();
	}

	BorderLayoutTest(){
		super("BorderLayoutTest");
		setSize(200, 100);
        setLayout(new BorderLayout());
        Button b1 = new Button("b1");
 //       Button b11 = new Button("b11");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        add("North", b1);
//        add("North", b11);
        add("East", b2);
        add("South", b3);
        add("West", b4);
        add("Center", b5);

        show();
	}

}
