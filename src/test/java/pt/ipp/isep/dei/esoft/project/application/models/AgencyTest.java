package pt.ipp.isep.dei.esoft.project.application.models;

// import application.models.Agency;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AgencyTest {

    @Test
    public void testConstructor() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        assertEquals("Agency One", agency.getName());
        assertEquals(123456789, agency.getVat());
        assertEquals("Porto", agency.getLocation());
        assertEquals("agencyone@example.com", agency.getEmail());
        assertEquals("1234567899", agency.getPhone());
    }

    @Test
    public void testSetName() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        agency.setName("New Agency Name");
        assertEquals("New Agency Name", agency.getName());
        assertThrows(IllegalArgumentException.class, () -> agency.setName(""));
    }

    @Test
    public void testSetVat() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        agency.setVat(987654321);
        assertEquals(987654321, agency.getVat());
        assertThrows(IllegalArgumentException.class, () -> agency.setVat(123));
    }

    @Test
    public void testSetAddress() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> agency.setLocation(""));
    }

    @Test
    public void testSetEmail() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        agency.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", agency.getEmail());
        assertThrows(IllegalArgumentException.class, () -> agency.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> agency.setEmail("invalidEmail"));
    }

    @Test
    public void testSetPhone() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        agency.setPhone("9876543219");
        assertEquals("9876543219", agency.getPhone());
        assertThrows(IllegalArgumentException.class, () -> agency.setPhone("123"));
    }

    @Test
    public void testSetManager() {
        Employee manager = new Employee("Joana", "joana@gmail.com", "123456789EBC", new Role("Agency Manager", 2),
                "1234567890", 12345678, 123456789,  "Rua Olá", new Agency("Ola", 123456789, "Rua Ola", "agencia@email.com", "1234567890", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890")) );

        Agency agency = new Agency("Adeus", 123456789, "Rua Adeus", "agencia@email.com", "1234567890", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));

        agency.setManager(manager);
        assertEquals(manager, agency.getManager());
    }

    @Test
    public void testSetLocation(){
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890"));
        agency.setLocation("Rua 2");
        assertEquals("Rua 2", agency.getLocation());
        assertThrows(IllegalArgumentException.class, () -> agency.setLocation(""));
    }

    @Test
    public void testSetAgencyNetwork(){
        AgencyNetwork agencyNetwork = new AgencyNetwork("Ola", "Rua agencyNetwork", "agencyNetwork@gmail.com", "1234567890");
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", "1234567899", null);
        agency.setAgencyNetwork(agencyNetwork);

        assertEquals(agencyNetwork, agency.getAgencyNetwork());
    }
}
