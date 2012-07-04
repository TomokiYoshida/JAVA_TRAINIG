package ch11.ex11_02;

import java.util.Iterator;

import junit.framework.TestCase;

public class AttributedTest extends TestCase {

	public void testTest(){

		Attr<String> a1 = new Attr<String>("key1");
		a1.setValue("value1");
		Attr<String> a2 = new Attr<String>("key2");
		a2.setValue("value2");

		Attributed<String> a = new AttributedImpl<String>();
		a.add(a1);
		a.add(a2);

		for (Iterator<Attr<String>> i = a.attrs(); i.hasNext();) {
			Attr<String> a3 = i.next();
			System.out.println(a3);
		}

	}

}
