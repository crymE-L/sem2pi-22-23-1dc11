package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.*;

import java.util.ArrayList;

/**
 * This class exists to act as a controller that holds all
 * the logical operations needed for all features that
 * may relate to the user story 1
 *
 * @author Gustavo Lima (1221349)
 */
public class PropertyController {
    private PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();

    /**
     * This constructor gets the property repository.
     */
    public PropertyController () {
        getPropertyRepository();
    }

    /**
     * This constructor takes a property repository object as a parameter.
     *
     * @param propertyRepository
     */
    public PropertyController (PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    /**
	 * This method initializes the propertyRepository
	 * instance variable if it is null.
	 */
    private void getPropertyRepository(){
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            propertyRepository = repositories.getPropertyRepository();
        }
	}

    /**
     * This method creates a new property object and adds it to the
     * property repository.
     *
     * @param name
     * @param address
     * @param area
     * @param distanceFromCenter
     * @param price
     * @param district
     * @param city
     * @param state
     * @param owner
     * @return propertyRepository
     */
    public Property createPropertyAndPutInRepository(String name, String address, int area, float distanceFromCenter, float price, City city, District district, State state, Person owner, Property.BusinessType businessType, ArrayList<String> photos) throws Exception, DataExistsException {
        Property property = new Property(name, address, area, distanceFromCenter, price, city, district, state, owner, businessType, photos);

        propertyRepository.addProperty(property);

		return property;
    }
}
