package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {


    @Test
    public void testFullConstructor() {
        Date date = new Date(20, 4, 2023);

        assertEquals(20, date.getDay());
        assertEquals(4, date.getMonth());
        assertEquals(2023, date.getYear());
    }
    @Test
    void setDay() {
        Date date = new Date(20, 4, 2023);

        assertThrows(IllegalArgumentException.class, () -> date.setDay(43));
    }

    @Test
    void setMonth() {
        Date date = new Date(20, 4, 2023);

        assertThrows(IllegalArgumentException.class, () -> date.setMonth(13));
    }

    @Test
    void setYear() {
        Date date = new Date(20, 4, 2023);

        assertThrows(IllegalArgumentException.class, () -> date.setYear(-1));
    }

    @Test
    void isValidDate() {
        Date date = new Date(1,1,1);

        assertTrue(date.isValidDate(1, 1, 2020));  // Normal year
        assertTrue(date.isValidDate(29, 2, 2020)); // Leap year
        assertTrue(date.isValidDate(31, 12, 2023)); // Last day of the year

        // Invalid dates
        assertFalse(date.isValidDate(0, 1, 2022)); // Invalid day
        assertFalse(date.isValidDate(32, 1, 2022)); // Invalid day
        assertFalse(date.isValidDate(29, 2, 2021)); // Invalid day for non-leap year
        assertFalse(date.isValidDate(30, 2, 2020)); // Invalid day for February
        assertFalse(date.isValidDate(31, 4, 2022)); // Invalid day for April
    }


}
