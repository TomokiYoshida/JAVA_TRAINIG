package ex1_2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Calendar;

import ex1_2.listener.MyMenuActionListener;
import ex1_2.listener.MyWindowListener;

public class DigitalClock extends Frame{

    //windowのアクションリスナー
    WindowListener windowListener = new MyWindowListener();
    //メニューのアクションリスナー
    ActionListener menuActionListener = new MyMenuActionListener();

    //時計のパネル
    Panel clockPanel = new ClockPanel();

    public DigitalClock(){
    	//タイトル表示
		super("DigitalClock");
		//リスナーをセット
		this.addWindowListener(windowListener);
		//windowサイズ
		setSize(400, 200);
        setLayout(new BorderLayout());
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        add("North", b1);
//       add("East", b2);
		add("Center",clockPanel);
       add("South", b3);
 //       add("West", b4);
//        add("Center", b5);


		//メニューバーを設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		//[File]
		Menu menuFile = new Menu("File");
		menuFile.addActionListener(menuActionListener);
		menuBar.add(menuFile);
		//[File]-[Open]
		MenuItem menuOpen = new MenuItem("Open...", new MenuShortcut('0'));
		menuFile.add(menuOpen);
		//[File]-[Exit]
		MenuItem menuExit = new MenuItem("Exit");
		menuFile.add(menuExit);
		//[View]
		Menu menuView = new Menu("View");
		menuView.addActionListener(menuActionListener);
		menuBar.add(menuView);
		//[View]-[Status Bar]
		CheckboxMenuItem menuStatusBar = new CheckboxMenuItem("Status Bar");
		menuStatusBar.addActionListener(menuActionListener);
		menuView.add(menuStatusBar);
		//[View]-[Size]
		Menu menuSize = new Menu("Size");
		menuSize.addActionListener(menuActionListener);
		menuView.add(menuSize);
		//[View]-[Size]-[Large]
		MenuItem menuSizeLarge = new MenuItem("Large");
		menuSize.add(menuSizeLarge);
		//[View]-[Size]-[Small]
		MenuItem menuSizeSmall = new MenuItem("Small");
		menuSize.add(menuSizeSmall);

		setVisible(true);
	}
	public static void main(String[] args){
		new DigitalClock();

	}



}
