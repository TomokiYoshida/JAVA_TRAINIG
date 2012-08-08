package ex1_4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StyleConstants.FontConstants;



/**
課題1-4 課題1-２のデジタル時計で、属性をダイアログで指定できるようにしましたが、ダイアログを作
り直してください。
● レイアウトマネージャは、GridBagLayoutを使用する。
● プロパティダイアログは、属性名＋のリストメニューが縦に並ぶようにする。
フォント フォントのリスト
フォントサイズ サイズのリスト
文字色 色のリスト
背景色 色のリスト
この場合「属性名」のラベルは右寄せして、「値の選択リスト」メニューは左寄せる。
● ダイアログの下には、「OK」「キャンセル」のボタンをダイアログの右下に寄せて表示し、そ
れぞれのボタンを実装する。キャンセルされた場合には、正しく、元の値に戻るようにする。
● java.util.prefsパッケージを使用して、プロパティダイアログの内容の保存と、時計の終了
時の位置を保存する。再度、時計を起動した場合に、それらの保存を復元して、デスクトップの
元の位置に表示されるようにする。
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
    Calendar now = Calendar.getInstance();
    PrefsUtil  prefsUtil = new PrefsUtil();
    static Thread thread;
	boolean isClockActive = true;
	Dimension nowDimention = getSize();
	Image buf;
	static int fontSizes[] = {8,9,10,11,12,13,14,15,20,24,32,45,50,80,100,120,150};
	static int fontSize;
	static Color colors[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	static String colorsStr[] ={"BLACK","BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
	static Map<String, Color> colorsMap;
	static String characterColor;
	static String backGroundColor;
	Graphics ct;
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static int paintedWidth = 0;
	static int paintedHeight = 0;
	Font fonts[] = ge.getAllFonts();
	String font;
	Map< String, Font> fontMap;

    public DigitalClock(){
    	//タイトル表示
		super("DigitalClock");
    	thisFrame = this;		//リスナーをセット
		this.addWindowListener(new MyWindowListener());
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		//windowサイズ
		setSize(200, 200);
		setMinimumSize(new Dimension(200, 200));
		colorsMap = new HashMap<String, Color>();
		for(int i = 0; i < colors.length; i ++){
			colorsMap.put(colorsStr[i], colors[i]);
		}
		fontMap = new HashMap<String, Font>();
		for(int i = 0; i < fonts.length; i ++){
			fontMap.put(fonts[i].getName(), fonts[i]);
		}
		font = prefsUtil.load("font", fonts[0].getName());
		fontSize =  Integer.valueOf(prefsUtil.load("fontSize", String.valueOf(fontSizes[12])));
		characterColor = prefsUtil.load("characterColor", colorsStr[0]);
		backGroundColor  = prefsUtil.load("backgroundColor", colorsStr[11]);
		setBackground(colorsMap.get(backGroundColor));
		thread = new Thread(this);
		thread.start();

		//メニューバーを設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		//[Menu]
		Menu menu = new Menu("Menu");
		menu.addActionListener(new MyMenuActionListener());
		menuBar.add(menu);
		//[Menu]-[Propety]
		MenuItem menuPro = new MenuItem("Property");
		menu.add(menuPro);

		setVisible(true);
	}

    public void paint(Graphics g)
    {
    		int width = nowDimention.width;
    		int height = nowDimention.height;

    		if(paintedWidth != width || paintedHeight != height){
    			paintedWidth = width;
    			paintedHeight = height;
    			buf = createImage(width , height);
    		}
    		ct = buf.getGraphics();

       		//ct.fillRect(0 , 0 , width , height);
       	    ct.clearRect(0, 0,width,height);
    	    ct.setColor(colorsMap.get(characterColor));

    		ct.setFont(new Font(font, Font.BOLD,fontSize));

    		fm = ct.getFontMetrics();
    	    String mes = h+":"+m+":"+s;
    	    int strWidth = fm.stringWidth(mes);
    	    int strHeight = fm.getHeight();
    	    if(width <= strWidth || height <= strHeight){
    	    	width += strWidth;
    	    	height += strHeight;
    	    	setSize(width, height);
    			buf = createImage(width , height);
    			ct = buf.getGraphics();
        		ct.clearRect(0, 0,width,height);
        	    ct.setColor(colorsMap.get(characterColor));
        		ct.setFont(new Font(font, Font.BOLD,fontSize));
    	    }
    	    ct.drawString(mes, ( width - strWidth ) / 2, ( height - strHeight ) / 2 + strHeight);
    	    g.drawImage(buf , 0 , 0 ,this);

/*    	    g.clearRect(0, 0,width,height);
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
    	    g.drawString(mes, ( width - strWidth ) / 2, ( height - strHeight ) / 2 + strHeight);*/
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
			String saveFont = font;
			String saveFontSize = "" + fontSize;
			String saveChracterColor = characterColor.toString();
			String saveBackgroundColor = backGroundColor.toString();
			prefsUtil.save("font", font);
			prefsUtil.save("fontSize", String.valueOf(fontSize));
			prefsUtil.save("characterColor", characterColor);
			prefsUtil.save("backgroundColor", backGroundColor);


			System.exit(0);
		}
		public void windowClosed(WindowEvent e){//閉じた
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
		}
		public void mouseMoved(MouseEvent e){
		}
	}
	class MyMenuActionListener implements ActionListener {
		PropertyDialog dlg = null;
		public void actionPerformed(ActionEvent e){
			System.out.println(e.getActionCommand());
			if(dlg == null){
				dlg = new PropertyDialog(thisFrame);
			}
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

			int x = 400;
			int y = 200;
			/**fontのリストボックス*/
	        Choice c1 = new Choice();
			/**font sizeのリストボックス*/
	        Choice c2 = new Choice();
			/**font colorのリストボックス*/
	        Choice c3 = new Choice();
			/**backgroundのリストボックス*/
	        Choice c4 = new Choice();
	        String c1Index;
	        String c2Index;
	        String c3Index;
	        String c4Index;
	        GridBagLayout gbl = new GridBagLayout();
	        public void setVisible(boolean b){
	        	init();
	        	super.setVisible(b);
	        }
	        void init(){
	        	c1.select(c1Index);
		        c2.select(c2Index);
		        c3.select(c3Index);
		        c4.select(c4Index);
	        }
		   	 void addComponent(Component  c,  int x, int y, int w, int h, int anchor) {
			        GridBagConstraints gbc = new GridBagConstraints();
			        gbc.anchor = anchor;
			        gbc.gridx = x;
			        gbc.gridy = y;
			        gbc.gridwidth = w;
			        gbc.gridheight = h;
			        gbc.weightx = 1.0d;
			        gbc.weighty = 1.0d;

			        gbl.setConstraints(c, gbc);
			        add(c);
			  }
			PropertyDialog(Frame owner) {
		        super(owner);
	        	c1Index = font;
	        	c2Index = String.valueOf(fontSize);
		        c3Index = characterColor;
		        c4Index = backGroundColor;
		        setLayout(gbl);
		        Label fontLabel = new Label("font:");
		        for(int i = 0; i < fonts.length; i++){
			        c1.add(fonts[i].getName());
		        }
		        Label fontSizeLabel = new Label("font size:");
		        for(int i = 0; i < fontSizes.length; i++){
			        c2.add(String.valueOf(fontSizes[i]));
		        }
		        Label characterColorLabel = new Label("character color:");
		        for(int i = 0; i < colorsStr.length; i++){
			        c3.add(String.valueOf(colorsStr[i]));
		        }
		        Label backgroundColorLabel = new Label("background color:");
		        for(int i = 0; i < colorsStr.length; i++){
			        c4.add(String.valueOf(colorsStr[i]));
		        }
		        addComponent(fontLabel, 0,0, 1, 1, GridBagConstraints.EAST);
		        addComponent(c1, 1, 0, 1, 1,GridBagConstraints.WEST);
		        addComponent(fontSizeLabel, 0, 1, 1, 1, GridBagConstraints.EAST);
		        addComponent(c2, 1, 1, 1, 1,GridBagConstraints.WEST);
		        addComponent(characterColorLabel, 0,2, 1, 1, GridBagConstraints.EAST);
		        addComponent(c3, 1, 2, 1, 1,GridBagConstraints.WEST);
		        addComponent(backgroundColorLabel, 0, 3, 1, 1, GridBagConstraints.EAST);
		        addComponent(c4, 1, 3, 1, 1,GridBagConstraints.WEST);
		        Button b1 = new Button("OK");
		        b1.addActionListener(this);
		        Button b2 = new Button("CANCEL");
		        b2.addActionListener(this);
		        addComponent(b1, 0,4, 1, 1, GridBagConstraints.EAST);
		        addComponent(b2, 1,4, 1, 1, GridBagConstraints.WEST);
		        setTitle("Property");
		        addWindowListener(new MyPropetyWindowListener());
		        setSize(x, y);

		    }
		    public void actionPerformed(ActionEvent e) {
		    	if(e.getActionCommand().equals("OK")){
		    		font = fonts[c1.getSelectedIndex()].getName();
		    		fontSize = fontSizes[c2.getSelectedIndex()];
		    		characterColor = colorsStr[c3.getSelectedIndex()];
		    		thisFrame.setBackground(colors[c4.getSelectedIndex()]);
		    		backGroundColor = colorsStr[c4.getSelectedIndex()];
		    		c1Index = c1.getSelectedItem();
		    		c2Index = c2.getSelectedItem();
		    		c3Index = c3.getSelectedItem();
		    		c4Index = c4.getSelectedItem();
	    			buf = thisFrame.createImage(nowDimention.width , nowDimention.height);
		    	}
		    	else{
		    		init();
		    	}
		        setVisible(false);
		    }
		    class MyPropetyWindowListener implements WindowListener{

				public void windowClosing(WindowEvent e){//閉じられている
					init();
					setVisible(false);
				}
				@Override
				public void windowOpened(WindowEvent e) {
				}
				@Override
				public void windowClosed(WindowEvent e) {
				}
				@Override
				public void windowIconified(WindowEvent e) {
				}
				@Override
				public void windowDeiconified(WindowEvent e) {
				}
				@Override
				public void windowActivated(WindowEvent e) {
				}
				@Override
				public void windowDeactivated(WindowEvent e) {
				}
		    }

		}
	}

	public void update(Graphics g){
	    paint(g);
	}
	public static void main(String[] args){
		new DigitalClock();

	}
}




