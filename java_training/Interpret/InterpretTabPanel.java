import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * 練習問題16.6、16.7、16.8、16.10をそれぞれ作成する代わりに、Interpretプログラムを １つ作成する。
 * 練習問題で指定された操作ができること。更に、以下のことも考慮して作成する。 ● GUIで作成する（AWT/Swingのどちらでも良い） ●
 * 自分自身を起動できるようにする ●
 * java.awt.FrameのsetVisible()、setTitle()、setSize()、setBackground()
 * を呼び出すデモができること ● private finalのインスタンスフィールドの書き換えもできること
 *
 * 16.06 要求された型のオブジェクトを生成し、ユーザがそのオブジェクトのフィールドを調べて修正できるInterpretプログラムを作成しなさい
 *
 * 16.07 オブジェクトに対してメソッドを呼び出すようにInterpretプログラムを修正しなさい。
 * 戻り値やスローされた礼儀を適切に表示するようにしなさい 16.08
 * Interpretプログラムをさらに修正して、任意のクラスのコンストラクタをユーザが呼び出せるようにしなさい。 その際にどんな例外も表示しなさい
 * また、オブジェクトの生成が成功したら、そのオブジェクトのメソッドをユーザが呼び出せるようにしなさい。* 16.10
 * Iterpretをさらに修正して、ユーザが生成する配列の型とサイズを指定できて
 * その配列の要素を読み出したり設定したりできたて、また、配列の要素とて含まれているオブジェクトを指定して、 そのオブジェクトのフィールドに
 * アクセスしたり、メソッドを呼び出したりできるようにしなさい
 */
public class InterpretTabPanel extends JPanel implements ActionListener {

	int panelWidth = 800;
	int panelHeight = 700;
	static int objectId = 0;

	// ラベル
	private JLabel lType = new JLabel("型");
	private JLabel lSize = new JLabel("サイズ");
	private JLabel lValue = new JLabel("値");
	private JLabel lList = new JLabel("配列");
	private JLabel lConst = new JLabel("コンストラクタ");
	private JLabel lConstParam = new JLabel("コンストラクタの引数");
	private JLabel lMethod = new JLabel("メソッド");
	private JLabel lMethodParam = new JLabel("メソッドの引数");
	private JLabel lField = new JLabel("フィールド");
	private JLabel lResult = new JLabel("結果");

	// ボタン
	private JButton bType = new JButton("配列生成");
	private JButton bConst = new JButton("選択");
	private JButton bMethod1 = new JButton("選択");
	private JButton bMethod2 = new JButton("実行");
	private JButton bField = new JButton("更新");
	private JButton bGene = new JButton("生成");
	// コンボボックス
	String[] comboBox1 = {};
	String[] comboBox2 = {};
	String[] comboBox3 = {};
	private JComboBox cbConst = new JComboBox(comboBox1);
	private JComboBox cbMethod = new JComboBox(comboBox2);
	private JComboBox cbField = new JComboBox(comboBox3);

	// タイトル-コンボボックスのマップ
	Map<String, JComboBox> comboMap = new HashMap<String, JComboBox>();

	// テーブル
	private JTextArea tResult = new JTextArea(3, 25);
	String[][] tableData0 = {};
	String[][] tableData1 = {};
	String[][] tableData2 = {};
	String[][] tableData3 = {};
	String[] columnNames0 = { "番号", "名前" };
	String[] columnNames1 = { "引数の型", "値" };
	String[] columnNames2 = { "引数の型", "値" };
	String[] columnNames3 = { "型", "フィールド名", "現在値", "変更値" };
	DefaultTableModel tableModel0 = new MyDefaultTableModel(tableData0,
			columnNames0);
	DefaultTableModel tableModel1 = new MyDefaultTableModel(tableData1,
			columnNames1);
	DefaultTableModel tableModel2 = new MyDefaultTableModel(tableData2,
			columnNames2);
	DefaultTableModel tableModel3 = new MyDefaultTableModel2(tableData3,
			columnNames3);

