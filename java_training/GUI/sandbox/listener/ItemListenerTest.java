package sandbox.listener;

import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerTest extends Frame implements ItemListener{

	ItemListenerTest(){
		super("ItemListenerTest");
		Checkbox cb1 = new Checkbox("CB1");
		cb1.addItemListener(this);
		add(cb1);
		setSize(200, 100);
		show();
	}

	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("SELECTED");
		}else if(e.getStateChange() == ItemEvent.DESELECTED){
			System.out.println("DESELECTED");
		}
	}
	public static void main(String[] args){
		new ItemListenerTest();
	}


}
