package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class NetworkManagersUI implements Runnable {
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        DisplayEmployeesUI displayEmployeesUI = new DisplayEmployeesUI();

        MainUI mainUI = new MainUI();

        System.out.println("### Network Managers menu ###\n");
        System.out.println("1 - Display Employees");
        System.out.println("0 - Exit");

        System.out.print("> ");
        int option = sc.nextInt();
        sc.nextLine();

        switch(option) {
            case 1:
                displayEmployeesUI.run();
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
