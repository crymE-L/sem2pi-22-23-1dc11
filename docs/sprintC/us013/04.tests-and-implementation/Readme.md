# US 013

# 4. Tests 

**Test 1:** Test the toDto employee class

	@Test
    public void testToDto() {
        employeeRepository = new EmployeeRepository();
        employeesMapper = new EmployeesMapper();
        Role role = new Role("ADMIN", 4);
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "email@email.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));
        Employee employee = new Employee("John Doe", "john.doe@example.com", "AAAbcde12", role, "1234567890", 12345678, 123456789, "123 Main St",  agency);

        EmployeeDto employeeDto = employeesMapper.toDto(employee);

        Assertions.assertEquals("John Doe", employeeDto.getName());
        Assertions.assertEquals(role, employeeDto.getRole());
        Assertions.assertEquals(agency, employeeDto.getAgency());
    }
	

**Test 2:** Test the toDto agency class

	@Test
    public void testToDto() {
        agencyRepository = new AgencyRepository();
        agenciesMapper = new AgenciesMapper();
        Agency agency = new Agency("Agency Name", 123456789, "Porto", "agency@example.com", "1234567890", new AgencyNetwork("agencyNetwork1", "Rua agencyNetwork1", "agencynetwork1@gmail.com", "1234567890"));

        AgencyDto agencyDto = agenciesMapper.toDto(agency);

        Assertions.assertEquals("Agency Name", agencyDto.getName());
        Assertions.assertEquals(123456789, agencyDto.getVat());
        Assertions.assertEquals("Porto", agencyDto.getLocation());
        Assertions.assertEquals("agency@example.com", agencyDto.getEmail());
        Assertions.assertEquals("1234567890", agencyDto.getPhone());
        Assertions.assertEquals("agencyNetwork1", agencyDto.getAgencyNetwork().getName());
    }


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class that displays all employees in the branch network according to the acceptance criteria

```java
 public void displayEmployeesToString() {
        List<AgencyDto> orderedAgencies = getOrderAgencyDtoList();

        for (AgencyDto agencyDto : orderedAgencies) {

        System.out.printf("Store: %s    Number of Property Listing: %d", agencyDto.getName(), getPropertiesNumber(agencyDto));

        List<EmployeeDto> orderedEmployees = getOrderEmployeeDtoList(agencyDto);

            for (EmployeeDto employeeDto : orderedEmployees) {

            System.out.println("- Employee: " + employeeDto.getName());

            }
        System.out.println();
        }
    }
```

# 6. Integration and Demo 

* 

# 7. Observations








