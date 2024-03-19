package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Person;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	private final List<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public void removeTransaction(Transaction transaction) {
		transactions.remove(transaction);
	}

	public List<Transaction> getAllTransactions() {
		return transactions;
	}

	public List<Transaction> getTransactionsByBuyer(Person buyer) {
		List<Transaction> buyerTransactions = new ArrayList<Transaction>();
		String email = buyer.getEmail();

		for (Transaction transaction : this.transactions) {
			if(transaction.getBuyer().getEmail().equals(email)) buyerTransactions.add(transaction);
		}

		return buyerTransactions;
	}

	public List<Transaction> getTransactionsByOwner(Person owner) {
		List<Transaction> ownerTransactions = new ArrayList<Transaction>();
		String email = owner.getEmail();

		for (Transaction transaction : this.transactions) {
			if(transaction.getOwner().getEmail().equals(email)) ownerTransactions.add(transaction);
		}

		return ownerTransactions;
	}

	public List<Transaction> getTransactionByProperty(Property property) {
		List<Transaction> propertyTransactions = new ArrayList<Transaction>();
		String address = property.getAddress();

		for (Transaction transaction : this.transactions) {
			if(transaction.getProperty().getAddress().equals(address)) propertyTransactions.add(transaction);
		}

		return propertyTransactions;
	}
}
