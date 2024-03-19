package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class AdminsUI implements Runnable {
	Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		AdminsAgencyUI adminsAgencyUI = new AdminsAgencyUI();
		AdminsEmployeeUI adminsEmployeeUI = new AdminsEmployeeUI();

		MainUI mainUI = new MainUI();

		System.out.println("### Administrators menu ###\n");
		System.out.println("1 - Agencies");
		System.out.println("2 - Employee");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				adminsAgencyUI.run();
				break;
			case 2:
				adminsEmployeeUI.run();
				break;
			case 0:
				mainUI.run();
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
	}
}
