package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Role;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

	@Test
	public void testFullConstructor() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertEquals("Farusco", farusco.getName());
		assertEquals("farusco@silly.com", farusco.getEmail());
		assertEquals("AAAbcde12", farusco.getPassword());
		assertEquals(role, farusco.getRole());
		assertEquals("1234567890", farusco.getPhoneNumber());
	}

	@Test
	public void testSetName() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setName(""));
	}

	@Test
	public void testSetEmail() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setEmail(""));
	}

	@Test
	public void testSetPassword() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setPassword(""));
	}

	@Test
	public void testSetWeakPassword() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setPassword("1234567"));
	}

	@Test
	public void testSetRole() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setRole(null));
	}

	@Test
	public void testSetPhoneNumber() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");

		assertThrows(IllegalArgumentException.class, () -> farusco.setPhoneNumber("123456789"));
		assertThrows(IllegalArgumentException.class, () -> farusco.setPhoneNumber("12345678909"));
		farusco.setPhoneNumber("1234567890");
		assertEquals("1234567890", farusco.getPhoneNumber());
	}
}
