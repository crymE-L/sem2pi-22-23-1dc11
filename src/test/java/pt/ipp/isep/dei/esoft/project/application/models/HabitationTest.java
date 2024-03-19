package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Habitation;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.State;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class HabitationTest {

	private Habitation habitation = new Habitation("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, new City("Porto"),
			new District("Porto"), new State("US"),
			new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "9172781921"), 3, 2, 1, true, false, new ArrayList<String>());

	@Test
	public void testGetBedrooms() {
		assertEquals(3, habitation.getBedrooms());
	}

	@Test
	public void testSetBedrooms() {
		habitation.setBedrooms(4);
		assertEquals(4, habitation.getBedrooms());
	}

	@Test
	public void testGetBathrooms() {
		assertEquals(2, habitation.getBathrooms());
	}

	@Test
	public void testSetBathrooms() {
		habitation.setBathrooms(3);
		assertEquals(3, habitation.getBathrooms());
	}

	@Test
	public void testGetParkingSpaces() {
		assertEquals(1, habitation.getParkingSpaces());
	}

	@Test
	public void testSetParkingSpaces() {
		habitation.setParkingSpaces(2);
		assertEquals(2, habitation.getParkingSpaces());
	}

	@Test
	public void testIsHasCentralHeating() {
		assertTrue(habitation.isHasCentralHeating());
	}

	@Test
	public void testSetHasCentralHeating() {
		habitation.setHasCentralHeating(false);
		assertFalse(habitation.isHasCentralHeating());
	}

	@Test
	public void testIsHasAirConditioning() {
		assertFalse(habitation.isHasAirConditioning());
	}

	@Test
	public void testSetHasAirConditioning() {
		habitation.setHasAirConditioning(true);
		assertTrue(habitation.isHasAirConditioning());
	}

	@Test
	public void testInvalidBedrooms() {
		assertThrows(IllegalArgumentException.class, () -> habitation.setBedrooms(-1));
	}

	@Test
	public void testInvalidBathrooms() {
		assertThrows(IllegalArgumentException.class, () -> habitation.setBathrooms(-1));
	}
}
