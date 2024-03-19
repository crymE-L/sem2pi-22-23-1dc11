package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.Before;
import org.junit.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.controllers.DisplayListController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DisplayListControllerTest {
    private DisplayListController displayListController;

    @Before
    public void setUp() {
        AnnouncementRequestRepository requestListRepository = new AnnouncementRequestRepository();
        PropertyRepository propertyRepository = new PropertyRepository();
        displayListController = new DisplayListController(requestListRepository, propertyRepository);
    }

    @Test
    public void testGetRequestList() {
        List<AnnouncementRequest> requestList = displayListController.getRequestList();
        assertNotNull(requestList);
        assertEquals(0, requestList.size());
    }

    @Test
    public void testAddAnnouncementRequestToPropertyRepository() {
        // Create an example AnnouncementRequest
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        Role role = new Role("Admin", 1);
        String address = "123 Main St";
        int area = 100;
        float distanceFromCenter = 5.0f;
        float price = 200000.0f;
        City city = new City("City");
        District district = new District("District");
        State state = new State("State");
        Person owner = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");
        int bedrooms = 3;
        int bathrooms = 2;
        int parkingSpaces = 1;
        boolean hasCentralHeating = true;
        boolean hasAirConditioning = true;
        Employee agent = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role,
                "1234567890", 12345678, 123456789, "123 Main St", agency);
        AnnouncementRequest.BusinessType businessType = AnnouncementRequest.BusinessType.SALE;
        int contractDuration = 0;

        AnnouncementRequest request = new AnnouncementRequest(address, area, distanceFromCenter, price, city, district, state,
                owner, bedrooms, bathrooms, parkingSpaces, hasCentralHeating, hasAirConditioning, agent, businessType,
                contractDuration);

        displayListController.addAnnouncementRequestToPropertyRepository(request);

        List<AnnouncementRequest> requestList = displayListController.getRequestList();
        assertEquals(1, requestList.size());

        // Additional assertions can be made to check the correctness of the added request
    }

    @Test
    public void testRemoveFromList() {
        // Create an example AnnouncementRequest
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        Role role = new Role("Admin", 1);
        String address = "123 Main St";
        int area = 100;
        float distanceFromCenter = 5.0f;
        float price = 200000.0f;
        City city = new City("City");
        District district = new District("District");
        State state = new State("State");
        Person owner = new Person("Farusco", "farusco@silly.com", "AAAbcde12", role, "1234567890");
        int bedrooms = 3;
        int bathrooms = 2;
        int parkingSpaces = 1;
        boolean hasCentralHeating = true;
        boolean hasAirConditioning = true;
        Employee agent = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role,
                "1234567890", 12345678, 123456789, "123 Main St", agency);
        AnnouncementRequest.BusinessType businessType = AnnouncementRequest.BusinessType.SALE;
        int contractDuration = 0;

        AnnouncementRequest request = new AnnouncementRequest(address, area, distanceFromCenter, price, city, district, state,
                owner, bedrooms, bathrooms, parkingSpaces, hasCentralHeating, hasAirConditioning, agent, businessType,
                contractDuration);
        displayListController.addAnnouncementRequestToPropertyRepository(request);

        List<AnnouncementRequest> requestList = displayListController.getRequestList();
        assertEquals(1, requestList.size());

        displayListController.removeFromList(request);

        requestList = displayListController.getRequestList();
        assertEquals(0, requestList.size());
    }



}
