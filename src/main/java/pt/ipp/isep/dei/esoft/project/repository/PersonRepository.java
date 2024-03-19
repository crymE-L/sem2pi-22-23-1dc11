package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Person;

/**
 * @author Miguel Ferreira (1210701)
 */
public class PersonRepository {
	private final List<Person> users = new ArrayList<>();

	/**
	 * Adds a user to the repository.
	 *
	 * @param person
	 */
	public void addUser(Person person) {
		users.add(person);
	}

	/**
	 * Removes a user from the repository.
	 *
	 * @param person
	 */
	public void removeUser(Person person) {
		users.remove(person);
	}

	/**
	 * Retrieves all users in the repository.
	 *
	 * @return List<Person>.
	 */
	public List<Person> getAllUsers() {
		return new ArrayList<>(this.users);
	}

	/**
	 * Retrieves a user by email.
	 *
	 * @param email
	 * @return Person
	 */
	public Person getUserByEmail(String email) {
		for (Person user : users) {
			if (user.getEmail().equals(email))
				return user;
		}

		return null;
	}

	/**
	 * Retrieves a user by name
	 *
	 * @param name
	 * @return
	 */
	public Person getUserByName(String name) {
		for (Person user : users) {
			if (user.getName().equals(name))
				return user;
		}
		return null;
	}
}
