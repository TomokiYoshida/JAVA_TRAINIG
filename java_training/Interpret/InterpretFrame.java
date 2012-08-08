import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
public class InterpretFrame extends JFrame{



	int frameWidth = 800;
	int frameHeight = 700;

    JTabbedPane tabbedPane = new JTabbedPane();
	JPanel tabPanel1 = new InterpretTabPanel();
	JPanel tabPanel2 = new InterpretTabPanel();
	JPanel tabPanel3 = new InterpretTabPanel();
	JPanel tabPanel4 = new InterpretTabPanel();
	JPanel tabPanel5 = new InterpretTabPanel();

	public InterpretFrame(){
		super("Interpret");
	    tabbedPane.addTab("class1", tabPanel1);
	    tabbedPane.addTab("class2", tabPanel2);
	    tabbedPane.addTab("class3", tabPanel3);
	    tabbedPane.addTab("class4", tabPanel4);
	    tabbedPane.addTab("class5", tabPanel5);
		setBounds(10, 10, frameWidth, frameHeight);
	    getContentPane().add(tabbedPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args){
		InterpretFrame frame = new InterpretFrame();

	}



}
