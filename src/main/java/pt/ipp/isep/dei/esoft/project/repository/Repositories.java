package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;

public class Repositories {
    private static final Repositories instance = new Repositories();
	private final AgencyRepository agencyRepository = new AgencyRepository();
	private final EmployeeRepository employeeRepository = new EmployeeRepository();
	private final PropertyRepository propertyRepository = new PropertyRepository();
	private final AnnouncementRequestRepository requestsRepository = new AnnouncementRequestRepository();
	private final TransactionRepository transactionsRepository = new TransactionRepository();
	private final RoleRepository roleRepository = new RoleRepository();
	private final PersonRepository personRepository = new PersonRepository();
    private final AgencyNetworkRepository agencyNetworkRepository = new AgencyNetworkRepository();

	ApplicationSession applicationSession = new ApplicationSession();


    public Repositories() {}

    public static Repositories getInstance() {
        return instance;
    }

    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public PropertyRepository getPropertyRepository() {
        return propertyRepository;
    }

    public AnnouncementRequestRepository getRequestsRepository() {
        return requestsRepository;
    }

	public TransactionRepository getTransactionsRepository() {
		return transactionsRepository;
	}

    public RoleRepository getRoleRepository() { return roleRepository; }

	public ApplicationSession getSession() { return applicationSession; }

	public PersonRepository getUsersRepository() { return personRepository; }

    public AgencyNetworkRepository getAgencyNetworkRepository() { return agencyNetworkRepository; }
}
