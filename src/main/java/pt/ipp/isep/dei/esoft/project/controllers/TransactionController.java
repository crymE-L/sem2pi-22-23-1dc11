package pt.ipp.isep.dei.esoft.project.controllers;

import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Transaction;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TransactionRepository;

public class TransactionController {
	final TransactionRepository repository = Repositories.getInstance().getTransactionsRepository();

	public Transaction create(Person owner, Person buyer, float price, Property property) throws Exception {
		Transaction transaction = new Transaction(owner, buyer, price, property);

		if(this.hasPreviousRequest(property, buyer)) throw new Exception("You can only make one request at a time. Wait for it to be reviewed");

		repository.addTransaction(transaction);

		return transaction;
	}

	/**
	 * Want to check if there's another transaction
	 * with the same amount? We gotcha!
	 *
	 * @param property
	 * @param price
	 * @return boolean
	 */
	public boolean hasTransactionWithAmount(Property property, float price) {
		for(Transaction transaction : repository.getTransactionByProperty(property)) {
			if(transaction.getPrice() == price) return true;
		}

		return false;
	}

	/**
	 * In this function we're going to verify if
	 * the buyer has any previous pending
	 * request, as it can only have
	 * one request at a time
	 * for each property
	 *
	 * @param buyer
	 * @return boolean
	 */
	private boolean hasPreviousRequest(Property property, Person buyer) {
		for(Transaction transaction : repository.getTransactionsByBuyer(buyer)) {
			Property transactionProperty = transaction.getProperty();
			String address = transactionProperty.getAddress();

			if(address.equals(property.getAddress()) && !transaction.wasReviewed()) return true;
		}

		return false;
	}
}
