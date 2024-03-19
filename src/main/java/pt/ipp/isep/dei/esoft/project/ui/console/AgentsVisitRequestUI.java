package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class AgentsVisitRequestUI implements Runnable {
	Scanner sc = new Scanner(System.in);

	AgentsUI agentsUI = new AgentsUI();

	@Override
	public void run() {
		System.out.println("### Visit requests menu ###\n");
		System.out.println("1 - List visit requests");
		System.out.println("2 - Edit visit request");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 0:
				agentsUI.run();
				break;
		}
	}
}
