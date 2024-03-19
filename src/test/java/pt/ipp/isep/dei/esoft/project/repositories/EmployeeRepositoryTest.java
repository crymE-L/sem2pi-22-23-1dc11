package pt.ipp.isep.dei.esoft.project.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository = new EmployeeRepository();
    @Test
    void addEmployee() {
         Role role1 = new Role("ADMIN", 4);
         Agency agency1 = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "9876543219", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role1);

         Employee employee1 = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "123 Main St", agency1);

         Employee employee2 = new Employee("Farusco", "farusco@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "69 Cima St", agency1);


         employeeRepository.addEmployee(employee1);
         employeeRepository.addEmployee(employee2);

        Assertions.assertEquals(2,employeeRepository.getAllEmployee().size());
            Assertions.assertTrue(employeeRepository.getAllEmployee().contains(employee1));
        Assertions.assertTrue(employeeRepository.getAllEmployee().contains(employee2));
    }

    @Test
    void removeEmployee() {
        Role role1 = new Role("ADMIN", 4);
        Agency agency1 = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "9876543219", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role1);

        Employee employee1 = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "123 Main St", agency1);

        Employee employee2 = new Employee("Farusco", "farusco@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "69 Cima St", agency1);

		employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        employeeRepository.removeEmployee(employee1);


        Assertions.assertEquals(1,employeeRepository.getAllEmployee().size());
        Assertions.assertFalse(employeeRepository.getAllEmployee().contains(employee1));
        Assertions.assertTrue(employeeRepository.getAllEmployee().contains(employee2));
    }

    @Test
    void getEmployeeByEmail() {
        Role role1 = new Role("ADMIN", 4);
        Agency agency1 = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "9876543219", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(role1);

        Employee employee1 = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "123 Main St", agency1);

        Employee employee2 = new Employee("Farusco", "farusco@example.com", "AAAbcde12", roles, "9876543219",
                12345678, 123456789, "69 Cima St", agency1);


		employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        Employee employee = employeeRepository.getEmployeeByEmail("farusco@example.com");

        Assertions.assertEquals(employee2,employee);

        employee = employeeRepository.getEmployeeByEmail("malaquias@example.com");

        Assertions.assertNull(employee);
    }
}
