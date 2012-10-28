package ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

/**
 *オブザーバーヘ変化を通知するのにObserver/Observableを使用するAttributedインタ
フェースの実装を提供しなさい。
なぜか通知されない
 * @author tom
 * p563
 */
public class AttributedImpl extends Observable  implements Attributed, Iterable<Attr>  {

	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();

	public void add(Attr newAttr){
		notifyObservers("add");
		notifyObservers();
		attrTable.put(newAttr.getName(), newAttr);
	}
	public Attr find(String name){
		notifyObservers("find");
		return attrTable.get(name);
	}
	public Attr remove(String name){
		notifyObservers("remove");
	return attrTable.remove(name);
	}
	public Iterator<Attr> attrs(){
		return attrTable.values().iterator();
	}
	public Iterator<Attr> iterator(){
		return attrs();
	}

}
