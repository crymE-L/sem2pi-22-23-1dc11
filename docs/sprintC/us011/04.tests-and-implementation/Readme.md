# US 011

# 4. Tests 

**Test 1:** Test the Employee constructor 

    @Test
	public void testConstructor() {
		assertEquals("John Doe", employee.getName());
		assertEquals("john.doe@example.com", employee.getEmail());
		assertEquals("password", employee.getPassword());
		assertEquals(new Role("ADMIN", 4), employee.getRole());
		assertEquals(12345678, employee.getPassport());
		assertEquals(123456789, employee.getVat());
		assertEquals("123 Main St", employee.getAddress());
		assertEquals(9876543219L, employee.getPhone());
		assertEquals(new Agency("Agency Name", 123456789, "Porto", "email@email.com", 9876543219L), employee.getAgency());
	}
	

**Test 2:** Check that it is not possible to create a passport with more tha 8 digits. 

    @Test
	public void testSetPassport() {
		assertThrows(IllegalArgumentException.class, () -> employee.setPassport(1234));
		assertThrows(IllegalArgumentException.class, () -> employee.setPassport(123456789));
		employee.setPassport(98765432);
		assertEquals(98765432, employee.getPassport());
	}

**Test 3:** Check that it is not possible to create a vat with more tha 9 digits.

    @Test
	public void testSetVat() {
        assertThrows(IllegalArgumentException.class, () -> employee.setVat(12345678));
        assertThrows(IllegalArgumentException.class, () -> employee.setVat(1234567890));
        employee.setVat(987654321);
        assertEquals(987654321, employee.getVat());
    }

**Test 4:** Check that it is not possible to create an empty adress.

    @Test
	public void testSetAddress() {
		assertThrows(IllegalArgumentException.class, () -> employee.setAddress(""));
		employee.setAddress("456 Oak St");
		assertEquals("456 Oak St", employee.getAddress());
	}

**Test 4:** Check that it is not possible to create a phone number with more than 10 digits.

    @Test
	public void testSetPhone() {
		assertThrows(IllegalArgumentException.class, () -> employee.setPhone(123456789L));
		assertThrows(IllegalArgumentException.class, () -> employee.setPhone(12345678909L));
		employee.setPhone(9876543219L);
		assertEquals(9876543219L, employee.getPhone());
	}

**Test 5:** Check that it is possible to create an instance of the Agency class with the correct values.
    
    @Test
	public void testSetAgency() {
		Agency newAgency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", 1234567899L);
		employee.setAgency(newAgency);
		assertEquals(newAgency, employee.getAgency());
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class CreateTaskController 

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


## Class Organization

```java

```

# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





