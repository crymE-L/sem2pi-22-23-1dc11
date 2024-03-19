# US 004

## 1. Requirements Engineering


### 1.1. User Story Description


As an owner, I intend to submit a request for listing a property sale or rent,
choosing the responsible agent.

  


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The Owner will be responsible for sending a request to submit a property

>	Agents will be responsible for reviewing requests and accepting the ones they see fit


**From the client clarifications:**

> **Question:** What information does the Owner have to provide about the property in order to request to list it?
>  
> **Answer:** The Owner must provide the adress, the area (m^2), when construction ended, latest modifications to the property
> and what type of property it is (House, appartment, etc)


> **Question:** Why did my request get denied?
>  
> **Answer:** Agents are responsible for reviewing the requests that are presented to them, 
> if the requests don't meet the criteria or are not correct in any way, the Agent's duty is to
> reject that request, if this happens to you, please verify the information on your request and re-send if there's been a mistake


### 1.3. Acceptance Criteria


* **AC1:** All data must be sent correctly.
* **AC2:** If any of the data is not sent correctly then the request will be rejected.
* **AC3:** Your property is listed if all the required data is correct.

### 1.4. Found out Dependencies


* There is a dependency to "US002 An agent can publish a sale", because there must be at least an agent to review the request


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Property adress
	* Property size (m^2)
	* A technical description
	* An estimated cost
	
* Selected data:
	* Property type


**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![us004SSD-0.svg](svg%2Fus004SSD-0.svg)

### 1.7 Other Relevant Remarks

*