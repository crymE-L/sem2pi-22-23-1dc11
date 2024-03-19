package pt.ipp.isep.dei.esoft.project.console.utils;

import java.util.Random;

/**
 * This class exists to help us with some functions
 * that we use across all program
 *
 * @author Miguel Ferreira (1210701)
 */
public class Helpers {
	/**
	 * Empty input's checker
	 * Checks if input is empty
	 *
	 * @param value
	 * @return boolean
	 */
	public static boolean isEmpty(String value) {
		return value.trim().isEmpty();
	}

	public static boolean isValidPhoneNumber(String value) {

		return value.length() == 10;
	}

	public static boolean isValidEmail (String value) {
		return value.trim().contains("@");
	}

	public static boolean isValidVat (int value) {
		return Integer.toString(value).length() == 9;
	}

	public static boolean isValidPassport(int value) {

		return Integer.toString(value).length() == 8;
	}
}
