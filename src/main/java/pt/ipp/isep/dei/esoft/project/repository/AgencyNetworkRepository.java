package pt.ipp.isep.dei.esoft.project.repository;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;

/**
 * Repository class for managing instances of AgencyNetwork.
 *
 * @author Diogo Martins (1221223)
 */
public class AgencyNetworkRepository {
    private final List<AgencyNetwork> agenciesNetwork = new ArrayList<>();

    /**
     * Adds an AgencyNetwork to the repository.
     *
     * @param agencyNetwork
     */
    public void addAgencyNetwork(AgencyNetwork agencyNetwork) {
        agenciesNetwork.add(agencyNetwork);
    }

    /**
     * Removes an AgencyNetwork from the repository.
     *
     * @param agencyNetwork
     */
    public void removeAgencyNetwork(AgencyNetwork agencyNetwork) {
        agenciesNetwork.remove(agencyNetwork);
    }

    /**
     * Retrieves all agenciesNetwork in the repository.
     *
     * @return List of agenciesNetwork.
     */
    public List<AgencyNetwork> getAllAgenciesNetwork() {
        return new ArrayList<>(agenciesNetwork);
    }

    /**
     * Retrieves an AgencyNetwork by email.
     *
     * @param email
     * @return The AgencyNetwork with the given email, or null if not found.
     */
    public AgencyNetwork getAgencyNetworkByEmail(String email) {
        for (AgencyNetwork agencyNetwork : agenciesNetwork) {
            if (agencyNetwork.getEmail().equals(email)) {
                return agencyNetwork;
            }
        }
        return null;
    }

}
