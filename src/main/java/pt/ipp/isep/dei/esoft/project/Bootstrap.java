package pt.ipp.isep.dei.esoft.project;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class Bootstrap implements Runnable {

	EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
	PersonRepository personRepository = Repositories.getInstance().getUsersRepository();
	RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
	AgencyNetworkRepository agencyNetworkRepository = Repositories.getInstance().getAgencyNetworkRepository();
	AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
	PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();

	/**
	 * This class will be called in the beginning of every code execution
	 */
    public void run() {
		this.addRoles();
		this.addAgencyNetwork();
		this.addAgencies();
    	this.addEmployees();
		this.addUsers();
		this.addProperties();
    }

	private void addRoles() {
		roleRepository.addRole(new Role("System Admin",10));
		roleRepository.addRole(new Role("Network Agent",20));
		roleRepository.addRole(new Role("Agent",30));
		roleRepository.addRole(new Role("User",40));
	}

	private void addAgencyNetwork() {
		AgencyNetwork agencyNetwork = new AgencyNetwork("Super Agencies", "4 Privet Drive", "general@agencies.com", "+13 5386672");

		agencyNetworkRepository.addAgencyNetwork(agencyNetwork);
	}

	private void addAgencies() {
		AgencyNetwork agencyNetwork = agencyNetworkRepository.getAgencyNetworkByEmail("general@agencies.com");

		agencyRepository.addAgency(new Agency("Name", 123456788, "Close", "agency@email.com", "5386672751", agencyNetwork));
		agencyRepository.addAgency(new Agency("Name 2", 123456777, "Really close", "agency2@email.com", "5386672778", agencyNetwork));
	}

    private void addEmployees() {
		Role role = roleRepository.getRoleByName("Agent");
		Agency agency = agencyRepository.getAgencyByAddress("Close");

		ArrayList<Role> roles = new ArrayList<>();
		roles.add(role);

		Employee employee = new Employee("Joana Pato", "joana@isep.pt", "1234ABC", roles, "1234567899", 12345678, 123421231, "The street", agency);
		Employee employee2 = new Employee("Gonçalo Pombo", "gonca@isep.pt", "1234ABC", roles, "1234567799", 12345678, 123421232, "The street", agency);

		employeeRepository.addEmployee(employee);
		employeeRepository.addEmployee(employee2);
    }

	private void addUsers() {
		Role role = roleRepository.getRoleByName("User");
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(role);

		Person user = new Person("Afonso Silva", "afonso@isep.pt", "1234ABC", roles, "1234567992");
		Person user1 = new Person("Diogo Martins", "diogo@isep.pt", "1234ABC", roles, "1234567991");

		personRepository.addUser(user);
		personRepository.addUser(user1);
	}

	private void addProperties() {
		City city = new City("Starling City");
		District district = new District("Our district");
		State state = new State("Big important state");

		Person owner = personRepository.getUserByEmail("afonso@isep.pt");

		Property property = new Property("Dream house", "The address", 120, 10, 120.20f, city, district, state, owner, Property.BusinessType.BUY, new ArrayList<String>());
		Property mansion = new Property("Dream mansion", "The big address", 300, 5, 500f, city, district, state, owner, Property.BusinessType.RENT, new ArrayList<String>());

		propertyRepository.addProperty(property);
		propertyRepository.addProperty(mansion);
	}
}
