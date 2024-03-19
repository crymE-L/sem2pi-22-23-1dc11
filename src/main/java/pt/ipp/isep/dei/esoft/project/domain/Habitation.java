package pt.ipp.isep.dei.esoft.project.domain;

import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.*;

import java.util.ArrayList;

/**
 * This class serves to simulate a habitation.
 *
 * @author Diogo Martins (1221223)
 */
public class Habitation extends Property{

    /**
     * The number of bedrooms of a habitation.
     */
    private int bedrooms;

    /**
     * The number of bathrooms of a habitation.
     */
    private int bathrooms;

    /**
     * The number of parking spaces of a habitation.
     */
    private int parkingSpaces;

    /**
     * The central heating of a habitation.
     */
    private boolean hasCentralHeating;

    /**
     * The air conditioning of a habitation.
     */
    private boolean hasAirConditioning;

    /**
	 * The constructor made specifically to create
	 * the object Habitation. This constructor contains
	 * all the parameters needed at once
	 *
	 * @param address
	 * @param area
	 * @param distanceFromCenter
	 * @param price
	 * @param city
	 * @param district
	 * @param state
	 * @param owner
	 * @param bedrooms
	 * @param bathrooms
	 * @param parkingSpaces
	 * @param hasCentralHeating
	 * @param hasAirConditioning
	 */
    public Habitation(String name, String address, int area, float distanceFromCenter, float price, City city, District district, State state, Person owner, int bedrooms, int bathrooms, int parkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, ArrayList<String> photos) {
        super(name, address, area, distanceFromCenter, price, city, district, state, owner, BUY, photos);
		setBedrooms(bedrooms);
		setBathrooms(bathrooms);
		setParkingSpaces(parkingSpaces);
		setHasCentralHeating(hasCentralHeating);
		setHasAirConditioning(hasAirConditioning);
    }

    /**
     * The getter for the number of bedrooms.
     *
     * @return int
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * The setter for the number of bedrooms.
     *
     * @param bedrooms
     */
    public void setBedrooms(int bedrooms) {
        if(bedrooms < 0) throw new IllegalArgumentException("Invalid number of bedrooms.");
        this.bedrooms = bedrooms;
    }

    /**
     * The getter for the number of bathrooms.
     *
     * @return int
     */
    public int getBathrooms() {
        return bathrooms;
    }

    /**
     * The setter for the number of bathrooms.
     *
     * @param bathrooms
     */
    public void setBathrooms(int bathrooms) {
        if(bathrooms < 0) throw new IllegalArgumentException("Invalid number of bathrooms.");
        this.bathrooms = bathrooms;
    }

    /**
     * The getter for the number of parking spaces.
     *
     * @return int
     */
    public int getParkingSpaces() {
        return parkingSpaces;
    }

    /**
     * The setter for the number of parking spaces.
     *
     * @param parkingSpaces
     */
    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * The getter for the existence of central heating.
     *
     * @return boolean
     */
    public boolean isHasCentralHeating() {
        return hasCentralHeating;
    }

    /**
     * The setter for the existence of central heating.
     *
     * @param hasCentralHeating
     */
    public void setHasCentralHeating(boolean hasCentralHeating) {
        this.hasCentralHeating = hasCentralHeating;
    }

    /**
     * The getter for the existence of air conditioning.
     *
     * @return boolean
     */
    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    /**
     * The setter for the existence of air conditioning.
     *
     * @param hasAirConditioning
     */
    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }
}
