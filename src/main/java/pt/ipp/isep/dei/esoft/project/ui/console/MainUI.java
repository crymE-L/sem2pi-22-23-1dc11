package pt.ipp.isep.dei.esoft.project.ui.console;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthUI;

public class MainUI implements Runnable {
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);

		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		AuthUI authUI = new AuthUI();
		DevTeamUI devTeamUI = new DevTeamUI();
		AdminsUI adminsUI = new AdminsUI();
		AgentsUI agentsUI = new AgentsUI();
		PropertyUI propertyUI = new PropertyUI();
		PurchaseOrdersUI ordersUI = new PurchaseOrdersUI();
		DisplayPropertiesUI displayPropertiesUI = new DisplayPropertiesUI();

		ApplicationSession session = Repositories.getInstance().getSession();

		System.out.printf("== %s system v%s ==\n", properties.getProperty("Company.Designation"), properties.getProperty("System.Version"));

		try {
			Person user = (Person) session.getCurrentUser();

			System.out.printf("Welcome, %s \n", user.getName());
		} catch(Exception exception) {
			System.out.println("");
		}

		System.out.println("\n1 - Display properties");
		System.out.println("2 - Manage property");
		System.out.println("3 - Authentication");
		System.out.println("4 - Agent menu");
		System.out.println("5 - Network manager menu");
		System.out.println("6 - Admin menu");
		System.out.println("7 - Dev team");

		System.out.print("> ");
		int option = sc.nextInt();

		switch (option) {
			case 1:
				displayPropertiesUI.run();
				break;
			case 2:
				propertyUI.run();
				break;
			case 3:
				authUI.run();
				break;
			case 4:
				agentsUI.run();
				break;
			case 5:
				break;
			case 6:
				adminsUI.run();
				break;
			case 7:
				devTeamUI.run();
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
	}
}
