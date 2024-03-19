package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;

/**
 *
 * @author Gonçalo Silva (1220607)
 */
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Adds an employee to the repository.
     *
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Removes an employee from the repository.
     *
     * @param employee
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Retrieves all agencies in the repository.
     *
     * @return List of agencies.
     */
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employees);
    }

    /**
     * Retrieves an employee by email.
     *
     * @param email
     * @return The employee with the given email, or null if not found.
     */
    public Employee getEmployeeByEmail(String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equals(email)) {
                return employee;
            }
        }
        return null;
    }

}
