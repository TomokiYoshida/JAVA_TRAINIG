package ch01.ex01_15;

class LookupImpl implements Lookup{

	private String[] names;
	private Object[] values;

	public Object find(String name){
		for(int i = 0; i < names.length; i++){
			if(names[i].equals(name)){
				return values[i];
			}
		}
		return null;
	}
	public void add(String name, Object obj){

		for(int i = 0; i < names.length; i++){
			if(names[i] == null){
				names[i] = name;
				values[i] = obj;
			}
		}
	}
	public void remove(String name){

		for(int i = 0; i < names.length; i++){
			if(names[i].equals(name)){
				names[i] = null;
				values[i] = null;
			}
		}
	}

}
