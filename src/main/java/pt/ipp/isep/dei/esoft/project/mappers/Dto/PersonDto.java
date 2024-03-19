package pt.ipp.isep.dei.esoft.project.mappers.Dto;


import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import java.util.ArrayList;

/**
 * This class exists to simulate a person from real life
 * and its applications to the software
 *
 * @author Diogo Martins (1221223)
 */
public class PersonDto {
    /**
     * The person's name
     */
    private String name;

    /**
     * The person's role
     */
    private Role role;

    /**
     * The person's properties
     */
    private ArrayList<Property> properties = new ArrayList<Property>();

    /**
     * This constructor was made to create a new person in the
     * system, that can have a role and will interact with the
     * platform
     *
     * @param name
     * @param role
     */
    public PersonDto(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    /**
     * The getter for name of the person.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * The getter for the person's role object
     *
     * @return Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * The getter for the person's properties
     *
     * @return ArrayList<Property>
     */
    public ArrayList<Property> getProperties() {
        return properties;
    }
}
