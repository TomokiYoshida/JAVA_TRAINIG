package ch03.ex03_07;

class ColorAttr  extends Attr{

	private ScreenColor myColor;

	public ColorAttr(String name, Object value){
		super(name, value);
		decodeColor();
	}
	public ColorAttr(String name){
		this(name, "transparent");
	}
	public ColorAttr(String name, ScreenColor value){
		super(name, value.toString());
		myColor = value;
	}
	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	public ScreenColor setValue(ScreenColor newValue){
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	public ScreenColor getColor(){
		return myColor;
	}
	protected void decodeColor(){
		if(getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}
	public boolean equals(ColorAttr attr){
		if(getName().equals(attr.getName())&& getValue().equals(attr.getValue()) && getColor().equals(attr.getColor()))
			return true;
		else return false;
	}
	public int hashCode(){
		return new String(getName()).hashCode();
	}


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ColorAttr c1 = new ColorAttr("test");
		ColorAttr c2 = new ColorAttr("test");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		if(c1.equals(c2)){
			System.out.println("c1 equals c2");
		}
		if(c1.equals(c1)){
			System.out.println("c1 equals c1");
		}
		c1 = new ColorAttr("test","test");
		c2 = new ColorAttr("test", "test");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		if(c1.equals(c2)){
			System.out.println("c1 equals c2");
		}
		if(c1.equals(c1)){
			System.out.println("c1 equals c1");
		}
		ScreenColor sc = new ScreenColor();
		c1 = new ColorAttr("test", "test");
		c2 = new ColorAttr("test", "test");
		c1.setValue(sc);
		c2.setValue(sc);

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		if(c1.equals(c2)){
			System.out.println("c1 equals c2");
		}
		if(c1.equals(c1)){
			System.out.println("c1 equals c1");
		}
	}

}
