package ch03.ex03_08;

import junit.framework.TestCase;

public class PassengerVehicleTest extends TestCase{


	public static void test1(){
		PassengerVehicle v1 = new PassengerVehicle("test");
		PassengerVehicle v2 = new PassengerVehicle(v1);

		assertEquals(v1.getDirection(), v2.getDirection());
		assertEquals(v1.getOwnerName(), v2.getOwnerName());
		assertNotSame(v1.getId(), v2.getId());

	}



}
