package pt.ipp.isep.dei.esoft.project.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

class AgencyRepositoryTest {
    private AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    void addAgency() {
        Agency agency1 = new Agency("Agency 1", 111111111, "Rua agencia 1", "agencia1@agencia1.com", "1111111111", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Agency agency2 = new Agency("Agency 2", 222222222, "Rua agencia 2", "agencia2@agencia2.com", "2222222222", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);

        Assertions.assertEquals(2, agencyRepository.getAllAgencies().size());
        Assertions.assertTrue(agencyRepository.getAllAgencies().contains(agency1));
        Assertions.assertTrue(agencyRepository.getAllAgencies().contains(agency2));
    }

    @Test
    void removeAgency() {
        Agency agency1 = new Agency("Agency 1", 111111111, "Rua agencia 1", "agencia1@agencia1.com", "1111111111", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Agency agency2 = new Agency("Agency 2", 222222222, "Rua agencia 2", "agencia2@agencia2.com", "2222222222", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);

        agencyRepository.removeAgency(agency1);

        Assertions.assertEquals(1, agencyRepository.getAllAgencies().size());
        Assertions.assertFalse(agencyRepository.getAllAgencies().contains(agency1));
        Assertions.assertTrue(agencyRepository.getAllAgencies().contains(agency2));
    }

    @Test
    void getAgencyByName() {
        Agency agency1 = new Agency("Agency 1", 111111111, "Rua agencia 1", "agencia1@agencia1.com", "1111111111", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Agency agency2 = new Agency("Agency 2", 222222222, "Rua agencia 2", "agencia2@agencia2.com", "2222222222", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);

        Agency agency = agencyRepository.getAgencyByAddress("Rua agencia 1");

        Assertions.assertEquals(agency1, agency);

        agency = agencyRepository.getAgencyByAddress("Rua agencia 3");

        Assertions.assertNull(agency);
    }
}
