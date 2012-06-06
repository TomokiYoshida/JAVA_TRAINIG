package ex1_2;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyDialog extends Dialog implements ActionListener{

	PropertyDialog(Frame owner) {
        super(owner);
        setLayout(new FlowLayout());
        Button b1 = new Button("OK");
        b1.addActionListener(this);
        add(b1);
        setTitle("MyDialog");
        setSize(80, 80);
    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
