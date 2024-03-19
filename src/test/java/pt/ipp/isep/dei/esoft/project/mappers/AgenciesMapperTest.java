package pt.ipp.isep.dei.esoft.project.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.AgencyDto;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

import java.util.List;

public class AgenciesMapperTest {
    private AgencyRepository agencyRepository;
    private AgenciesMapper agenciesMapper;

    @Test
    public void testToDto() {
        agencyRepository = new AgencyRepository();
        agenciesMapper = new AgenciesMapper();
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "agency@example.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        AgencyDto agencyDto = agenciesMapper.toDto(agency);

        Assertions.assertEquals("Agency Name", agencyDto.getName());
        Assertions.assertEquals(123456789, agencyDto.getVat());
        Assertions.assertEquals("Porto", agencyDto.getLocation());
        Assertions.assertEquals("agency@example.com", agencyDto.getEmail());
        Assertions.assertEquals("1234567890", agencyDto.getPhone());
        Assertions.assertEquals("agencyNetwork1", agencyDto.getAgencyNetwork().getName());
    }

    @Test
    public void testToDtoList() {
        agencyRepository = new AgencyRepository();
        agenciesMapper = new AgenciesMapper();
        AgencyNetwork agencyNetwork1 = new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1111111111");
        Agency agency1 = new Agency("Agency Name 1", 111111111, "Location 1", "agency1@example.com", "1111111111", agencyNetwork1);
        AgencyNetwork agencyNetwork2 = new AgencyNetwork("agencyNetwork2", "Rua agencyNetwork2", "agencynetwork2@gmail.com", "2222222222");
        Agency agency2 = new Agency("Agency Name 2", 222222222, "Location 2", "agency2@example.com", "2222222222", agencyNetwork2);
        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);


        List<AgencyDto> agencyDtos = agenciesMapper.toDto(agencyRepository);

        Assertions.assertEquals(2, agencyDtos.size());
        AgencyDto agencyDto1 = agencyDtos.get(0);
        Assertions.assertEquals("Agency Name 1", agencyDto1.getName());
        Assertions.assertEquals(111111111, agencyDto1.getVat());
        Assertions.assertEquals("Location 1", agencyDto1.getLocation());
        Assertions.assertEquals("agency1@example.com", agencyDto1.getEmail());
        Assertions.assertEquals("1111111111", agencyDto1.getPhone());
        Assertions.assertEquals("agencyNetwork1", agencyDto1.getAgencyNetwork().getName());
        AgencyDto agencyDto2 = agencyDtos.get(1);
        Assertions.assertEquals("Agency Name 2", agencyDto2.getName());
        Assertions.assertEquals(222222222, agencyDto2.getVat());
        Assertions.assertEquals("Location 2", agencyDto2.getLocation());
        Assertions.assertEquals("agency2@example.com", agencyDto2.getEmail());
        Assertions.assertEquals("2222222222", agencyDto2.getPhone());
        Assertions.assertEquals("agencyNetwork2", agencyDto2.getAgencyNetwork().getName());
    }
}
