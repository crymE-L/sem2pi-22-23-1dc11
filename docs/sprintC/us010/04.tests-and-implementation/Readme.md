# US 004

# 4. Tests

**Test 1:** Check that it is not possible to set parameters of the AgencyNetwork class with null values.

    @Test
    public void testSetPhoneWithEmptyString() {
		ArrayList<Agency> agencies = new ArrayList<Agency>() {
			{
				add(new Agency("Agency 1", 123456789, "Location", "general@agency.com", 9123456789L));
				add(new Agency("Agency 2", 123456789, "Location", "noreply@agency.com", 9123456799L));
			}
		};

		AgencyNetwork network = new AgencyNetwork("Network", "Location", "email@example.com", "123456789", agencies);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			network.setPhone("");
		});
		assertEquals( "Inválido.", exception.getMessage());
	}

*It is also recommended to organize this content by subsections.*

# 5. Construction (Implementation)


## Class SaleAnnouncementController

```java
    public TransactionRequest create(Person owner, Person buyer, Employee agent, float price, float commission, Property property) {
		TransactionRequest transactionRequest = new TransactionRequest(owner, buyer, agent, price, commission, false, property);
		repository.addRequest(transactionRequest);

		return transactionRequest;
	}
```


# 6. Integration and Demo


# 7. Observations



