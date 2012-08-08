package sandbox.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import sandbox.parts.TextAreaTest;

public class GridBagLayoutTest extends Frame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new GridBagLayoutTest();
	}
	 GridBagLayout gbl = new GridBagLayout();
	 void addButton(Button b, int x, int y, int w, int h) {
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        gbl.setConstraints(b, gbc);
	        add(b);
	  }
	GridBagLayoutTest(){
		super("GridLayoutTest");
		setSize(200, 100);
        setLayout(gbl);
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5= new Button("button5");
        Button b6= new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");
        Button b9 = new Button("button9");
    //   b1.setSize(10000, 10000);
        b2.setSize(100, 11);
        b3.setSize(100, 11);
        b4.setSize(100, 11);
        b5.setSize(100, 11);
        b6.setSize(100, 11);
        b7.setSize(100, 11);
        b8.setSize(100, 11);
        b9.setSize(100, 11);

        addButton(b1, 0, 0, 1, 2);   // (0, 0) 幅=1, 高さ=3
   //     addButton(b2, 0, 1, 1, 1);   // (1, 0) 幅=1, 高さ=1
        addButton(b3, 1, 0, 1, 1);   // (1, 1) 幅=1, 高さ=1
        addButton(b4, 1, 1, 1, 1);   // (1, 2) 幅=1, 高さ=1
        addButton(b5, 1, 2, 1, 1);   // (1, 2) 幅=1, 高さ=1
        addButton(b6, 0, 2, 1, 1);   // (1, 2) 幅=1, 高さ=1
        addButton(b7, 2, 0, 1, 1);   // (1, 2) 幅=1, 高さ=1
        addButton(b8, 2, 1, 1, 1);   // (1, 2) 幅=1, 高さ=1
        addButton(b9, 2, 2, 1, 1);   // (1, 2) 幅=1, 高さ=1
               show();
	}

}