	// タイトル-テーブルのマップ
	Map<String, JTable> tableMap = new HashMap<String, JTable>();

	private JTable tList = new JTable(tableModel0);
	private JTable tConst1 = new JTable(tableModel1);
	private JTable tMethod1 = new JTable(tableModel2);
	private JTable tField1 = new JTable(tableModel3);
	private JScrollPane pane0 = new JScrollPane(tList);
	private JScrollPane pane1 = new JScrollPane(tConst1);
	private JScrollPane pane2 = new JScrollPane(tMethod1);
	private JScrollPane pane3 = new JScrollPane(tField1);
	private JTextField tType = new JTextField("java.awt.Frame", 20);
	private JTextField tSize = new JTextField("1", 5);
	GridBagLayout gbl1 = new GridBagLayout();

	/**
	 * -----------------------------------------------
	 * |p[0][0]|p[1][0]|p[2][0]|p[3][0]|
	 * -----------------------------------------------
	 * |p[0][1]|p[1][1]|p[2][1]|p[3][1]|
	 * -----------------------------------------------
	 * |p[0][2]|p[1][2]|p[2][2]|p[3][2]|
	 * -----------------------------------------------
	 * |p[0][3]|p[1][3]|p[2][3]|p[3][3]|
	 * -----------------------------------------------
	 * |p[0][4]|p[1][4]|p[2][4]|p[3][4]|
	 * -----------------------------------------------
	 * |p[0][5]|p[1][5]|p[2][5]|p[3][5]|
	 * -----------------------------------------------
	 * |p[0][6]|p[1][6]|p[2][6]|p[3][6]|
	 * -----------------------------------------------
	 */
	// [列][行] [x][y]
	JPanel[][] panels;
	JPanel[] linePanels;
	//配列
	Object[] objectList;
	static Map<String, Object> objMap = new HashMap<String, Object>();
	{
		// パネルを生成
		int width = 3;// x
		int height = 10;// y
		panels = new JPanel[width][height];
		linePanels = new JPanel[height - 1];
		for (int i = 0; i < height - 1; i++) {
			linePanels[i] = new JPanel();
			JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
			separator.setPreferredSize(new Dimension(panelWidth - 60, 5));
			linePanels[i].add(separator);
		}

		for (int i = 0; i < width; i++) {
			panels[i] = new JPanel[height];
			for (int j = 0; j < height; j++) {
				panels[i][j] = new JPanel();
			}
		}
		int paneWidth = 400;
		int paneHeight = 56;
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

		comboMap.put("コンストラクタ", cbConst);
		cbConst.addActionListener(new MyComboxActionListner("コンストラクタ"));
		comboMap.put("メソッド", cbMethod);
		cbMethod.addActionListener(new MyComboxActionListner("メソッド"));
		comboMap.put("フィールド", cbField);
		cbField.addActionListener(new MyComboxActionListner("フィールド"));
		cbConst.setPreferredSize(new Dimension(400, 20));
		cbMethod.setPreferredSize(new Dimension(400, 20));

		tList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tConst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tMethod1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tField1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tList.getTableHeader().setReorderingAllowed(false);
		tConst1.getTableHeader().setReorderingAllowed(false);
		tMethod1.getTableHeader().setReorderingAllowed(false);
		tField1.getTableHeader().setReorderingAllowed(false);

		tableMap.put("リスト", tList);
		tableMap.put("コンストラクタ", tConst1);
		tableMap.put("メソッド", tMethod1);
		tableMap.put("フィールド", tField1);

		tList.getSelectionModel().addListSelectionListener(
				new MyListSelectionListener("リスト"));
		tConst1.getSelectionModel().addListSelectionListener(
				new MyListSelectionListener("コンストラクタ"));
		tMethod1.getSelectionModel().addListSelectionListener(
				new MyListSelectionListener("メソッド"));
		tField1.getSelectionModel().addListSelectionListener(
				new MyListSelectionListener("フィールド"));

		tResult.setLineWrap(true);
	}
	static int getNextId(){
		objectId++;
		return objectId;
	}

