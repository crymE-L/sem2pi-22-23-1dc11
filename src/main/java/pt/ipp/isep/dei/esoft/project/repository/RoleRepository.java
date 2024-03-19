package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Role;

/**
 * Repository class for managing instances of Roles.
 *
 * @author Gonçalo Silva (1220607)
 */
public class RoleRepository {
    private final List<Role>  roles = new ArrayList<>();

    /**
     * Adds a role to the repository.
     * @param role
     */
    public void addRole (Role role) {
        roles.add(role);
    }

    /**
     * Removes a role to the repository.
     * @param role
     */
    public void removeRole (Role role) {
        roles.remove(role);
    }


    /**
     * Retrieves all roles in the repository.
     *
     * @return List of roles.
     */
    public  List<Role> getAllRoles() {
        return roles;
    }

	/**
	 * Get a specific role according to the
	 * name passed as a parameter
	 *
	 * @param name
	 * @return
	 */
	public Role getRoleByName(String name) {
		for(Role role : roles) {
			if(role.getName().equals(name))
				return role;
		}

		return null;
	}

}
