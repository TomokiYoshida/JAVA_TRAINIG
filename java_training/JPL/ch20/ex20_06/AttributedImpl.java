package ch20.ex20_06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AttributedImpl<E> implements Attributed<E>, Iterable<Attr<E>> {

	protected Map<String, Attr<E>> attrTable = new HashMap<String, Attr<E>>();

	public void add(Attr<E> newAttr){
		attrTable.put(newAttr.getName(), newAttr);
	}
	public Attr<E> find(String name){
		return attrTable.get(name);
	}
	public Attr<E> remove(String name){
		return attrTable.remove(name);
	}
	public Iterator<Attr<E>> attrs(){
		return attrTable.values().iterator();
	}
	public Iterator<Attr<E>> iterator(){
		return attrs();
	}

}
