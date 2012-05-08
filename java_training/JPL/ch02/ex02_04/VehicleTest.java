package ch02.ex02_04;

import junit.framework.TestCase;

public class VehicleTest extends TestCase {

	public void testTest(){

		Vehicle v1 = new Vehicle();
		assertTrue(v1.getId() == 1);

		Vehicle v2 = new Vehicle();
		assertTrue(v2.getId() == 2);
	}

}
