package ex2_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

/**
 * 課題2-2 デジタル時計に次の機能追加を行ってください。 ● メニューを付けて、プロパティダイアログを開ける。 ●
 * プロパティダイアログでは、以下の項目を設定できる。 1. フォントの指定 2. フォントサイズの指定 3.
 * 文字色の指定（色が分かるようにカラーチップも表示すること） 4. 時計の背景色の指定 ● 描画に際して、ちらつきをなくすようにダブルバッファリングする。
 * （Swingは、デフォルト でダブルバッファリングしてくれます）。 ●
 * フォントとフォントサイズを変更すると、時計を表示すべきフレームの大きさを適切に自動変更 して、正しく表示されるようにする
 *
 */

public class DigitalClock extends JFrame implements Runnable {

	/** 時間を入れる変数 */
	static int h;
	private JFrame thisFrame;
	/** 分を入れる変数 */
	static int m;
	/** 秒 */
	static int s;
	static FontMetrics fm;
	Calendar now = Calendar.getInstance();
	PrefsUtil prefsUtil = new PrefsUtil();
	static Thread thread;
	boolean isClockActive = true;
	Dimension nowDimention = getSize();
	Image buf;
	static int fontSizes[] = { 8, 9, 10, 11, 12, 13, 14, 15, 20, 24, 32, 45,
			50, 80, 100, 120, 150 };
	static int fontSize;
	static Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };
	static String colorsStr[] = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY",
			"GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE",
			"YELLOW" };
	static Map<String, Color> colorsMap;
	static String characterColor;
	static String backGroundColor;
	Graphics ct;
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static int paintedWidth = 0;
	static int paintedHeight = 0;
	Font fonts[] = ge.getAllFonts();
	String font;
	Map<String, Font> fontMap;

	public DigitalClock() {
		// タイトル表示
		super("DigitalClock");
		thisFrame = this; // リスナーをセット
		this.addWindowListener(new MyWindowListener());
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		// windowサイズ
		setSize(400, 200);
		setMinimumSize(new Dimension(200, 200));
		colorsMap = new HashMap<String, Color>();
		for (int i = 0; i < colors.length; i++) {
			colorsMap.put(colorsStr[i], colors[i]);
		}
		fontMap = new HashMap<String, Font>();
		for (int i = 0; i < fonts.length; i++) {
			fontMap.put(fonts[i].getName(), fonts[i]);
		}
		font = prefsUtil.load("font", fonts[0].getName());
		fontSize = Integer.valueOf(prefsUtil.load("fontSize",
				String.valueOf(fontSizes[12])));
		characterColor = prefsUtil.load("characterColor", colorsStr[0]);
		backGroundColor = prefsUtil.load("backgroundColor", colorsStr[11]);
		setBackground(colorsMap.get(backGroundColor));
		thread = new Thread(this);
		thread.start();

		// メニューバーを設定
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		// [Menu]
		Menu menu = new Menu("Menu");
		menu.addActionListener(new MyMenuActionListener());
		menuBar.add(menu);
		// [Menu]-[Propety]
		MenuItem menuPro = new MenuItem("Property");
		menu.add(menuPro);

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		int width = nowDimention.width;
		int height = nowDimention.height;

		if (paintedWidth != width || paintedHeight != height) {
			paintedWidth = width;
			paintedHeight = height;
			buf = createImage(width, height);
		}
		ct = buf.getGraphics();

		// ct.fillRect(0 , 0 , width , height);
		ct.clearRect(0, 0, width, height);
		ct.setColor(colorsMap.get(characterColor));

		ct.setFont(new Font(font, Font.BOLD, fontSize));

		fm = ct.getFontMetrics();
		String mes = h + ":" + m + ":" + s;
		int strWidth = fm.stringWidth(mes);
		int strHeight = fm.getHeight();
		if (width <= strWidth || height <= strHeight) {
			width += strWidth;
			height += strHeight;
			setSize(width, height);
			buf = createImage(width, height);
			ct = buf.getGraphics();
			ct.clearRect(0, 0, width, height);
			ct.setColor(colorsMap.get(characterColor));
			ct.setFont(new Font(font, Font.BOLD, fontSize));
		}
		ct.drawString(mes, (width - strWidth) / 2, (height - strHeight) / 2
				+ strHeight);
		g.drawImage(buf, 0, 0, this);

		/*
		 * g.clearRect(0, 0,width,height); g.setColor(color); g.setFont(new
		 * Font(font,Font.BOLD,fontSize)); fm = g.getFontMetrics(); String mes =
		 * h+":"+m+":"+s; int strWidth = fm.stringWidth(mes); int strHeight =
		 * fm.getHeight(); if(width <= strWidth || height <= strHeight){ width
		 * += strWidth; height += strHeight; setSize(width, height); }
		 * g.drawString(mes, ( width - strWidth ) / 2, ( height - strHeight ) /
		 * 2 + strHeight);
		 */
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
			if (getExtendedState() == ICONIFIED) {
				setTitle(h + ":" + m + ":" + s);
			}
			nowDimention = getSize();
			repaint();
			try {
				Thread.sleep(1000); // スリープ１秒
			} catch (InterruptedException e) {
			}
		}
	}

	class MyWindowListener implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) { // 開かれた
			System.out.println("windowOpened");
		}

		@Override
		public void windowClosing(WindowEvent e) {// 閉じられている
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

		@Override
		public void windowClosed(WindowEvent e) {// 閉じた
			System.out.println("windowClosed");
		}

		@Override
		public void windowIconified(WindowEvent e) {// アイコン化された
			System.out.println("windowIconified");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {// 非アイコン化された
			setTitle("DigitalClock");
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
		}

		@Override
		public void mouseReleased(MouseEvent e) {
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
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}
	}

	class MyMenuActionListener implements ActionListener {
		PropertyDialog dlg = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (dlg == null) {
				dlg = new PropertyDialog(thisFrame);
			}
			dlg.setVisible(true);
		}

		/**
		 * プロパティダイアログでは、以下の項目を設定できる。 フォントの指定 フォントサイズの指定 文字色の指定 時計の背景色の指定
		 *
		 */

		class PropertyDialog extends Dialog implements ActionListener {

			int x = 400;
			int y = 300;
			/** fontのリストボックス */
			Choice c1 = new Choice();
			/** font sizeのリストボックス */
			Choice c2 = new Choice();
			/** font colorのリストボックス */
			Choice c3 = new Choice();
			JPanel c3Panel = new JPanel();
			DefaultListModel model = new DefaultListModel();
			JList j3 = new JList();
			JButton b3 = new JButton();


			/** backgroundのリストボックス */
			Choice c4 = new Choice();
			JButton b4 = new JButton();
			JPanel c4Panel = new JPanel();
			String c1Index;
			String c2Index;
			String c3Index;
			String c4Index;
			GridBagLayout gbl = new GridBagLayout();

			@Override
			public void setVisible(boolean b) {
				init();
				super.setVisible(b);
			}

			void init() {
				c1.select(c1Index);
				c2.select(c2Index);
				c3.select(c3Index);
				c4.select(c4Index);
				b3.setBackground(colors[c3.getSelectedIndex()]);
				b4.setBackground(colors[c4.getSelectedIndex()]);
			}

			void addComponent(Component c, int x, int y, int w, int h,
					int anchor) {
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

			PropertyDialog(JFrame owner) {
				super(owner);

				c1Index = font;
				c2Index = String.valueOf(fontSize);
				c3Index = characterColor;
				c4Index = backGroundColor;
				ItemListener listener = new MyItemListener();
				c1.addItemListener(listener);
				c2.addItemListener(listener);
				c3.addItemListener(listener);
				MouseListener listener2 = new MyMouseListener2();
				c3Panel.setSize(130, 50);
				c3Panel.add(c3);
				c3Panel.add(b3);
				c4.addItemListener(listener);
				c4Panel.setSize(130, 50);
				c4Panel.add(c4);
				c4Panel.add(b4);
				setLayout(gbl);
				Label fontLabel = new Label("font:");
				for (int i = 0; i < fonts.length; i++) {
					c1.add(fonts[i].getName());

				}
				Label fontSizeLabel = new Label("font size:");
				for (int i = 0; i < fontSizes.length; i++) {
					c2.add(String.valueOf(fontSizes[i]));
				}
				Label characterColorLabel = new Label("character color:");
				for (int i = 0; i < colorsStr.length; i++) {
					c3.add(String.valueOf(colorsStr[i]));
				}
				/*
				String[] initData = { "Blue", "Green", "Red", "Whit", "Black" };
				for (int i = 0; i < 5; i++) {
					model.addElement(initData[i]);
				}
				j3 = new JList(model);
				j3.setSize(100, 80);
				MyCellRenderer renderer = new MyCellRenderer();
				j3.setCellRenderer(renderer);

				j3.addMouseListener(new MyMouseListener2());
				JScrollPane sp = new JScrollPane();
				sp.getViewport().setView(j3);
				sp.setPreferredSize(new Dimension(100, 80));
				sp.setSize(180, 80);*/
				Label backgroundColorLabel = new Label("background color:");
				for (int i = 0; i < colorsStr.length; i++) {
					c4.add(String.valueOf(colorsStr[i]));
				}
				addComponent(fontLabel, 0, 0, 1, 1, GridBagConstraints.EAST);
				addComponent(c1, 1, 0, 1, 1, GridBagConstraints.WEST);
				addComponent(fontSizeLabel, 0, 1, 1, 1, GridBagConstraints.EAST);
				addComponent(c2, 1, 1, 1, 1, GridBagConstraints.WEST);
				addComponent(characterColorLabel, 0, 2, 1, 1,
				GridBagConstraints.EAST);
				 addComponent(c3Panel, 1, 2, 1, 1,GridBagConstraints.WEST);
				addComponent(backgroundColorLabel, 0, 3, 1, 1,
				GridBagConstraints.EAST);
				addComponent(c4Panel, 1, 3, 1, 1, GridBagConstraints.WEST);
				Button b1 = new Button("OK");
				b1.addActionListener(this);
				Button b2 = new Button("CANCEL");
				b2.addActionListener(this);
				addComponent(b1, 0, 4, 1, 1, GridBagConstraints.EAST);
				addComponent(b2, 1, 4, 1, 1, GridBagConstraints.WEST);
				setTitle("Property");
				addWindowListener(new MyPropetyWindowListener());
				setSize(x, y);

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("OK")) {
					font = fonts[c1.getSelectedIndex()].getName();
					fontSize = fontSizes[c2.getSelectedIndex()];
					characterColor = colorsStr[c3.getSelectedIndex()];
					thisFrame.setBackground(colors[c4.getSelectedIndex()]);
					backGroundColor = colorsStr[c4.getSelectedIndex()];
					c1Index = c1.getSelectedItem();
					c2Index = c2.getSelectedItem();
					c3Index = c3.getSelectedItem();
					c4Index = c4.getSelectedItem();
					buf = thisFrame.createImage(nowDimention.width,
							nowDimention.height);
				} else {
					init();
					font = c1Index;
					fontSize = Integer.valueOf(c2Index);
					characterColor = c3Index;
					thisFrame.setBackground(colors[c4.getSelectedIndex()]);
					backGroundColor = c4Index;
				}
				setVisible(false);
			}

			class MyMouseListener2 implements MouseListener {
				@Override
				public void mouseClicked(MouseEvent e) {
					/* 再描画してみる */
					j3.repaint();
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}
			}

			class MyPropetyWindowListener implements WindowListener {

				@Override
				public void windowClosing(WindowEvent e) {// 閉じられている
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

			class MyItemListener implements ItemListener {

				@Override
				public void itemStateChanged(ItemEvent e) {

					font = fonts[c1.getSelectedIndex()].getName();
					fontSize = fontSizes[c2.getSelectedIndex()];
					characterColor = colorsStr[c3.getSelectedIndex()];
					thisFrame.setBackground(colors[c4.getSelectedIndex()]);
					backGroundColor = colorsStr[c4.getSelectedIndex()];
					b3.setBackground(colors[c3.getSelectedIndex()]);
					b4.setBackground(colors[c4.getSelectedIndex()]);
				}
			}

			class MyActionListener implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					font = fonts[c1.getSelectedIndex()].getName();
					fontSize = fontSizes[c2.getSelectedIndex()];
					characterColor = colorsStr[c3.getSelectedIndex()];
					thisFrame.setBackground(colors[c4.getSelectedIndex()]);
					backGroundColor = colorsStr[c4.getSelectedIndex()];
					b3.setBackground(colors[c3.getSelectedIndex()]);
					b4.setBackground(colors[c4.getSelectedIndex()]);
				}
			}
		}

		class MyCellRenderer implements ListCellRenderer {
			JLabel label;

			public MyCellRenderer() {
				label = new JLabel();
				label.setOpaque(true);
			}

			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				label.setText(value.toString());
				System.out.println(value.toString());
//				label.setBackground();
//				label.setForeground(Color.black);

/*				if (isSelected) {
					label.setText("●  " + value.toString() + "  ●");

					label.setBackground(Color.red);
					label.setForeground(Color.white);
				} else {
					label.setText(value.toString());

					label.setBackground(Color.white);
					label.setForeground(Color.black);
				}*/

				return label;
			}
		}
	}

	public static void main(String[] args) {
		new DigitalClock();

	}
}
