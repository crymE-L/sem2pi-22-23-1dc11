package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.mappers.*;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class exists to act as a controller that holds all
 * the logical operations needed for all features that
 * may relate to the user story 13
 *
 * @author Diogo Martins (1221223)
 */
public class DisplayEmployeesController {
    private EmployeesMapper employeesMapper = new EmployeesMapper();
    private AgenciesMapper agenciesMapper = new AgenciesMapper();
    private EmployeeRepository employeeRepository;
    private AgencyNetworkRepository agencyNetworkRepository;
    private AgencyRepository agencyRepository;
    ApplicationSession applicationSession = new ApplicationSession();

    /**
     * This method takes the 3 required repositories as a parameter
     *
     * @param employeeRepository
     * @param agencyNetworkRepository
     * @param agencyRepository
     */
    public DisplayEmployeesController (EmployeeRepository employeeRepository, AgencyNetworkRepository agencyNetworkRepository, AgencyRepository agencyRepository) {
        this.agencyNetworkRepository = agencyNetworkRepository;
        this.employeeRepository = employeeRepository;
        this.agencyRepository = agencyRepository;
    }

    /**
     * This constructor get the 3 required repositories.
     */
    public DisplayEmployeesController () {
        getAgencyNetworkRepository();
        getEmployeeRepository();
        getAgencyRepository();
    }

