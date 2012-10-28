package ch22.ex22_04;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	AttributedImpl watching;

	public MyObserver(AttributedImpl watching){
		this.watching = watching;
		watching.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		System.out.println(arg);
	}

	public static void main(String[] args){
		AttributedImpl watching = new AttributedImpl();
		MyObserver mo = new MyObserver(watching);
		watching.add(new Attr("test"));
		watching.find("test");
	}


}
