package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class AgentsUI implements Runnable {
	Scanner sc = new Scanner(System.in);

	@Override
	public void run() {
		AgentsSaleAnnouncementsUI agentsSaleAnnouncementsUI = new AgentsSaleAnnouncementsUI();
		AgentsVisitRequestUI agentsVisitRequestUI = new AgentsVisitRequestUI();
		DisplayPurchaseOrdersUI displayPurchaseOrdersUI = new DisplayPurchaseOrdersUI();

		MainUI mainUI = new MainUI();

		System.out.println("### Agents menu ###\n");
		System.out.println("1 - Sale announcements");
		System.out.println("2 - Purchase Orders");
		System.out.println("3 - Visit requests");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 1:
				agentsSaleAnnouncementsUI.run();
				break;
			case 2:
				displayPurchaseOrdersUI.run();
				break;
			case 3:
				agentsVisitRequestUI.run();
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
