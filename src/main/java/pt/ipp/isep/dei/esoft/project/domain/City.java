package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to simulate a city
 * from the real life
 *
 * @author Miguel Ferreira (1210701)
 */
public class City {
	/**
	 * The city's name
	 */
	private String name;

	/**
	 * This constructor exists to allow the program to
	 * create a city
	 *
	 * @param name
	 */
	public City(String name) {
		setName(name);
	}

	/**
	 * The getter for the city's name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter for the city's name
	 *
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name))
			throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}
}
