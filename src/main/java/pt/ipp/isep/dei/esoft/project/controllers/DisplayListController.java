package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;

import java.util.ArrayList;
import java.util.List;

public class DisplayListController {
    private AnnouncementRequestRepository requestListRepository;
    private PropertyRepository propertyRepository;

    private AnnouncementRequest announcementRequest;

    public DisplayListController(AnnouncementRequestRepository requestListRepository, PropertyRepository propertyRepository) {
        this.requestListRepository = requestListRepository;
        this.propertyRepository = propertyRepository;
    }
    public void removeFromList(AnnouncementRequest announcementRequest) {
            requestListRepository.removeAnnouncementRequest(announcementRequest);

    }

    public List<AnnouncementRequest> getRequestList() {
        return requestListRepository.getAllAnnouncementRequests();
    }
    public void addAnnouncementRequestToPropertyRepository(AnnouncementRequest request) {
        // Extract relevant information from the AnnouncementRequest
        String propertyName = request.getName();
        String propertyAddress = request.getAddress();
        int propertyArea = (int) request.getArea();
        float distanceFromCenter = (float) request.getDistanceFromCenter();
        float propertyPrice = (float) request.getPrice();
        City propertyCity = request.getCity();
        District propertyDistrict = request.getDistrict();
        State propertyState = request.getState();
        Person propertyOwner = request.getOwner();
        AnnouncementRequest.BusinessType businessType = request.getBusinessType();
        ArrayList<String> propertyPhotos = null;

        // Create a new Property object using the extracted information
        Property property = new Property(propertyName, propertyAddress, propertyArea, distanceFromCenter, propertyPrice, propertyCity, propertyDistrict, propertyState, propertyOwner, null, propertyPhotos);

        // Add the Property object to the property repository
        propertyRepository.addProperty(property);
    }

    public void  displayRequestList(List<AnnouncementRequest> requestList) {
        // Display the request list in the UI
        System.out.println("Request List:");
        for (AnnouncementRequest announcementRequest : requestList) {
            System.out.println(announcementRequest.toString());
        }
    }


    public List<AnnouncementRequest> getAnnouncementRequestList() {
        return requestListRepository.getAllAnnouncementRequests();
    }
}