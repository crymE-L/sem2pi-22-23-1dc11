package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.*;

public class PropertyUI implements Runnable {
	Scanner sc = new Scanner(System.in);
	Repositories repositories = new Repositories();
	PropertyRepository propertyRepository = repositories.getPropertyRepository();
	PersonRepository users = repositories.getUsersRepository();
	EmployeeRepository agents = repositories.getEmployeeRepository();
	MainUI mainUI = new MainUI();

	@Override
	public void run() {
		System.out.println("### List property ###\n");
		System.out.println("1 - Create property");
		System.out.println("2 - Check sale announcement");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				try {
					this.createProperty();
				} catch (RuntimeException exception) {
					System.out.println(exception.getMessage());
					break;
				}
				break;
			case 2:
				this.createSaleAnnouncement();
				break;
			case 0:
				mainUI.run();
				break;
		}
	}

	private void createProperty() {
		AuthController authController = new AuthController();

		System.out.print("Name of the property: ");
		String name = sc.nextLine();

		System.out.print("Address of the property: ");
		String address = sc.nextLine();

		System.out.print("Name of the city of the property: ");
		String city = sc.nextLine();

		System.out.print("Name of the district of the property: ");
		String district = sc.nextLine();

		System.out.print("Name of the state of the property: ");
		String state = sc.nextLine();

		System.out.print("Area of the property: ");
		int area = sc.nextInt();

		System.out.print("Property's distance from center: ");
		float distanceFromCenter = sc.nextFloat();

		System.out.print("Property's price: ");
		float price = sc.nextFloat();
		sc.nextLine();

		System.out.print("Owner's name: ");
		String ownerName = sc.nextLine();

		System.out.print("Owner's email: ");
		String ownerEmail = sc.nextLine();

		System.out.print("Owner's phone number: ");
		String ownerPhone = sc.nextLine();

		//	Property property = new Property(name, address, area, distanceFromCenter, price, new City(city), new District(district), new State(state), owner, BUY);
		Person owner = authController.register(ownerName, ownerEmail, ownerPhone);
		Property property = new Property(name, address, area, distanceFromCenter, price, new City(city), new District(district), new State(state), owner, BUY, new ArrayList<String>());

		//	propertyRepository.addProperty(property);
	}

	private void createSaleAnnouncement() {
		/**
		 * Temporary1

		 */
		int counter = 1;
		int option = 0;

		System.out.println("== Select an owner ==");
		Person owner = selectUser();

		System.out.println("== Select a buyer ==");
		Person buyer = selectUser();

		System.out.println("== Select an agent ==");
		Employee agent = selectEmployee();

		System.out.println("== Select a property ==");
		Property property = selectProperty();

		System.out.print("What's the commission? > ");
		float commission = sc.nextFloat();


	}

	private Person selectUser() {
		int option = 0;
		int counter = 1;

		List<Person> allUsers = users.getAllUsers();

		for(Person user : allUsers) {
			System.out.printf("%d - %s", counter, user.getName());
			counter++;
		}

		do {
			System.out.print("> ");
			option = sc.nextInt();
		} while (option < 0 || option > allUsers.size());

		return allUsers.get(option - 1);
	}

	private Employee selectEmployee() {
		int option = 0;
		int counter = 1;

		List<Employee> allAgents = agents.getAllEmployee();

		for(Employee agent : allAgents) {
			System.out.printf("%d - %s", counter, agent.getName());
			counter++;
		}

		do {
			System.out.print("> ");
			option = sc.nextInt();
		} while (option < 0 || option > allAgents.size());

		return allAgents.get(option - 1);
	}

	private Property selectProperty() {
		int option = 0;
		int counter = 1;

		List<Property> allProperties = propertyRepository.getAllProperties();

		for(Property property : allProperties) {
			System.out.printf("%d - %s", counter, property.getName());
			counter++;
		}

		do {
			System.out.print("> ");
			option = sc.nextInt();
		} while (option < 0 || option > allProperties.size());

		return allProperties.get(option - 1);
	}
}
