package pt.ipp.isep.dei.esoft.project.application.models;

import org.junit.jupiter.api.Test;

import pt.ipp.isep.dei.esoft.project.console.utils.FileReadingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

public class FileReadingSytemTest {
	@Test
	public void testContructor() {
		FileReadingSystem fileReading = null;

		try {
			fileReading = new FileReadingSystem("file.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		assertEquals("file.csv", fileReading.getFilename());
		assertEquals(3, fileReading.getLines());
		assertTrue(fileReading.getFile() instanceof File);
	}
}
