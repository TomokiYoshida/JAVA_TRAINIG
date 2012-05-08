package sandbox.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.*;

	public class BorderLayoutTest2 extends Frame{
		    Panel p1 = new Panel();
		    Panel p2 = new Panel();
		    Button b1 = new Button("B1");
		    Button b2 = new Button("B2");
		    Button b3 = new Button("B3");
		    Button b4 = new Button("B4");
		    public BorderLayoutTest2() {
		        super("BorderLayoutTest2");
		        setLayout(new GridLayout(1, 2));
		        add(p1);
		        add(p2);
		        p1.setLayout(new GridLayout(1, 1));
		        p2.setLayout(new GridLayout(3, 1));
		        p1.add(b1);
		        p2.add(b2);
		        p2.add(b3);
		        p2.add(b4);
		        setSize(300, 200);
		        show();
		    }
		    public static void main (String args []) {
		        new BorderLayoutTest2();
		    }
		}