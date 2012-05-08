package sandbox.listener;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest extends Frame implements WindowListener{

	WindowListenerTest(){
		super("WindowListenerTest");
		this.addWindowListener(this);
		setSize(200, 100);
		show();

	}
	public void windowOpened(WindowEvent e){ //開かれた
		System.out.println("windowOpened");
	}
	public void windowClosing(WindowEvent e){//閉じられている
		System.out.println("windowClosing");
	}
	public void windowClosed(WindowEvent e){//閉じた
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
	public static void main(String[] args){
		new WindowListenerTest();
	}



}
