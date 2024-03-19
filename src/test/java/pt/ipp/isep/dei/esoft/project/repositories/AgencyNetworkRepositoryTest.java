package pt.ipp.isep.dei.esoft.project.repositories;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;

import static org.junit.jupiter.api.Assertions.*;

class AgencyNetworkRepositoryTest {
    private AgencyNetworkRepository repository;

    @Test
    void addAgencyNetwork() {
        repository = new AgencyNetworkRepository();
        AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890");
        repository.addAgencyNetwork(agencyNetwork);

        assertTrue(repository.getAllAgenciesNetwork().contains(agencyNetwork));
    }

    @Test
    void removeAgencyNetwork() {
        repository = new AgencyNetworkRepository();
        AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890");
        repository.addAgencyNetwork(agencyNetwork);
        repository.removeAgencyNetwork(agencyNetwork);

        assertFalse(repository.getAllAgenciesNetwork().contains(agencyNetwork));
    }

    @Test
    void getAllAgenciesNetwork_NoAgenciesNetwork_EmptyListReturned() {
        repository = new AgencyNetworkRepository();
        var result = repository.getAllAgenciesNetwork();

        assertTrue(result.isEmpty());
    }

    @Test
    void getAllAgenciesNetwork_MultipleAgenciesNetwork_ListReturned() {
        repository = new AgencyNetworkRepository();
        AgencyNetwork agencyNetwork1 = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890");
        AgencyNetwork agencyNetwork2 = new AgencyNetwork("agencyNetwork2", "Street agencyNetwork2", "agencyNetwork2@gmail.com", "1234567890");
        repository.addAgencyNetwork(agencyNetwork1);
        repository.addAgencyNetwork(agencyNetwork2);
        var result = repository.getAllAgenciesNetwork();

        assertEquals(2, result.size());
        assertTrue(result.contains(agencyNetwork1));
        assertTrue(result.contains(agencyNetwork2));
    }

    @Test
    void getAgencyNetworkByEmail_ExistingEmail_ReturnsAgencyNetwork() {
        repository = new AgencyNetworkRepository();
        String email = "test@test.com";
        AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", email, "1234567890");
        repository.addAgencyNetwork(agencyNetwork);

        assertEquals(agencyNetwork, repository.getAgencyNetworkByEmail(email));
    }

    @Test
    void getAgencyNetworkByEmail_NonExistingEmail_ReturnsNull() {
        repository = new AgencyNetworkRepository();
        String email = "test@test.com";
        AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", email, "1234567890");
        repository.addAgencyNetwork(agencyNetwork);
        var result = repository.getAgencyNetworkByEmail("nonexisting@test.com");

        assertNull(result);
    }
}
