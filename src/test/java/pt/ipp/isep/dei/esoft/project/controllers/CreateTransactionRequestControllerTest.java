package pt.ipp.isep.dei.esoft.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRequestRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

public class CreateTransactionRequestControllerTest {

    private CreateTransactionRequestController controller;
    private AnnouncementRequestRepository requestRepo;

    @BeforeEach
    public void setUp() {
        requestRepo = Repositories.getInstance().getRequestsRepository();
        controller = new CreateTransactionRequestController();
    }

    @Test
    public void createTransactionRequest_ValidInput_Success() {
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "9876543219", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        City city = new City("Baião");
        District district = new District("Gaia");
        State state = new State("State");
        Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4));
        Person Owner = new Person("Tio", "tio@email.com", "AJJbade30", new Role("Owner", 3));

        Employee employee = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", new Role("Agent",3), "9876543219",
                12345678, 123456789, "123 Main St", agency);
        float price = 1000.0f;
        float commission = 100.0f;

        TransactionRequest request = controller.createTransactionRequest(Owner, buyer,  employee, price, commission, null);

        Assertions.assertNotNull(request);
        Assertions.assertEquals(Owner, request.getOwner());
        Assertions.assertEquals(buyer, request.getBuyer());
        Assertions.assertEquals(employee, request.getAgent());
        Assertions.assertEquals(price, request.getPrice(), 0.001);
        Assertions.assertEquals(commission, request.getCommission(), 0.001);

    }

    @Test
    public void createTransactionRequest_NullInput_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.createTransactionRequest(null, null, null, 0.0f, 0.0f, null);
        });
    }

}
