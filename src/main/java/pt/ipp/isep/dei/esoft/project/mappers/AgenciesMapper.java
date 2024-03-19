package pt.ipp.isep.dei.esoft.project.mappers;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.AgencyDto;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for mapping Agency class
 * objects to agency DTO
 *
 * @author Diogo Martins (1221223)
 */
public class AgenciesMapper {

    /**
     * This method creates and returns an AgencyDto object
     * by extracting the name, vat, location, email, phone
     * and agency network information from the provided Employee object.
     *
     * @param agency
     * @return AgencyDto
     */
    public static AgencyDto toDto(Agency agency) {
        return new AgencyDto(agency.getName(), agency.getVat(), agency.getLocation(), agency.getEmail(), agency.getPhone(), agency.getAgencyNetwork());
    }

    /**
     * This method retrieves a list of Agency objects
     * from the AgencyRepository, iterates over each
     * Agency, converts them to AgencyDto objects using
     * the toDto method, and returns a list
     * of the resulting AgencyDto objects.
     *
     * @param agencyRepository
     * @return List<AgencyDto>
     */
    public List<AgencyDto> toDto(AgencyRepository agencyRepository){
        List<Agency> agencies = agencyRepository.getAllAgencies();
        List<AgencyDto> agenciesDto = new ArrayList<>();

        for (Agency agency : agencies) {
            agenciesDto.add(this.toDto(agency));
        }

        return agenciesDto;
    }
}
