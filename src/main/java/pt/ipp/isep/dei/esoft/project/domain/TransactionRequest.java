package pt.ipp.isep.dei.esoft.project.domain;

/**
 * This class serves the purpose of
 * representing a request from each
 * transaction involving any property
 * made inside the application.
 *
 * @author Gustavo Lima (1221349)
 */
public class TransactionRequest {

    /**
     * The owner of the transaction's request
     */
    private Person owner;

    /**
     * The buyer of the transaction's request
     */
    private Person buyer;

    /**
     * The agent of the transaction's request
     */
    private Employee agent;

    /**
     * The price of the transaction's request
     */
    private float price;

    /**
     * The commission of the transaction's request
     */
    private float commission;

    /**
     * The state of the transaction's request
     */
    private boolean accepted;

	private Property property;

	/** Builds an object of TransactionRequest
     * receiving the owner, buyer, agent, price
     * commission and state (accepted)
     *
     * @param owner
     * @param buyer
     * @param agent
     * @param price
     * @param commission
     * @param accepted
     */
    public TransactionRequest(Person owner, Person buyer, Employee agent, float price, float commission, boolean accepted, Property property) {
        setOwner(owner);
        setBuyer(buyer);
        setAgent(agent);
        setPrice(price);
        setCommission(commission);
        setAccepted(accepted);
		setProperty(property);
    }

    /**
     * The getter for the owner
     *
     * @return Person
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * The setter for the owner
     *
     * @param owner
     */
    public void setOwner(Person owner) {
        if(owner == null) throw new IllegalArgumentException("Invalid owner.");

        this.owner = owner;
    }

    /** The getter for the buyer
     *
     * @return Person
     */
    public Person getBuyer() {
        return buyer;
    }

    /** The setter for the buyer
     *
     * @param buyer
     */
    public void setBuyer(Person buyer) {
		this.buyer = buyer;
    }

    /**
	 * The getter for the agent
	 *
	 * @return Employee
	 */
    public Employee getAgent() {
        return agent;
    }

    /** The setter for the agent
     *
     * @param agent
     */
    public void setAgent(Employee agent) {
		this.agent = agent;
    }

    /** The getter for the price
     *
     * @return float
     */
    public float getPrice() {
        return price;
    }

    /** The setter for the price
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
        if(price < 0) throw new IllegalArgumentException("Invalid price.");
    }

    /** The getter for the commission
     *
     * @return float
     */
    public float getCommission() {
        return commission;
    }

    /** The setter for the commission
     *
     * @param commission
     */
    public void setCommission(float commission) {
        this.commission = commission;
        if(commission < 0) throw new IllegalArgumentException("Invalid commission.");
    }

    /** The getter for the accepted
     *
     * @return boolean
     */
    public boolean isAccepted() {
        return accepted;
    }

    /** The setter for the accepted
     *
     * @param accepted
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

	/**
	 * The getter for the property
	 *
	 * @return Property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * The setter for the property
	 *
	 * @param property
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

    /** The textual description of the transaction
     *
     * @return String
     */
    @Override
    public String toString() {
		return accepted ?
				String.format("The transaction was accepted") :
				String.format("The transaction was not accepted");
	}


}
