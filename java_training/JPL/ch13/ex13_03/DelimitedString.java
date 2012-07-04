package ch13.ex13_03;

import java.util.ArrayList;
import java.util.List;

public class DelimitedString {


	public static List<String> delimitedString(String from, char start, char end){

		List<String> strList = new ArrayList<String>();
		while(true){
			int startPos = from.indexOf(start);
			int endPos = from.indexOf(end);
			if(startPos == -1){
				break;
			}else if(endPos == -1){
				strList.add(from.substring(startPos));
				break;
			}
			else if(startPos > endPos){
				from = from.substring(endPos + 1);
			}
			else{
				strList.add(from.substring(startPos, endPos+1));
				from = from.substring(endPos+1);
			}
		}
		return strList;

	}

	public static void main(String[] args){
		DelimitedString sc = new DelimitedString();
		System.out.println(delimitedString("abcdefgabdcaaae",'a','e'));
	}

}
