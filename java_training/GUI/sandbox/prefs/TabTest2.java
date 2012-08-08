package sandbox.prefs;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

	public class TabTest2 extends JFrame implements ActionListener{

	  JTabbedPane tabbedpane;
	  JTextField indexText;

	  public static void main(String[] args){
	    TabTest2 frame = new TabTest2();

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(10, 10, 300, 200);
	    frame.setTitle("タイトル");
	    frame.setVisible(true);
	  }

	  TabTest2(){
	    tabbedpane = new JTabbedPane();
	    JPanel topPanel = new JPanel();
	    JButton addButton = new JButton("追加");
	    topPanel.add(addButton);
	    addButton.addActionListener(this);

	    JPanel tabPanel1 = new JPanel();
	    tabPanel1.add(new JButton("button1"));

	    JPanel tabPanel2 = new JPanel();
	    tabPanel2.add(new JLabel("型:"));
	    tabPanel2.add(new JTextField("", 10));
	    tabPanel2.add(new JLabel("サイズ:"));
	    tabPanel2.add(new JTextField("", 10));

	    JPanel tabPanel3 = new JPanel();
	    tabPanel3.add(new JButton("button2"));

	    tabbedpane.addTab("tab1", tabPanel1);
	    tabbedpane.addTab("tab2", tabPanel2);
	    tabbedpane.addTab("tab3", tabPanel3);

	    indexText = new JTextField("", 2);
	    JButton selectButton = new JButton("select");
	    selectButton.addActionListener(this);

	    JPanel actionPanel = new JPanel();
	    actionPanel.add(indexText);
	    actionPanel.add(selectButton);

	    getContentPane().add(topPanel, BorderLayout.NORTH);
	    getContentPane().add(tabbedpane, BorderLayout.CENTER);
	    getContentPane().add(actionPanel, BorderLayout.PAGE_END);
	  }

	  public void actionPerformed(ActionEvent e){
		 System.out.println("ok");
	     JPanel tabPanel4 = new JPanel();
		    tabPanel4.add(new JButton("button3"));
		    tabbedpane.add("tab4",tabPanel4);
	    //int index = Integer.parseInt(indexText.getText());
	 //   tabbedpane.setSelectedIndex(index);
	  }
	}

