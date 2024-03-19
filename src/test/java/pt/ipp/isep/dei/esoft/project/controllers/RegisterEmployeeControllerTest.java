package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyNetwork;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.exceptions.DataExistsException;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

class RegisterEmployeeControllerTest {
    private String name = "Farusco";
    private String email = "farusco@example.com";
    private String password = "ABC32dd";
    private Role role = new Role("Employee",3);
    private int passport = 12345678;
    private int vat = 111111111;
    private String adress = "123 Main St";
    private String phone = "1234567899";
    private Agency agency = new Agency("Farusco Corp",123345678,"132 Main St","farusco@corp.com","1234567899", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private RegisterEmployeeController controller = new RegisterEmployeeController(employeeRepository);

    @Test
    void createEmployee() {
		controller.createEmployee(name, email, password, role, passport, vat, adress, phone, agency);
        //Act
        /*try {
            controller.createEmployee(name,email,password,role,passport,vat,adress,phone,agency);
        } catch (Exception | DataExistsException e) {
            fail("Exception thrown");
        }*/

        assertTrue(employeeRepository.getAllEmployee().size() == 1);
        assertEquals(employeeRepository.getAllEmployee().get(0).getName(), name);
        assertEquals(employeeRepository.getAllEmployee().get(0).getEmail(), email);
        assertEquals(employeeRepository.getAllEmployee().get(0).getPassword(), password);
        assertEquals(employeeRepository.getAllEmployee().get(0).getRole(), role);
        assertEquals(employeeRepository.getAllEmployee().get(0).getPassport(), passport);
        assertEquals(employeeRepository.getAllEmployee().get(0).getVat(), vat);
        assertEquals(employeeRepository.getAllEmployee().get(0).getAddress(), adress);
        assertEquals(employeeRepository.getAllEmployee().get(0).getPhoneNumber(), phone);
        assertEquals(employeeRepository.getAllEmployee().get(0).getAgency(), agency);

    }
    @Test
    void testRegisterEmployee_DataExistsException(){
        controller.createEmployee(name, email, password, role, passport, vat, adress, phone, agency);

        try {
            controller.createEmployee(name,email,password,role,passport,vat,adress,phone,agency);
        } catch (Exception e){
            assertEquals(e.getMessage(), "Employee already exists");
        }
    }
}
