package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controllers.CreateAgencyController;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;
import java.util.List;
import java.util.Scanner;

public class CreateAgencyUI implements Runnable {
    Scanner sc = new Scanner(System.in);
    CreateAgencyNetworkUI agencyNetworkUI = new CreateAgencyNetworkUI();
    AdminsAgencyUI adminsAgencyUI = new AdminsAgencyUI();
    private final CreateAgencyController agencyController = new CreateAgencyController();
    private String designation;
    private State state;
    private District district;
    private City city;
    private String address;
    private String email;
    private String phoneNumber;
    private int vat;
    private AgencyNetwork agencyNetwork;

    public CreateAgencyUI() {
    }

    private CreateAgencyController getAgencyController() {
        return agencyController;
    }

    private AgencyNetworkRepository getAgencyNetworkRepository() {
        Repositories repositories = new Repositories();
        AgencyNetworkRepository agencyNetworkRepository = repositories.getAgencyNetworkRepository();
        return agencyNetworkRepository;
    }

    public void run() {
        System.out.println("### Create Agency ###");

        requestsData();

        try {
            submitsData();
        } catch (DataExistsException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void requestsData() {
        agencyNetwork = requestAgencyNetwork();
        designation = requestDesignation();
        state = requestsState();
        district = requestsDistrict();
        city = requestsCity();
        address = requestsAddress();
        email = requestsEmail();
        phoneNumber = requestsPhoneNumber();
        vat = requestsVat();
    }

    private AgencyNetwork requestAgencyNetwork(){
        System.out.println("Choose the Agency Network where you want to create the new agency:\n");
        List<AgencyNetwork> agencyNetworks = getAgencyNetworkRepository().getAllAgenciesNetwork();

        if (agencyNetworks.isEmpty()) {
            System.out.println("There is no agency network available, if you want to create an agency you have to create an agency network. Do you want to move forward?\n");
            System.out.println("1- Yes\n2- No");
            System.out.print(">");
            int option = sc.nextInt();


            switch (option) {
                case 1:
                    agencyNetworkUI.run();
                    break;
                case 2:
                    adminsAgencyUI.run();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } else {
            int pos = 1;
            for (AgencyNetwork agencyNetwork : agencyNetworks) {
                System.out.printf("%d - %s\n", pos, agencyNetwork.getName());
                pos ++;
            }
            System.out.println("Choose one:\n");
            System.out.print(">");
            int index = sc.nextInt();
            return agencyNetworks.get(index-1);
        }

        return null;
    }

    private String requestDesignation(){
        System.out.println("Agency designation:");
        return sc.nextLine();
    }

    private State requestsState(){
        String state = "";

        do {
            System.out.println("Agency state:");
            state = sc.nextLine();
            if (state.isEmpty()) {
                System.out.println("\nInvalid state.\n");
            }
        } while (state.isEmpty());

        return new State(state);
    }

    private District requestsDistrict(){
        String district = "";
        do {
            System.out.println("Agency district:");
            district = sc.nextLine();
            if (district.isEmpty()){
                System.out.println("\nInvalid district\n");
            }
        } while (district.isEmpty());

        return new District(district);
    }

    private City requestsCity(){
        String city = "";

        do {
            System.out.println("Agency city:");
            city = sc.nextLine();
            if (city.isEmpty()) {
                System.out.println("\nInvalid city.\n");
            }
        } while (city.isEmpty());

        return new City(city);
    }

    private String requestsAddress(){
        String address = "";

        do {
            System.out.println("Agency address:");
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.out.println("\nInvalid address.\n");
            }
        } while (address.isEmpty());

        return address;
    }

    private String requestsEmail(){
        String email = "";
        do {
            System.out.println("Agency email:");
            email = sc.nextLine();
            if (email.isEmpty() || !Helpers.isValidEmail(email)) {
                System.out.println("\nInvalid email.\n");
            }
        } while (email.isEmpty() || !Helpers.isValidEmail(email));

        return email;
    }

    private String requestsPhoneNumber(){
        String phoneNumber = "";

        do {
            System.out.println("Agency phone number:");
            phoneNumber = sc.nextLine();
            if (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty()) {
                System.out.println("\nInvalid phone number.\n");
            }
        } while (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty());

        return phoneNumber;
    }

    private int requestsVat(){
        int vat;

        do {
            System.out.println("Agency vat:");
            vat = sc.nextInt();
            if (!Helpers.isValidVat(vat) || Integer.toString(vat).isEmpty()) {
                System.out.println("\nInvalid vat.\n");
            }
        } while (!Helpers.isValidVat(vat) || Integer.toString(vat).isEmpty());

        return vat;
    }

    private void submitsData() throws DataExistsException, Exception {
        AgencyRepository agency = getAgencyController().createAgencyAndPutInRepository(designation, state, district, city, email, phoneNumber, vat, address, agencyNetwork);
		AdminsUI adminsUI = new AdminsUI();

        if(agency.getAgencyByAddress(address) != null){
            System.out.println("The agency " + designation + " in the location " + address + " was created.");
        }

		sc.nextLine();

		adminsUI.run();
    }

}
