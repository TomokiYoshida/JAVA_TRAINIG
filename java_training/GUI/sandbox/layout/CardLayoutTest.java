package sandbox.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import sandbox.parts.TextAreaTest;

public class CardLayoutTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new CardLayoutTest();
	}

	CardLayoutTest(){
		super("CardLayoutTest");
		setSize(200, 100);
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        CardLayout cl = new CardLayout();
        setLayout(cl);
        add("b1", b1);
        add("b2", b2);
        add("b3", b3);
        cl.show(this, "b1");
        show();
	}

}
