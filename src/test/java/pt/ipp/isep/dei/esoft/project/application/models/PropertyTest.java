package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.State;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
class PropertyTest  {

    @Test
    public void testConstructor() {
		City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());
        assertEquals("Habitation at Porto", property.getName());
        assertEquals("Castle Street", property.getAddress());
        assertEquals(100, property.getArea());
        assertEquals(5.0f, property.getDistanceFromCenter());
        assertEquals(150000.0f, property.getPrice());
        assertEquals(city, property.getCity());
		assertEquals(district, property.getDistrict());
        assertEquals(state, property.getState());
        assertEquals(owner, property.getOwner());
    }

    @Test
    public void testSetName() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

        property.setName("Habitação luxuosa na Barrosa");
        assertEquals("Habitação luxuosa na Barrosa", property.getName());

        assertThrows(IllegalArgumentException.class, () -> property.setName(""));
    }

    @Test
    public void testSetAddress() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

        property.setAddress("Rua da Ribeira");
        assertEquals("Rua da Ribeira", property.getAddress());

        assertThrows(IllegalArgumentException.class, () -> property.setAddress(""));
    }

    @Test
    public void testSetArea() {
		City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

        property.setArea(12);
        assertEquals(12, property.getArea());

        assertThrows(IllegalArgumentException.class, () -> property.setArea(0));
        assertThrows(IllegalArgumentException.class, () -> property.setArea(-5));
    }

    @Test
    public void testSetDistanceFromCenter() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

        property.setDistanceFromCenter(12f);
        assertEquals(12f, property.getDistanceFromCenter());

        assertThrows(IllegalArgumentException.class, () -> property.setDistanceFromCenter(-1));
    }

    @Test
    public void testSetPrice() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

        property.setPrice(12f);
        assertEquals(12f, property.getPrice());

        assertThrows(IllegalArgumentException.class, () -> property.setPrice(-1f));
        assertThrows(IllegalArgumentException.class, () -> property.setPrice(0f));
    }

    @Test
    public void testSetParish() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f,  city,  district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

		City city2 = new City("City 2");
        property.setCity(city2);
        assertEquals(city2, property.getCity());

        assertThrows(IllegalArgumentException.class, () -> property.setCity(null));
    }

	@Test
	public void testSetDistrict() {
		City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner = new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
		Property property = new Property("Habitation at Porto", "Castle Street", 100, 5.0f, 150000.0f, city,
				district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

		District district2 = new District("District 2");
		property.setDistrict(district2);
		assertEquals(district2, property.getDistrict());

		assertThrows(IllegalArgumentException.class, () -> property.setDistrict(null));
	}

    @Test
    public void testSetState() {
		City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

		State state2 = new State("State 2");
        property.setState(state2);
        assertEquals(state2, property.getState());

        assertThrows(IllegalArgumentException.class, () -> property.setState(null));
    }

    @Test
    public void testSetOwner() {
        City city = new City("Avanca");
		District district = new District("Aveiro");
		State state = new State("State");

		Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

		Person owner2 = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        property.setOwner(owner2);
        assertEquals(owner2, property.getOwner());

        assertThrows(IllegalArgumentException.class, () -> property.setOwner(new Person("", "", "", new Role("", -1), "1234567890")));
        assertThrows(IllegalArgumentException.class, () -> property.setOwner(null));
    }

    @Test
    public void testSetBusinessType() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner = new Person("Diogo", "diogo@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Property property = new Property("Habitation at Porto", "Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT,
				new ArrayList<String>());

        // Test setting business type to BUY
        property.setBusinessType(Property.BusinessType.BUY);
        assertEquals(Property.BusinessType.BUY, property.getBusinessType());

        // Test setting business type to RENT
        property.setBusinessType(Property.BusinessType.RENT);
        assertEquals(Property.BusinessType.RENT, property.getBusinessType());

        // Test setting business type to null
        assertThrows(IllegalArgumentException.class, () -> property.setBusinessType(null));
    }
}
