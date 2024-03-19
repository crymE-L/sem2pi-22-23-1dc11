# US 008

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, I intend to see the list of property announcement requests made
to myself, so that I can post the announcement.

  


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Agents will be responsible for reviewing requests and accepting the ones they see fit


**From the client clarifications:**

> **Question:**  About US08, since as an agent I intend to see the advertisement requests made to me in order to publish the chosen advertisement after consulting the list, why should there be an option to reject it since the previously chosen advertisement had already the intention of being published.The rejection operation shouldn't be described as another feature?
>
>> **Answer:**  I want to check all property announcement requests and have the option to accept or reject any announcement request. The property owner is a human being and can make errors like any other human being...

> 
> **Question:**   Besides the creation of a message justifiyng the rejection should a message or an email be sent to the client.
>
>> **Answer:** The system should also send the message to the owner by e-mail.

> 
> **Question:** Does the request once its declined by the agent be deleted from the request list?
>
>> **Answer:**  The announcement request should not be shown again to the agent. We never delete information from our system.


>  **Question:** Do the agent have to insert the commission after accepting the request from the request list?
>
>>**Answer:** The agent should, firstly, set the commission and then publishes the offer in the system. The sale price (the USD value that is shown in the announcement) should include the commission value (owner requested price + commission) and should not show the commission. The commission is only specified when the agent accepts the request.


>  **Question:** Is the owner responsible to assigning the property to an agent or there are other ways to do that?
>
>> **Answer:** The owner chooses the responsible agent in one other US. Please discuss this question with your teammates and teatchers.

### 1.3. Acceptance Criteria


* **AC1:** . The list of property announcement requests should be sorted by the date
  they were created, with the most recent requests appearing first.

* **AC2:** . An announcement is posted when a request is accepted. The list of requests
  should be refreshed, and that request should not be shown again.
### 1.4. Found out Dependencies


* US2: "As an agent, I can publish any sale announcement on the system, for
  example received through a phone call." An agent is needed to manage the announcements.
* US3: "As a system administrator, I want to register a new employee" A system administrator is needed to manage and add employees (Agents).
* US4: "As an owner, I intend to submit a request for listing a property sale or rent,
  choosing the responsible agent." A registred user is needed to post the announcement request.
* US7: "As an unregistered user, I want to register in the system to buy, sell or rent
  properties." The user that posts the announcement request needs to be registred.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	
* Selected data:
	* Announcement Requests


**Output Data:**

* List of announcement requests made to the agent
* Invividual request's information

### 1.6. System Sequence Diagram (SSD)

![us008SSD-0.svg](svg%2Fus008SSD.svg)

### 1.7 Other Relevant Remarks

*