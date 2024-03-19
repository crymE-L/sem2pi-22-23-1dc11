package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controllers.DisplayListController;
import pt.ipp.isep.dei.esoft.project.domain.AnnouncementRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.util.List;
import java.util.Scanner;

public class DisplayListUI implements Runnable {
    private AnnouncementRequestRepository requestListRepository;
    private PropertyRepository propertyRepository;
    private DisplayListController controller;
    private Scanner scanner;


    public DisplayListUI() {

        controller = new DisplayListController(requestListRepository, propertyRepository);
        this.controller = controller;
        scanner = new Scanner(System.in);
        this.requestListRepository = requestListRepository;
        this.propertyRepository = propertyRepository;
}

    @Override
    public void run() {
            // Agent requests personal transaction request list
            List<AnnouncementRequest> requestList = controller.getAnnouncementRequestList();
            controller.displayRequestList(requestList);

            // Prompt the agent to select an operation
            int operation = promptOperationSelection();

            // Process the selected operation
            switch (operation) {
                case 1:
                    // Agent selects an announcement request
                    AnnouncementRequest selectedRequest = promptRequestSelection(requestList);

                    // Prompt the agent to accept or decline the request
                    boolean accept = promptAcceptanceSelection();

                    // Process the agent's choice
                    if (accept) {
                        controller.removeFromList(selectedRequest);
                        controller.addAnnouncementRequestToPropertyRepository(selectedRequest);
                    } else {
                        controller.removeFromList(selectedRequest);
                    }
                    break;
                case 2:
                    // Agent selects another operation (if applicable)
                    // Handle the other operation here
                    break;
                default:
                    // Invalid operation
                    System.out.printf("Invalid operation selected.");
                    break;
            }

    }

    private int promptOperationSelection() {
        System.out.println("Select an operation:");
        System.out.println("1. Accept or decline a request");
        System.out.println("2. Other operation"); // Add more options if needed
        System.out.print("Enter the operation number: ");
        return scanner.nextInt();
    }

    private AnnouncementRequest promptRequestSelection(List<AnnouncementRequest> requestList) {
        System.out.print("Select a request by entering its index: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < requestList.size()) {
            return requestList.get(index);
        }
        return null;
    }

    private boolean promptAcceptanceSelection() {
        System.out.println("Accept or decline the request:");
        System.out.println("1. Accept");
        System.out.println("2. Decline");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice == 1;
    }
}
