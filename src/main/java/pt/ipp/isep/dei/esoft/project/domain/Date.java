package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves to build a date
 *
 * @author Gonçalo Silva (1220607)
 */
public class Date {

    /**
     * The day
     */
    private int day;

    /**
     * the month
     */
    private int month;

    /**
     * the year
     */
    private int year;

    /**
     * This constructor is made to create a date.
     * It only creates a date if it is valid.
     *
     * @param day
     * @param month
     * @param year
     */
    public Date (int day, int month, int year) {
        if (!isValidDate(day,month,year)) {
            throw new IllegalArgumentException("Invalid date.");
        }

		setDay(day);
		setMonth(month);
		setYear(year);
    }

    /**
     * The getter for the day
     *
     * @return int
     */
    public int getDay() {
        return day;
    }

    /**
     * the setter for the day
     * It only set a new date, if it is valid
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day.");
        }
    }

    /**
     * the getter for the month
     *
     * @return int
     */
    public int getMonth() {
        return month;
    }


    /**
     * The setter for the month
     * It only set a new month, if it is valid
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month.");
        }
    }

    /**
     * the getter for the year
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * The setter for the year
     * It only set a new year, if it is valid
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;

        if (year < 0) {
            throw new IllegalArgumentException("Invalid year.");
        }
    }

    /**
     * This method validates a date, and it
     * is used in the constructor
     *
     * @param day
     * @param month
     * @param year
     * @return boolean
     */
    public boolean isValidDate (int day, int month, int year) {
        boolean isLeapYear = false;

        if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
            isLeapYear = true;

            if (month == 2) {
                if (day < 1 || day > 29) {
                  return false;
                }
            }
        }

        List monthsWith31Days = new ArrayList<Integer>(){{
			add(1);
			add(3);
			add(5);
			add(7);
			add(8);
			add(10);
			add(12);
		}};

		if (month == 2 && !isLeapYear && (day < 1 || day > 28))
			return false;

		if(monthsWith31Days.contains(month)) {
			if (day < 1 || day > 31) return false;
		} else {
			if (day < 1 || day > 30) return false;
		}

        return true;
    }
}
