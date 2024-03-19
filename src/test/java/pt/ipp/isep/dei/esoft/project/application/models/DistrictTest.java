package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DistrictTest {
	@Test
	public void testFullConstructor() {
		ArrayList<City> cities = new ArrayList<City>() {
			{
				new City("Porto");
				new City("Braga");
				new City("Aveiro");
			}
		};

		District district = new District("Cool district", cities);

		assertEquals("Cool district", district.getName());
		assertEquals(cities, district.getCities());
	}

	@Test
	public void testNameConstructor() {
		District district = new District("Cool district");

		assertEquals("Cool district", district.getName());
	}

	@Test
	public void testSetName() {
		District district = new District("Cool district");

		assertThrows(IllegalArgumentException.class, () -> district.setName(""));
	}

	@Test
	public void testSetCitiesNull() {
		District district = new District("Cool district");

		assertThrows(IllegalArgumentException.class, () -> district.setCities(null));
	}
}
