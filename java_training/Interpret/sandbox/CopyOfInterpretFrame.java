package sandbox;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
練習問題16.6、16.7、16.8、16.10をそれぞれ作成する代わりに、Interpretプログラムを
１つ作成する。
練習問題で指定された操作ができること。更に、以下のことも考慮して作成する。
● GUIで作成する（AWT/Swingのどちらでも良い）
● 自分自身を起動できるようにする
● java.awt.FrameのsetVisible()、setTitle()、setSize()、setBackground()
を呼び出すデモができること
● private finalのインスタンスフィールドの書き換えもできること

*16.06
*要求された型のオブジェクトを生成し、ユーザがそのオブジェクトのフィールドを調べて修正できるInterpretプログラムを作成しなさい
*
*16.07
*オブジェクトに対してメソッドを呼び出すようにInterpretプログラムを修正しなさい。
*戻り値やスローされた礼儀を適切に表示するようにしなさい
*16.08
*Interpretプログラムをさらに修正して、任意のクラスのコンストラクタをユーザが呼び出せるようにしなさい。
*その際にどんな例外も表示しなさい
*また、オブジェクトの生成が成功したら、そのオブジェクトのメソッドをユーザが呼び出せるようにしなさい。*
*16.10
*Iterpretをさらに修正して、ユーザが生成する配列の型とサイズを指定できて
*その配列の要素を読み出したり設定したりできたて、また、配列の要素とて含まれているオブジェクトを指定して、
*そのオブジェクトのフィールドに
*アクセスしたり、メソッドを呼び出したりできるようにしなさい
*/
public class CopyOfInterpretFrame extends JFrame implements ActionListener{

	int frameWidth = 600;
	int frameHeight = 600;

	private JLabel lType = new JLabel("型");
	private JLabel lSize = new JLabel("サイズ");
	private JLabel lValue = new JLabel("値");
	private JLabel lList = new JLabel("配列");
	private JLabel lConst = new JLabel("コンストラクタ");
	private JLabel lConstParam = new JLabel("コンストラクタの引数");
	private JLabel lMethod = new JLabel("メソッド");
	private JLabel lMethodParam = new JLabel("メソッドの引数");
	private JLabel lField = new JLabel("フィールド");

	private JButton bType = new JButton("配列生成");
	private JButton bConst = new JButton("選択");
	private JButton bMethod1 = new JButton("選択");
	private JButton bMethod2 = new JButton("実行");
	private JButton bField = new JButton("更新");
	private JButton bGene = new JButton("生成");
	String[] comboBox1 = {"java.awt.Frame()","java.awt.Frame(String)"};
	private JComboBox cbConst = new JComboBox(comboBox1);
	String[] comboBox2 = {"setVisible(boolean)","setSize(int, int)"};
	private JComboBox cbMethod = new JComboBox(comboBox2);
	String[] comboBox3 = {"field1"};
	private JComboBox cbField = new JComboBox(comboBox3);

	String[][] tableData0 = { {"[0]", "frame1"}, {"[1]", "frame2"}};
	String[][] tableData1 = { {"java.awt.String", "test"}, {"java.awt.String", "test2"}};
	String[][] tableData2 = { {"java.String","test"}};
	String[][] tableData3 = { {"value1"}};
	String[] columnNames0 = { "番号", "名前"};
	String[] columnNames1 = { "引数の型", "値"};
	String[] columnNames2 = { "引数の型", "値"};
	String[] columnNames3 = { "現在値", "変更値"};
	DefaultTableModel tableModel0 = new DefaultTableModel(tableData0, columnNames0);
	DefaultTableModel tableModel1 = new DefaultTableModel(tableData1, columnNames1);
	DefaultTableModel tableModel2 = new DefaultTableModel(tableData2, columnNames2);
	DefaultTableModel tableModel3 = new DefaultTableModel(tableData3, columnNames3);

	private JTable tList =new JTable(tableModel0);
	private JTable tConst1 =new JTable(tableModel1);
	private JTable tMethod1 =new JTable(tableModel2);
	private JTable tField1 =new JTable(tableModel3);
	private JScrollPane pane0 = new JScrollPane(tList);
	private JScrollPane pane1 = new JScrollPane(tConst1);
	private JScrollPane pane2 = new JScrollPane(tMethod1);
	private JScrollPane pane3 = new JScrollPane(tField1);
	private JTextField tType = new JTextField("java.awt.Frame",20);
	private JTextField tSize = new JTextField("1",5);
	private JTable tMethod =new JTable(3,2);
    GridBagLayout gbl1 = new GridBagLayout();

