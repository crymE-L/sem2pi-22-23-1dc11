package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthController;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;
import pt.ipp.isep.dei.esoft.project.controllers.PropertyController;
import pt.ipp.isep.dei.esoft.project.controllers.SaleAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
import java.util.Scanner;

public class AgentsSaleAnnouncementsUI implements Runnable{
	Scanner sc = new Scanner(System.in);
	PersonRepository personRepository = Repositories.getInstance().getUsersRepository();
	EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

	@Override
	public void run() {
		AgentsUI agentsUI = new AgentsUI();

		int option;

		do {
			System.out.println("### Sale announcements menu ###\n");
			System.out.println("1 - Create sale announcement");
			System.out.println("2 - List sale announcements");
			System.out.println("0 - Exit");

			System.out.print("> ");
			option = sc.nextInt();
			sc.nextLine();

			switch(option) {
				case 1:
					this.createSaleAnnouncement();
					break;
				case 2:
					this.listSaleAnnouncements();
					break;
				case 0:
					agentsUI.run();
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		} while(option != 0);
	}

	private void createSaleAnnouncement() {
		SaleAnnouncementController controller = new SaleAnnouncementController();
		ApplicationSession session = Repositories.getInstance().getSession();

		Employee agent = (Employee) session.getCurrentUser();

		System.out.println("Please introduce the owner e-mail: ");
		String email = sc.nextLine();

		Person user = personRepository.getUserByEmail(email);

		if(user == null) {
			System.out.println("The email introduced does not exist. Please continue the user creation process.");
			user = this.createUser(email);
		}

		Property property = this.createProperty(user);

		float commission;

		do {
			System.out.println("Property's commission: ");
			commission = sc.nextFloat();

			if(commission <= 0) {
				System.out.println("Invalid commission.");
			}
		} while(commission <= 0);

		try {
			controller.create(user, null, agent, property.getPrice(), commission, property);
		} catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	private Person createUser(String email) {
		AuthController authController = new AuthController();
		Person person = null;

		do {
			System.out.println("Owner's name: ");
			String name = sc.nextLine();

			System.out.println("Owner's phone number: ");
			String phoneNumber = sc.nextLine();

			try {
				person = authController.register(name, email, phoneNumber);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		} while(person == null);

		return person;
	}

	private Property createProperty(Person owner) {
		PropertyController controller = new PropertyController();
		Property property = null;

		do {
			String name = readValidString("Property's name: ");

			String address = readValidString("Property's address: ");

			String cityName = readValidString("Property city: ");
			City city = new City(cityName);

			String districtName = readValidString("Property district: ");
			District district = new District(districtName);

			String stateName = readValidString("Property state: ");
			State state = new State(stateName);

			String businessTypeString;
			Property.BusinessType businessType;

			do {
				businessTypeString = readValidString("Business type (buy / rent): ").toUpperCase();

				if (!businessTypeString.equals("BUY") && !businessTypeString.equals("RENT")) {
					System.out.println("Invalid business type.");
				}
			} while(!businessTypeString.equals("BUY") && !businessTypeString.equals("RENT"));

			if (businessTypeString.equals("RENT")) {
				businessType = Property.BusinessType.RENT;
			} else {
				businessType = Property.BusinessType.BUY;
			}

			int area;

			do {
				System.out.println("Property's area: ");
				area = sc.nextInt();

				if(area <= 0) {
					System.out.println("Invalid area.");
				}
			} while(area <= 0);

			float distanceFromCenter;

			do {
				System.out.println("Property's distance from center: ");
				distanceFromCenter = sc.nextFloat();

				if(distanceFromCenter <= 0) {
					System.out.println("Invalid distance from center.");
				}
			} while(distanceFromCenter <= 0);

			float price;

			do {
				System.out.println("Property's price: ");
				price = sc.nextFloat();

				if(price <= 0) {
					System.out.println("Invalid price.");
				}
			} while(price <= 0);

			try {
				property = controller.createPropertyAndPutInRepository(name, address, area, distanceFromCenter, price, city, district, state, owner, businessType, new ArrayList<String>());
			} catch (DataExistsException | Exception exception) {
				System.out.println(exception.getMessage());
			}
		} while (property == null);

		return property;
	}

	private String readValidString(String message) {
		String data;

		do {
			System.out.println(message);
			data = sc.nextLine();

			if(Helpers.isEmpty(data)) {
				System.out.println("Invalid string.");
			}
		} while(Helpers.isEmpty(data));

		return data;
	}

	private void listSaleAnnouncements() {
		ApplicationSession session = Repositories.getInstance().getSession();
		Employee agent = (Employee) session.getCurrentUser();

		AnnouncementRequestRepository repository = Repositories.getInstance().getRequestsRepository();

		for (TransactionRequest transaction : repository.getAnnouncementsByAgent(agent)) {
			System.out.println("Price: " + transaction.getProperty().getName());
		}
	}
}
