package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to simulate a real life
 * state, that is a collection of districts
 *
 * @author Miguel Ferreira (1210701)
 */
public class State {
	/**
	 * The state's name
	 */
	private String name;

	/**
	 * The state's districts
	 */
	private List<District> districts;

	/**
	 * This constructor exists to set up
	 * a State initializing with its name
	 * and districts
	 *
	 * @param name
	 * @param districts
	 */
	public State(String name, List<District> districts) {
		setName(name);
		setDistricts(districts);
	}

	/**
	 * This constructor exists in order for the programmer
	 * to set up a State initializing only with its name
	 *
	 * @param name
	 */
	public State(String name) {
		setName(name);
	}

	/**
	 * The getter for the state's name
	 *
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter for the state's name
	 *
	 * @param name
	 */
	public void setName(String name) {
		if(Helpers.isEmpty(name))
			throw new IllegalArgumentException("Invalid name.");

		this.name = name;
	}

	/**
	 * The getter for the state's districts
	 *
	 * @return List<District>
	 */
	public List<District> getDistricts() {
		return districts;
	}

	/**
	 * The setter for the state's districts
	 *
	 * @param districts
	 */
	public void setDistricts(List<District> districts) {
		if (districts == null)
			throw new IllegalArgumentException("Invalid district.");

		for (District district : districts) {
			if (district == null)
				throw new IllegalArgumentException("Invalid district.");
		}

		this.districts = districts;
	}
}
