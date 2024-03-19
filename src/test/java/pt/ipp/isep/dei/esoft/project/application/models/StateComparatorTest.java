package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;

public class StateComparatorTest {
    private StateComparator stateComparator;

    @Test
    public void testCompare_StateNamesAreEqual_ReturnZero() {
        stateComparator = new StateComparator();
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state = new State("State");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = stateComparator.compare(property1, property2);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCompare_StateNameOfProperty1ComesBeforeStateNameOfProperty2_ReturnNegative() {
        stateComparator = new StateComparator();
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state1 = new State("StateA");
        State state2 = new State("StateB");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state1, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city, district, state2, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = stateComparator.compare(property1, property2);

        Assertions.assertTrue(result < 0);
    }

    @Test
    public void testCompare_StateNameOfProperty2ComesBeforeStateNameOfProperty1_ReturnPositive() {
        stateComparator = new StateComparator();
        City city = new City("Avanca");
        District district = new District("Aveiro");
        State state1 = new State("StateA");
        State state2 = new State("StateB");
        Person owner =  new Person("Diogo", "email@email.com", "AAAbcde12", new Role("USER", 4), "1234567890");
        Property property1 = new Property("Habitation at Porto","Castle Street", 100, 5.0f, 150000.0f, city, district, state1, owner, Property.BusinessType.RENT, new ArrayList<String>());
        Property property2 = new Property("Habitation at Braga","Braga Street", 40, 3.0f, 10000.0f, city, district, state2, owner, Property.BusinessType.RENT, new ArrayList<String>());

        int result = stateComparator.compare(property2, property1);

        Assertions.assertTrue(result > 0);
    }
}
