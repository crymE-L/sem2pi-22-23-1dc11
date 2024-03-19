package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.TransactionRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class SaleAnnouncementController {
	private final AnnouncementRequestRepository repository = Repositories.getInstance().getRequestsRepository();

	public TransactionRequest create(Person owner, Person buyer, Employee agent, float price, float commission, Property property) {
		TransactionRequest transactionRequest = new TransactionRequest(owner, buyer, agent, price, commission, false, property);
		repository.addRequest(transactionRequest);

		return transactionRequest;
	}
}
