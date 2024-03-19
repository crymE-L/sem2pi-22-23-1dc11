package pt.ipp.isep.dei.esoft.project.mappers;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.EmployeeDto;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for mapping Employee class
 * objects to employee DTO
 *
 * @author Diogo Martins (1221223)
 */
public class EmployeesMapper {
    /**
     * This method creates and returns an EmployeeDto object
     * by extracting the name, role, and agency information
     * from the provided Employee object.
     *
     * @param employee
     * @return EmployeeDto
     */
    public static EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getName(), employee.getRoles().get(0), employee.getAgency());
    }

    /**
     * This method retrieves a list of Employee objects
     * from the EmployeeRepository, iterates over each
     * Employee, converts them to EmployeeDto objects using
     * the toDto method, and returns a list
     * of the resulting EmployeeDto objects.
     *
     * @param employeeRepository
     * @return List<EmployeeDto>
     */
    public List<EmployeeDto> toDto(EmployeeRepository employeeRepository) {
        List<Employee> employees = employeeRepository.getAllEmployee();
        List<EmployeeDto> employeesDto = new ArrayList<>();

        for (Employee employee : employees) {
            employeesDto.add(this.toDto(employee));
        }

        return employeesDto;
    }
}
