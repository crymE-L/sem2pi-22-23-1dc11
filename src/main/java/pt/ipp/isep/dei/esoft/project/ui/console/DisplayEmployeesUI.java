package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controllers.DisplayEmployeesController;

import java.util.Scanner;

public class DisplayEmployeesUI implements Runnable{
    Scanner sc = new Scanner(System.in);

    private final DisplayEmployeesController displayEmployeesController = new DisplayEmployeesController();

    public DisplayEmployeesUI() {}

    private DisplayEmployeesController getDisplayEmployeesController() {
        return displayEmployeesController;
    }

    public void run() {
        NetworkManagersUI networkManagersUI = new NetworkManagersUI();
        System.out.println("### Display Employees ###");

        getDisplayEmployeesController().displayEmployeesToString();

        System.out.println("1 - Display all the employees again");
        System.out.println("0 - Exit");
        System.out.print(">");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                getDisplayEmployeesController().displayEmployeesToString();
                break;
            case 0:
                networkManagersUI.run();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

    }

}
