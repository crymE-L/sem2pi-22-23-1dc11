package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;

public class CityComparatorTest {
    private CityComparator cityComparator;

    @Test
    public void testCompare_CityNamesAreEqual_ReturnZero() {
        cityComparator = new CityComparator();
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = cityComparator.compare(property1, property2);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompare_CityNameOfProperty1ComesBeforeCityNameOfProperty2_ReturnNegative() {
        cityComparator = new CityComparator();
        City city1 = new City("Braga");
        City city2 = new City("Porto");
        District district = new District("Aveiro");
        State state = new State("State");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city1, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city2, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = cityComparator.compare(property1, property2);

        Assertions.assertTrue(result < 0);
    }

    @Test
    public void testCompare_CityNameOfProperty2ComesBeforeCityNameOfProperty1_ReturnPositive() {
        cityComparator = new CityComparator();
        City city1 = new City("Braga");
        City city2 = new City("Porto");
        District district = new District("Aveiro");
        State state = new State("State");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city1, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city2, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = cityComparator.compare(property2, property1);

        Assertions.assertTrue(result > 0);
    }
}
