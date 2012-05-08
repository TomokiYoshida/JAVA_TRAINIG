package sandbox.listener;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerTest extends Frame implements MouseMotionListener{

	public MouseMotionListenerTest() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("MouseMotionListenerTest");
		addMouseMotionListener(this);
		setSize(200, 100);
		show();
	}
	public void mouseDragged(MouseEvent e){
		System.out.println("D: " + e.getX() + ", " + e.getY() );
	}
	public void mouseMoved(MouseEvent e){
		System.out.println("M: " + e.getX() + ", " + e.getY() );
	}
	public static void main(String[] args){
		new MouseMotionListenerTest();
	}

}
