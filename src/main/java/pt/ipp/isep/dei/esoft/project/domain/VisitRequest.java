package pt.ipp.isep.dei.esoft.project.domain;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class serves the purpose
 * of defining a visit request
 * @author Gonçalo Silva (1220607)
 */
public class VisitRequest {

	/**
	 * The user
	 */
	private Person user;

	/**
	 * The agent
	 */
	private Employee agent;

	/**
	 * The property
	 */
	private Property property;

	/**
	 * The date
	 */
	private LocalDate date;

	/**
	 * The start time
	 */
	private LocalTime startTime;

	/**
	 * The end time
	 */
	private LocalTime endTime;

	/**
	 * The confirmation for the transaction
	 */
	private boolean willBuy;

	/**
	 * The constructor made to create the visit request
	 * This constructor contains all the parameters needed at once
	 * @param user
	 * @param agent
	 * @param property
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param willBuy
	 */
	public VisitRequest (Person user, Employee agent, Property property, LocalDate date, LocalTime startTime, LocalTime endTime, boolean willBuy) {
		setUser(user);
		setAgent(agent);
		setProperty(property);
		setDate(date);
		setStartTime(startTime);
		setEndTime(endTime);
		setWillBuy(willBuy);
	}

	/**
	 * The getter for the user
	 * @return Person
	 */
	public Person getUser() {
		return user;
	}

	/**
	 * The setter for the user
	 * @param user
	 */
	public void setUser(Person user) {
		this.user = user;
	}

	/**
	 * The getter for the agent
	 * @return Employee
	 */
	public Employee getAgent() {
		return agent;
	}

	/**
	 * The setter for the agent
	 * @param agent
	 */
	public void setAgent(Employee agent) {
		this.agent = agent;
	}

	/**
	 * The getter for the property
	 * @return Property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * the setter for the property
	 * @param property
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

	/**
	 * The getter for the date
	 * @return Date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * The setter for the date
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * The getter for the start time
	 * @return
	 */
	public LocalTime getStartTime() {
		return startTime;
	}

	/**
	 * The setter for the start time
	 * @param startTime
	 */
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * The getter for the end time
	 * @return
	 */
	public LocalTime getEndTime() {
		return endTime;
	}

	/**
	 * The setter for the end time
	 * @param endTime
	 */
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * The getter for the transaction
	 * @return boolean
	 */
	public boolean isWillBuy() {
		return willBuy;
	}

	/**
	 * the setter for the transaction
	 * @param willBuy
	 */
	public void setWillBuy(boolean willBuy) {
		this.willBuy = willBuy;
	}
}
