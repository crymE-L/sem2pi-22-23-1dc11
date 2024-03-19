package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class AdminsAgencyUI implements Runnable {
	Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		CreateAgencyUI createAgencyUI = new CreateAgencyUI();
		AdminsUI adminsUI = new AdminsUI();

		System.out.println("### Agencies menu ###\n");
		System.out.println("1 - Search agency");
		System.out.println("2 - Create agency");
		System.out.println("3 - Edit agency");
		System.out.println("4 - Delete agency");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 2:
				createAgencyUI.run();
				break;
			case 0:
				adminsUI.run();
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
	}
}
