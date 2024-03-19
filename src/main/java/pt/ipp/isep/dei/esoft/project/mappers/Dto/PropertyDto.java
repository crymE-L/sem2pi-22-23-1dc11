package pt.ipp.isep.dei.esoft.project.mappers.Dto;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;

/**
 * This class serves to create a property DTO (Data Transfer Object).
 * It represents a property object in a simplified manner for data transfer purposes.
 *
 * @author Gustavo Lima (1221349)
 */
public class PropertyDto {
    /**
     * The property's name
     */
    private String name;

    /**
     * The property's address
     */
    private String address;

    /**
     * The property's area
     */
    private int area;

    /**
     * The property's distance from center
     */
    private float distanceFromCenter;

    /**
     * The property's price
     */
    private float price;

    /**
     * The property's city
     */
    private City city;

    /**
     * The property's district
     */
    private District district;

    /**
     * The property's state
     */
    private State state;

    /**
     * The property's owner
     */
    private Person owner;

    public PropertyDto(String name, String address, int area, float distanceFromCenter, float price, City city, District district, State state, Person owner, Property.BusinessType businessType, ArrayList<String> photos) {
    }

    /**
     * The possible types of the transaction's request
     */
    public enum BusinessType { BUY, RENT }

    /**
     * The type of the transaction's request
     */
    private BusinessType businessType;

    /**
     * The list of property photos
     */
    private ArrayList<String> photos;

    /**
     * Constructs a PropertyDto object with the specified information.
     *
     * @param id                the property's ID
     * @param name              the property's name
     * @param address           the property's address
     * @param area              the property's area
     * @param distanceFromCenter the property's distance from center
     * @param price             the property's price
     * @param city              the property's city
     * @param district          the property's district
     * @param state             the property's state
     * @param owner             the property's owner
     * @param businessType      the type of the transaction's request
     * @param photos            the list of property photos
     */
    public PropertyDto(String name, String address, int area, float distanceFromCenter, float price, City city,
                       District district, State state, Person owner, BusinessType businessType, ArrayList<String> photos) {
        this.name = name;
        this.address = address;
        this.area = area;
        this.distanceFromCenter = distanceFromCenter;
        this.price = price;
        this.city = city;
        this.district = district;
        this.state = state;
        this.owner = owner;
        this.businessType = businessType;
        this.photos = photos;
    }

    /**
     * Gets the property's name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the property's address.
     *
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the property's area.
     *
     * @return int
     */
    public int getArea() {
        return area;
    }

    /**
     * Gets the property's distance from center.
     *
     * @return float
     */
    public float getDistanceFromCenter() {
        return distanceFromCenter;
    }

    /**
     * Gets the property's price.
     *
     * @return float
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the property's city.
     *
     * @return City
     */
    public City getCity() {
        return city;
    }

    /**
     * Gets the property's district.
     *
     * @return District
     */
    public District getDistrict() {
        return district;
    }

    /**
     * Gets the property's state.
     *
     * @return State
     */
    public State getState() {
        return state;
    }

    /**
     * Gets the property's owner.
     *
     * @return Person
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Gets the type of the transaction's request.
     *
     * @return BusinessType
     */
    public BusinessType getBusinessType() {
        return businessType;
    }

    /**
     * Gets the list of property photos.
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getPhotos() {
        return photos;
    }
}
