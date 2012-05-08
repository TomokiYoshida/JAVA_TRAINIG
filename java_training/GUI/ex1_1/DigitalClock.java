package ex1_1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;

import sandbox.listener.MouseListenerTest;
import sandbox.listener.MouseMotionListenerTest;

public class DigitalClock extends Frame implements Runnable{

	/**時間を入れる変数*/
	static int h;
	/**分を入れる変数*/
	static int m;
	/**秒*/
	static int s;
	static int fontSize = 10;
    Calendar now = Calendar.getInstance();

    static Thread thread;
	boolean isClockActive = true;
	Dimension nowDimention = getSize();
    public DigitalClock(){
    	//タイトル表示
		super("DigitalClock");
		//リスナーをセット
		this.addWindowListener(new MyWindowListener());
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		//windowサイズ
		setSize(200, 100);
		thread = new Thread(this);
		thread.start();
		setMinimumSize(new Dimension(200, 100));
		System.out.println("max" + getSize());
		setVisible(true);
	}
	public static void main(String[] args){
		new DigitalClock();

	}
    public void paint(Graphics g)
    {
    	g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, fontSize));
    	//時刻を表示
        g.drawString(h+":"+m+":"+s,nowDimention.width/4, 2*nowDimention.height/3);
    }

	public void run(){
	    while(isClockActive == true){
	    	//時を代入
            h = now.getInstance().get(now.HOUR_OF_DAY);
            //分を代入
            m =  now.getInstance().get(now.MINUTE);
            //秒を代入
            s =  now.getInstance().get(now.SECOND);
	    	if(getExtendedState() == ICONIFIED){
	    		setTitle(h+":"+m+":"+s);
	    	}
	    	nowDimention = getSize();
			if(nowDimention.height > 600 && nowDimention.width > 300){
				fontSize = 200;
			}
			else if(nowDimention.height > 300 && nowDimention.width > 150){
				fontSize = 100;
			}
			else{
				fontSize = 30;
			}

            repaint();
            try{
                thread.sleep(1000);  //スリープ１秒
            }catch(InterruptedException e){
            }
      }
	}
	class MyWindowListener implements WindowListener{

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
			setTitle("DigitalClock");
			System.out.println("windowDeiconified");
		}
		public void windowActivated(WindowEvent e){//アクティブになった
			System.out.println("windowActivated");
		}
		public void windowDeactivated(WindowEvent e){//非アクティブになった
			System.out.println("wndowDeactivated");
		}
	}
	class MyMouseListener implements MouseListener{

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
	}

	class MyMouseMotionListener implements MouseMotionListener{

		public void mouseDragged(MouseEvent e){
			System.out.println("D: " + e.getX() + ", " + e.getY() );
		}
		public void mouseMoved(MouseEvent e){
			System.out.println("M: " + e.getX() + ", " + e.getY() );
		}
	}
}
