package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class serves to store the agency network's important data
 * @author Afonso Silva (1221179)
 */
public class AgencyNetwork {
    /**
     * The agency network's name
     */
    private String name;
    /**
     * The agency network's address
     */
    private String address;

	/**
	 * The agency network's city
	 */
	private City city;

	/**
	 * The agency network's district
	 */
	private District district;

	/**
	 * The agency network's state
	 */
	private State state;

    /**
     * The agency network's email
     */
    private String email;
    /**
     * The agency network's phone
     */
    private String phone;

	/**
	 * The agency network's manager
	 */
	private Employee networkManager;

	/**
	 * TEMPORARY
	 */
	public AgencyNetwork() { }

    /**
     * The constructor made specifically to create
     * the object AgencyNetwork. This constructor contains
     * all the parameters needed at once
     *
     * @param name
     * @param address
     * @param phone
     * @param email
     */
    public AgencyNetwork(String name, String address, String email, String phone) {
        setName(name);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
    }
    /**
     * The setter for the agency network's name
     *
     * @param name
     */
    public void setName(String name) {
        if(Helpers.isEmpty(name)) throw new IllegalArgumentException("Invalid name.");

        this.name = name;
    }
    /**
     * The setter for the agency network's address
     *
     * @param address
     */
    public void setAddress(String address) {
        if(Helpers.isEmpty(address)) throw new IllegalArgumentException("Invalid address.");

        this.address = address;
    }
    /**
     * The setter for the agency network's email
     *
     * @param email
     */
    public void setEmail(String email) {
        if(Helpers.isEmpty(email)) throw new IllegalArgumentException("Invalid email.");
        this.email = email;
    }
    /**
     * The setter for the agency network's phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        if(Helpers.isEmpty(phone)) throw new IllegalArgumentException("Invalid phone number.");
        this.phone = phone;
    }

    /**
     * The getter for the agency network's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * The getter for the agency network's address
     *
     * @return String
     */
    public String getAddress() {
        return address;
    }
    /**
     * The getter for the agency network's email
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

	/**
     * The getter for the agency network's phone
     *
     * @return String
     */
    public String getPhone() {
        return phone;
    }

	/**
	 * The getter for the agency network's city
	 *
	 * @return City
	 */
	public City getCity() {
		return city;
	}

	/**
	 * The setter for the agency network's city
	 *
	 * @param city
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * The getter for the agency network's district
	 *
	 * @return District
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * The setter for the agency network's district
	 *
	 * @param district
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * The getter for the agency network's state
	 *
	 * @return State
	 */
	public State getState() {
		return state;
	}

	/**
	 * The setter for the agency network's state
	 *
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * The getter for the agency network's manager
	 *
	 * @return Employee
	 */
	public Employee getManager() {
		return networkManager;
	}

	/**
	 * The setter for the agency network's manager
	 *
	 * @param networkManager
	 */
	public void setManager(Employee networkManager) {
		this.networkManager = networkManager;
	}
}
