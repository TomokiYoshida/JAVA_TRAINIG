package ex1_3;

import java.awt.AWTException;
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
import java.awt.GraphicsEnvironment;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Window;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Calendar;

/**
 * 課題1-2 デジタル時計に次の機能追加を行ってください。 メニューを付けて、プロパティダイアログを開ける。
 * プロパティダイアログでは、以下の項目を設定できる。 フォントの指定 フォントサイズの指定 文字色の指定 時計の背景色の指定
 * 描画に際して、ちらつきをなくすようにダブルバッファリングする。
 * フォントとフォントサイズを変更すると、時計を表示すべきフレームの大きさを適切に自動変更して、正しく表示されるようにする。
 *
 *
 *
 * WindowではなくWindowクラスを使用して、フレーム枠のないデジタル時計にする。
 *
 * 課題1-２のダイアログで指定できた属性は、マウスの右クリックでポップアップメニューを表示して、
 * カスケード形式で選択出来るようにする（ダイアログは開かない）。
 * 時計内をマウスの左ボタンでクリックしたまま、デスクトップ上でウィンドウを移動させることができるようにする。
 *
 *
 *
 *
 */

public class DigitalClock extends Window implements Runnable {

	/** 時間を入れる変数 */
	static int h;
	private Window thisWindow;
	/** 分を入れる変数 */
	static int m;
	/** 秒 */
	static int s;

