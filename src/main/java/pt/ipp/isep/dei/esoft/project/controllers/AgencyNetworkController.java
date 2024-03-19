package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class AgencyNetworkController {
    private AgencyNetworkRepository agencyNetworkRepository = null;

    /**
     * This constructor get the method agencyNetworkRepository.
     */
    public AgencyNetworkController(){getAgencyNetworkRepository();}

    /**
     * This constructor takes an agency network repository object as a parameter.
     *
     * @param agencyNetworkRepository
     */
    public AgencyNetworkController(AgencyNetworkRepository agencyNetworkRepository) {
        this.agencyNetworkRepository = agencyNetworkRepository;
    }

    /**
     * This method initializes the agency network repository
     * instance variable if it is null.
     * If the agency network repository is already initialized, it returns
     * the existing instance.
     *
     * @return AgencyNetworkRepository
     */
    private AgencyNetworkRepository getAgencyNetworkRepository() {
        if (agencyNetworkRepository == null) {
            Repositories repositories = Repositories.getInstance();

            agencyNetworkRepository = repositories.getAgencyNetworkRepository();
        }

        return agencyNetworkRepository;
    }

    /**
     * This method create a new agencyNetwork object and add it to the
     * agency network repository.
     * If an agency network with the same designation already exists
     * in the repository, it throws a DataExistsException.
     * Otherwise, it adds the new agency network to the repository.
     *
     * @param name
     * @param location
     * @param email
     * @param phone
     * @return
     * @throws Exception
     * @throws DataExistsException
     */
    public AgencyNetworkRepository createAgencyNetworkAndPutInRepository(String name, String location, String email, String phone) throws Exception, DataExistsException {
        AgencyNetwork newNetwork = new AgencyNetwork(name, location, email, phone);

        if (agencyNetworkRepository.getAgencyNetworkByEmail(email) == null) {
            agencyNetworkRepository.addAgencyNetwork(newNetwork);
        } else {
            throw new DataExistsException(name);
        }

        return agencyNetworkRepository;
    }
}
