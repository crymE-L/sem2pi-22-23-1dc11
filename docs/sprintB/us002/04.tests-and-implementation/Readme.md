# US 002

# 4. Tests

**Test 1:** This test checks if the full constructor of the Person class correctly initializes the name, email, password, and role fields of a Person object. It uses the assertEquals method to verify that the values of these fields are set correctly.

```java
@Test
public void testFullConstructor() {
	Role role = new Role("Admin", 1);
	Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

	assertEquals("Farusco", farusco.getName());
	assertEquals("farusco@silly.com", farusco.getEmail());
	assertEquals("123456789", farusco.getPassword());
	assertEquals(role, farusco.getRole());
}
```


**Test 2:** This Java test that checks if the "setEmail()" method of the Person class correctly throws an IllegalArgumentException when an empty string is passed as an argument.

```java
@Test
public void testSetEmail() {
	Role role = new Role("Admin", 1);
	Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

	assertThrows(IllegalArgumentException.class, () -> farusco.setEmail(""));
}
```

**Test 3:** After creating a property let's verify if an actor is valid, alongside with its role, when we're setting it as an owner.

```java
@Test
public void testSetOwner() {
	City city = new City("Avanca");
	District district = new District("Aveiro");
	State state = new State("State");

	Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
	Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, city, district, state, owner);

	Person owner2 = new Person("Tobias", "tobias@email.com", "11111111aaa", new Role("ADMIN", 4));

	property.setOwner(owner2);
	assertEquals(owner2, property.getOwner());

	assertThrows(IllegalArgumentException.class, () -> property.setOwner(new Person("", "", "", new Role("", -1))));
	assertThrows(IllegalArgumentException.class, () -> property.setOwner(null));
}
```

*It is also recommended to organize this content by subsections.*

# 5. Construction (Implementation)


## Class CreateTransactionRequestController

```java
public TransactionRequest createTransactionRequest(String owner, String buyer, float price, float commission, TransactionType transactionType) {
	/**
	 * Verify if the object parameters are not null
	 */
	if(transactionType == null) {
		throw new IllegalArgumentException("Invalid transaction type");
	}

	TransactionRequest transactionRequest = new TransactionRequest(owner, buyer, buyer, price, commission, false);

	return transactionRequest;
}
```


## Class CreateRegisterEmployeeController

```java
public EmployeeRepository createEmployee(String name, String email, String password, Role role, int passport, int vat, String address, long phone, Agency agency) throws Exception, DataExistsException{
	Employee newEmployee = new Employee(name, email, password, role, passport, vat, address, phone, agency);

	if (employeeRepository.getEmployeeByEmail(email) == null) {
		employeeRepository.addEmployee(newEmployee);

	} else {
		throw new DataExistsException(email);
	}

	return employeeRepository;
}
```

# 6. Integration and Demo



# 7. Observations
