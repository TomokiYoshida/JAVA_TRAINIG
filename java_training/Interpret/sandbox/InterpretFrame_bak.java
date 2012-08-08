package sandbox;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Frame;
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
public class InterpretFrame_bak extends JFrame implements ActionListener{

	private JLabel lType = new JLabel("型");
	private JLabel lValue = new JLabel("値");
	private JLabel lConst = new JLabel("コンストラクタ");
	private JLabel lMethod = new JLabel("メソッド");
	private JLabel lField = new JLabel("フィールド");

	private JButton bType = new JButton("表示");
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



	String[][] tableData1 = { {"java.lang.String"}};
	String[][] tableData2 = { {""}};
	String[][] tableData3 = { {"boolean"}};
	String[][] tableData4 = { {""}};
	String[] columnNames1 = { "引数の型"};
	String[] columnNames2 = {  "値"};
	private JTable tConst1 =new JTable(tableData1, columnNames1);
	private JTable tConst2 =new JTable(tableData2, columnNames2);
	private JTable tMethod1 =new JTable(tableData3, columnNames1);
	private JTable tMethod2 =new JTable(tableData4, columnNames2);
	private JScrollPane pane1 = new JScrollPane(tConst1);
	private JScrollPane pane2 = new JScrollPane(tConst2);
	private JScrollPane pane3 = new JScrollPane(tMethod1);
	private JScrollPane pane4 = new JScrollPane(tMethod2);
	private JTextField tType = new JTextField("java.awt.Frame",20);
	private JTable tMethod =new JTable(3,2);

	/**----------
	 *  |    p1    |
	 *  ---------
	 *  |p2|p3|4|
	 *  ----------
	 *  |    p5   |
	 *  ----------
	 */
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();


	InterpretFrame_bak(){
		super("Interpret");
		setBounds(10, 10, 500, 300);
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.WEST);
		add(p3, BorderLayout.CENTER);
		add(p4, BorderLayout.EAST);
		add(p5, BorderLayout.SOUTH);

		p1.setLayout(new GridLayout(0,3));
		p1.add(lType);
		p1.add(tType);
		p1.add(bType);

		p1.add(lConst);
		p1.add(cbConst);
		p1.add(bConst);

		pane1.setPreferredSize(new Dimension(150, 40));
		pane2.setPreferredSize(new Dimension(150, 40));
		pane3.setPreferredSize(new Dimension(150, 40));
		pane4.setPreferredSize(new Dimension(150, 40));
		p1.add(pane1);
		p1.add(pane2);
		p1.add(bGene);
		p1.add(lMethod);
		p1.add(cbMethod);
		p1.add(bMethod1);
		p1.add(pane3);
		p1.add(pane4);
		p1.add(bMethod2);
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setPreferredSize(new Dimension(200 , 5));
		p1.add(separator);
		p1.add(lField);
		p1.add(cbField);
//		p1.add(bField)

	//	p1.add(p1_1);
		//p1.add(pane1);
		//p1.add(pane2);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		InterpretFrame_bak frame = new InterpretFrame_bak();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}



}
