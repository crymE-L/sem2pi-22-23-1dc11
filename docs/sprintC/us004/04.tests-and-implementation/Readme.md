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
	

**Test 2:** Check that the getters in the Agency Network class are working. 

		@Test
	public void testGetters() {
		ArrayList<Agency> agencies = new ArrayList<Agency>() {
			{
				add(new Agency("Agency 1", 123456789, "Location", "general@agency.com", 9123456789L));
				add(new Agency("Agency 2", 123456789, "Location", "noreply@agency.com", 9123456799L));
			}
		};

		AgencyNetwork network = new AgencyNetwork("Network", "Location", "email@example.com", "123456789", agencies);

		assertEquals("Network", network.getName());
		assertEquals("Location", network.getAddress());
		assertEquals("email@example.com", network.getEmail());
		assertEquals("123456789", network.getPhone());
		assertEquals(agencies, network.getAgencies());
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class AgencyNetworkController 

```java
    public AgencyNetwork createAgencyNetwork(String name, String location, String email, String phone, String[] agencies) {
        if (Helpers.isEmpty(name) || Helpers.isEmpty(location) || Helpers.isEmpty(email) || Helpers.isEmpty(phone)) {
        throw new IllegalArgumentException("Invalid input.");
        }

        AgencyNetwork newNetwork = new AgencyNetwork(name, location, email, phone, agencies);
        // add newNetwork to a list of agency networks

        return newNetwork;
        }
```


# 6. Integration and Demo 


# 7. Observations

    