    /**
     * This method initializes the agencyRepository
     * instance variable if it is null.
     * If the agencyRepository is already initialized, it returns
     * the existing instance.
     *
     * @return agencyRepository
     */
    private AgencyRepository getAgencyRepository() {
        if (agencyRepository == null) {

            Repositories repositories = Repositories.getInstance();

            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    /**
     * This method initializes the agencyNetworkRepository
     * instance variable if it is null.
     * If the agencyNetworkRepository is already initialized, it returns
     * the existing instance.
     *
     * @return agencyNetworkRepository
     */
    private AgencyNetworkRepository getAgencyNetworkRepository() {
        if (agencyNetworkRepository == null) {

            Repositories repositories = Repositories.getInstance();

            agencyNetworkRepository = repositories.getAgencyNetworkRepository();
        }

        return agencyNetworkRepository;
    }

    /**
     * This method initializes the employeeRepository
     * instance variable if it is null.
     * If the employeeRepository is already initialized, it returns
     * the existing instance.
     *
     * @return employeeRepository
     */
    private EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {

            Repositories repositories = Repositories.getInstance();

            employeeRepository = repositories.getEmployeeRepository();
        }

        return employeeRepository;
    }

    /**
     * This method initializes the employeeRepository
     * instance variable if it is null.
     *
     * @return employeeRepository
     */
    private List<EmployeeDto> getEmployeesDto(){
        if (employeeRepository == null) {

            Repositories repositories = Repositories.getInstance();

            employeeRepository = repositories.getEmployeeRepository();
        }

        return employeesMapper.toDto(employeeRepository);
    }

    /**
     * This method initializes the agencyRepository
     * instance variable if it is null.
     *
     * @return agencyRepository
     */
    private List<AgencyDto> getAgenciesDto(){
        if (agencyRepository == null) {

            Repositories repositories = Repositories.getInstance();

            agencyRepository = repositories.getAgencyRepository();
        }

        return agenciesMapper.toDto(agencyRepository);
    }


    /**
     * This method get the agency network asoociated
     * with the current user.
     *
     * @return userAgencyNetwork
     */
    public AgencyNetwork getUserAgencyNetwork(){
        AgencyNetwork userAgencyNetwork = null;
        List<AgencyNetwork> agencyNetworkList = agencyNetworkRepository.getAllAgenciesNetwork();
        Object currentUser = applicationSession.getCurrentUser();

        for (AgencyNetwork agencyNetwork : agencyNetworkList) {

            if (currentUser.equals(agencyNetwork.getManager())) {

                userAgencyNetwork = agencyNetwork;
            }
        }

        return userAgencyNetwork;
    }

    /**
     * This method get a list of agency DTOs from
     * the agency network associated with the current
     * user.
     *
     * @return newAgencyDtoList
     */
    public List<AgencyDto> getAgenciesFromAgencyNetwork(){
        List<AgencyDto> agencyDtoList = getAgenciesDto();
        List<AgencyDto> newAgencyDtoList = new ArrayList<>();

        for (AgencyDto agencyDto : agencyDtoList) {
            if (agencyDto.getAgencyNetwork().equals(getUserAgencyNetwork())) {

                newAgencyDtoList.add(agencyDto);
            }
        }

        return newAgencyDtoList;
    }

    /**
     * This method sorts a list of agency DTOs
     * based on the number of properties of
     * each agency.
     *
     * @return agencyDtoList
     */
    public List<AgencyDto> getOrderAgencyDtoList() {
        List<AgencyDto> agencyDtoList = getAgenciesFromAgencyNetwork();

        Collections.sort(agencyDtoList, new Comparator<AgencyDto>() {
            @Override
            public int compare(AgencyDto agencyDto1, AgencyDto agencyDto2) {
                int propertyCount1 = getPropertiesNumber(agencyDto1);

                int propertyCount2 = getPropertiesNumber(agencyDto2);

                return Integer.compare(propertyCount2, propertyCount1);
            }
        });

        return agencyDtoList;
    }

    /**
     * This method retrives a list of employee DTOs associated
     * with a specific agency DTO.
     *
     * @param agencyDto
     * @return newEmployeeDtoList
     */
    public List<EmployeeDto> getEmployeesFromAgency(AgencyDto agencyDto) {
        List<EmployeeDto> employeeDtoList = getEmployeesDto();
        List<EmployeeDto> newEmployeeDtoList = new ArrayList<>();

        for (EmployeeDto employeeDto : employeeDtoList) {

            if (agencyDto.equals(agenciesMapper.toDto(employeeDto.getAgency()))) {

                newEmployeeDtoList.add(employeeDto);

            }
        }

        return newEmployeeDtoList;
    }

    /**
     * This method retrives a sorted, based on their names
     * in a case-insensitive manner, list of employees DTOs
     * associated with a specific agency DTO
     *
     * @param agencyDto
     * @return employeeDtoList
     */
    public List<EmployeeDto> getOrderEmployeeDtoList(AgencyDto agencyDto) {
        List<EmployeeDto> employeeDtoList = getEmployeesFromAgency(agencyDto);

        Collections.sort(employeeDtoList, new Comparator<EmployeeDto>() {
            @Override
            public int compare(EmployeeDto employeeDto1, EmployeeDto employeeDto2) {

                String name1 = employeeDto1.getName();

                String name2 = employeeDto2.getName();

                return name1.compareToIgnoreCase(name2);
            }
        });

        return employeeDtoList;
    }

    /**
     * This method claculates the total number
     * of properties associated with an agency DTO.
     *
     * @param agencyDto
     * @return contProperties
     */
    public int getPropertiesNumber(AgencyDto agencyDto) {
        int contProperties = 0;
        List<EmployeeDto> employeeDtoList = getEmployeesFromAgency(agencyDto);

        for (EmployeeDto employeeDto : employeeDtoList) {

            if (employeeDto.getRole().getName().equals("Agent")) {

                contProperties = contProperties + employeeDto.getProperties().size();

            }
        }

        return contProperties;
    }

    /**
     * This method diplays the necessary information about us13.
     */
    public void displayEmployeesToString() {
        List<AgencyDto> orderedAgencies = getOrderAgencyDtoList();

        for (AgencyDto agencyDto : orderedAgencies) {

            System.out.printf("Store: %s    Number of Property Listing: %d", agencyDto.getName(), getPropertiesNumber(agencyDto));

            List<EmployeeDto> orderedEmployees = getOrderEmployeeDtoList(agencyDto);

            for (EmployeeDto employeeDto : orderedEmployees) {

                System.out.println("- Employee: " + employeeDto.getName());

            }
            System.out.println();
        }
    }
}

