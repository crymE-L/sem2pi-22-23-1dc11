package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

	@Test
	public void testConstructor() {
		City city = new City("Porto");

		assertEquals("Porto", city.getName());
	}

	@Test
	public void testSetName() {
		City city = new City("Porto");

		assertThrows(IllegalArgumentException.class, () -> city.setName(""));
	}
}
