package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * This class exists to act as a controller that holds all
 * the logical operations needed for all features that
 * may relate to the user story 5
 *
 * @author Diogo Martins (1221223)
 */
public class CreateAgencyController {

    private AgencyRepository agencyRepository = null;

    /**
     * This constructor get the method agency repository.
     */
    public CreateAgencyController() {
        getAgencyRepository();
    }

    /**
     * This constructor takes an agency repository object as a parameter.
     *
     * @param agencyRepository
     */
    public CreateAgencyController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    /**
     * This method initializes the agencyRepository
     * instance variable if it is null.
     * If the agencyRepository is already initialized, it returns
     * the existing instance.
     *
     * @return agencyRepository
     */
    private AgencyRepository getAgencyRepository(){
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();

            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    /**
     * This method create a new agency object and add it to the
     * agency repository.
     * If an agency with the same designation already exists
     * in the repository, it throws a DataExistsException.
     * Otherwise, it adds the new agency to the repository.
     *
     * @param designation
     * @param state
     * @param district
     * @param city
     * @param email
     * @param phoneNumber
     * @param vat
     * @param address
     * @return agencyRepository
     * @throws Exception
     * @throws DataExistsException
     */
    public AgencyRepository createAgencyAndPutInRepository(String designation, State state, District district, City city, String email, String phoneNumber, int vat, String address, AgencyNetwork agencyNetwork) throws Exception, DataExistsException {
        Agency newAgency = new Agency(designation, vat, address, email, phoneNumber, agencyNetwork);

        if (agencyRepository.getAgencyByAddress(address) == null) {
            agencyRepository.addAgency(newAgency);

        } else {
            throw new DataExistsException(designation);
        }

        return agencyRepository;
    }
}
