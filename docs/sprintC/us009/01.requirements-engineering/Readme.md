# US 011 - To leave a message to the agent to schedule a visit to a property 

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

> **Question:** Assuming that this is done so the client can see the available properties in order to select one and given that in a previous question you've stated that the required information for the message should be typed then, for this US, is the only selected data the property that the client wishes to visit?
>
>> **Answer:** System behavior must be consistent. For instance, the filters to be applied when the client is viewing a list of properties should be similar to the filters used in US1.
 
> **Question:** Does the client provide (by typing) their name and phone number for the message, regardless of whether or not that information is already available to the system?
>
>> **Answer:** The information available in the system should be used. The client does not need to type the name and phone number.
 
> **Question:** Is all the required data for the message typed, or is any of it selected?
>
>> **Answer:** For now the information should be typed.

### 1.3. Acceptance Criteria

* **AC1:** A list of available properties must be shown, sorted from the most recent
entries to the oldest.
* **AC2:** The message must also include the client's name, phone number,
preferred date and time slot (from x hour to y hour) for the property visit.
* **AC3:** A client may post multiple visit requests, but only if those do not overlap
each other.
* **AC4:** The client must receive a success message when the request is valid and
registered in the system.

### 1.4. Found out Dependencies

* There is a dependency to "US1" since there must be properties listed.
  
* There is a dependency to "US3" since there must be employees (agent) registered in order to send a message to the agent.

* There is a dependency to "US5" since there must be stores registered in order to list properties and send messages to the employee (agent).

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * Client's name
    * Phone number
    * Preferred date
    * Time slot

**Output Data:**

### 1.6. System Sequence Diagram (SSD)

![us011-system-sequence-diagram-0.svg](svg%2Fus011-system-sequence-diagram-0.svg)

### 1.7 Other Relevant Remarks