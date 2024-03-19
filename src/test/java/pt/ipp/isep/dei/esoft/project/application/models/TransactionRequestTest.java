package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.*;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionRequestTest {
    @Test
    public void testConstructor() {
		Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "1234567890", 12345678,
				123456789, "X 	STREET", agency);


        TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);

        assertEquals(owner, request.getOwner());
        assertEquals(buyer, request.getBuyer());
        assertEquals(agent, request.getAgent());
        assertEquals(150, request.getPrice());
        assertEquals(0.05f, request.getCommission());
        assertEquals(true, request.isAccepted());
    }

    @Test
    public void testSetOwner() {
		Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);

		Person owner2 = new Person("Outro tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

        TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);
        request.setOwner(owner2);
        assertEquals(owner2, request.getOwner());
        assertThrows(IllegalArgumentException.class, () -> request.setOwner(null));
    }

    @Test
    public void testSetBuyer() {
		Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);

		Person buyer2 = new Person("Outro Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

        TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);
        request.setBuyer(buyer2);
        assertEquals(buyer2, request.getBuyer());
    }

    @Test
    public void testSetAgent() {
		Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);

		Employee agent2 = new Employee("Outro Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);

        TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);
        request.setAgent(agent2);
        assertEquals(agent2, request.getAgent());
    }

    @Test
    public void testSetPrice() {
		Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);


		TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);
        request.setPrice(200);
        assertEquals(200, request.getPrice());
        assertThrows(IllegalArgumentException.class, () -> request.setCommission(-0.02f));
    }

    @Test
    public void testSetCommission() {
        Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);


		TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);

        request.setCommission(0.02f);
        assertEquals(0.02f, request.getCommission());
        assertThrows(IllegalArgumentException.class, () -> request.setCommission(-0.02f));
    }

    @Test
    public void testSetAccepted() {
        Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);


		TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);

        request.setAccepted(false);
        assertEquals(false, request.isAccepted());
    }

    @Test
    public void testToString() {
        Agency agency = new Agency("Agency", 123456789, "Location", "general@agency.com", "9126237819", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

		Person owner = new Person("Tobias", "tobias@email.com", "AAAbcde12", new Role("User", 4), "1234567890");
		Person buyer = new Person("Primo", "primo@email.com", "AAAbcde12", new Role("User", 4), "1234567890");

		Employee agent = new Employee("Elias", "elias@email.com", "AAAbcde12", new Role("Agent", 2), "9162678111", 12345678,
				123456789, "X 	STREET", agency);

		TransactionRequest request = new TransactionRequest(owner, buyer, agent, 150, 0.05f, true);

        assertEquals("The transaction was accepted", request.toString());
    }
}
