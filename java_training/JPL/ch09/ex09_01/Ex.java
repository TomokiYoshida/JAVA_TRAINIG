package ch09.ex09_01;

public class Ex {

	public static void main(String[] args){
		Double dpi = Double.POSITIVE_INFINITY;
		Double dni = Double.NEGATIVE_INFINITY;
		System.out.println(dpi + "+" + dni + "=" + (dpi + dni));
		System.out.println(dpi + "-" + dni + "=" + (dpi - dni));
		System.out.println(dpi + "*" + dni + "=" + (dpi * dni));
		System.out.println(dpi + "/" + dni + "=" + (dpi / dni));
		System.out.println(dpi + "+" + dpi + "=" + (dpi + dpi));
		System.out.println(dpi + "-" + dpi + "=" + (dpi - dpi));
		System.out.println(dpi + "*" + dpi + "=" + (dpi * dpi));
		System.out.println(dpi + "/" + dpi + "=" + (dpi / dpi));
	}


}