	/**
	 *  layoutにコンポーネントを追加
	 */
	void addComponent(GridBagLayout gbl, Component c, int x, int y, int w,
			int h, int anchor, int fill) {
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
	InterpretTabPanel() {
		setBounds(10, 10, panelWidth, panelHeight);
		setLayout(gbl1);
		int l = 0;// 現在の行数
		// 1行目
		addComponent(gbl1, panels[0][0], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][0], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][0], 2, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 2行目
		addComponent(gbl1, panels[0][1], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][1], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][1], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 区切り
		addComponent(gbl1, linePanels[0], 0, l, 5, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;// 改行
		// 3行目
		addComponent(gbl1, panels[0][2], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][2], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][2], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 4行目
		addComponent(gbl1, panels[0][3], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][3], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][3], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 5行目
		addComponent(gbl1, panels[0][4], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][4], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][4], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 区切り
		addComponent(gbl1, linePanels[1], 0, l, 5, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;
		// 6行目
		addComponent(gbl1, panels[0][5], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][5], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][5], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 7行目
		addComponent(gbl1, panels[0][6], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][6], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][6], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 区切り
		addComponent(gbl1, linePanels[2], 0, l, 5, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;
		// 8行目
		addComponent(gbl1, panels[0][7], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][7], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][7], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 区切り
		addComponent(gbl1, linePanels[3], 0, l, 5, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		l++;
		// 9行目
		addComponent(gbl1, panels[0][8], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][8], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][8], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		l++;// 改行
		// 10行目
		addComponent(gbl1, panels[0][9], 0, l, 1, 1, GridBagConstraints.EAST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[1][9], 1, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);
		addComponent(gbl1, panels[2][9], 2, l, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.NONE);

		l = 0;// 現在の行数

		panels[0][l].add(lType);
		panels[1][l].add(tType);
		l++;// 改行
		panels[0][l].add(lSize);
		panels[1][l].add(tSize);
		panels[2][l].add(bType);
		l++;// 改行
		panels[0][l].add(lList);
		panels[1][l].add(pane0);
		l++;// 改行
		panels[0][l].add(lConst);
		panels[1][l].add(cbConst);
		// panels[2][l].add(bConst);
		l++;// 改行
		panels[0][l].add(lConstParam);
		panels[1][l].add(pane1);
		panels[2][l].add(bGene);
		l++;// 改行
		panels[0][l].add(lMethod);
		panels[1][l].add(cbMethod);
		// panels[2][l].add(bMethod1);
		l++;// 改行
		panels[0][l].add(lMethodParam);
		panels[1][l].add(pane2);
		panels[2][l].add(bMethod2);
		l++;// 改行
		panels[0][l].add(lField);
		panels[1][l].add(pane3);
		panels[2][l].add(bField);
		l++;// 改行
		panels[0][l].add(lResult);
		panels[1][l].add(tResult);
	}

	/**
	 * ボタン押下後イベント
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("配列生成")) {
			listGenerateButtonPushEvent();
		} else if (e.getActionCommand().equals("生成")) {
			objectGenerateButtonPushEvent();
		} else if (e.getActionCommand().equals("実行")) {
			methodExeuteButtonPushEvent();
		} else if (e.getActionCommand().equals("更新")) {
			fieldUpdateButtonPushEvent();
		}
	}
	/**
	 * コンボボックスのリスナー
	 * @author tom
	 */
	class MyComboxActionListner implements ActionListener {
		String boxTitle;// コンボボックスのタイトル
		public MyComboxActionListner(String boxTitle) {
			this.boxTitle = boxTitle;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = comboMap.get(boxTitle).getSelectedIndex();
			//System.out.println(boxTitle + ":" + index);
			if (!isListSelected())
				return;
			if (boxTitle.equals("コンストラクタ")) {
				constructorComboBoxChangeEvent(index);
			} else if (boxTitle.equals("メソッド")) {
				methodComboBoxChangeEvent(index);
			} else if (boxTitle.equals("フィールド")) {
				fieldComboBoxChangeEvent(index);
			}
		}
	}
	// 偶数列のみ編集可能
	class MyDefaultTableModel extends DefaultTableModel {
		public MyDefaultTableModel(Object[][] data, Object[] columnNamess) {
			super(data, columnNamess);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			if (column % 2 == 0)
				return false;// 編集不可
			else
				return true;
		}
	}
	// 4列目のみ編集可能
	class MyDefaultTableModel2 extends DefaultTableModel {
		public MyDefaultTableModel2(Object[][] data, Object[] columnNamess) {
			super(data, columnNamess);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			if (column >=3)
				return true;
			else
				return false;
		}
	}
	class MyListSelectionListener implements ListSelectionListener {
		String tableTitle;
		public MyListSelectionListener(String title) {
			tableTitle = title;
		}
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// リストを選択した際に呼ばれる
			if (e.getValueIsAdjusting())
				return;
			int selectedRow = tableMap.get(tableTitle).getSelectedRow();

			if (tableTitle.equals("リスト")) {
				listTableSelectEvent(selectedRow);
			} else if (tableTitle.equals("コンストラクタ")) {

			} else if (tableTitle.equals("メソッド")) {

			} else if (tableTitle.equals("フィールド")) {
			}
		}
	}

	/**
	 * 配列生成ボタン押下後イベント
	 */
	void listGenerateButtonPushEvent(){
		int size = 0;

		deleteTable(tList, tableModel0);
		deleteTable(tConst1, tableModel1);
		deleteTable(tMethod1, tableModel2);
		deleteTable(tField1, tableModel3);
		cbConst.removeAllItems();
		cbMethod.removeAllItems();
		try {
			size = Integer.valueOf(tSize.getText());
		} catch (Exception ex) {
			showResult(ex.toString() + "sizeは1以上の半角数字を入力してください。");
			return;
		}
		if (size <= 0) {
			showResult("sizeは1以上を指定してください。");
			return;
		}
		objectList = new Object[size];
		String className = tType.getText();
		if (!isTypeInputed(className))
			return;
		try {
			Reflection.classNameExists(className);
		} catch (ClassNotFoundException ex) {
			showResult(ex.toString() + "クラスが見つかりません。");
			return;
		}
		String[][] newList = new String[size][2];
		for (int i = 0; i < size; i++) {
			newList[i] = new String[2];
			newList[i][0] = "[" + i + "]";
			// TODO タブ名と関連
			String name = "obj" + getNextId();
			newList[i][1] = name;
		}
		tableData0 = newList;
		deleteTable(tList, tableModel0);
		for (int i = 0; i < newList.length; i++) {
			tableModel0.addRow(newList[i]);
		}
		showResult("配列生成に成功しました。");
	}
	/**
	 * オブジェクト生成ボタン押下後イベント
	 */
	void objectGenerateButtonPushEvent(){
		if (!isListSelected())
			return;
		int constIndex = comboMap.get("コンストラクタ").getSelectedIndex();
		if (constIndex == -1) {
			showResult("コンストラクタを選択してください。");
			return;
		}
		String className = tType.getText();
		if (!isTypeInputed(className))
			return ;
		String[] strList = null;
	try {
		int listIndex = tList.getSelectedRow();
			//オブジェクトの生成
			int paramNumber = tConst1.getRowCount();
			if(paramNumber == 0){
				objectList[listIndex] = Reflection.generateObject(className);
			}else{
				String[] paramTypeList = new String[paramNumber];
				String[] paramValueList = new String[paramNumber];
				for(int i = 0 ;  i <  paramNumber; i ++){
					paramTypeList[i] = (String)tConst1.getValueAt(i,0);
					paramValueList[i] = (String)tConst1.getValueAt(i,1);
				}
				objectList[listIndex] = Reflection.generateObject(className, paramTypeList, paramValueList);
			}
			//オブジェクトをマップに登録
			objMap.put((String)tList.getValueAt(listIndex, 1), objectList[listIndex]);
			if(!updateMethodView()){
				showResult("メソッドの更新に失敗しました。");
				return;
			}
			if(!updateFieldView()){
				showResult("フィールドの更新に失敗しました。");
				return;
		}
		} catch (Exception ex) {
			showResult(ex.toString());
			return;
		}

			showResult("オブジェクトの生成に成功しました。");
		}

	/**
	 * メソッド実行ボタン押下後イベント
	 */
	void methodExeuteButtonPushEvent(){
		if (!isListSelected())
			return;
		if (!isMethodSelected())
			return;
		int paramNumber = tMethod1.getRowCount();
		int listNumber = tList.getSelectedRow();
		String temp = (String)cbMethod.getSelectedItem();
		String methodName = temp.substring(0, temp.indexOf("("));
		System.out.println(methodName);
		String[] paramTypeList = new String[paramNumber];
		String[] paramValueList = new String[paramNumber];
		for(int i = 0 ;  i <  paramNumber; i ++){
			paramTypeList[i] = (String)tMethod1.getValueAt(i,0);
			paramValueList[i] = (String)tMethod1.getValueAt(i,1);
		}
		try{
			Reflection.executeMethod(objectList[listNumber], methodName, paramTypeList, paramValueList);
		}catch(Exception ex){
			showResult(ex.toString());
			return;
		}

		showResult("メソッドを実行しました。");
	}

	/**
	 * フィールド更新ボタン押下後イベント
	 */
	void fieldUpdateButtonPushEvent(){
		String className = tType.getText();
		if (!isTypeInputed(className) || !isListSelected())
			return;
		int fieldIndex = tableMap.get("フィールド").getSelectedRow();
		if (fieldIndex == -1) {
			showResult("フィールドを選択してください");
			return;
		}
		int listIndex = tList.getSelectedRow();
		System.out.println(fieldIndex);
		String selectedType = (String)tField1.getValueAt(fieldIndex, 0);
		String selectedName = (String)tField1.getValueAt(fieldIndex, 1);
		String selectedValue = (String)tField1.getValueAt(fieldIndex, 2);
		String selectedNewValue = (String)tField1.getValueAt(fieldIndex, 3);
		try {
			if(!(Reflection.updateField(objectList[listIndex],className, selectedType,selectedName, selectedNewValue))){
				showResult("更新内容がありません");
				return;
			}
		} catch (Exception e){
			showResult(e.toString());
			return;
		}
		if(!updateFieldView()){
			showResult("フィールドの更新に失敗しました");
			return;
		}
		showResult("更新しました");
	}
	/**
	 * 	コンストラクターのコンボボックスが変更された際のイベント
	 * @param index
	 */
	void constructorComboBoxChangeEvent(int index){
		String className = tType.getText();
		String[] strList = null;
		deleteTable(tConst1, tableModel1);
		if (index == -1 || !isTypeInputed(className))
			return;

		try {
			strList = Reflection.getConstructorParamList(className,
					index);
		} catch (ClassNotFoundException ex) {
			showResult(ex.toString());
			return;
		} finally {

		}
		if (strList == null || strList.length == 0) {
			return;
		}
		String[][] newList = new String[strList.length][2];
		tableData2 = newList;
		if (strList == null || strList.length == 0)
			return;// 引数なしの場合終了
		for (int i = 0; i < strList.length; i++) {
			newList[i][0] = strList[i];
			newList[i][1] = ""; // TODO 保存機能
		}
		for (int i = 0; i < newList.length; i++) {
			tableModel1.addRow(newList[i]);
		}
		showResult("コンストラクタ引数取得に成功しました。");
	}

	/**
	 * メソッドのコンボボックスが変更された際のイベント
	 * @param index
	 */
	void methodComboBoxChangeEvent(int index){
		if (!isMethodSelected())
			return;
		String className = tType.getText();
		if (!isTypeInputed(className))
			return;
		String[] strList = null;
		try {
			strList = Reflection.getMethodParamList(className, index);
		} catch (ClassNotFoundException ex) {
			showResult(ex.toString());
			return;
		}
		deleteTable(tMethod1, tableModel2);
		if (strList == null || strList.length == 0)
			return;// 引数なしの場合終了
		String[][] newList = new String[strList.length][2];
		for (int i = 0; i < strList.length; i++) {
			newList[i][0] = strList[i];
			newList[i][1] = ""; // TODO 保存機能
		}
		tableData2 = newList;
		for (int i = 0; i < strList.length; i++) {
			tableModel2.addRow(newList[i]);
		}
	}
	/**
	 * フィールドのコンボボックスが変更された際のイベント
	 * @param index
	 */
	void fieldComboBoxChangeEvent(int index){

	}
	/**
	 *  配列テーブルを選択した際のイベント
	 */
	void listTableSelectEvent(int selectedRowIndex){
		if (selectedRowIndex== -1) {
			deleteTable(tConst1, tableModel1);
			deleteTable(tMethod1, tableModel2);
			deleteTable(tField1, tableModel3);
			cbConst.removeAllItems();
			cbMethod.removeAllItems();
			return;
		}
		if(objectList[selectedRowIndex] != null){
			updateFieldView();
			updateMethodView();
		}

		String className = tType.getText();
		if (!isTypeInputed(className))
			return;
		cbConst.removeAllItems();
		try {
			String[] strList = Reflection.getConstructorList(className);
			if (strList == null) {
				showResult("コンストラクタが存在しません");
				return;
			}
			comboBox1 = strList;
			for (int i = 0; i < strList.length; i++) {
				cbConst.addItem(strList[i]);
			}
		} catch (ClassNotFoundException ex) {
			showResult(ex.toString() + "クラスが見つかりません。");
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * クラスが入力されているか確認
	 * @return
	 */
	boolean isTypeInputed(String className) {
		if (className == null || className.length() == 0) {
			showResult("クラス名を入力してください");
			return false;
		}
		return true;
	}
	/**
	 * 配列が選択されているか確認
	 * @return
	 */
	boolean isListSelected() {
		int index = tableMap.get("リスト").getSelectedRow();
		if (index == -1) {
			showResult("配列を選択してください。");
			return false;
		}
		return true;
	}

	boolean updateMethodView(){

		String className = tType.getText();
		if(!isTypeInputed(className))return false;
		try{
			String[]strList = Reflection.getMethodList(className);
			comboBox2 = strList;
			cbMethod.removeAllItems();
			if (strList == null) {
				showResult("メソッドが存在しません");
				return false;
			}
			for (int i = 0; i < comboBox2.length; i++) {
				cbMethod.addItem(strList[i]);
			}
			cbMethod.setSelectedIndex(0);

		} catch (Exception ex) {
		showResult(ex.toString());
		return false;
		}
		return true;
}
	/**
	 * フィールドリストを更新する。
	 * @return
	 */
	boolean updateFieldView(){
		String className = tType.getText();
		String[][] newList = null;
		try {
			int listIndex = tList.getSelectedRow();
			newList = Reflection.getFieldList(objectList[listIndex], className);
		} catch (Exception ex) {
			showResult(ex.toString());
			return false;
		}
		if(newList == null || newList.length == 0){
			return false;
		}
		tableData3 = newList;
		deleteTable(tField1, tableModel3);
		for (int i = 0; i < newList.length; i++) {
			tableModel3.addRow(newList[i]);
		}
		return true;
	}

	/**
	 * メソッドが選択されているか確認
	 * @return
	 */
	boolean isMethodSelected() {
		int methodIndex = comboMap.get("メソッド").getSelectedIndex();
		if (methodIndex == -1) {
			showResult("メソッドを選択してください");
			return false;
		}
		return true;
	}
	/**
	 * 結果を表示
	 * @param message
	 */
	void showResult(String message) {
		tResult.setText("");
		if (message == null)
			return;
		tResult.setText(message);
	}


	void deleteTable(JTable table, DefaultTableModel tableModel){
		if(table == null)return;
			table.removeAll();
		if(tableModel == null)return;
		while (tableModel.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
	}

	public static void main(String[] args) {
		InterpretFrame frame = new InterpretFrame();
	}
}
