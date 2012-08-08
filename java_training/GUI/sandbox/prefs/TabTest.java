package sandbox.prefs;
import java.awt.*;
import javax.swing.*;

public class TabTest extends JFrame{

	public TabTest() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(10,10,300,300);
		init();
		setVisible(true);

	}

		public void init() {
			JTabbedPane tab = new JTabbedPane(
				SwingConstants.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);
			JTabbedPane tab_1 = new JTabbedPane(
					SwingConstants.TOP , JTabbedPane.SCROLL_TAB_LAYOUT);

			JPanel[] tabPanels = {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel() };
			JPanel[] tabPanels_1 = {new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel() };
			for(int i = 0 ; i < 5; i++){
				tab_1.add(tabPanels_1[i] , "Tab Panel Child" + i);
			}
			getContentPane().add(tab);


		}

		public static void main(String[] args){
			new TabTest();
		}
	}