	private int x = 0;
	private int y = 0;
	private int xOnScreen = 0;
	private int yOnScreen = 0;
	static FontMetrics fm;
	static int fontSize = 15;
	static Color color = Color.BLACK;
	Calendar now = Calendar.getInstance();
	PopupMenu pop = new PopupMenu("Kitty");
	private Robot robot;
	private BufferedImage image;
	private boolean isTransparent =false;
	static Thread thread;
	boolean isClockActive = true;
	boolean isPopUped = false;
	Dimension nowDimention = getSize();
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Font fonts[] = ge.getAllFonts();
	int fontSizes[] = {8,9,10,11,12,13,14,15,20,24,32,45,50,80};
	Color colors[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	String colorsStr[] ={"BLACK","BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};
	String font = fonts[0].getName();

	private CheckboxMenuItem mFontItemList[] = {};
	private CheckboxMenuItem mFontSizeItemList[] = {};
	private CheckboxMenuItem mFontColorItemList[] = {};
	private CheckboxMenuItem mBackgroundColorItemList[] = {};

	{
		mFontItemList = new CheckboxMenuItem[fonts.length];
		mFontItemList[0] = new CheckboxMenuItem(fonts[0].getName(), true);
		for(int i = 1; i < fonts.length; i ++){
		mFontItemList[i] = new CheckboxMenuItem(fonts[i].getName(), false);
		}
		mFontSizeItemList = new CheckboxMenuItem[fontSizes.length];
		for(int i = 0; i < fontSizes.length; i ++){
		mFontSizeItemList[i] = new CheckboxMenuItem(String.valueOf(fontSizes[i]), false);
		}
		mFontSizeItemList[7] = new CheckboxMenuItem(String.valueOf(fontSizes[7]), true);
		mFontColorItemList = new CheckboxMenuItem[colors.length];
		mBackgroundColorItemList = new CheckboxMenuItem[colors.length];
		for(int i = 0; i < colors.length; i ++){
			mFontColorItemList[i] = new CheckboxMenuItem(colorsStr[i], false);
			mBackgroundColorItemList[i] = new CheckboxMenuItem(colorsStr[i], false);
		}
		mFontColorItemList[0] = new CheckboxMenuItem(colorsStr[0], true);
		mBackgroundColorItemList[11] = new CheckboxMenuItem(colorsStr[11], true);


	}

	public DigitalClock() {
		super(new Frame());
		// タイトル表示
		// super("DigitalClock");
		thisWindow = this;
		// リスナーをセット
		// this.addWindowListener(new MyWindowListener());
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		setBackground(Color.white);

		// Font
		Menu mFont = new Menu("Font");
		mFont.addActionListener(new MyMenuActionListener());
		for(int i = 0; i < mFontItemList.length; i++){
			mFontItemList[i].addItemListener(new MyFontItemListener(i));
			mFont.add(mFontItemList[i]);
		}
		pop.add(mFont);
		Menu mFontSize = new Menu("Font Size");
		for(int i = 0; i < mFontSizeItemList.length; i++){
			mFontSizeItemList[i].addItemListener(new MyFontSizeItemListener(i));
			mFontSize.add(mFontSizeItemList[i]);
		}
		pop.add(mFontSize);
		Menu mFontColor = new Menu("Font Color");
		for(int i = 0; i < mFontColorItemList.length; i++){
			mFontColorItemList[i].addItemListener(new MyFontColorItemListener(i));
			mFontColor.add(mFontColorItemList[i]);
		}
		pop.add(mFontColor);
		Menu mBackgroundColor = new Menu("Background Color");
		for(int i = 0; i < mBackgroundColorItemList.length; i++){
			mBackgroundColorItemList[i].addItemListener(new MyBackgroundColorItemListener(i));
			mBackgroundColor.add(mBackgroundColorItemList[i]);
		}
		pop.add(mBackgroundColor);

		setLayout(new GridLayout(5, 2));

		add(pop);
		addMouseListener(new MyMouseListener());
		// windowサイズ
		setSize(200, 200);
		thread = new Thread(this);
		thread.start();
		setMinimumSize(new Dimension(200, 200));
		System.out.println("max" + getSize());

		   try {
	            robot = new Robot();
	        } catch (AWTException ex) {
	            ex.printStackTrace();
	            return;
	        }

	        // 範囲を指定してキャプチャ
	        Rectangle bounds = new Rectangle(nowDimention);
	        image = robot.createScreenCapture(bounds);
	        thisWindow.setBounds(bounds);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DigitalClock();

	}

	@Override
	public void paint(Graphics g) {
		int width = nowDimention.width;
		int height = nowDimention.height;
		// g.setBackground(Color.WHITE);
		g.clearRect(0, 0, width, height);
		g.setColor(color);
		g.setFont(new Font(font, Font.BOLD, fontSize));
		fm = g.getFontMetrics();
		String mes = h + ":" + m + ":" + s;
		int strWidth = fm.stringWidth(mes);
		int strHeight = fm.getHeight();
		if (width <= strWidth || height <= strHeight) {
			width += strWidth;
			height += strHeight;
			setSize(width, height);
		}
		if(isTransparent)g.drawImage(image, 0, 0, this);
		g.drawString(mes, (width - strWidth) / 2, (height - strHeight) / 2

				+ strHeight);
		// g.setFont(new Font(font, Font.ITALIC, fontSize));
		// 時刻を表示
		// g.drawString(h+":"+m+":"+s,nowDimention.width/4,
		// 2*nowDimention.height/3);
	}

	@Override
	public void run() {
		while (isClockActive == true) {
			// 時を代入
			h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			// 分を代入
			m = Calendar.getInstance().get(Calendar.MINUTE);
			// 秒を代入
			s = Calendar.getInstance().get(Calendar.SECOND);
			/*
			 * if(getExtendedState() == ICONIFIED){ setTitle(h+":"+m+":"+s); }
			 */
			nowDimention = getSize();

			repaint();
			try {
				Thread.sleep(800); // スリープ１秒
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * windowに関するリスナーを提供
	 *
	 * @author tom
	 *
	 */
	class MyWindowListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) { // 開かれた
			System.out.println("windowOpened");
		}

		@Override
		public void windowClosing(WindowEvent e) {// 閉じられている
			System.out.println("windowClosing");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {// 閉じた
			// いつ呼ばれるの?

			System.out.println("windowClosed");
		}

		@Override
		public void windowIconified(WindowEvent e) {// アイコン化された
			System.out.println("windowIconified");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {// 非アイコン化された
			// setTitle("DigitalClock");
			System.out.println("windowDeiconified");
		}

		@Override
		public void windowActivated(WindowEvent e) {// アクティブになった
			System.out.println("windowActivated");
		}

		@Override
		public void windowDeactivated(WindowEvent e) {// 非アクティブになった
			System.out.println("wndowDeactivated");
		}
	}
	class MyMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("mousePressed");

			if (e.isPopupTrigger()) {
				System.out.println("popup");
				pop.show(thisWindow, e.getX(), e.getY());
			}x = e.getX();
			y = e.getY();
			xOnScreen = e.getXOnScreen();
			yOnScreen = e.getYOnScreen();
	}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("mouseReleased");
			if (e.isPopupTrigger()) {
				if(isPopUped)isPopUped = false;
				else{ isPopUped = true;
				System.out.println("popup");
				pop.show(thisWindow, e.getX(), e.getY());
				}
			}
	        // 範囲を指定してキャプチャ
			if(isTransparent){
	        Rectangle bounds = new Rectangle( xOnScreen -e.getX(),  yOnScreen - e.getY(), nowDimention.width, nowDimention.height);
	        thisWindow.setVisible(false);
	        image = robot.createScreenCapture(bounds);
	        thisWindow.setVisible(true);
	        thisWindow.setBounds(bounds);
			}
			System.out.println("mouseReleased");
		}

		/** マウスがフレーム内に入ったとき */
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
		}
	}

	class MyMouseMotionListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {

			   try {
		            robot = new Robot();
		        } catch (AWTException ex) {
		            ex.printStackTrace();
		            return;
		        }

		        // 範囲を指定してキャプチャ
			   if(isTransparent){
		        Rectangle bounds = new Rectangle(e.getX() -2*x + xOnScreen, e.getY()-2*y + yOnScreen, nowDimention.width, nowDimention.height);
		        thisWindow.setVisible(false);
		        image = robot.createScreenCapture(bounds);
		        thisWindow.setVisible(true);
		        thisWindow.setBounds(bounds);
			   }
		thisWindow.setLocation(e.getX() -2*x + xOnScreen, e.getY()-2*y + yOnScreen);
			xOnScreen = e.getX()-x + xOnScreen;
			yOnScreen = e.getY()-y + yOnScreen;


		}
		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}

