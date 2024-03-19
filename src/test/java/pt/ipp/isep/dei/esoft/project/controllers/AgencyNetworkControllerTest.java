package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;

import static org.junit.jupiter.api.Assertions.*;

class AgencyNetworkControllerTest {
    @Test
    void addAgencyNetwork_ValidAgencyNetwork_AgencyNetworkAddedToRepository() {
        AgencyNetworkRepository repository = new AgencyNetworkRepository();

        AgencyNetwork agencyNetwork = new AgencyNetwork("Test Network", "Location", "test@test.com", "123456789");
        repository.addAgencyNetwork(agencyNetwork);

        assertTrue(repository.getAllAgenciesNetwork().contains(agencyNetwork));
    }

    @Test
    void createAgencyNetworkAndPutInRepository_ValidData_AgencyNetworkCreatedAndAddedToRepository() {
        AgencyNetworkRepository repository = new AgencyNetworkRepository();
        AgencyNetworkController controller = new AgencyNetworkController(repository);
        String name = "Test Network";
        String location = "Location";
        String email = "test@test.com";
        String phone = "123456789";
        try {
            controller.createAgencyNetworkAndPutInRepository(name, location, email, phone);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        } catch (DataExistsException e) {
            throw new RuntimeException(e);
        }

        AgencyNetwork agencyNetwork = repository.getAgencyNetworkByEmail(email);
        assertNotNull(agencyNetwork);
        assertEquals(name, agencyNetwork.getName());
        assertEquals(location, agencyNetwork.getAddress());
        assertEquals(email, agencyNetwork.getEmail());
        assertEquals(phone, agencyNetwork.getPhone());
    }

    @Test
    void createAgencyNetworkAndPutInRepository_DuplicateEmail_DataExistsExceptionThrown() throws Exception {
        AgencyNetworkRepository repository = new AgencyNetworkRepository();
        AgencyNetworkController controller = new AgencyNetworkController(repository);

        String name1 = "Test Network 1";
        String name2 = "Test Network 2";
        String location = "Location";
        String email = "test@test.com";
        String phone = "123456789";

        try {
            controller.createAgencyNetworkAndPutInRepository(name1, location, email, phone);
        } catch (Exception | DataExistsException e) {
            fail("Exception thrown");
        }

        try {
            controller.createAgencyNetworkAndPutInRepository(name2, location, email, phone);
            fail("Exception not thrown");
        } catch (DataExistsException e) {

            assertEquals(e.getMessage(), "Test Network 2 already exists");
        } catch (Exception e) {
        }
    }



    @Test
    void removeAgencyNetwork_ValidAgencyNetwork_AgencyNetworkRemovedFromRepository() {
        AgencyNetworkRepository repository = new AgencyNetworkRepository();
        AgencyNetwork agencyNetwork = new AgencyNetwork("Test Network", "Location", "test@test.com", "123456789");
        repository.addAgencyNetwork(agencyNetwork);
        repository.removeAgencyNetwork(agencyNetwork);

        assertFalse(repository.getAllAgenciesNetwork().contains(agencyNetwork));
    }
}
