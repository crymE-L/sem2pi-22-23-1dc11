package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
	private Role role = new Role("ADMIN", 4);
	private Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

	private Employee employee = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role,
			"1234567890", 12345678, 123456789, "123 Main St", agency);

	@Test
	public void testConstructor() {
		assertEquals("John Doe", employee.getName());
		assertEquals("john.doe@example.com", employee.getEmail());
		assertEquals("AAAbcde12", employee.getPassword());
		assertEquals(role, employee.getRole());
		assertEquals("1234567890", employee.getPhoneNumber());
		assertEquals(12345678, employee.getPassport());
		assertEquals(123456789, employee.getVat());
		assertEquals("123 Main St", employee.getAddress());
		assertEquals("1234567890", employee.getPhoneNumber());
		assertEquals(agency, employee.getAgency());
	}

	@Test
	public void testGetPassport() {
		assertEquals(12345678, employee.getPassport());
	}

	@Test
	public void testSetPassport() {
		assertThrows(IllegalArgumentException.class, () -> employee.setPassport(1234));
		assertThrows(IllegalArgumentException.class, () -> employee.setPassport(123456789));
		employee.setPassport(98765432);
		assertEquals(98765432, employee.getPassport());
	}

	@Test
	public void testGetVat() {
		assertEquals(123456789, employee.getVat());
	}

	@Test
	public void testSetVat() {
		assertThrows(IllegalArgumentException.class, () -> employee.setVat(12345678));
		assertThrows(IllegalArgumentException.class, () -> employee.setVat(1234567890));
		employee.setVat(987654321);
		assertEquals(987654321, employee.getVat());
	}

	@Test
	public void testGetAddress() {
		assertEquals("123 Main St", employee.getAddress());
	}

	@Test
	public void testSetAddress() {
		assertThrows(IllegalArgumentException.class, () -> employee.setAddress(""));
		employee.setAddress("456 Oak St");
		assertEquals("456 Oak St", employee.getAddress());
	}

	@Test
	public void testGetPhone() {
		assertEquals("1234567890", employee.getPhoneNumber());
	}

	@Test
	public void testSetPhone() {
		assertThrows(IllegalArgumentException.class, () -> employee.setPhoneNumber("123456789"));
		assertThrows(IllegalArgumentException.class, () -> employee.setPhoneNumber("12345678909"));
		employee.setPhoneNumber("1234567890");
		assertEquals("1234567890", employee.getPhoneNumber());
	}

	@Test
	public void testGetAgency() {
		assertNotNull(employee.getAgency());
	}

	@Test
	public void testSetAgency() {
		Agency newAgency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567899", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
		employee.setAgency(newAgency);
		assertEquals(newAgency, employee.getAgency());
	}

	@Test
	public void testSetAgency_Null() {
		assertThrows(IllegalArgumentException.class, () -> employee.setAgency(null));
	}
}
