package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to simulate a real life district,
 * which is a mashup of little cities and belongs to a state
 *
 * @author Miguel Ferreira (1210701)
 */
public class District {
	/**
	 * The district's name
	 */
	private String name;

	/**
	 * The district's cities
	 */
	private List<City> cities;

	/**
	 * This constructor exists to allow the programmer
	 * to initiate the district inside the program
	 * passing the cities in the beginning
	 *
	 * @param name
	 * @param cities
	 */
	public District(String name, List<City> cities) {
		setName(name);
		setCities(cities);
	}

	/**
	 * This constructor exists to allow the programmer
	 * to initiate the district inside the program
	 * without passing the cities
	 *
	 * @param name
	 */
	public District(String name) {
		setName(name);
	}

	/**
	 * The getter for the district's name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter for the district's name
	 *
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name))
			throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}

	/**
	 * The getter for the district's cities
	 *
	 * @return List<City>
	 */
	public List<City> getCities() {
		return cities;
	}

	/**
	 * The setter for the district's cities
	 *
	 * @param cities
	 */
	public void setCities(List<City> cities) {
		if(cities == null)
			throw new IllegalArgumentException("Invalid city.");

		for(City city : cities) {
			if(city == null)
				throw new IllegalArgumentException("Invalid city.");
		}

		this.cities = cities;
	}
}
