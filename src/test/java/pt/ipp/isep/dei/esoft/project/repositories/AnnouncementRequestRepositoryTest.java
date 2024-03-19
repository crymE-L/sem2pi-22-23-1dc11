package pt.ipp.isep.dei.esoft.project.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AnnouncementRequestRepositoryTest {

    private AnnouncementRequestRepository repo;
    private TransactionRequest request;
    private Person user;
    private Property land;
    private Employee agent;

    @BeforeEach
    public void setUp() {
        Role role = new Role("Owner", 4);
        Role role2 = new Role("Agent", 3);
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "9876543219", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        City city = new City("Baião");
        District district = new District("Gaia");
        State state = new State("State");

		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(new Role("User", 4));

        Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", roles, "9876543219");

		ArrayList<Role> roles2 = new ArrayList<Role>();
		roles.add(role);

        repo = new AnnouncementRequestRepository();
        user = new Person ("Farusco", "farusco@silly.com", "AAAbcde12", roles2, "1234565590");
        land = new Property("House in Gaia","Petter's Sanctuary ST", 230, 10.0f, 300600.0f, city, district, state, user, Property.BusinessType.RENT, new ArrayList<String>());

		ArrayList<Role> roles3 = new ArrayList<Role>();
		roles.add(role2);

        agent = new Employee("Peter Griphyn", "peterlove@example.com", "AAAbcde12", roles3, "9876543219",
                12345678, 123456789, "123 Main St", agency);

        request = new TransactionRequest(user, buyer, agent, 150, 0.05f, true, land);
    }

    @Test
    public void addRequest() {
        repo.addRequest(request);
        assertTrue(repo.getAllRequests().contains(request));
    }

    @Test
    public void removeRequest() {
        repo.addRequest(request);
        repo.removeRequest(request);
        assertFalse(repo.getAllRequests().contains(request));
    }

    @Test
    public void validateRequestNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            repo.validateRequest(null, land, agent);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            repo.validateRequest(user, null, agent);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            repo.validateRequest(user, land, null);
        });
    }

    @Test
    public void validateRequestValidInput() {
        assertDoesNotThrow(() -> {
            repo.validateRequest(user, land, agent);
        });
    }
}
