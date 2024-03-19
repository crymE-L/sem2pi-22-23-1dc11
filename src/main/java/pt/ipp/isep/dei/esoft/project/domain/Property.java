package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to simulate any piece of
 * real estate that can exist
 *
 * @author Miguel Ferreira (1210701)
 */
public class Property {

	private static int nextId = 1;

	/**
	 * The property's ID
	 */
	private int id;

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

	/**
	 * The property's visit requests
	 */
	private ArrayList<VisitRequest> visitRequests = new ArrayList<VisitRequest>();

	/**
	 * The possible types of the transaction's request
	 */
	public enum BusinessType { BUY, RENT };

	/**
	 * The type of the transaction's request
	 */
	private BusinessType businessType;

	/**
	 * The list of property photos
	 */
	private ArrayList<String> photos;

	/**
	 * This constructor exists to create a new property
	 *
	 * @param name
	 * @param address
	 * @param area
	 * @param distanceFromCenter
	 * @param price
	 * @param city
	 * @param district
	 * @param state
	 * @param owner
	 * @param businessType
	 */
	public Property(String name, String address, int area, float distanceFromCenter, float price, City city, District district, State state, Person owner, BusinessType businessType, ArrayList<String> photos) {
		this.id = generateNextId();
		setName(name);
		setAddress(address);
		setArea(area);
		setDistanceFromCenter(distanceFromCenter);
		setPrice(price);
		setCity(city);
		setDistrict(district);
		setState(state);
		setOwner(owner);
		setBusinessType(businessType);
		setPhotos(photos);
	}

	/**
	 * Generates the next available ID for a property
	 *
	 * @return the next available ID
	 */
	private static int generateNextId() {
		return nextId++;
	}

	/**
	 * Gets the ID of the property
	 *
	 * @return the property ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * The getter for the name
	 * @return String
	 */
	public String getName() {return name;}

	/**
	 * The setter for the name
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name))
			throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}
	/**
	 * The getter for the address
	 *
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * The setter for the address
	 *
	 * @param address
	 */
	public void setAddress(String address) {
		if(Helpers.isEmpty(address))
			throw new IllegalArgumentException("Invalid address.");

		this.address = address;
	}

	/**
	 * The getter for the area
	 *
	 * @return int
	 */
	public int getArea() {
		return area;
	}

	/**
	 * The setter for the area
	 *
	 * @param area
	 */
	public void setArea(int area) {
		if(area <= 0)
			throw new IllegalArgumentException("Invalid area.");

		this.area = area;
	}

	/**
	 * The getter for the distance from center
	 *
	 * @return float
	 */
	public float getDistanceFromCenter() {
		return distanceFromCenter;
	}

	/**
	 * The setter for the distance from center
	 *
	 * @param distanceFromCenter
	 */
	public void setDistanceFromCenter(float distanceFromCenter) {
		if(distanceFromCenter < 0)
			throw new IllegalArgumentException("Invalid distance from center.");

		this.distanceFromCenter = distanceFromCenter;
	}

	/**
	 * The getter for the price
	 *
	 * @return float
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * The setter for the price
	 *
	 * @param price
	 */
	public void setPrice(float price)
	{
		if(price <= 0)
			throw new IllegalArgumentException("Invalid price.");

		this.price = price;
	}

	/**
	 * The getter for the city
	 *
	 * @return City
	 */
	public City getCity() {
		return city;
	}

	/**
	 * The setter for the city
	 *
	 * @param city
	 */
	public void setCity(City city) {
		if (city == null)
			throw new IllegalArgumentException("Invalid city.");

		this.city = city;
	}

	/**
	 * The getter for the district
	 *
	 * @return District
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * The setter for the district
	 *
	 * @param district
	 */
	public void setDistrict(District district) {
		if (district == null)
			throw new IllegalArgumentException("Invalid district.");

		this.district = district;
	}

	/**
	 * The getter for the state
	 *
	 * @return State
	 */
	public State getState() {
		return state;
	}

	/**
	 * The setter for the state
	 *
	 * @param state
	 */
	public void setState(State state) {
		if (state == null)
			throw new IllegalArgumentException("Invalid state.");

		this.state = state;
	}

	/**
	 * The getter for the owner
	 *
	 * @return Person
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * The setter for the owner
	 *
	 * @param owner
	 */
	public void setOwner(Person owner) {
		if(owner == null)
			throw new IllegalArgumentException("Invalid owner.");

		this.owner = owner;
	}

	/**
	 * The getter for the property's visit requests
	 *
	 * @return ArrayList<VisitRequest>
	 */
	public ArrayList<VisitRequest> getVisitRequests() {
		return visitRequests;
	}

	/**
	 * The setter for the property's visit requests
	 *
	 * @param visitRequests
	 */
	public void setVisitRequests(ArrayList<VisitRequest> visitRequests) {
		this.visitRequests = visitRequests;
	}

	/**
	 * Adds a new visit request to the property
	 *
	 * @param visitRequest
	 */
	public void addVisitRequest(VisitRequest visitRequest) {
		this.visitRequests.add(visitRequest);
	}

	/**
	 * The getter for the property type
	 *
	 * @return BusinessType
	 */
	public BusinessType getBusinessType() { return businessType; }

	/**
	 * The setter for the property type
	 *
	 * @param businessType
	 */
	public void setBusinessType(BusinessType businessType) {
		if (businessType == null) throw new IllegalArgumentException("Invalid business type.");
		this.businessType = businessType;
	}

	/**
	 * The getter for the photos
	 *
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getPhotos() {
		return photos;
	}

	/**
	 * The setter for the photos
	 *
	 * @param photos
	 */
	public void setPhotos(ArrayList<String> photos) {
		if(photos == null) throw new IllegalArgumentException("Invalid photos.");

		this.photos = photos;
	}

	/**
	 * The textual description of a property
	 * @return String
	 */
	@Override
	public String toString() {
		return "Property {" + "\n" +
				"name = '" + name + '\'' + "\n" +
				"address = '" + address + '\'' + "\n" +
				"area = " + area + "\n" +
				"distanceFromCenter = " + distanceFromCenter + "km" + "\n" +
				"price = " + price + "€" + "\n" +
				"city = " + city.getName() + "\n" +
				"district = " + district.getName() + "\n" +
				"state = " + state.getName() + "\n" +
				"owner = " + owner.getName() + "\n" +
				"businessType = " + businessType + "\n" +
				'}';
	}

}
