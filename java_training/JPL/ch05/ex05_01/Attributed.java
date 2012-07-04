package ch05.ex05_01;

//お互いネストする必要がない。attributed内にattrを定義した場合、attributedの拡張に不都合
//attr内にattributedインターフェースを定義しても、ほかのinterface持ちたい場合に不都合

public interface Attributed {

	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();

}
