package sandbox.parts;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CheckboxMenuItem;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuTest extends Frame implements ActionListener, ItemListener{

	public static void main(String[] args){
		new MenuTest();
	}
	MenuTest(){
		setTitle("MenuTest");
		setSize(200, 100);
		setLayout(new FlowLayout());
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		//[File]
		Menu menuFile = new Menu("File");
		menuFile.addActionListener(this);
		menuBar.add(menuFile);
		//[File]-[Open]
		MenuItem menuOpen = new MenuItem("Open...", new MenuShortcut('0'));
		menuFile.add(menuOpen);
		//[File]-[Exit]
		MenuItem menuExit = new MenuItem("Exit");
		menuFile.add(menuExit);
		//[View]
		Menu menuView = new Menu("View");
		menuView.addActionListener(this);
		menuBar.add(menuView);
		//[View]-[Status Bar]
		CheckboxMenuItem menuStatusBar = new CheckboxMenuItem("Status Bar");
		menuStatusBar.addActionListener(this);
		menuView.add(menuStatusBar);
		//[View]-[Size]
		Menu menuSize = new Menu("Size");
		menuSize.addActionListener(this);
		menuView.add(menuSize);
		//[View]-[Size]-[Large]
		MenuItem menuSizeLarge = new MenuItem("Large");
		menuSize.add(menuSizeLarge);
		//[View]-[Size]-[Small]
		MenuItem menuSizeSmall = new MenuItem("Small");
		menuSize.add(menuSizeSmall);
		show();

	}
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
