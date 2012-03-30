package ch01.ex01_15;

public interface Lookup {
	Object find(String name);
	void add(String name, Object obj);
	void remove(String name);
}
