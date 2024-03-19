# US 001 

# 4. Tests 

**Test 1:** Test the property constructor 

    @Test
    public void testConstructor() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);
        assertEquals("Habitação luxuosa na ribeira", property.getName());
        assertEquals("Rua da Barrosa", property.getAddress());
        assertEquals(100, property.getArea());
        assertEquals(5.0f, property.getDistanceFromCenter());
        assertEquals(150000.0f, property.getPrice());
        assertEquals("Parish", property.getParish());
        assertEquals("City", property.getCity());
        assertEquals("State", property.getState());
        assertEquals(owner, property.getOwner());
    }
	

**Test 2:** Check that it is not possible to create an empty name

    @Test
    public void testSetName() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setName("Habitação luxuosa na Barrosa");
        assertEquals("Habitação luxuosa na Barrosa", property.getName());

        assertThrows(IllegalArgumentException.class, () -> property.setName(""));
    }

**Test 3:** Check that it is not possible to create an empty address

    @Test
    public void testSetAddress() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setAddress("Rua da Ribeira");
        assertEquals("Rua da Ribeira", property.getAddress());

        assertThrows(IllegalArgumentException.class, () -> property.setAddress(""));
    }

**Test 4:** Check that it is not possible to create an area, lower or equal to zero

    @Test
    public void testSetArea() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setArea(12);
        assertEquals(12, property.getArea());

        assertThrows(IllegalArgumentException.class, () -> property.setArea(0));
        assertThrows(IllegalArgumentException.class, () -> property.setArea(-5));
    }

**Test 5:** Check that it is not possible to create a distanceFromCenter, lower than zero

    @Test
    public void testSetDistanceFromCenter() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setDistanceFromCenter(12f);
        assertEquals(12f, property.getDistanceFromCenter());

        assertThrows(IllegalArgumentException.class, () -> property.setDistanceFromCenter(-1));
    }

**Test 6:** Check that it is not possible to create a price, lower or equal to zero 

    @Test
    public void testSetPrice() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setPrice(12f);
        assertEquals(12f, property.getPrice());

        assertThrows(IllegalArgumentException.class, () -> property.setPrice(-1f));
        assertThrows(IllegalArgumentException.class, () -> property.setPrice(0f));
    }

**Test 7:** Check that it is not possible to create an empty parish

    @Test
    public void testSetParish() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setParish("Parish Test");
        assertEquals("Parish Test", property.getParish());

        assertThrows(IllegalArgumentException.class, () -> property.setParish(""));
    }

**Test 8:** Check that it is not possible to create an empty city

    @Test
    public void testSetCity() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setCity("City Test");
        assertEquals("City Test", property.getCity());

        assertThrows(IllegalArgumentException.class, () -> property.setCity(""));
    }

**Test 9:** Check that it is not possible to create an empty state

    @Test
    public void testSetState() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setState("State Test");
        assertEquals("State Test", property.getState());

        assertThrows(IllegalArgumentException.class, () -> property.setState(""));
    }

**Test 10:** Check that it is not possible to create an empty owner

    @Test
    public void testSetOwner() {
        Person owner =  new Person("Diogo", "email@email.com", "11111111aaa", new Role("ADMIN", 4));
        Property property = new Property("Habitação luxuosa na ribeira","Rua da Barrosa", 100, 5.0f, 150000.0f, "Parish", "City", "State", owner);

        property.setOwner(new Person("Tobias", "tobias@email.com", "11111111aaa", new Role("ADMIN", 4)));
        assertEquals(new Person("Tobias", "tobias@email.com", "11111111aaa", new Role("ADMIN", 4)), property.getOwner());

        assertThrows(IllegalArgumentException.class, () -> property.setOwner(new Person("", "", "", new Role("", -1))));
        assertThrows(IllegalArgumentException.class, () -> property.setOwner(null));
    }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

## Class DisplayPropertiesController

```java
public createPropertyAndPutInRepository(String name, String address, int area, 
                                        float distanceFromCenter, float price, String parish,
                                        String city, String state, Person owner) 
                                        throws Exception, DataExistsException {
    
    Property newProperty = new Property(name, address, area, 
                    distanceFromCenter, price, parish, city, state, owner);

    propertyRepository.addProperty(newProperty);
}
```

# 6. Integration and Demo

# 7. Observations