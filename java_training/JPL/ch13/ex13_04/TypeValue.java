package ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;

//問題の意味がいまいちわからないです。
public class TypeValue {


	public  List typeValue(String str){

		List typeValueList = new ArrayList();

		String[] list = str.split("\n");
		if(list == null)return null;

		for(int i = 0 ; i < list.length; i++){
			if(list[i] == null) break;
			String[] typeValue = list[i].split(" ");
			if(typeValue[0].equals("Boolean")){
				typeValueList.add(new Boolean(typeValue[1]));
			}
			if(typeValue[0].equals("Character")){
				typeValueList.add(new Character(typeValue[1].charAt(0)));
			}
		}
		return typeValueList;
	}

	public static void main(String[] args){
		TypeValue tv = new TypeValue();
		System.out.println(tv.typeValue("Boolean true"));
		TypeValue tv2 = new TypeValue();

		System.out.println(tv2.typeValue("Character a\nCharacter b"));

	}


}
