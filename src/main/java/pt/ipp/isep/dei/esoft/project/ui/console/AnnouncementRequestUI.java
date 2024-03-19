package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Scanner;

public class AnnouncementRequestUI {

    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private Scanner scanner;
    private Person Owner() {
        String ownerName = scanner.nextLine();
        return new Person(ownerName, Owner().getEmail(), Owner().getPassword(), new Role("Owner", 3));
    }

    public AnnouncementRequestUI() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        AgentsUI agentsUI = new AgentsUI();

        System.out.println("Welcome to the Announcement Request UI!");
        System.out.println("Please select an option:");
        System.out.println("1. View all employees");
        System.out.println("0. Go back to the previous menu");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                // Display all employees
                for (Employee employee : employeeRepository.getAllEmployee()) {
                    System.out.println(employee);
                    Employee agent = selectAgent();
                    String agentEmail = agent.getEmail();
                }
                break;
            case 0:
                // Go back to the previous menu
                agentsUI.run();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }


    public AnnouncementRequest createAnnouncementRequest() {
        System.out.println("Creating Announcement Request");
        System.out.println("Please enter the following information:");

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Area: ");
        int area = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Distance from Center: ");
        float distanceFromCenter = scanner.nextFloat();
        scanner.nextLine(); // Consume newline character

        System.out.print("Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline character

        System.out.print("City: ");
        String cityName = scanner.nextLine();
        City city = new City(cityName);

        System.out.print("District: ");
        String districtName = scanner.nextLine();
        District district = new District(districtName);

        System.out.print("State: ");
        String stateName = scanner.nextLine();
        State state = new State(stateName);


        System.out.print("Number of Bedrooms: ");
        int bedrooms = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Number of Bathrooms: ");
        int bathrooms = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Number of Parking Spaces: ");
        int parkingSpaces = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Has Central Heating (true/false): ");
        boolean hasCentralHeating = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Has Air Conditioning (true/false): ");
        boolean hasAirConditioning = scanner.nextBoolean();
        scanner.nextLine();


        System.out.print("Business Type (BUY/RENT): ");
        String businessType = scanner.nextLine();

        System.out.print("Contract Duration: ");
        int contractDuration = scanner.nextInt();
        scanner.nextLine();

        AnnouncementRequest.BusinessType businessTypeEnum;
        if (businessType.equalsIgnoreCase("BUY")) {
            businessTypeEnum = AnnouncementRequest.BusinessType.BUY;
        } else if (businessType.equalsIgnoreCase("RENT")) {
            businessTypeEnum = AnnouncementRequest.BusinessType.RENT;
        } else {
            throw new IllegalArgumentException("Invalid business type: " + businessType);
        }

        Person owner;
        return new AnnouncementRequest(address, area, distanceFromCenter, price, city, district, state,
                new Person(Owner().getName(), Owner().getEmail(), Owner().getPassword(), new Role("Owner", 3)), bedrooms, bathrooms, parkingSpaces, hasCentralHeating, hasAirConditioning,
                selectAgent(), businessTypeEnum, contractDuration);
    }
    private Employee selectAgent() {
        System.out.print("Enter the email of the selected agent: ");
        String agentEmail = scanner.nextLine();
        Employee agent = employeeRepository.getEmployeeByEmail(agentEmail);
        return agent;
    }

}

