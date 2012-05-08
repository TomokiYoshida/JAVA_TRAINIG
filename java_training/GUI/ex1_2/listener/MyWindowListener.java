package ex1_2.listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener{

		public void windowOpened(WindowEvent e){ //開かれた
			System.out.println("windowOpened");
		}
		public void windowClosing(WindowEvent e){//閉じられている
			System.out.println("windowClosing");
			System.exit(0);
		}
		public void windowClosed(WindowEvent e){//閉じた
			//いつ呼ばれるの?

			System.out.println("windowClosed");
		}
		public void windowIconified(WindowEvent e){//アイコン化された
			System.out.println("windowIconified");
		}
		public void windowDeiconified(WindowEvent e){//非アイコン化された
			System.out.println("windowDeiconified");
		}
		public void windowActivated(WindowEvent e){//アクティブになった
			System.out.println("windowActivated");
		}
		public void windowDeactivated(WindowEvent e){//非アクティブになった
			System.out.println("wndowDeactivated");
		}

}
