package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class StateTest {
	@Test
	public void testFullConstructor() {
		ArrayList<City> cities = new ArrayList<City>() {
			{
				new City("Porto");
				new City("Braga");
				new City("Aveiro");
			}
		};

		ArrayList<District> districts = new ArrayList<District>() {
			{
				new District("Cool district", cities);
				new District("Second cool district", cities);
				new District("Third cool district", cities);
			}
		};

		State state = new State("Alabama", districts);

		assertEquals("Alabama", state.getName());
		assertEquals(districts, state.getDistricts());
	}

	@Test
	public void testNameConstructor() {
		State state = new State("Alabama");

		assertEquals("Alabama", state.getName());
	}

	@Test
	public void testSetName() {
		State state = new State("Alabama");

		assertThrows(IllegalArgumentException.class, () -> state.setName(""));
	}

	@Test
	public void testSetDistrictsNull() {
		State state = new State("Alabama");

		assertThrows(IllegalArgumentException.class, () -> state.setDistricts(null));
	}
}
