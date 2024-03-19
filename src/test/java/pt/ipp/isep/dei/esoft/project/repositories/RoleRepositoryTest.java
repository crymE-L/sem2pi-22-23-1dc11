package pt.ipp.isep.dei.esoft.project.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.RoleRepository;

import static org.junit.jupiter.api.Assertions.*;

class RoleRepositoryTest {

    private RoleRepository roleRepository = new RoleRepository();

    @Test
    void addRole() {
        Role role1 = new Role("Admin", 1);
        Role role2 = new Role("Manager", 5);

        roleRepository.addRole(role1);
        roleRepository.addRole(role2);

        Assertions.assertEquals(2, roleRepository.getAllRoles().size());
        Assertions.assertTrue(roleRepository.getAllRoles().contains(role1));
        Assertions.assertTrue(roleRepository.getAllRoles().contains(role2));
    }

    @Test
    void removeRole() {
        Role role1 = new Role("Admin", 1);
        Role role2 = new Role("Manager", 5);

        roleRepository.addRole(role1);
        roleRepository.addRole(role2);

        roleRepository.removeRole(role1);

        Assertions.assertEquals(1, roleRepository.getAllRoles().size());
        Assertions.assertFalse(roleRepository.getAllRoles().contains(role1));
        Assertions.assertTrue(roleRepository.getAllRoles().contains(role2));
    }

}
