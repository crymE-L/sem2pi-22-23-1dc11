package pt.ipp.isep.dei.esoft.project.domain;
//

import java.util.ArrayList;

/**
 * The announcement request will need to have the following:
 *
 *  address
 *  area
 *  distanceFromCenter
 *  price
 *  city
 *  district
 *  state
 *  owner
 *  bedrooms
 *  bathrooms
 *  parkingSpaces
 *  hasCentralHeating
 *  hasAirConditioning
 * agent
 *  business Type
 *  Contract duration (if it's for rent)
 *   price
 */

public class AnnouncementRequest {
    private String name;
    private String address;
    private int area;
    private float distanceFromCenter;
    private float price;
    private City city;
    private District district;
    private State state;
    private Person owner;
    private int bedrooms;
    private int bathrooms;
    private int parkingSpaces;
    private boolean hasCentralHeating;
    private boolean hasAirConditioning;
    private static Employee agent;
    private BusinessType businessType;
    private int contractDuration;

    // Constructor
    public AnnouncementRequest(String address, int area, float distanceFromCenter, float price, City city,
                               District district, State state, Person owner, int bedrooms, int bathrooms,
                               int parkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                               Employee agent, BusinessType businessType, int contractDuration) {
        this.address = address;
        this.area = area;
        this.distanceFromCenter = distanceFromCenter;
        this.price = price;
        this.city = city;
        this.district = district;
        this.state = state;
        this.owner = owner;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.parkingSpaces = parkingSpaces;
        this.hasCentralHeating = hasCentralHeating;
        this.hasAirConditioning = hasAirConditioning;
        this.agent = agent;
        this.businessType = businessType;
        this.contractDuration = contractDuration;


        Habitation habitation = new Habitation(name, address,  area,  distanceFromCenter,  price,  city,  district, state,  owner,  bedrooms,  bathrooms,  parkingSpaces,  hasCentralHeating,  hasAirConditioning, null);
    }
    // Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(float distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Person getOwner() {return owner;}

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getBedrooms() {return bedrooms;}

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public boolean hasCentralHeating() {
        return hasCentralHeating;
    }

    public void setCentralHeating(boolean hasCentralHeating) {
        this.hasCentralHeating = hasCentralHeating;
    }

    public boolean hasAirConditioning() {return hasAirConditioning;}

    public void setAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public static Employee getAgent() {
        return agent;
    }

    public void setAgent(Employee agent) {
        this.agent = agent;
    }

    public enum BusinessType {
        BUY,
        SALE, RENT
    }

    public void setBusinessType(String businessType) {
        if (businessType.equalsIgnoreCase("BUY")) {
            this.businessType = BusinessType.BUY;
        } else if (businessType.equalsIgnoreCase("RENT")) {
            this.businessType = BusinessType.RENT;
        } else {
            throw new IllegalArgumentException("Invalid business type: " + businessType);
        }
    }
    public BusinessType getBusinessType() {
        return businessType;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }
}