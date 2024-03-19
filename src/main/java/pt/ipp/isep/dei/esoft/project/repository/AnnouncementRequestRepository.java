package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRequestRepository {
    private Date date;
    private List<TransactionRequest> requests;
    private static List<AnnouncementRequest> announcementRequests;
    public AnnouncementRequestRepository() {
        announcementRequests = new ArrayList<>();
    }
    public void addAnnouncementRequest(AnnouncementRequest request){announcementRequests.add((AnnouncementRequest) announcementRequests);}
    public void removeAnnouncementRequest(AnnouncementRequest request){announcementRequests.remove((AnnouncementRequest) announcementRequests);}
    public void addRequest(TransactionRequest request){requests.add(request);}

    public void removeRequest(TransactionRequest request){requests.remove(request);}

    public List<TransactionRequest> getAllRequests() {
        return new ArrayList<>(requests);
    }
    public static List<AnnouncementRequest> getAllAnnouncementRequests() {
        return new ArrayList<>(announcementRequests);
    }

    public void validateRequest(Person user, Property land, Employee agent) {
        if (user == null || land == null || agent == null) {
            throw new IllegalArgumentException("One or more input parameters are null");
        }
    }

	public List<TransactionRequest> getAnnouncementsByAgent(Employee agent) {
		List<TransactionRequest> saleAnnouncements = new ArrayList<TransactionRequest>();
		String email = agent.getEmail();

		for (TransactionRequest request: requests) {
			if(request.getAgent().getEmail().equals(email)) saleAnnouncements.add(request);
		}

		return saleAnnouncements;
	}

    public TransactionRequest getPurchaseOrdersByProperty(Property property) {
        for (TransactionRequest purchaseOrder : requests) {
            if (purchaseOrder.getProperty().equals(property)) {
                return purchaseOrder;
            }
        }
        return null;
    }

}
