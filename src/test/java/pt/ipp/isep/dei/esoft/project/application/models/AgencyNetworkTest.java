package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AgencyNetworkTest {

	@Test
	public void testSetNameWithEmptyString() {
		AgencyNetwork network = new AgencyNetwork("Name", "Location", "email@example.com", "123456789");
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			network.setName("");
		});
		assertEquals("Invalid name.", exception.getMessage());
	}


	@Test
	public void testSetLocationWithEmptyString() {
		AgencyNetwork network = new AgencyNetwork("Network", "Location", "email@example.com", "123456789");

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			network.setAddress("");
		});
		assertEquals("Invalid address.", exception.getMessage());
	}

	@Test
	public void testSetEmailWithEmptyString() {
		AgencyNetwork network = new AgencyNetwork("Network", "Location", "Email", "123456789");
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			network.setEmail("");
		});
		assertEquals( "Invalid email.", exception.getMessage());
	}

	@Test
	public void testSetPhoneWithEmptyString() {
		AgencyNetwork network = new AgencyNetwork("Network", "Location", "email@example.com", "123456789");
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			network.setPhone("");
		});
		assertEquals( "Invalid phone number.", exception.getMessage());
	}

	@Test
	public void testGetters() {
		AgencyNetwork network = new AgencyNetwork("Network", "Location", "email@example.com", "123456789");

		assertEquals("Network", network.getName());
		assertEquals("Location", network.getAddress());
		assertEquals("email@example.com", network.getEmail());
		assertEquals("123456789", network.getPhone());
	}
}
