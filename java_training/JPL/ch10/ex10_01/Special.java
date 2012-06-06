package ch10.ex10_01;

public class Special {

	static String change(String str){

		String result = "";
		for(int i = 0; i < str.length(); i++){

		char c = str.charAt(i);
		//\ " ' \t \b \r \f \n

		if(c == '"'){
			result += "\"";
		}
		else if(c == '\''){
			result += "\\'";
		}
		else if(c == '\t'){
			result += "\\t";
		}
		else if(c == '\b'){
			result += "\\b";
		}
		else if(c == '\r'){
			result += "\\r";
		}
		else if(c == '\f'){
			result += "\\f";
		}
		else if(c == '\n'){
			result += "\\n";
		}
		else if(c == '\\'){
			result += "\\\\";
		}
		else{
			result += c;

		}


		}
		return result;

	}

	public static void main(String[] args){
		//\ " ' \t \b \r \f \n
		System.out.println("\\ \" \' \t \b \r \f \n"+ "-->" + change("\\ \" \' \t \b \r \f \n"));
	}

}
