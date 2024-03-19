package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import static org.junit.jupiter.api.Assertions.*;

public class RoleTest {

    @Test
    public void TestConstructor() {
        Role roleExample = new Role("Admin", 2);
        assertEquals("Admin", roleExample.getName());
        assertEquals(2, roleExample.getPermissionLevel());
    }

    @Test
    public void testSetName() {
        Role roleExample = new Role("Admin", 2);
        roleExample.setName("Manager");
        assertEquals("Manager", roleExample.getName());
        assertThrows(IllegalArgumentException.class, () -> roleExample.setName(""));
    }

    @Test
    public void testSetPermissionLevel() {
        Role roleExample = new Role("Admin", 2);
        roleExample.setPermissionLevel(4);
        assertEquals(4, roleExample.getPermissionLevel());
        assertThrows(IllegalArgumentException.class, () -> roleExample.setPermissionLevel(-1));
    }

    @Test
    public void testToString() {
        Role roleExample = new Role("Admin", 2);
        assertEquals("Role: Admin.", roleExample.toString());
    }
}