	/**-----------------------------------------------
	 *  |p[0][0]|p[1][0]|p[2][0]|p[3][0]|p[4][0]|
	 *  -----------------------------------------------
	 *  |p[0][1]|p[1][1]|p[2][1]|p[3][1]|p[4][1]|
	 *  -----------------------------------------------
	 *  |p[0][2]|p[1][2]|p[2][2]|p[3][2]|p[4][2]|
	 *  -----------------------------------------------
	 *  |p[0][3]|p[1][3]|p[2][3]|p[3][3]|p[4][3]|
	 *  -----------------------------------------------
	 *  |p[0][4]|p[1][4]|p[2][4]|p[3][4]|p[4][4]|
	 *  -----------------------------------------------
	 *  |p[0][5]|p[1][5]|p[2][5]|p[3][5]|p[4][5]|
	 *  -----------------------------------------------
	 *  |p[0][6]|p[1][6]|p[2][6]|p[3][6]|p[4][6]|
	 *  -----------------------------------------------
	 */
    //[列][行] [x][y]
	JPanel[][] panels;
	JPanel[] linePanels;

	{
		//パネルを生成
		int width = 5;//x
		int height = 10;//y
		panels = new JPanel[width][height];
		linePanels = new JPanel[height-1];
		for(int i = 0; i < height-1; i++ ){
			linePanels[i] = new JPanel();
			JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
			separator.setPreferredSize(new Dimension(frameWidth-30 , 10));
			linePanels[i].add(separator);
		}

		for(int i = 0; i < width; i++ ){
			panels[i] = new JPanel[height];
			for(int j = 0; j < height; j++){
				panels[i][j] = new JPanel();
			}
		}
		int paneWidth = 300;
		int paneHeight = 55;
		pane0.setPreferredSize(new Dimension(paneWidth, paneHeight));
		pane1.setPreferredSize(new Dimension(paneWidth, paneHeight));
		pane2.setPreferredSize(new Dimension(paneWidth, paneHeight));
		pane3.setPreferredSize(new Dimension(paneWidth, paneHeight));

		bType.addActionListener(this);
		bConst.addActionListener(this);
		bMethod1.addActionListener(this);
		bMethod2.addActionListener(this);
		bField.addActionListener(this);
		bGene.addActionListener(this);

	}

  	 void addComponent( GridBagLayout gbl, Component  c,  int x, int y, int w, int h, int anchor, int fill) {
  		 GridBagConstraints gbc = new GridBagConstraints();

  		   	gbc.fill = fill;
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
	CopyOfInterpretFrame(){
		super("Interpret");
		setBounds(10, 10, frameWidth, frameHeight);
		setLayout(gbl1);
		int l = 0;//現在の行数
		//1行目
		addComponent(gbl1, panels[0][0], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][0], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][0], 2, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][0], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][0], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//2行目
		addComponent(gbl1, panels[0][1], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][1], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][1], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][1], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][1], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//区切り
		addComponent(gbl1, linePanels[0], 0, l, 5,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;//改行
		//3行目
		addComponent(gbl1, panels[0][2], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][2], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][2], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][2], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][2], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//4行目
		addComponent(gbl1, panels[0][3], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][3], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][3], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][3], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][3], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//5行目
		addComponent(gbl1, panels[0][4], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][4], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][4], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][4], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][4], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//区切り
		addComponent(gbl1, linePanels[1], 0, l, 5,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;
		//6行目
		addComponent(gbl1, panels[0][5], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][5], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][5], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][5], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][5], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//7行目
		addComponent(gbl1, panels[0][6], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][6], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][6], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][6], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][6], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;//改行
		//区切り
		addComponent(gbl1, linePanels[2], 0, l, 5,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;
		//8行目
		addComponent(gbl1, panels[0][7], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][7], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][7], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][7], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][7], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		l++;
		//9行目
		addComponent(gbl1, panels[0][8], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][8], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][8], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][8], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][8], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		//10行目
		addComponent(gbl1, panels[0][9], 0, l, 1,1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][9], 1, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][9], 2, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[3][9], 3, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComponent(gbl1, panels[4][9], 4, l, 1,1, GridBagConstraints.WEST, GridBagConstraints.NONE);

		l = 0;//現在の行数

		panels[0][l].add(lType);
		panels[1][l].add(tType);
		l++;//改行
		panels[0][l].add(lSize);
		panels[1][l].add(tSize);
		panels[2][l].add(bType);
		l++;//改行
		panels[0][l].add(lList);
		panels[1][l].add(pane0);
		l++;//改行
		panels[0][l].add(lConst);
		panels[1][l].add(cbConst);
		//panels[2][l].add(bConst);
		l++;//改行
		panels[0][l].add(lConstParam);
		panels[1][l].add(pane1);
		panels[2][l].add(bGene);
		l++;//改行
		panels[0][l].add(lMethod);
		panels[1][l].add(cbMethod);
		//panels[2][l].add(bMethod1);
		l++;//改行
		panels[0][l].add(lMethodParam);
		panels[1][l].add(pane2);
		panels[2][l].add(bMethod2);
		l++;//改行
		panels[0][l].add(lField);
		panels[1][l].add(pane3);
		panels[2][l].add(bField);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		CopyOfInterpretFrame frame = new CopyOfInterpretFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());


	}



}
