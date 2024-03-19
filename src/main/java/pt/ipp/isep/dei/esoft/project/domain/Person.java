package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to simulate a person from real life
 * and its applications to the software
 *
 * @author Miguel Ferreira (1210701)
 */
public class Person {
	/**
	 * The person's name
	 */
	private String name;

	/**
	 * The person's email for authentication
	 */
	private String email;

	/**
	 * The person's password for authentication
	 */
	private String password;

	/**
	 * The person's role
	 */
	private ArrayList<Role> roles;

	/**
	 * The person's phone number
	 */
	private String phoneNumber;
	/**
	 * The person's properties
	 */
	private ArrayList<Property> properties = new ArrayList<Property>();

	/**
	 * This constructor was made to create a new person in the
	 * system, that can have a role and will interact with the
	 * platform
	 *
	 * @param name
	 * @param email
	 * @param password
	 * @param roles
	 * @param phoneNumber
	 */
	public Person(String name, String email, String password, ArrayList<Role> roles, String phoneNumber) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setRoles(roles);
		setPhoneNumber(phoneNumber);
	}

	/**
	 * This constructor was made to create a new person in the
	 * system, that can have a role and will interact with the
	 * platform
	 *
	 * @param name
	 * @param email
	 * @param password
	 * @param roles
	 */
	public Person(String name, String email, String password, Role roles) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setRoles(roles);
	}

	/**
	 * The getter for name of the person.
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter for the person's name.
	 *
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name))
			throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}

	/**
	 * The getter for the person's email
	 *
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * The setter for the person's email.
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		if (Helpers.isEmpty(email) || !email.trim().contains("@"))
			throw new IllegalArgumentException("Invalid email.");

		this.email = email;
	}

	/**
	 * The getter for the person's password
	 *
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * The setter for the person's password.
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		int uppercaseCharacters = 0;
		int numberCounter = 0;

		if (Helpers.isEmpty(password) || password.trim().length() < 7)
			throw new IllegalArgumentException("The password must have 7 characters or more.");

		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);

			if(Character.isUpperCase(character)) uppercaseCharacters++;

			if(Character.isDigit(character)) numberCounter++;
		}

		if(uppercaseCharacters < 3)
			throw new IllegalArgumentException("The password must have at least 3 capital letters.");

		if(numberCounter < 2)
			throw new IllegalArgumentException("The password must have at least 2 digits.");

		this.password = password;
	}

	/**
	 * The getter for the person's role object
	 *
	 * @return ArrayList<Role>
	 */
	public ArrayList<Role> getRoles() {
		return roles;
	}

	/**
	 * The setter for the person's role.
	 *
	 * @param roles
	 */
	public void setRoles(ArrayList<Role> roles) {
		if(roles == null)
			throw new IllegalArgumentException("Invalid roles.");

		this.roles = roles;
	}

	/**
	 * The getter for the person's phoneNumber object
	 *
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * The setter for the person's phoneNumber.
	 *
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10)
			throw new IllegalArgumentException("The phone number must have 10 characters.");

		this.phoneNumber = phoneNumber;
	}

	/**
	 * The getter for the person's properties
	 *
	 * @return ArrayList<Property>
	 */
	public ArrayList<Property> getProperties() {
		return properties;
	}

	/**
	 * The setter for the person's properties
	 *
	 * @param properties
	 */
	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}

	/**
	 * Adds a property to the person, creating
	 * a dependency relation
	 *
	 * @param property
	 */
	public void addProperty(Property property) {
		this.properties.add(property);
	}

	/**
	 * Adds a valid role to the user
	 *
	 * @param role
	 */
	public void addRole(Role role) {
		this.roles.add(role);
	}

	/**
	 * Removes the selected role from the user
	 *
	 * @param role
	 */
	public void removeRole(Role role) {
		this.roles.remove(role);
	}
}
