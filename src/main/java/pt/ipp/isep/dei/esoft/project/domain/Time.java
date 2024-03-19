package pt.ipp.isep.dei.esoft.project.domain;

/**
 * This class exists to represent a real time
 * in hours minutes and seconds
 *
 * @author Miguel Ferreira (1210701)
 */
public class Time {
	/**
	 * The hours representation
	 */
	private int hours;

	/**
	 * The minutes representation
	 */
	private int minutes;

	/**
	 * The seconds representation
	 */
	private int seconds;

	/**
	 * This constructor allows the programmer to create a time
	 * passing all the parameters as he wants
	 *
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public Time(int hours, int minutes, int seconds) {
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	/**
	 * This constructor allows the programmer to
	 * create a time with the seconds defaulted to 0
	 *
	 * @param hours
	 * @param minutes
	 */
	public Time(int hours, int minutes) {
		setHours(hours);
		setMinutes(minutes);

		setSeconds(0);
	}

	/**
	 * This constructor allows the programmer to create
	 * a time with the minutes and seconds defaulted to 0
	 *
	 * @param hours
	 */
	public Time(int hours) {
		setHours(hours);

		setMinutes(0);
		setSeconds(0);
	}

	/**
	 * The getter for the time's hours
	 *
	 * @return int
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * The setter for the time's hours.
	 * The hours must be between 0 and 23
	 *
	 * @param hours
	 */
	public void setHours(int hours) {
		if (hours < 0 || hours > 23)
			throw new IllegalArgumentException("Invalid hours.");

		this.hours = hours;
	}

	/**
	 * The getter for the time's minutes
	 *
	 * @return int
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * The setter for the time's minutes.
	 * The minutes must be between 0 and 59
	 *
	 * @param minutes
	 */
	public void setMinutes(int minutes) {
		if (minutes < 0 || minutes > 59)
			throw new IllegalArgumentException("Invalid minutes.");

		this.minutes = minutes;
	}

	/**
	 * The getter for the time's seconds
	 *
	 * @return int
	 */
	public int getSeconds() {
		return seconds;
	}

	/**
	 * The setter for the time's seconds
	 * The seconds must be between 0 and 59
	 *
	 * @param seconds
	 */
	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException("Invalid seconds.");

		this.seconds = seconds;
	}

	/**
	 * This method allows the programmer to receive
	 * the time in the following format
	 *
	 * > 12:05:25
	 *
	 * @return String
	 */
	public String toString() {
		return String.format("%d:%d:%d", this.hours, this.minutes, this.seconds);
	}
}
