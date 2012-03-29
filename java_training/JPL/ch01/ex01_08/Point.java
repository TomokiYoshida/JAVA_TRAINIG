package ch01.ex01_08;

class Point {
	public double x, y;

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
/* テキスト内のクリアー関数
	public void clear(){
		x=0.0;
		y=0.0;
	}*/
	public String toString(){
		return x + "," + y;
	}
/*	テキスト内の移動関数
  public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}*/
	public void move(Point that) {
		this.x = that.x;
		this.y = that.y;
	}
/*	public double distance(Point that){
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}*/
	public static void main(String[] args){
		Point p1 = new Point(1.0, 1.0);
		Point p2 = new Point(2.0, 3.0);
		p1.move(p2);
		System.out.println(p1);

	}
}
