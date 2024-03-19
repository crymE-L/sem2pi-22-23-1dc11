package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.TransactionRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;
import java.util.Scanner;

public class DisplayPurchaseOrdersUI implements Runnable{
    Scanner sc = new Scanner(System.in);
    Repositories repositories = new Repositories();
    PropertyRepository propertyRepository = repositories.getPropertyRepository();
    AnnouncementRequestRepository announcementRequestRepository = repositories.getRequestsRepository();
    MainUI mainUI = new MainUI();
    AcceptPurchaseOrdersUI acceptPurchaseOrdersUI = new AcceptPurchaseOrdersUI();

    @Override
    public void run() {
        System.out.println("### Purchase Orders ###\n");
        System.out.println("1 - Select order");
        System.out.println("0 - Exit");

        System.out.print("> ");
        int option = sc.nextInt();
        sc.nextLine();

        switch(option) {
            case 1:
                acceptPurchaseOrdersUI.run();
                break;

            case 0:
                mainUI.run();
                break;
        }

    }

    private void displayAllPurchaseOrders() {
        List<TransactionRequest> transactionRequests = announcementRequestRepository.getAllRequests();

        if (transactionRequests.isEmpty()) {
            System.out.println("There are no purchase orders registered.");
            return;
        }

        System.out.println("### All Properties ###\n");
        for (TransactionRequest transactionRequest : transactionRequests) {
            System.out.println(transactionRequest);
        }
    }
}
