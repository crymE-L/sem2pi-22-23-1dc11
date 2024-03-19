package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.PersonRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MessageUI implements Runnable {
    private Scanner sc = new Scanner(System.in);
    private Repositories repositories = new Repositories();
    private PropertyRepository propertyRepository = repositories.getPropertyRepository();
    private PersonRepository personRepository = repositories.getUsersRepository();
    private AuthController authController = new AuthController();

    private Employee agent = null;

    private boolean willBuy = false;

    @Override
    public void run() {
        System.out.println("### Schedule Visit ###\n");

        System.out.print("Your name: ");
        String clientName = sc.nextLine();

        System.out.print("Your phone number: ");
        String phoneNumber = sc.nextLine();

        Person client = personRepository.getUserByName(clientName);

        if (client == null) {
            System.out.println("You are not registered in our system. Please register first.");
            client = registerClient(clientName, phoneNumber);
        }

        System.out.println("Available Properties:");
        propertyRepository.getAllProperties().forEach(System.out::println);

        System.out.print("Select a property ID for the visit: ");
        int propertyId = sc.nextInt();

        Property property = propertyRepository.getPropertyById(propertyId);

        if (property == null) {
            System.out.println("Invalid property ID. Visit scheduling failed.");
            return;
        }

        System.out.print("Visit date (YYYY-MM-DD): ");
        LocalDate visitDate = LocalDate.parse(sc.nextLine());

        System.out.print("Visit start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.print("Visit end time (HH:MM): ");
        LocalTime endTime = LocalTime.parse(sc.nextLine());

        scheduleVisit(client, agent, property, visitDate, startTime, endTime, willBuy);

        System.out.println("Visit scheduled successfully!");
    }

    private Person registerClient(String clientName, String phoneNumber) {
        System.out.println("Registering as a new client...");

        System.out.print("Your email address: ");
        String email = sc.nextLine();

        Person client = authController.register(clientName, email, phoneNumber);
        client.setPhoneNumber(phoneNumber);

        personRepository.addUser(client);

        System.out.println("Registration successful!");
        return client;
    }

    private void scheduleVisit(Person client, Employee agent, Property property, LocalDate visitDate, LocalTime startTime, LocalTime endTime, boolean willBuy) {
        // Perform the scheduling logic here
        // You can use the provided parameters to store the visit details, create a Visit object, etc.
        // Example code snippet: Creating a Visit object and adding it to the property
        VisitRequest visitRequest = new VisitRequest(client, agent, property, visitDate, startTime, endTime, willBuy);
        property.addVisitRequest(visitRequest);
    }
}
