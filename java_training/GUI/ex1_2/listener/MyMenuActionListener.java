package ex1_2.listener;

import java.awt.CheckboxMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class MyMenuActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
	}
	public void itemStateChanged(ItemEvent e){
		CheckboxMenuItem menu = (CheckboxMenuItem)e.getSource();
		if(menu.getState()){
			System.out.println(menu.getLabel() + " SELECTED");
		} else {
			System.out.println(menu.getLabel() +" DESELECTED" );
		}

	}
}
