package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.domain.Time;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

	@Test
	public void testFullConstructor() {
		Time time = new Time(12, 10, 20);

		assertEquals(12, time.getHours());
		assertEquals(10, time.getMinutes());
		assertEquals(20, time.getSeconds());
	}

	@Test
	public void testHoursMinutesConstructor() {
		Time time = new Time(12, 10);

		assertEquals(12, time.getHours());
		assertEquals(10, time.getMinutes());
		assertEquals(0, time.getSeconds());
	}

	@Test
	public void testHoursConstructor() {
		Time time = new Time(12);

		assertEquals(12, time.getHours());
		assertEquals(0, time.getMinutes());
		assertEquals(0, time.getSeconds());
	}

	@Test
	public void testInvalidTime() {
		assertThrows(IllegalArgumentException.class, () -> new Time(12, 10, 89));
	}

	@Test
	public void setHours() {
		Time time = new Time(12, 10, 20);

		assertThrows(IllegalArgumentException.class, () -> time.setHours(66));
	}

	@Test
	public void setMinutes() {
		Time time = new Time(12, 10, 20);

		assertThrows(IllegalArgumentException.class, () -> time.setMinutes(90));
	}

	@Test
	public void setSeconds() {
		Time time = new Time(12, 10, 20);

		assertThrows(IllegalArgumentException.class, () -> time.setSeconds(100));
	}

	@Test
	public void testToString() {
		Time time = new Time(12, 10, 20);

		assertEquals("12:10:20", time.toString());
	}
}
