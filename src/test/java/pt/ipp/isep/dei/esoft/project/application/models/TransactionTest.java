package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.domain.Transaction;

import static org.junit.jupiter.api.Assertions.*;
import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.*;

import java.util.ArrayList;

class TransactionTest {

    @Test
    public void testConstructor() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Person buyer =  new Person("Matias", "matias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        Property property = new Property("Habitation at Porto ","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, BUY, new ArrayList<String>());

        Transaction transaction = new Transaction(owner, buyer, 150.000f, property);

        assertEquals(owner, transaction.getOwner());
        assertEquals(buyer, transaction.getBuyer());
        assertEquals(150.000f, transaction.getPrice());
        assertEquals(property, transaction.getProperty());
    }

    @Test
    public void testSetOwner() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Person buyer =  new Person("Matias", "matias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        Property property = new Property("Habitation at Porto ","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, BUY, new ArrayList<String>());

        Transaction transaction = new Transaction(owner, buyer, 150.000f, property);

        Person owner1 =  new Person("Digas", "digas@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        transaction.setOwner(owner1);
        assertEquals(owner1, transaction.getOwner());

        assertThrows(IllegalArgumentException.class, () -> transaction.setOwner(null));
    }

    @Test
    public void testSetBuyer() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Person buyer =  new Person("Matias", "matias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        Property property = new Property("Habitation at Porto ","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, RENT, new ArrayList<String>());

        Transaction transaction = new Transaction(owner, buyer, 150.000f, property);

        Person buyer1 =  new Person("Mat", "mat@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        transaction.setBuyer(buyer1);
        assertEquals(buyer1, transaction.getBuyer());

        assertThrows(IllegalArgumentException.class, () -> transaction.setBuyer(null));
    }

    @Test
    public void testSetPrice() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Person buyer =  new Person("Matias", "matias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        Property property = new Property("Habitation at Porto ","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, RENT, new ArrayList<String>());

        Transaction transaction = new Transaction(owner, buyer, 150.000f, property);

        transaction.setPrice(200f);
        assertEquals(200f, transaction.getPrice());

        assertThrows(IllegalArgumentException.class, () -> transaction.setPrice(-1));
        assertThrows(IllegalArgumentException.class, () -> transaction.setPrice(0));
    }

    @Test
    public void testSetProperty() {
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");

        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");
        Person buyer =  new Person("Matias", "matias@email.com", "AAAbcde12", new Role("ADMIN", 4), "1234567890");

        Property property = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, RENT, new ArrayList<String>());

        Transaction transaction = new Transaction(owner, buyer, 150.000f, property);

        Property property1 = new Property("Habitation at York","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, BUY, new ArrayList<String>());

        transaction.setProperty(property1);
        assertEquals(property1, transaction.getProperty());

        assertThrows(IllegalArgumentException.class, () -> transaction.setProperty(null));
    }
}
