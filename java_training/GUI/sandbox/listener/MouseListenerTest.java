package sandbox.listener;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerTest extends Frame implements MouseListener{

	public MouseListenerTest() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("MouseListerTest");
		this.addMouseListener(this);
		setSize(200, 100);
		show();
	}
	public void mouseClicked(MouseEvent e){
		System.out.println("mouseClicked");
	}
	public void mousePressed(MouseEvent e){
		System.out.println("mousePressed");
	}
	public void mouseReleased(MouseEvent e){
		System.out.println("mouseReleased");
	}
	/**マウスがフレーム内に入ったとき*/
	public void mouseEntered(MouseEvent e){
		System.out.println("mouseEntered");
	}
	public void mouseExited(MouseEvent e){
		System.out.println("mouseExited");
	}
	public static void main(String[] args){
		new MouseListenerTest();
	}

}
