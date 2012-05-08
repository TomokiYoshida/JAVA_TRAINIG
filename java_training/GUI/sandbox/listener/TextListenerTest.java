package sandbox.listener;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextListenerTest extends Frame implements TextListener{

	public TextListenerTest() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("TextListenerTest");
		TextField tf1 = new TextField();
		tf1.addTextListener(this);
		add(tf1);
		setSize(200, 100);
		show();

	}

	public void textValueChanged(TextEvent e){
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
	}

	public static void main(String [] args){
		new TextListenerTest();
	}

}
