package ch10.ex10_02;

public class Special {

	static String change(String str){

		String result = "";
		for(int i = 0; i < str.length(); i++){

		char c = str.charAt(i);
		//\ " ' \t \b \r \f \n

		switch(c){
		case '"':
			result += "\"";
			break;
		case '\'':
			result += "\\'";
			break;
		case '\t':
			result += "\\t";
			break;
		case '\b':
			result += "\\b";
			break;
		case '\r':
			result += "\\r";
			break;
		case '\f':
			result += "\\f";
			break;
		case '\n':
			result += "\\n";
			break;
		case '\\':
			result += "\\\\";
			break;
		default: result += c;
			break;
		}


		}
		return result;

	}

	public static void main(String[] args){
		//\ " ' \t \b \r \f \n
		System.out.println("\\ \" \' \t \b \r \f \n"+ "-->" + change("\\ \" \' \t \b \r \f \n"));
	}

}
