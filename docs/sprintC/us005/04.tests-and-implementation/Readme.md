# US 005

# 4. Tests 

**Test 1:** Test the agency constructor 

	@Test
    public void testConstructor() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        assertEquals("Agency One", agency.getName());
        assertEquals(123456789, agency.getVat());
        assertEquals("Porto", agency.getLocation());
        assertEquals("agencyone@example.com", agency.getEmail());
        assertEquals(1234567899L, agency.getPhone());
    }
	

**Test 2:** Check that it is not possible to create an empty agency name 

	@Test
    public void testSetName() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        agency.setName("New Agency Name");
        assertEquals("New Agency Name", agency.getName());
        assertThrows(IllegalArgumentException.class, () -> agency.setName(""));
    }

**Test 3:** Check that is not possible to create an empty agency address

    @Test
    public void testSetAddress() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        assertThrows(IllegalArgumentException.class, () -> agency.setLocation(""));
    }

**Test 4:** Check that is not possible to create a wrong email, empty or without the "@"

    @Test
    public void testSetEmail() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        agency.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", agency.getEmail());
        assertThrows(IllegalArgumentException.class, () -> agency.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> agency.setEmail("invalidEmail"));
    }

**Test 5:** Check that is not possible to create a phone number whithout more or less than 10 characters

    @Test
    public void testSetPhone() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        agency.setPhone(9876543219L);
        assertEquals(9876543219L, agency.getPhone());
        assertThrows(IllegalArgumentException.class, () -> agency.setPhone(123));
    }

**Test 6:** Check that is not possible to create a vat number without more or less than 9 characters

    @Test
    public void testSetVat() {
        Agency agency = new Agency("Agency One", 123456789, "Porto", "agencyone@example.com", 1234567899L);
        agency.setVat(987654321);
        assertEquals(987654321, agency.getVat());
        assertThrows(IllegalArgumentException.class, () -> agency.setVat(123));
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class create an agency and put it in the agency repository

```java
public AgencyRepository createAgencyAndPutInRepository(String designation, String State, String district, String city, String email, long phoneNumber, int vat, String address) throws Exception, DataExistsException {
        Agency newAgency = new Agency(designation, vat, address, email, phoneNumber);

        if (agencyRepository.getAgencyByAddress(address) == null) {
        agencyRepository.addAgency(newAgency);

        } else {
        throw new DataExistsException(designation);
        }

        return agencyRepository;
        }
```

# 6. Integration and Demo 

* 

# 7. Observations








