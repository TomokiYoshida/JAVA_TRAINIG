package sandbox.parts;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;

public class CanvasTest extends Frame{

	public static void main(String[] args){
		new CanvasTest();
	}
	CanvasTest(){
		super("CanvasTest");
		setSize(200, 100);
		setLayout(new BorderLayout());
		MyCanvas mc1 = new MyCanvas();
		add(mc1, BorderLayout.CENTER);
		show();

	}

	class MyCanvas extends Canvas{
		public void paint(Graphics g){
			g.drawLine(10, 10, 120, 40);
		}
	}

}
