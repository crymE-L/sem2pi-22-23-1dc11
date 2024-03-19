# US 003 - To register a new employee

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a new employee.


### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

>	An employee has a role (e.g. store manager) and works for an agency. Each role has a set of operations and permissions associated with it.

>	The company's systems administrator will be responsible for registering all employees specifying
the name, the citizen's card number, the tax number, the address, the email address, the contact
telephone number and the agency to which it is assigned.




**From the client clarifications:**

> **Question:** The administrator when registering a new employee will also have to specify the category/office that he will perform (for example agent, store manager, store network manager)?
>
> **Answer:** The administrator has to specify the role of the employee.


> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
>
> **Answer:** The System Administrator should be logged in the application.


> **Question:** When registering a new employee, will the administrator set the respective employee password?
>
> **Answer:** The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.


### 1.3. Acceptance Criteria


* **AC1:** All required fiels must be filled in.
* **AC2:** Tax number must have 9 digits.
* **AC3:** Telephone number must have 10 digits.

### 1.4. Found out Dependencies


* There is a dependency to "US005 Create an Agency" since an agency must exist in order to register a new employee.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* name
    * passport's card number
    * tax number
    * address
	* email address
    * telephone number
	
  

* Selected data:
  * agency
  * role

**Output Data:**

* (In)Success of the operation
* Employee's password

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One
![us003-system-sequence-diagram-alternative-one-System Sequence Diagram (SSD).svg](svg%2Fus003-system-sequence-diagram-alternative-one-System%20Sequence%20Diagram%20%28SSD%29.svg)
### 1.7 Other Relevant Remarks

