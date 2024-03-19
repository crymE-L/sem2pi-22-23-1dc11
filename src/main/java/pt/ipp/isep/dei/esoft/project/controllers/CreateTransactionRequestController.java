package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.TransactionRequest;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;

public class CreateTransactionRequestController {
    private EmployeeRepository employeeRepository = null;
    private AnnouncementRequestRepository requestsRepository = null;

    public CreateTransactionRequestController() {
        this.requestsRepository = Repositories.getInstance().getRequestsRepository();
    }

	public TransactionRequest createTransactionRequest(Person owner, Person buyer, Employee agent, float price, float commission, Property property) {
		/**
		 * Verify if the object parameters are not null
		 */
		if(owner == null) {
			throw new IllegalArgumentException("Invalid owner.");
		}

		TransactionRequest transactionRequest = new TransactionRequest(owner, buyer, agent, price, commission, false, property);
		requestsRepository.addRequest(transactionRequest);

		return transactionRequest;
	}

    private EmployeeRepository getEmployeeRepository(){
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();

            employeeRepository = repositories.getEmployeeRepository();
        }

        return employeeRepository;
    }

    private AnnouncementRequestRepository getRequestsRepository(){
        if (requestsRepository == null) {
            Repositories repositories = Repositories.getInstance();

            requestsRepository = repositories.getRequestsRepository();
        }

        return requestsRepository;
    }
}
