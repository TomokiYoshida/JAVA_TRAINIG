package ch10.ex10_03;

public class EX01 {

	//曜日
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,
	}
	//信号
	enum Signal {
		RED, YELLOW, BLUE,
	}
	static boolean isWorkDay(Day day){
		switch(day){
		case SUNDAY: case SATURDAY:
				return false;
		default: return true;
		}
	}

	public static void main(String[] args){

		System.out.println(isWorkDay(Day.SUNDAY));
		System.out.println(isWorkDay(Day.MONDAY));
		System.out.println(isWorkDay(Day.TUESDAY));
		System.out.println(isWorkDay(Day.WEDNESDAY));
		System.out.println(isWorkDay(Day.THURSDAY));
		System.out.println(isWorkDay(Day.FRIDAY));
		System.out.println(isWorkDay(Day.SATURDAY));

	}

}
