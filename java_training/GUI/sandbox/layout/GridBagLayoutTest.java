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
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");

        addButton(b1, 0, 0, 1, 3);   // (0, 0) 幅=1, 高さ=3
        addButton(b2, 1, 0, 1, 1);   // (1, 0) 幅=1, 高さ=1
        addButton(b3, 1, 1, 1, 1);   // (1, 1) 幅=1, 高さ=1
        addButton(b4, 1, 2, 1, 1);   // (1, 2) 幅=1, 高さ=1
        show();
	}

}
