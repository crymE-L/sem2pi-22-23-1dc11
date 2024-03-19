# US 005

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID                                      | Question: Which class is responsible for...       | Answer                 | Justification (with patterns)       |
|:----------------------------------------------------|:--------------------------------------------------|:-----------------------|:------------------------------------|
| Step 1 : Asks to create a store                     | 	... interacting with the actor?                  | CreateAgencyUI         | Pure Fabrication                    |
| 			  		                                             | ... coordinating the US?                          | CreateAgencyController | Controller                          |
| Step 2 : Requests data  		                          | ... validating the data locally?							           | CreateAgencyUI         | Pure Fabrication                    |
|                                                     | ... temporarily keeping input data?               | CreateAgencyUI         | Pure Fabrication                    |
| Step 3 : Submits data 		                            | ... creating the Agency Object?                   | AgencyRepository       | Creator R: 1,2                      |
|                                                     | ... validating the data locally (mandatory data)? | Agency                 | The object created has its own data |
| Step 4 : Shows the data and requests a confirmation |                                                   |                        |                                     |
| Step 5 : Confirms the data                          |                                                   |                        |                                     |
| Step 6 : Informs operation success                  | ... informing operation success?                  | CreateAgencyUI         | Pure fabrication                    |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Agency

Other software classes (i.e. Pure Fabrication) identified: 

 * CreateAgencyUI  
 * CreateAgencyController


## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us005-sequence-diagram-full.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us005-class-diagram.svg)