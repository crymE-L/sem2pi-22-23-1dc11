package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthController;
import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;
import pt.ipp.isep.dei.esoft.project.controllers.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable{
    Scanner sc = new Scanner(System.in);
    private Repositories repositories = new Repositories();
    private RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
    private AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
    private List<Agency> agencies = agencyRepository.getAllAgencies();
    private List<Role> roles = roleRepository.getAllRoles();

    private final RegisterEmployeeController employeeController = new RegisterEmployeeController();

    private AuthController authController = new AuthController();

    private String name;
    private String email;
    private String password = authController.passwordGenerator(7);
    private Role role;
    private int passport;
    private int vat;
    private String address;
    private String phone;
    private Agency agency;

	AdminsUI adminsUI = new AdminsUI();

    private RegisterEmployeeController getEmployeeController(){
        return employeeController;
    }


    @Override
    public void run() {
        System.out.println("### Register a Employee ###");

        requestsData();

        try {
            submitsData();
			adminsUI.run();
        } catch (DataExistsException | Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String requestName () {
        System.out.println("Name:");
        return sc.nextLine();
    }

    private String requestEmail () {
        String email = "";
        do {
            System.out.println("Email:");
            email = sc.nextLine();
            if (email.isEmpty() || !Helpers.isValidEmail(email)) {
                System.out.println("\nInvalid email.\n");
            }
        } while (email.isEmpty() || !Helpers.isValidEmail(email));

        return email;
    }

    private Role requestRole () {
		System.out.println("Roles:");
		RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();


		int pos = 1;
		for (Role role : roleRepository.getAllRoles()) {
			System.out.printf("%d - %s\n", pos, role.getName());
			pos++;
		}

		int index;

		do {

			System.out.println("Chose one:");
			System.out.print(">");
			index = sc.nextInt();


			if (index <= 0 || index > roles.size())
				System.out.println("Invalid option.");

			System.out.println();
		} while (index <= 0 || index > roles.size());

		sc.nextLine();

        return roleRepository.getAllRoles().get(index-1);
    }

    private int requestPassport () {
        int passport = 0;

        do {
            System.out.println("Passport number:");
            passport = sc.nextInt();
            if (!Helpers.isValidPassport(passport)) {
                System.out.println("\nInvalid passport number.\n");
            }
        } while (!Helpers.isValidPassport(passport));

        return passport;
    }

    private int requestVat () {
        int vat;

        do {
            System.out.println("Vat:");

			vat = sc.nextInt();
			sc.nextLine();

            if (!Helpers.isValidVat(vat) || Integer.toString(vat).isEmpty()) {
                System.out.println("\nInvalid vat.\n");
            }
        } while (!Helpers.isValidVat(vat) || Integer.toString(vat).isEmpty());

        return vat;
    }

    private String requestAddress () {
        String address = "";

        do {
            System.out.println("Address:");
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.out.println("\nInvalid address.\n");
            }
        } while (address.isEmpty());

        return address;
    }

    private String requestPhone () {
        String phoneNumber = "";

        do {
            System.out.println("Phone number:");
            phoneNumber = sc.nextLine();
            if (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty()) {
                System.out.println("\nInvalid phone number.\n");
            }
        } while (!Helpers.isValidPhoneNumber(phoneNumber) || phoneNumber.isEmpty());

        return phoneNumber;
    }

    private Agency requestAgency () {
        System.out.println("Agency:");
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();

        int pos = 1;
        for (Agency agency: agencyRepository.getAllAgencies()) {
            System.out.printf("%d - %s", pos,agency.getName());
            System.out.println();
            pos++;
        }

        int index;

        do {

            System.out.println("Select an agency:");
            System.out.print(">");
            index = sc.nextInt();


            if(index <= 0 || index > agencies.size())
                System.out.println("Invalid option.");
            System.out.println();
        } while(index <= 0 || index > agencies.size());

        sc.nextLine();

        return agencyRepository.getAllAgencies().get(index - 1);
    }




    private void requestsData() {
        name = requestName();
        email = requestEmail();
        role = requestRole();
        phone = requestPhone();
        passport = requestPassport();
        vat = requestVat();
        address = requestAddress();
        agency = requestAgency();
    }

    private void submitsData() throws DataExistsException, Exception {
		EmployeeRepository employee = Repositories.getInstance().getEmployeeRepository();

        if(employee.getEmployeeByEmail(email) != null){
            if (this.authController.existsUser(email)) {
				ArrayList<Role> roles = new ArrayList<>();
				roles.add(role);

                employee = getEmployeeController().createEmployee(name, email, password, roles, passport, vat, address, phone, agency);
                System.out.println("The employee " + name + "was registered successfully");
            }
		}


        sc.nextLine();
        adminsUI.run();
    }
}
