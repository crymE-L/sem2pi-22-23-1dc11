package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

import java.util.ArrayList;

/**
 * This class serves the purpose of mimicking
 * a real life real estate agency that belongs
 * to an AgencyNetwork
 *
 * @author Miguel Ferreira (1210701)
 */
public class Agency {
	/**
	 * The agency's name
	 */
	private String name;

	/**
	 * The agency's vat number, for
	 * taxation purposes
	 */
	private int vat;

	/**
	 * The location of the Agency, for
	 * tracking purposes
	 */
	private String location;

	/**
	 * The ageny's email
	 */
	private String email;

	/**
	 * The agency's phone number
	 */
	private String phone;

	/**
	 * The agency's agency network
	 */
	private AgencyNetwork agencyNetwork;

	/**
	 * The agency's manager
	 */
	private Employee manager;

	/**
	* The constructor made specifically to create
	* the object Agency. This constructor contains
	* all the parameters needed at once
	*
	* @param name
	* @param vat
	* @param location
	* @param email
	* @param phone
	*/
	public Agency(String name, int vat, String location, String email, String phone, AgencyNetwork agencyNetwork) {
		setName(name);
		setVat(vat);
		setLocation(location);
		setEmail(email);
		setPhone(phone);
		setAgencyNetwork(agencyNetwork);
	}

	/**
	 * The getter for the property name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter for the property name
	 *
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name) || name.length() > 40) throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}

	/**
	 * The getter for the property vat
	 *
	 * @return int
	 */
	public int getVat() {
		return vat;
	}

	/**
	 * The setter for the property vat.
	 * The vat number must have at least 9 characters.
	 *
	 * @param vat
	 */
	public void setVat(int vat) {
		if(Integer.toString(vat).length() != 9)
			throw new IllegalArgumentException("Your VAT number must have 9 characters.");

		this.vat = vat;
	}

	/**
	 * The getter for the property location
	 *
	 * @return String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * The setter for the property location
	 *
	 * @param location
	 */
	public void setLocation(String location) {
		if (Helpers.isEmpty(location))
			throw new IllegalArgumentException("Invalid location.");

		this.location = location;
	}

	/**
	 * The getter for the property email
	 *
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * The setter for the property email.
	 * The email must contain at least an @ symbol
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		if(Helpers.isEmpty(email) || !email.trim().contains("@"))
			throw new IllegalArgumentException("Invalid email.");

		this.email = email;
	}

	/**
	 * The getter for the property phone
	 *
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * The setter for the property phone.
	 * The phone number must have at least 10 characters.
	 *
	 * @param phone
	 */
	public void setPhone(String phone) {

		if (Helpers.isEmpty(phone) || phone.length() != 10)
			throw new IllegalArgumentException("The phone number must have 10 digits.");

		this.phone = phone;
	}

	/**
	 * The getter for the agency's manager
	 *
	 * @return Employee
	 */
	public Employee getManager() {
		return manager;
	}

	/**
	 * The setter for the agency's manager
	 *
	 * @param manager
	 */
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/**
	 * The getter for the agency's agency network
	 *
	 * @return AgencyNetwork
	 */
	public AgencyNetwork getAgencyNetwork() {
		return agencyNetwork;
	}

	/**
	 * The setter for the agency's agency network
	 *
	 * @param agencyNetwork
	 */
	public void setAgencyNetwork(AgencyNetwork agencyNetwork) {
		this.agencyNetwork = agencyNetwork;
	}
}
