package ex1_2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Calendar;



/**
 * 課題1-2    デジタル時計に次の機能追加を行ってください。
    メニューを付けて、プロパティダイアログを開ける。
    プロパティダイアログでは、以下の項目を設定できる。
    フォントの指定
    フォントサイズの指定
    文字色の指定
    時計の背景色の指定
    描画に際して、ちらつきをなくすようにダブルバッファリングする。
    フォントとフォントサイズを変更すると、時計を表示すべきフレームの大きさを適切に自動変更して、正しく表示されるようにする。
 *
 *
 */

public class DigitalClock extends Frame implements Runnable{

	/**時間を入れる変数*/
	static int h;
	private Frame thisFrame;
	/**分を入れる変数*/
	static int m;
	/**秒*/
	static int s;
	static  FontMetrics fm;
	static int fontSize = 15;
	static Color color = Color.BLACK;
	static String font = Font.SANS_SERIF;
    Calendar now = Calendar.getInstance();

    static Thread thread;
	boolean isClockActive = true;
	Dimension nowDimention = getSize();
    public DigitalClock(){
    	//タイトル表示
		super("DigitalClock");
    	thisFrame = this;
		//リスナーをセット
		this.addWindowListener(new MyWindowListener());
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		//windowサイズ
		setSize(200, 200);
		thread = new Thread(this);
		thread.start();
		setMinimumSize(new Dimension(200, 200));
		System.out.println("max" + getSize());

		//メニューバーを設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		//[Menu]
		Menu menu = new Menu("Menu");
		menu.addActionListener(new MyMenuActionListener());
		menuBar.add(menu);
		//[Menu]-[Propety]
		MenuItem menuPro = new MenuItem("Property", new MenuShortcut('0'));
		menu.add(menuPro);

		setVisible(true);
	}
	public static void main(String[] args){
		new DigitalClock();

	}
    public void paint(Graphics g)
    {
    		int width = nowDimention.width;
    		int height = nowDimention.height;
    	 //   g.setBackground(Color.WHITE);
    	    g.clearRect(0, 0,width,height);
    	    g.setColor(color);
    	    g.setFont(new Font(font,Font.BOLD,fontSize));
    	    fm = g.getFontMetrics();
    	    String mes = h+":"+m+":"+s;
    	    int strWidth = fm.stringWidth(mes);
    	    int strHeight = fm.getHeight();
    	    if(width <= strWidth || height <= strHeight){
    	    	width += strWidth;
    	    	height += strHeight;
    	    	setSize(width, height);
    	    }
    	    g.drawString(mes, ( width - strWidth ) / 2, ( height - strHeight ) / 2 + strHeight);
    	// g.setFont(new Font(font, Font.ITALIC, fontSize));
    	//時刻を表示
//        g.drawString(h+":"+m+":"+s,nowDimention.width/4, 2*nowDimention.height/3);
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
		//	System.out.println("D: " + e.getX() + ", " + e.getY() );
		}
		public void mouseMoved(MouseEvent e){
		//	System.out.println("M: " + e.getX() + ", " + e.getY() );
		}
	}
	class MyMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){

			System.out.println(e.getActionCommand());
			 PropertyDialog dlg = new PropertyDialog(thisFrame);
		        dlg.setVisible(true);

		}

		/**
		 *プロパティダイアログでは、以下の項目を設定できる。
		 *フォントの指定
		 *フォントサイズの指定
		 *文字色の指定
		 *時計の背景色の指定
		 *
		 */

		class PropertyDialog extends Dialog implements ActionListener{

	        Choice c1 = new Choice();
	        Choice c2 = new Choice();
	        Choice c3 = new Choice();
	        Choice c4 = new Choice();

			PropertyDialog(Frame owner) {
		        super(owner);

		        setLayout(new GridLayout(5,2));

		        Label fontLabel = new Label("font:");
		        add (fontLabel);
		        c1.add("SANS_SERIF");
		        c1.add("MONOSPACED");
		        add(c1);
		        Label fontSizeLabel = new Label("font size:");
		        add (fontSizeLabel);
		        c2.add("15px");
		        c2.add("30px");
		        c2.add("50px");
		        add(c2);
		        Label characterColorLabel = new Label("character color:");
		        add (characterColorLabel);
		        c3.add("Black");
		        c3.add("Yellow");
		        c3.add("Blue");
		        add(c3);
		        Label backgroundColorLabel = new Label("background color:");
		        add (backgroundColorLabel);
		        c4.add("White");
		        c4.add("Gray");
		        c4.add("Pink");
		        add(c4);
		        Button b1 = new Button("OK");
		        b1.addActionListener(this);
		        add(b1);
		        setTitle("Property");
		        setSize(200, 200);
		    }
		    public void actionPerformed(ActionEvent e) {
		    	switch(c1.getSelectedIndex()){
	    		case 0:
	    			font = Font.SANS_SERIF;
	    			break;
	    		case 1:
	    			font = Font.MONOSPACED;
	    			break;
	    		default: font = Font.DIALOG_INPUT;
		    	}
		    	switch(c2.getSelectedIndex()){

		    		case 0:
		    			fontSize = 15;
		    			break;
		    		case 1:
		    			fontSize = 30;
		    			break;
		    		case 2:
		    			fontSize = 50;
		    			break;
		    		default: fontSize = 15;
		    	}
		    	switch(c3.getSelectedIndex()){

	    		case 0:
	    			color = Color.BLACK;
	    			break;
	    		case 1:
	    			color = Color.YELLOW;
	    			break;
	    		case 2:
	    			color = Color.BLUE;
	    			break;
	    		default: color = Color.BLACK;
	    	}
	    	switch(c4.getSelectedIndex()){
	    		case 0:
	    			thisFrame.setBackground(Color.WHITE);
	    			break;
	    		case 1:
	    			thisFrame.setBackground(Color.GRAY);
	    			break;
	    		case 2:
	    			thisFrame.setBackground(Color.PINK);
	    			break;
	    		default:
	    			thisFrame.setBackground(Color.WHITE);
	    	}
		        setVisible(false);
		    }

		}
	}

	public void update(Graphics g){
	    paint(g);
	}
}




