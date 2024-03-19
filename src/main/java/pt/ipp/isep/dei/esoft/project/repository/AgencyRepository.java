package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.Agency;

/**
 * Repository class for managing instances of Agency.
 *
 * @author Diogo Martins (1221223)
 */
public class AgencyRepository {
    private final List<Agency> agencies = new ArrayList<>();

    /**
     * Adds an Agency to the repository.
     *
     * @param agency
     */
    public void addAgency(Agency agency) {
        agencies.add(agency);
    }

    /**
     * Removes an Agency from the repository.
     *
     * @param agency
     */
    public void removeAgency(Agency agency) {
        agencies.remove(agency);
    }

    /**
     * Retrieves all agencies in the repository.
     *
     * @return List of agencies.
     */
    public List<Agency> getAllAgencies() {
        return new ArrayList<>(agencies);
    }

    /**
     * Retrieves an Agency by address.
     *
     * @param address
     * @return The Agency with the given address, or null if not found.
     */
    public Agency getAgencyByAddress(String address) {
        for (Agency agency : agencies) {
            if (agency.getLocation().equals(address)) {
                return agency;
            }
        }
        return null;
    }

}
