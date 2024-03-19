package pt.ipp.isep.dei.esoft.project.repositories;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

/**
 * Repository class for managing instances of Property.
 *
 * @author Gustavo Lima (1221349)
 */
class PropertyRepositoryTest {
    private PropertyRepository propertyRepository = new PropertyRepository();

    @Test
    void addProperty() {
		Person user = new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "9162677775");

        Property property1 = new Property("Habitação luxuosa na ribeira", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"), user, Property.BusinessType.BUY, new ArrayList<String>());
		Property property2 = new Property("Habitação humilde na ribeira", "Egas", 120, 3.0f, 120000f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.BUY, new ArrayList<String>());

        propertyRepository.addProperty(property1);
        propertyRepository.addProperty(property2);

        Assertions.assertEquals(2, propertyRepository.getAllProperties().size());
        Assertions.assertTrue(propertyRepository.getAllProperties().contains(property1));
        Assertions.assertTrue(propertyRepository.getAllProperties().contains(property2));
    }

    @Test
    void removeProperty() {
        Person user = new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "9666121315");

		Property property1 = new Property("Habitação luxuosa na ribeira", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.BUY, new ArrayList<String>());
		Property property2 = new Property("Habitação humilde na ribeira", "Egas", 120, 3.0f, 120000f,
				new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.BUY, new ArrayList<String>());

        propertyRepository.addProperty(property1);
        propertyRepository.addProperty(property2);

        propertyRepository.removeProperty(property1);

        Assertions.assertEquals(1, propertyRepository.getAllProperties().size());
        Assertions.assertFalse(propertyRepository.getAllProperties().contains(property1));
        Assertions.assertTrue(propertyRepository.getAllProperties().contains(property2));
    }

    @Test
    void getPropertyByName() {
        Person user = new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "9112345235");

		Property property1 = new Property("Habitação luxuosa na ribeira", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.BUY, new ArrayList<String>());
		Property property2 = new Property("Habitação humilde na ribeira", "Egas", 120, 3.0f, 120000f,
				new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.BUY, new ArrayList<String>());

        propertyRepository.addProperty(property1);
        propertyRepository.addProperty(property2);

        Property property = propertyRepository.getPropertyByName("Habitação luxuosa na ribeira");

        Assertions.assertEquals(property1, property);

        property = propertyRepository.getPropertyByName("Property 3");

        Assertions.assertNull(property);
    }
}
