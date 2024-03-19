package pt.ipp.isep.dei.esoft.project.application.controller.authorization;

import java.io.IOException;
import java.util.*;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.console.utils.FileReadingSystem;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;


public class AuthController {
	public void login(String email, String password) {
		/**
		 * First we get our repositories
		 */
		PersonRepository users = Repositories.getInstance().getUsersRepository();
		EmployeeRepository employees = Repositories.getInstance().getEmployeeRepository();

		ApplicationSession session = Repositories.getInstance().getSession();

		Person user = users.getUserByEmail(email);
		Employee employee = employees.getEmployeeByEmail(email);

		/**
		 * If both objects are null, then it means that the repository
		 * failed to get both of those objects by the email passed
		 * as a parameter.
		 */
		if(user == null && employee == null)
			throw new IllegalArgumentException("Invalid email or password.");

		if(user != null) {
			if(!checkUserPassword(user, password))
				throw new IllegalArgumentException("Invalid email or password.");

			session.setCurrentUser(user);
		} else {
			if(!checkEmployeePassword(employee, password))
				throw new IllegalArgumentException("Invalid email or password.");

			session.setCurrentUser(employee);
		}
	}

	public Person register(String name, String email, String phoneNumber) {
		PersonRepository users = Repositories.getInstance().getUsersRepository();
		RoleRepository rolesRepository = Repositories.getInstance().getRoleRepository();

		Properties properties = new Properties();

		FileReadingSystem file = null;

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String filename = properties.getProperty("Environment.ProjectRoot") + "emails.txt";

			file = new FileReadingSystem(filename);
		} catch (IOException exception) {
			System.out.println("File not found");
		}

		/**
		 * Let's generate the password for our
		 * beautiful user
		 */
		String password = this.passwordGenerator(7);

		/**
		 * Instead of sending the password via email,
		 * for now we'll simply show it in the
		 * console
		 */
		System.out.printf("TEMPORARY\n");
		System.out.printf("Password: %s\n", password);

		/**
		 * We can't register two users with the same email
		 */
		if(users.getUserByEmail(email) != null)
			throw new IllegalArgumentException("User already exists.");

		Role role = rolesRepository.getRoleByName("User");
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role);

		Person user = new Person(name, email, password, roles, phoneNumber);

		users.addUser(user);

		String[] data = new String[]{
				email,
				password
		};

		try {
			file.writeData(data);
		} catch(IOException exception) {
			System.out.println("It wasn't possible to write the user data to the file.");
		}

		return user;
	}

	private boolean checkUserPassword(Person user, String password) { return user.getPassword().equals(password); }

	private boolean checkEmployeePassword(Employee employee, String password) { return employee.getPassword().equals(password); }

	/**
	 * This password generator function takes in the length that
	 * the password should have and generates a string
	 * according to a set of characters available
	 * in the string availableCharacters.
	 *
	 * The higher the length of a password,
	 * the stronger it is
	 *
	 * @param length
	 * @return
	 */
	public String passwordGenerator(int length) {
		/**
		 * Get all the possible characters in a password
		 */
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String specialCharacters = "_*^.-()%&@#!";

		/**
		 * Let's start by determining the difference between
		 * the strength that we want and the minimun strength
		 * needed for the password.
		 */
		int strengthDifference = length - 5;

		/**
		 * Mix them all together
		 */
		String availableCharacters = alphabet + alphabet.toUpperCase() + numbers + specialCharacters;

		StringBuilder password = new StringBuilder();
		Random random = new Random();

		/**
		 * Start off to choose our preset parameters:
		 * - Have three uppercase letters
		 * - Have at least two digits
		 */
		password.append(this.selectRandomCharacters(3, alphabet.toUpperCase()));
		password.append(this.selectRandomCharacters(2, numbers));

		for (int i = 0; i < strengthDifference; i++) {
			int index = random.nextInt(availableCharacters.length());
			char randomCharacter = availableCharacters.charAt(index);

			password.append(randomCharacter);
		}

		/**
		 * To finish off, we have to shuffle our password as,
		 * otherwise, it would always have the same formula
		 */
		List<String> passwordList = new ArrayList<>(List.of(password.toString().split("")));
		Collections.shuffle(passwordList);

		return String.join("", passwordList);
	}

	/**
	 * Generates a string with a combination of random X characters
	 * (length) provided by a specific string (list) and returns
	 * it as a string
	 *
	 * Since we have very specific requirements to generate the
	 * password, this function will allow us to generate
	 * a password accordingly to those requirements.
	 *
	 * @param length
	 * @param list
	 * @return String
	 */
	private String selectRandomCharacters(int length, String list) {
		StringBuilder combination = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(list.length());
			char randomCharacter = list.charAt(index);

			combination.append(randomCharacter);
		}

		return combination.toString();
	}

	public boolean existsUser(String email) {
		return (checkForUser(email) || checkForEmployee(email));
	}

	private boolean checkForUser(String email) {
		PersonRepository usersRepository = Repositories.getInstance().getUsersRepository();
		Person user = usersRepository.getUserByEmail(email);

		return user != null;
	}

	private boolean checkForEmployee(String email) {
		EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
		Employee employee = employeeRepository.getEmployeeByEmail(email);

		return employee != null;
	}
}
