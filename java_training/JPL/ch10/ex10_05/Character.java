package ch10.ex10_05;

public class Character {

	static void showCharacter(char a, char b){

		int x = a - b;
		if(x < -1){
			x = -x;
			for(int i = 0; i < x; i ++){
				int y = a + i;
				char c = (char) y;
				System.out.print(c + " ");
			}
		}
		else{
			for(int i = 0; i < x; i ++){
				int y = b + i;
				char c = (char) y;
				System.out.print(c + " ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args){
		showCharacter('a', 'z');
		showCharacter('z', 'a');
		showCharacter('A', 'Z');
		showCharacter('Z', 'A');

	}


}