	class MyMenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());/*
			switch (c1.getSelectedIndex()) {
			case 0:
				font = Font.SANS_SERIF;
				break;
			case 1:
				font = Font.MONOSPACED;
				break;
			default:
				font = Font.DIALOG_INPUT;
			}
			switch (c2.getSelectedIndex()) {

			case 0:
				fontSize = 15;
				break;
			case 1:
				fontSize = 30;
				break;
			case 2:
				fontSize = 50;
				break;
			default:
				fontSize = 15;
			}
			switch (c3.getSelectedIndex()) {

			case 0:
				color = Color.BLACK;
				break;
			case 1:
				color = Color.YELLOW;
				break;
			case 2:
				color = Color.BLUE;
				break;
			default:
				color = Color.BLACK;
			}
			switch (c4.getSelectedIndex()) {
			case 0:
				thisWindow.setBackground(Color.WHITE);
				break;
			case 1:
				thisWindow.setBackground(Color.GRAY);
				break;
			case 2:
				thisWindow.setBackground(Color.PINK);
				break;
			default:
				thisWindow.setBackground(Color.WHITE);
			}
			setVisible(false);*/
		}
	}


	class MyFontItemListener implements ItemListener{

		private int itemNumber = 0;
		MyFontItemListener(int itemNumber){
			this.itemNumber = itemNumber;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < mFontItemList.length; i++){
					mFontItemList[i].setState(false);
				}
				mFontItemList[itemNumber].setState(true);
				font = fonts[itemNumber].getName();

		}
	}
	class MyFontSizeItemListener implements ItemListener{

		private int itemNumber = 0;
		MyFontSizeItemListener(int itemNumber){
			this.itemNumber = itemNumber;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < mFontSizeItemList.length; i++){
					mFontSizeItemList[i].setState(false);
				}
				mFontSizeItemList[itemNumber].setState(true);
				fontSize = fontSizes[itemNumber];
		}
	}
	class MyFontColorItemListener implements ItemListener{
		private int itemNumber = 0;
		MyFontColorItemListener(int itemNumber){
			this.itemNumber = itemNumber;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < mFontColorItemList.length; i++){
					mFontColorItemList[i].setState(false);
				}
				mFontColorItemList[itemNumber].setState(true);
				color = colors[itemNumber];
		}

	}
	class MyBackgroundColorItemListener implements ItemListener{
		private int itemNumber = 0;
		MyBackgroundColorItemListener(int itemNumber){
			this.itemNumber = itemNumber;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < mBackgroundColorItemList.length; i++){
					mBackgroundColorItemList[i].setState(false);
				}
				mBackgroundColorItemList[itemNumber].setState(true);
				isTransparent = false;
				thisWindow.setBackground(colors[itemNumber]);
		}

	}


	@Override
	public void update(Graphics g) {
		paint(g);
	}
}
