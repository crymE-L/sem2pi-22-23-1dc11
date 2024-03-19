
package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VisitRequestTest {

    @Test
    public void testConstructor() {
        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119",  99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));

        Property property = new Property("Habitation at Porto", "Egas",69,420f,99f, new City("Avanca"), new District("Aveiro"), new State(
				"Ohio"), user, Property.BusinessType.RENT, new ArrayList<String>());

        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);


        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);

        assertEquals(user, visitRequest.getUser());
        assertEquals(agent, visitRequest.getAgent());
        assertEquals(property, visitRequest.getProperty());
        assertEquals(date, visitRequest.getDate());
        assertEquals(startTime, visitRequest.getStartTime());
        assertEquals(endTime, visitRequest.getEndTime());
        assertEquals(true, visitRequest.isWillBuy());
    }


    @Test
    void setUser() {
        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);
        assertThrows(IllegalArgumentException.class, () -> visitRequest.setUser(new Person("","","1", new Role("",-1), "12345678901")));
    }

    @Test
    void setAgent() {
        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);

        assertThrows(IllegalArgumentException.class, () -> visitRequest.setAgent(new Employee("","-1","1",new Role("",-1), "", 1,1,"", new Agency("",1,"","","9", new AgencyNetwork("", "", "7", "123")))));
    }

    @Test
    void setProperty() {

        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user,  Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);

        assertThrows(IllegalArgumentException.class, () -> visitRequest.setProperty(new Property("Habitation at Porto", "Egas",69,420f,99f, new City(""), new District(""), new State(""), user, Property.BusinessType.RENT,
						new ArrayList<String>())));
    }

    @Test
    void setDate() {

        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user, Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);

        assertThrows(DateTimeException.class, () -> visitRequest.setDate(LocalDate.of(39, 15, 1)));
    }

    @Test
    void setTime() {
        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user,  Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);
        assertThrows(DateTimeException.class, () -> visitRequest.setStartTime(LocalTime.of(-1, -12)));
    }


    void setWillBuy() {
        Person user = new Person("Farusco","malaquias@sigma.com", "AAAbcde12", new Role("migas",1), "1234567890");
        Employee agent = new Employee("Malaquias","farusco@silly.com",
						"AAAbcde12", new Role("migas",1), "9119119119", 99999999,123456789,"Egas", new Agency("Mercadona",123456789,"Avanca","arroz@massa.com","9191919119", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890")));
        Property property = new Property("Habitation at Porto", "Egas", 69, 420f, 99f, new City("Avanca"),
				new District("Aveiro"), new State(
						"Ohio"),
				user,  Property.BusinessType.RENT, new ArrayList<String>());
        LocalDate date = LocalDate.of(2,2,2);
        LocalTime startTime = LocalTime.of(12, 2);
        LocalTime endTime = LocalTime.of(13,0);

        VisitRequest visitRequest = new VisitRequest(user, agent, property, date, startTime, endTime, true);

        assertThrows(IllegalArgumentException.class, () -> visitRequest.setWillBuy(true));
    }


}
