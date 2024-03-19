package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class DisplayPropertyControllerTest {
    private String name = "Habitação luxuosa na ribeira";
    private String address = "Rua da Barrosa";
    private int area = 100;
    private float distanceFromCenter = 5.0f;
    private float price = 15000.0f;
    private City city = new City("Avanca");
	private District district = new District("Aveiro");
    private State state = new State("State");
    private Person owner = new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
    private PropertyRepository repo = new PropertyRepository();
    private PropertyController controller = new PropertyController(repo);

    @Test
    public void testCreatePropertyAndPutInRepository() {
        // Act
        try {
            controller.createPropertyAndPutInRepository(name, address, area, distanceFromCenter, price, city, district, state, owner, new ArrayList<String>());
        } catch (Exception | DataExistsException e) {
            fail("Exception thrown");
        }

        // Assert
        assertTrue(repo.getAllProperties().size() == 1);
        assertEquals(repo.getAllProperties().get(0).getName(), name);
        assertEquals(repo.getAllProperties().get(0).getAddress(), address);
        assertEquals(repo.getAllProperties().get(0).getArea(), area);
        assertEquals(repo.getAllProperties().get(0).getDistanceFromCenter(), distanceFromCenter);
        assertEquals(repo.getAllProperties().get(0).getPrice(), price);
        assertEquals(repo.getAllProperties().get(0).getCity(), city);
		assertEquals(repo.getAllProperties().get(0).getDistrict(), district);
        assertEquals(repo.getAllProperties().get(0).getState(), state);
        assertEquals(repo.getAllProperties().get(0).getOwner(), owner);
    }
}
