package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * This class exists to act as a controller that holds all
 * the logical operations needed for all features that
 * may relate to the user story 3
 *
 * @author Gonçalo Silva (1220607)
 */
public class RegisterEmployeeController {

    private EmployeeRepository employeeRepository = null;
    private AgencyRepository agencyRepository = null;
    private RoleRepository roleRepository = null;

    /**
     * This constructor get the method employee repository.
     */
    public RegisterEmployeeController() {
        getEmployeeRepository();
    }

    /**
     * This constructor takes an employee repository object as a parameter.
     *
     * @param employeeRepository
     */
    public RegisterEmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * This method initializes the employeeRepository
     * instance variable if it is null.
     * If the employeeRepository is already initialized, it returns
     * the existing instance.
     *
     * @return employeeRepository
     */
    private EmployeeRepository getEmployeeRepository(){
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            employeeRepository = repositories.getEmployeeRepository();
        }

        return employeeRepository;
    }

    /**
     * This constructor get the method agency repository.
     */
    private AgencyRepository getAgencyRepository(){
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    /**
     * This constructor get the method role repository.
     */
    private RoleRepository getRoleRepository(){
        if (roleRepository == null) {
            Repositories repositories = Repositories.getInstance();

            roleRepository = repositories.getRoleRepository();
        }

        return roleRepository;
    }

    /**
     * This method create a new employee object and add it to the
     * employee repository.
     * If an employee with the same email already exists
     * in the repository, it throws a DataExistsException.
     * Otherwise, it adds the new employee to the repository.
     *
     * @param name
     * @param email
     * @param password
     * @param roles
     * @param passport
     * @param vat
     * @param address
     * @param phone
     * @param agency
     * @return
     * @throws Exception
     * @throws DataExistsException
     */
    public EmployeeRepository createEmployee(String name, String email, String password, ArrayList<Role> roles, int passport, int vat, String address, String phone, Agency agency) {
		Employee newEmployee = new Employee(name, email, password, roles, phone, passport, vat, address, agency);

        employeeRepository.addEmployee(newEmployee);

        return employeeRepository;
    }
}
