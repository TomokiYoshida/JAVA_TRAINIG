package ex1_3;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Window;

public class DigitalClockWindow extends Window

{


	public DigitalClockWindow(Frame f1) {

		super(f1);
		setLayout(new FlowLayout());
//		DigitalClock dc = new DigitalClock();
//		add(dc)
		Panel p1 = new Panel();
		TextArea ta1 = new TextArea("test");
		p1.setSize(100,150);
		p1.add(ta1);
		f1.add(p1);
		f1.add(new Button("te"));
		f1.setVisible(true);

//		dc.setVisible(true);
		setSize(400 , 400);
//		setBackground(Color.b);
//		toBack();
		setVisible(true);
		toFront();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] argds){
		Frame f1 = new Frame();
		new DigitalClockWindow(f1);
	}

}
