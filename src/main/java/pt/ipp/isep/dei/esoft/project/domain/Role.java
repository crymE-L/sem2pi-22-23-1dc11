package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class serves the purpose of
 * representing the role of each person
 * that uses the application.
 * Their role, directly, influences
 * their permissions inside the application.
 *
 * @author Gustavo Lima (1221349)
 */
public class Role {

    private String name;

    private int permissionLevel;

    /** Builds an object of Role,
     * receiving the name and permission level
     *
     * @param name
     * @param permissionLevel
     */
    public Role(String name, int permissionLevel) {
        setName(name);
        setPermissionLevel(permissionLevel);
    }

    /**
     * The getter for the name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        if(Helpers.isEmpty(name)) throw new IllegalArgumentException("Invalid name.");
    }

    /** The getter for the permission level
     *
     * @return int
     */
    public int getPermissionLevel() {
        return permissionLevel;
    }

    /** The setter for the permission level
     *
     * @param permissionLevel
     */
    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
        if(permissionLevel < 0) throw new IllegalArgumentException("Invalid permission level.");
    }

    /** The textual description of the role
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Role: " + name + ".");
    }
}
