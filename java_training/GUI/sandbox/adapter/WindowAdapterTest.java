package sandbox.adapter;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterTest extends Frame{

	public WindowAdapterTest() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("WindowAdaterTest");
		this.addWindowListener(new MyWindowListener());
		setSize(200, 100);
		show();
	}
	public static void main(String [] args){
		new WindowAdapterTest();
	}


	class MyWindowListener extends WindowAdapter{
		public void windowActivated(WindowEvent e){
			System.out.println("windowActivated");
		}
	}
}
