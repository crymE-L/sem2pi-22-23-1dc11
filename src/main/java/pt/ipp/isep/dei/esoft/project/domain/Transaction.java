package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.console.utils.Helpers;

/**
 * This class exists to mimic a transaction of a
 * real estate piece between two users
 *
 * @author Miguel Ferreira (1210701)
 */
public class Transaction {
	/**
	 * The property's owner
	 */
	private Person owner;

	/**
	 * The property's buyer
	 */
	private Person buyer;

	/**
	 * The transaction amount
	 */
	private float price;

	/**
	 * The property being transacted
	 */
	private Property property;

	/**
	 * The validation if whether the transaction was approved or not
	 */
	private boolean approved;

	/**
	 * The control variable to see if the transaction was reviewed or not
	 */
	private boolean reviewed;

	/**
	 * This constructor allows us to initiate the Transaction object
	 * that can be used on the software to sell or lease a piece
	 * of real estate
	 *
	 * @param owner
	 * @param buyer
	 * @param price
	 * @param property
	 */
	public Transaction(Person owner, Person buyer, float price, Property property) {
		setOwner(owner);
		setBuyer(buyer);
		setPrice(price);
		setProperty(property);
		setApproved(false);
		setReviewed(false);
	}

	/**
	 * The getter for the property owner
	 *
	 * @return Person
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * The setter for the property owner
	 *
	 * @param owner
	 */
	public void setOwner(Person owner) {
		if(owner == null)
			throw new IllegalArgumentException("Invalid owner.");

		this.owner = owner;
	}

	/**
	 * The getter for the property buyer
	 *
	 * @return Person
	 */
	public Person getBuyer() {
		return buyer;
	}

	/**
	 * The setter for the property buyer
	 *
	 * @param buyer
	 */
	public void setBuyer(Person buyer) {
		if (buyer == null)
			throw new IllegalArgumentException("Invalid buyer.");

		this.buyer = buyer;
	}

	/**
	 * The getter for the transaction amount
	 *
	 * @return float
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * The setter for the transaction amount
	 *
	 * @param price
	 */
	public void setPrice(float price) {
		if(price <= 0)
			throw new IllegalArgumentException("Invalid price.");

		this.price = price;
	}

	/**
	 * The getter for the transacted property
	 *
	 * @return Property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * The setter for the transacted property
	 *
	 * @param property
	 */
	public void setProperty(Property property) {
		if(property == null)
			throw new IllegalArgumentException("Invalid property.");

		this.property = property;
	}

	/**
	 * The getter for the approval of the
	 * transaction
	 *
	 * @return boolean
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * The setter for the approving of the property
	 *
	 * @param approved
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	/**
	 * The getter for the reviewed variable
	 *
	 * @return boolean
	 */
	public boolean wasReviewed() {
		return reviewed;
	}

	/**
	 * The setter for the reviewed variable
	 *
	 * @param reviewed
	 */
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
}
