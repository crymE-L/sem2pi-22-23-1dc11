package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Comparator;

public class CityComparator implements Comparator<Property> {
    /**
     * Compares the city of different announcement
     * and then sorts each property
     * @param property1
     * @param property2
     * @return
     */
    public int compare(Property property1, Property property2) {
        return property1.getCity().getName().compareTo(property2.getCity().getName());
    }
}
