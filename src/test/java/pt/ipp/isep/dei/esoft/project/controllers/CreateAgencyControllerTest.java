package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.City;
import pt.ipp.isep.dei.esoft.project.domain.District;
import pt.ipp.isep.dei.esoft.project.domain.State;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

import static org.junit.jupiter.api.Assertions.*;

class CreateAgencyControllerTest {
    private String designation = "Agency1";
    private State state = new State("state1");
    private District district = new District("District1");
    private City city = new City("City1");
    private String email = "email1@test.com";
    private String phoneNumber = "9876543219";
    private int vat = 123456789;
    private String address = "Location1";
    private AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890");
    private AgencyRepository repo = new AgencyRepository();
    private CreateAgencyController controller = new CreateAgencyController(repo);

    @Test
    public void testCreateAgencyAndPutInRepository() {
        //Act
        try {
            controller.createAgencyAndPutInRepository(designation, state, district, city, email, phoneNumber, vat, address, agencyNetwork);
        } catch (Exception | DataExistsException e) {
            fail("Exception thrown");
        }

        //Assert
        assertTrue(repo.getAllAgencies().size() == 1);
        assertEquals(repo.getAllAgencies().get(0).getName(), designation);
        assertEquals(repo.getAllAgencies().get(0).getEmail(), email);
        assertEquals(repo.getAllAgencies().get(0).getPhone(), phoneNumber);
        assertEquals(repo.getAllAgencies().get(0).getVat(), vat);
        assertEquals(repo.getAllAgencies().get(0).getLocation(), address);
        assertEquals(repo.getAllAgencies().get(0).getAgencyNetwork(), agencyNetwork);
    }

    @Test
    public void testCreateAgencyAndPutInRepository_DataExistsException() {
        //Add the first agency
        try {
            controller.createAgencyAndPutInRepository(designation, state, district, city, email, phoneNumber, vat, address, agencyNetwork);
        } catch (Exception | DataExistsException e) {
            fail("Exception thrown");
        }

        //Act
        try {
            controller.createAgencyAndPutInRepository(designation, state, district, city, email, phoneNumber, vat, address, agencyNetwork);
            fail("Exception not thrown");
        } catch (DataExistsException e) {
            //Assert
            assertEquals(e.getMessage(), "Agency1 already exists");
        } catch (Exception e) {
        }
    }

}
