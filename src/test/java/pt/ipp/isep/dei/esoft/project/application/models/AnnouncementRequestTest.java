package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.Before;
import org.junit.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import static org.junit.Assert.assertEquals;

public class AnnouncementRequestTest {
    private AnnouncementRequest announcementRequest;

    @Before
    public void setUp() {
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Role role = new Role("Admin", 1);
        City city = new City("City");
        District district = new District("District");
        State state = new State("State");
        Person owner = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");
        Employee agent = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role,
                "1234567890", 12345678, 123456789, "123 Main St", agency);

        announcementRequest = new AnnouncementRequest(
                "Address",
                100,
                10.5f,
                100000.0f,
                city,
                district,
                state,
                owner,
                2,
                1,
                1,
                true,
                true,
                agent,
                AnnouncementRequest.BusinessType.SALE,
                0
        );
    }

    @Test
    public void testGetAddress() {
        assertEquals("Address", announcementRequest.getAddress());
    }

    @Test
    public void testSetAddress() {
        announcementRequest.setAddress("New Address");
        assertEquals("New Address", announcementRequest.getAddress());
    }

}
