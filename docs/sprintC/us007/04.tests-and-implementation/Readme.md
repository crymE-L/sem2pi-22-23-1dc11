# US 007

# 4. Tests 

**Test 1:** Test the user constructor 

	@Test
	public void testConstructor() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

		assertEquals("Farusco", farusco.getName());
		assertEquals("farusco@silly.com", farusco.getEmail());
		assertEquals("123456789", farusco.getPassword());
		assertEquals(role, farusco.getRole());
	}
	

**Test 2:** Check that it is not possible to create an empty username 

	@Test
	public void testSetName() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

		assertThrows(IllegalArgumentException.class, () -> farusco.setName(""));
	}

**Test 3:** Check that is not possible to create a wrong email, empty or without the "@"

    @Test
	public void testSetEmail() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

		assertThrows(IllegalArgumentException.class, () -> farusco.setEmail(""));
	}

**Test 4:** Check that is not possible to create an empty password

	@Test
	public void testSetPassword() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

		assertThrows(IllegalArgumentException.class, () -> farusco.setPassword(""));
	}

**Test 5:** Check that is not possible to create a password whith less than 8 characters

    @Test
	public void testSetWeakPassword() {
		Role role = new Role("Admin", 1);
		Person farusco = new Person("Farusco", "farusco@silly.com", "123456789", role);

		assertThrows(IllegalArgumentException.class, () -> farusco.setPassword("1234567"));
	}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class User/Person with user role

```java 
public Person(String name, String email, String password, Role role) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setRole(role);
	}
```

# 6. Integration and Demo 

* 


# 7. Observations






