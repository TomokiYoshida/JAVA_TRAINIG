package ch03.ex03_08;

import junit.framework.TestCase;

public class VehicleTest extends TestCase{


	public static void test1(){
		Vehicle v1 = new Vehicle("test");
		Vehicle v2 = new Vehicle(v1);

		assertEquals(v1.getDirection(), v2.getDirection());
		assertEquals(v1.getOwnerName(), v2.getOwnerName());
		assertNotSame(v1.getId(), v2.getId());
		System.out.println(v1);
		System.out.println(v2);
	}



}
