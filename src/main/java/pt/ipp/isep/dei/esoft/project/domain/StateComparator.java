package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Comparator;

public class StateComparator implements Comparator<Property> {
    /**
     * Compares the state of different announcement
     * and then sorts each property
     * @param property1
     * @param property2
     * @return
     */
    public int compare(Property property1, Property property2) {
        return property1.getState().getName().compareTo(property2.getState().getName());
    }
}
