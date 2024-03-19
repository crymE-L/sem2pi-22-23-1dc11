package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.*;

import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.*;

/**
 * Repository class for managing instances of Properties.
 *
 * @author Gustavo Lima (1221349)
 */
public class PropertyRepository {
    private final List<Property> properties = new ArrayList<>();

    /**
     * Adds a Property to the repository.
     *
     * @param property
     */
    public void addProperty(Property property) {
        properties.add(property);
    }

    /**
     * Removes a Property from the repository.
     *
     * @param property
     */
    public void removeProperty(Property property) {
        properties.remove(property);
    }

    /**
     * Retrieves all properties in the repository.
     *
     * @return List of properties.
     */
    public List<Property> getAllProperties() {
        return new ArrayList<>(properties);
    }

    /**
     * Retrieves a Property by id.
     *
     * @param id
     * @return The Property with the given id, or null if not found.
     */
    public Property getPropertyById(int id) {
        for (Property property : properties) {
            if (property.getId() == (id)) {
                return property;
            }
        }
        return null;
    }

    /**
     * Retrieves a Property by name.
     *
     * @param name
     * @return The Property with the given name, or null if not found.
     */
    public Property getPropertyByName(String name) {
        for (Property property : properties) {
            if (property.getName().equals(name)) {
                return property;
            }
        }
        return null;
    }

    /**
     * Filters every property by the ascending price
     *
     * @return List
     */
    public List<Object> getPropertiesByPriceAsc() {
        List<Object> propertiesByAscendingPrice = new ArrayList<>();

        Collections.sort(properties, Comparator.comparingDouble(Property::getPrice));

        for(Property property : properties) {
            propertiesByAscendingPrice.add((Object) property);
        }

        return propertiesByAscendingPrice;
    }

    /**
     * Filters every property by the descending price
     *
     * @return List
     */
    public List<Object> getPropertiesByPriceDesc() {
        List<Object> propertiesByDescendingPrice = new ArrayList<>();

        Collections.sort(properties, Comparator.comparingDouble(Property::getPrice).reversed());

        for(Property property : properties) {
            propertiesByDescendingPrice.add((Object) property);
        }

        return propertiesByDescendingPrice;
    }

    /**
     * Filters every Land that exists
     *
     * @return List
     */
    public List<Object> getLands() {
        List<Object> lands = new ArrayList<>();

        for(Object property : properties) {
            if (!(property instanceof Habitation)) lands.add((Property) property);
        }

        return lands;
    }

    /**
     * Filters every House that exists
     *
     * @return List
     */
    public List<Object> getHouses() {
        List<Object> houses = new ArrayList<>();

        for (Object property : properties) {
            if (property instanceof House) houses.add((House) property);
        }

        return houses;
    }

    /**
     * Filters every Apartment that exists
     *
     * @return List
     */
    public List<Object> getApartments() {
        List<Object> apartments = new ArrayList<>();

        for (Object property : properties) {
            if ((property instanceof Habitation) && !(property instanceof House)) apartments.add((Habitation) property);
        }

        return apartments;
    }

    /**
     * Filters every property by the number of bedrooms
     *
     * @param minBedrooms
     * @return List
     */
    public List<Object> getPropertiesByBedrooms(int minBedrooms) {
        List<Object> propertiesByBedrooms = new ArrayList<>();

        for (Object property : properties) {
            if ((property instanceof Habitation)) {
                if (minBedrooms <= ((Habitation) property).getBedrooms()) {
                    propertiesByBedrooms.add(property);
                }
            }
        }

        return propertiesByBedrooms;
    }

    /**
     * Filters every property by the business type, rent
     *
     * @return List
     */
    public List<Object> getPropertiesToRent() {
        List<Object> propertiesToRent = new ArrayList<>();

        for (Object property : properties) {
            if (((Property) property).getBusinessType() == RENT) {
                propertiesToRent.add(property);
            }
        }

        return propertiesToRent;
    }

    /**
     * Filters every property by the business type, buy
     *
     * @return List
     */
    public List<Object> getPropertiesToBuy() {
        List<Object> propertiesToBuy = new ArrayList<>();

        for (Object property : properties) {
            if (((Property) property).getBusinessType() == BUY) {
                propertiesToBuy.add(property);
            }
        }

        return propertiesToBuy;
    }

    /**
     * Filters every property by the city's name
     *
     * @param cityName
     * @return List
     */
    public List<Object> getPropertiesByCity(String cityName) {
        List<Object> propertiesByCity = new ArrayList<>();

        for (Object property : properties) {
            if (((Property) property).getCity().getName().equalsIgnoreCase(cityName)) {
                propertiesByCity.add(property);
            }
        }

        return propertiesByCity;
    }

    /**
     * Filters every property by the state's name
     * @param stateName
     * @return List
     */
    public List<Object> getPropertiesByState(String stateName) {
        List<Object> propertiesByState = new ArrayList<>();

        for (Object property : properties) {
            if (((Property) property).getState().getName().equalsIgnoreCase(stateName)) {
                propertiesByState.add(property);
            }
        }

        return propertiesByState;
    }
}
