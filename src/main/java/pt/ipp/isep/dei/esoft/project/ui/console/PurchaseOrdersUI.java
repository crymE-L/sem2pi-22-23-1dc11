package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.TransactionRequest;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;

import java.util.List;
import java.util.Scanner;

public class PurchaseOrdersUI implements Runnable{
    Scanner sc = new Scanner(System.in);
    Repositories repositories = new Repositories();
    PropertyRepository propertyRepository = repositories.getPropertyRepository();
    AnnouncementRequestRepository announcementRequestRepository = repositories.getRequestsRepository();
    MainUI mainUI = new MainUI();
    @Override
    public void run() {
        System.out.println("### Purchase Orders ###\n");
        System.out.println("1 - Display Purchase Orders");
        System.out.println("0 - Exit");

        System.out.print("> ");
        int option = sc.nextInt();
        sc.nextLine();

        switch(option) {
            case 1:
                try {
                    this.displayAllPurchaseOrders();
                } catch (RuntimeException exception) {
                    System.out.println(exception.getMessage());
                    break;
                }
                break;

            case 0:
                mainUI.run();
                break;
        }

    }
    private void displayAllPurchaseOrders() {
        List<TransactionRequest> transactionRequests = announcementRequestRepository.getAllRequests();
        List<Property> properties = propertyRepository.getAllProperties();

        for (Property property : properties) {
            if (announcementRequestRepository.getPurchaseOrdersByProperty(property) == null) {
                System.out.println(property.toString() + " Purchase Orders");
                System.out.println("There are no purchase orders registered.");

            } else {
                System.out.println(property.toString() + " Purchase Orders");
                System.out.println();
                System.out.println(announcementRequestRepository.getPurchaseOrdersByProperty(property));
            }
        }

        System.out.println();
        System.out.println("Type the purchase order ID to select");
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
