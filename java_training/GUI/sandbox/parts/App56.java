package sandbox.parts;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*	<applet code="App56.class" width="300"height="300">
 	</applet>
*/

public class App56 extends Applet implements ActionListener , Runnable {
	Toolkit tk = getToolkit();
	Dimension dim;
	Window win;
	public void init() {
		setBackground(Color.white);
		dim = tk.getScreenSize();
		setLayout(new GridLayout(1,1));
		Button but = (Button)add(new Button("スプラッシュウィンドウ"));
		but.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Thread th = new Thread(this);
		th.start();
	}
	public void run() {
		synchronized(this) {
			Label lb = new Label("Kitty on your lap");
			lb.setForeground(Color.red);
			lb.setFont(new Font("Serif" , Font.ITALIC , 30));

			win = new Window(new Frame());
			win.setLayout(new FlowLayout(FlowLayout.CENTER));
			win.setSize(400 , 400);
			win.setBackground(Color.black);
			win.add(lb);
			win.setLocation(dim.width / 2 - 200 , dim.height / 2 - 200);
			win.show();
			win.toFront();

			try {	Thread.sleep(5000);	 }
			catch (Exception e) {	 }
			finally {	win.dispose();	 }
		}
	}
}