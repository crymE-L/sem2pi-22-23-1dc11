# US 011 - To list real estate purchase orders to accept or decline a purchase order for a property.

## 1. Requirements Engineering

### 1.1. User Story Description

As an agent, I want to list real estate purchase orders to accept or decline a
purchase order for a property. After accepting or declining, an email notification
should be sent to the customer.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

The real estate agent reviews advertisement requests, registers the information in the system and
publishes the offer so that it is visible to all clients who visit the agency and use the application. All
registered information, except the agency commission, can be accessed by the client who intends to
buy or rent the property

**From the client clarifications:**

> **Question:** When the agent wants to list real estate purchase orders, does he/she list all of them at once or can a property be chosen to list the purchase orders that are related to that specific property?
>  
> **Answer:** The properties should be sorted from the oldest to the most recent one. For each property, the list of purchase orders should be sorted by the amount offered, the highest offer must appear first.


> **Question:** Regarding US011 should we provide all the property characteristics to assist agents in choosing the appropriate purchase order? If so, is it required to display the amount established by the property owner?
>
> **Answer:** Yes. Yes.


### 1.3. Acceptance Criteria

* **AC1:** The list of purchase orders should be grouped by property. The properties
  should be sorted from the oldest to the most recent one. For each property, the
  list of purchase orders should be sorted by the amount offered, the highest offer
  must appear first.


* **AC2:** For each offer, the agent must be able to accept or decline it. The action of
  accepting or declining an offer should trigger an email notification to the client.


* **AC3:**  When a purchase order is accepted, all the other orders should be declined,
  and a message sent to the client.


* **AC4:**  If a property does not contain any offers, the system should show an empty
  list of offers.

### 1.4. Found out Dependencies

* There is a dependency to "US2" and "US4" since there must be properties listed for the agent to accept ou decline.


* There is a dependency to "US5" since there must be stores registered in order to list properties.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
	* None


* Selected Data:
  * Purchase Order ID  
	
**Output Data:**

* Real estate purchase orders list
* Email

### 1.6. System Sequence Diagram (SSD)

![us011-system-sequence-diagram-0.svg](svg%2Fus011-system-sequence-diagram-0.svg)

### 1.7 Other Relevant Remarks