package ch02.ex02_13;

public class PassRef {


	public static void main(String[] args){
		Body sirius = new Body("Sirius");

		System.out.println("before: " + sirius.name);
		commonName(sirius);
		System.out.println("after: " + sirius.name);
	}

	public static void commonName(final Body bodyRef){
		bodyRef.name = "test";

	}
}
