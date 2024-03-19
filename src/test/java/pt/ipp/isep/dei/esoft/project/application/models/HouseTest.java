package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.House;
import pt.ipp.isep.dei.esoft.project.domain.SunExposure;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {
	@Test
	public void testHouseCharacteristics() {
		House house = new House(true, false, SunExposure.NORTH);

		assertTrue(house.getBasement());
		assertFalse(house.getLoft());
		assertEquals(SunExposure.NORTH, house.getSunExposure());

		house.setBasement(false);
		house.setLoft(true);
		house.setSunExposure(SunExposure.SOUTH);

		assertFalse(house.getBasement());
		assertTrue(house.getLoft());
		assertEquals(SunExposure.SOUTH, house.getSunExposure());
	}
}
