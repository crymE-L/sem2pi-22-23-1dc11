package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class CheckPropertyUI implements Runnable {
	Scanner sc = new Scanner(System.in);
	MainUI mainUI = new MainUI();

	@Override
	public void run() {
		System.out.println("### Check properties ###\n");
		System.out.println("1 - List all properties");
		System.out.println("2 - Filter properties");
		System.out.println("0 - Exit");

		System.out.print("> ");
		int option = sc.nextInt();
		sc.nextLine();

		switch(option) {
			case 0:
				mainUI.run();
				break;
		}
	}
}
