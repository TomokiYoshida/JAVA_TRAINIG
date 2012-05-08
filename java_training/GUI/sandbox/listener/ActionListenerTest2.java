package sandbox.listener;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest2 extends Frame{

	public ActionListenerTest2() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("ActionListenerTest");
		Button b1 = new Button("BUTTON1");
		b1.addActionListener(new MyActionListener());
		add(b1);
		setSize(200, 100);
		show();
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	public static void main(String[] args){
		new ActionListenerTest2();
	}


}
