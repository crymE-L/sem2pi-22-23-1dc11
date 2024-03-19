package pt.ipp.isep.dei.esoft.project.ui.console.authorization;

import java.util.Scanner;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthController;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.MainUI;

public class AuthUI implements Runnable {
	Scanner sc = new Scanner(System.in);

	private Repositories repositories = new Repositories();

	private final AuthController authController = new AuthController();
	private final ApplicationSession session = repositories.getSession();

	@Override
	public void run() {
		int option;

		MainUI mainUI = new MainUI();

		do {
			System.out.println("### Authentication ###\n");
			System.out.println("1 - Login");
			System.out.println("2 - Register");
			System.out.println("0 - Exit");

			System.out.print("> ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
				case 1:
					this.initiateLogin();
					break;
				case 2:
					this.initiateRegister();
					break;
				case 0:
					mainUI.run();
					break;
			}
		} while (option != 0);
	}

	public void initiateLogin() {
		System.out.println("### Login ###\n");

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Password: ");
		String password = sc.nextLine();

		try {
			authController.login(email.trim(), password.trim());
		} catch(IllegalArgumentException exception) {
			System.out.println("Invalid email or password provided.");
		}
	}

	public void initiateRegister() {
		System.out.println("### Register ###\n");

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Phone Number: ");
		String phoneNumber = sc.nextLine();

		Person user = authController.register(name.trim(), email.trim(), phoneNumber.trim());
		authController.login(user.getEmail(), user.getPassword());
	}

}
