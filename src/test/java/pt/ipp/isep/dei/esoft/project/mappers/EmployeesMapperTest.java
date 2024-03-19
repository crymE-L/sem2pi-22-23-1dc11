package pt.ipp.isep.dei.esoft.project.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.EmployeeDto;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeesMapperTest {
    private EmployeeRepository employeeRepository;
    private EmployeesMapper employeesMapper;


    @Test
    public void testToDto() {
        employeeRepository = new EmployeeRepository();
        employeesMapper = new EmployeesMapper();
        Role role = new Role("ADMIN", 4);
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Employee employee = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role, "1234567890", 12345678, 123456789, "123 Main St",  agency);

        EmployeeDto employeeDto = employeesMapper.toDto(employee);

        Assertions.assertEquals("John Doe", employeeDto.getName());
        Assertions.assertEquals(role, employeeDto.getRole());
        Assertions.assertEquals(agency, employeeDto.getAgency());
    }

    @Test
    public void testToDtoList() {
        employeeRepository = new EmployeeRepository();
        employeesMapper = new EmployeesMapper();
        List<Employee> employees = new ArrayList<>();
        Role role1 = new Role("ADMIN", 4);
        Agency agency1 =  new Agency("Agency 1", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Employee employee1 = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role1, "1234567890", 12345678, 123456789, "123 Main St", agency1);
        Role role2 = new Role("MANAGER", 4);
        Agency agency2 = new Agency("Agency 2", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Employee employee2 = new Employee("Diogo", "diogo@gmail.com", "AAAbcde12", role2, "1234567890", 12345678, 123456789, "123 Main St", agency2);
        employees.add(employee1);
        employees.add(employee2);
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        List<EmployeeDto> employeeDtos = employeesMapper.toDto(employeeRepository);

        Assertions.assertEquals(2, employeeDtos.size());
        EmployeeDto employeeDto1 = employeeDtos.get(0);
        Assertions.assertEquals("John Doe", employeeDto1.getName());
        Assertions.assertEquals(role1, employeeDto1.getRole());
        Assertions.assertEquals(agency1, employeeDto1.getAgency());
        EmployeeDto employeeDto2 = employeeDtos.get(1);
        Assertions.assertEquals("Diogo", employeeDto2.getName());
        Assertions.assertEquals(role2, employeeDto2.getRole());
        Assertions.assertEquals(agency2, employeeDto2.getAgency());
    }
}
