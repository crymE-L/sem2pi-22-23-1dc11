package pt.ipp.isep.dei.esoft.project.ui.console;

import java.util.Scanner;

public class DevTeamUI implements Runnable{
	MainUI mainUI = new MainUI();
	Scanner sc = new Scanner(System.in);

    public DevTeamUI() {

    }

    public void run() {
        System.out.println("\n");
        System.out.print("Development Team:\n");
        System.out.print("\t Afonso Silva - 1221179@isep.ipp.pt \n");
        System.out.print("\t Diogo Martins - 1221223@isep.ipp.pt \n");
        System.out.print("\t Gonçalo Silva - 1220607@isep.ipp.pt \n");
        System.out.print("\t Gustavo Lima - 1221349@isep.ipp.pt \n");
        System.out.print("\t Miguel Ferreira - 1210701@isep.ipp.pt \n");
        System.out.println("\n");

		sc.nextLine();

		mainUI.run();
    }
}
