package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.mappers.AgenciesMapper;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.AgencyDto;
import pt.ipp.isep.dei.esoft.project.mappers.Dto.EmployeeDto;
import pt.ipp.isep.dei.esoft.project.mappers.EmployeesMapper;
import pt.ipp.isep.dei.esoft.project.repository.AgencyNetworkRepository;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import static pt.ipp.isep.dei.esoft.project.domain.Property.BusinessType.BUY;

class DisplayEmployeesControllerTest {

    private DisplayEmployeesController displayEmployeesController;
    private EmployeeRepository employeeRepository;
    private AgencyNetworkRepository agencyNetworkRepository;
    private AgencyRepository agencyRepository;

    @Test
    void testGetAgenciesFromAgencyNetwork() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency);
        AgencyDto agencyDto = AgenciesMapper.toDto(agency);

        List<AgencyDto> result = displayEmployeesController.getAgenciesFromAgencyNetwork();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(agencyDto, result.get(0));
    }

    @Test
    void testGetUserAgencyNetwork() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        AgencyNetwork agencyNetwork = new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890");
        agencyNetwork.setManager(new Employee("Manager", "manager@gmail.com", "1234567890LLLL", new Role("Manager", 2), "1234567890", 12345678, 123456789, "Street manager", new Agency("managerAgency", 123456789, "Street managerAgency", "managerAgency@gmail.com", "1234567890", new AgencyNetwork("managerAgencyNetwork", "Street managerAgencynetwork", "manageragencynetwork@gmail.com", "1234567890"))));
        agencyNetworkRepository.addAgencyNetwork(agencyNetwork);

        AgencyNetwork result = displayEmployeesController.getUserAgencyNetwork();

        Assertions.assertEquals(agencyNetwork, result);
    }

    @Test
    void testGetOrderAgencyDtoList() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency1 = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        Agency agency2 = new Agency("agencyDto2", 123456789, "Street agencyDto2", "agencyDto2@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency1.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agency2.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency1);
        agencyRepository.addAgency(agency2);
        AgencyDto agencyDto1 = AgenciesMapper.toDto(agency1);
        AgencyDto agencyDto2 = AgenciesMapper.toDto(agency2);

        List<AgencyDto> result = displayEmployeesController.getOrderAgencyDtoList();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(agencyDto1, result.get(0));
        Assertions.assertEquals(agencyDto2, result.get(1));
    }

    @Test
    void testGetEmployeesFromAgency() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency);
        AgencyDto agencyDto = AgenciesMapper.toDto(agency);

        Employee employee = new Employee("employee1", "employee1@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        employee.setAgency(agency);
        employeeRepository.addEmployee(employee);
        EmployeeDto employeeDto = EmployeesMapper.toDto(employee);

        List<EmployeeDto> result = displayEmployeesController.getEmployeesFromAgency(agencyDto);

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(employeeDto, result.get(0));
    }

    @Test
    void testGetOrderEmployeeDtoList() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency);
        AgencyDto agencyDto = AgenciesMapper.toDto(agency);

        Employee employee1 = new Employee("employee1", "employee1@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        Employee employee2 = new Employee("employee2", "employee2@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        employee1.setAgency(agency);
        employee2.setAgency(agency);
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        EmployeeDto employeeDto1 = EmployeesMapper.toDto(employee1);
        EmployeeDto employeeDto2 = EmployeesMapper.toDto(employee2);

        List<EmployeeDto> result = displayEmployeesController.getOrderEmployeeDtoList(agencyDto);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(employeeDto1, result.get(0));
        Assertions.assertEquals(employeeDto2, result.get(1));
    }

    @Test
    void testGetPropertiesNumber() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency);
        AgencyDto agencyDto = AgenciesMapper.toDto(agency);

        Employee employee1 = new Employee("employee1", "employee1@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        Employee employee2 = new Employee("employee2", "employee2@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        employee1.setAgency(agency);
        employee2.setAgency(agency);
        employee1.setRole(new Role("Agent", 3));
        employee2.setRole(new Role("Not an Agent", 2));
        employee1.setProperties(new ArrayList<>());
        employee2.setProperties(new ArrayList<>());
        employee1.getProperties().add(new Property("property1", "Street property1", 1, 1f, 1, new City("cityProperty1"), new District("districtProperty1"), new State("stateProperty1"), new Person("ownerProperty1", "ownerproperty1@gmail.com", "12345686493", new Role("Owner", 1)), BUY, new ArrayList<>()));
        employee1.getProperties().add(new Property("property1", "Street property1", 1, 1f, 1, new City("cityProperty1"), new District("districtProperty1"), new State("stateProperty1"), new Person("ownerProperty1", "ownerproperty1@gmail.com", "12345686493", new Role("Owner", 1)), BUY, new ArrayList<>()));
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        int result = displayEmployeesController.getPropertiesNumber(agencyDto);

        Assertions.assertEquals(2, result);
    }

    @Test
    void testDisplayEmployeesToString() {
        employeeRepository = new EmployeeRepository();
        agencyNetworkRepository = new AgencyNetworkRepository();
        agencyRepository = new AgencyRepository();
        displayEmployeesController = new DisplayEmployeesController(employeeRepository, agencyNetworkRepository, agencyRepository);

        Agency agency = new Agency("agencyDto1", 123456789, "Street agencyDto1", "agencyDto1@gmail.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Street agencyNetwork1", "agencyNetwork1@gmail.com", "1234567890"));
        agency.setAgencyNetwork(displayEmployeesController.getUserAgencyNetwork());
        agencyRepository.addAgency(agency);
        AgencyDto agencyDto = AgenciesMapper.toDto(agency);

        Employee employee1 = new Employee("employee1", "employee1@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        Employee employee2 = new Employee("employee2", "employee2@gmail.com", "1234567890LLLL", new Role("Employee", 2), "1234567890", 12345678, 123456789, "Street employee1", agency);
        employee1.setAgency(agency);
        employee2.setAgency(agency);
        employee1.setRole(new Role("Agent", 3));
        employee2.setRole(new Role("Not an Agent", 2));
        employee1.setProperties(new ArrayList<>());
        employee2.setProperties(new ArrayList<>());
        employee1.getProperties().add(new Property("property1", "Street property1", 1, 1f, 1, new City("cityProperty1"), new District("districtProperty1"), new State("stateProperty1"), new Person("ownerProperty1", "ownerproperty1@gmail.com", "12345686493", new Role("Owner", 1)), BUY, new ArrayList<>()));
        employee1.getProperties().add(new Property("property1", "Street property1", 1, 1f, 1, new City("cityProperty1"), new District("districtProperty1"), new State("stateProperty1"), new Person("ownerProperty1", "ownerproperty1@gmail.com", "12345686493", new Role("Owner", 1)), BUY, new ArrayList<>()));
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);

        displayEmployeesController.displayEmployeesToString();

        // Assert
        // Verifique a saída no console manualmente
    }
}
