package pt.ipp.isep.dei.esoft.project.mappers.Dto;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Role;

/**
 * This class serves to create an employee.
 *
 * @author Diogo Martins (1221223)
 */
public class EmployeeDto extends PersonDto {
    /**
     * The employee's agency object
     */
    private Agency agency;

    /**
     * The constructor made specifically to create
     * the object Habitation. This constructor contains
     * all the parameters needed at once
     *
     * @param name
     * @param role
     * @param agency
     */
    public EmployeeDto(String name, Role role, Agency agency) {
        super(name, role);
        this.agency = agency;
    }

    /**
     * The getter for the agency object
     *
     * @return Agency
     */
    public Agency getAgency() {
        return agency;
    }

}
