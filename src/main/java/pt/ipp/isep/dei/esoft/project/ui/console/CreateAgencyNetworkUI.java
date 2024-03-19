package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controllers.AgencyNetworkController;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;
import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;
import java.util.Scanner;

public class CreateAgencyNetworkUI implements Runnable {
    Scanner sc = new Scanner(System.in);

    private final AgencyNetworkController agencyNetworkController = new AgencyNetworkController();
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    private AgencyNetworkController getAgencyNetworkController(){
        return agencyNetworkController;
    }

    public void run() {
        System.out.println("### Create Agency Network###");

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
        name = requestName();
        phoneNumber = requestsPhoneNumber();
        address = requestsAddress();
        email = requestsEmail();
    }

    private String requestName(){
        System.out.println("Agency name:");
        return sc.nextLine();
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
        String phoneNumber;

        do {
            System.out.println("Agency phone number:");
            phoneNumber = sc.nextLine();
            if (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty()) {
                System.out.println("\nInvalid phone number.\n");
            }
        } while (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty());

        return phoneNumber;
    }


    private void submitsData() throws DataExistsException, Exception {
        AgencyNetworkRepository agencyNetwork = getAgencyNetworkController().createAgencyNetworkAndPutInRepository(name, address, email, phoneNumber);

        if(agencyNetwork.getAgencyNetworkByEmail(email) != null){
            System.out.println("The agency network " + name + " in the location " + address + " was created.");
        }
    }

}
