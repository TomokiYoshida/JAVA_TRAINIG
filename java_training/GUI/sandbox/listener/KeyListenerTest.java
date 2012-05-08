package sandbox.listener;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest extends Frame implements KeyListener{

	public KeyListenerTest(){
		super("keyLsitenerTest");
		TextField tf1 = new TextField();
		tf1.addKeyListener(this);
		add(tf1);
		setSize(200, 100);
		show();
	}
	public void keyPressed(KeyEvent e){
		System.out.println("Press: " + e.getKeyText(e.getKeyCode()));
	}
	public void keyReleased(KeyEvent e){
		System.out.println("Released: " + e.getKeyText(e.getKeyCode()));
	}
	public void keyTyped(KeyEvent e){
		System.out.println("Type: " + e.getKeyChar());
	}
	public static void main(String [] args){
		new KeyListenerTest();
	}

}
