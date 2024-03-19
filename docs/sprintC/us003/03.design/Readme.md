# US 003

## 3. Design - User Story Realization 

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID                                               | Question: Which class is responsible for...        | Answer                     | Justification (with patterns)                                                                                 |
|:-------------------------------------------------------------|:---------------------------------------------------|:---------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1 :  Asks to register a employee		                      | 	... interacting with the actor?                   | RegisterEmployeeUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                                      | 	... coordinating the US?                          | RegisterEmployeeController | Controller                                                                                                    |
| 			  		                                                      | 	                                                  |                            |                                                                                                               |
| 			  		                                                      |                                                    |                            |                                                                                                               |
| 			  		                                                      | 							                                            |                            |                                                                                                               |
| 			  		                                                      | 							                                            |                            |                                                                                                               |
| Step 2 : shows agencies list and asks to select		            | 		...knowing the agencies to show?  					          | System                     | IE: The agencies are defined by the Administrators.                                                           |
| Step 3 : selects an agency                                   | 	                                                  |                            |                                                                                                               |
| Step 4 : shows roles list and asks to select		               | 	...knowing the roles to show?                     | System                     | IE: The roles are defined by the Administrators.                                                              |
| Step 5 : selects a role 		                                   | 	                                                  |                            |                                                                                                               |
| Step 6 : requests data		                                     | 				... validating all data (local validation)?			 | RegisterEmployeeUI         | Pure Fabrication                                                                                              |              
| 	                                     | 				... temporarily keeping input data?			 | RegisterEmployeeUI         | Pure Fabrication                                                                                              |
| Step 7 : types the data		                                    | 	       |                       |                                                                                             | 
| Step 8 : shows the selected agency, role and inserted data		 |                  |                            |                                                                                                               | 
| Step 9 : submites data		                                     | 	      ... validating the data locally (mandatory data)?           | Employee                   |               The object created has its own data                                                                                                | 
| 			  		                                                      |                        ... creating the Agency Object?                             | EmployeeRepository         |                  Creator R: 1,2                                                                                                  |
| Step 10 : sends password		                                   | 	                                                  |                            |                                                                                                               | 
| Step 11 : informs operation sucess		                         | 	... informing operation success?                  | RegisterEmployeeUI         | IE: is responsible for user interactions.                                                                     | 


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Agency
 * Role
 * Employee

Other software classes (i.e. Pure Fabrication) identified: 

 * RegisterEmployeeUI  
 * RegisterEmployeeController


## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![us003-sequence-diagram-full-0.svg](svg%2Fus003-sequence-diagram-full-0.svg)


## 3.3. Class Diagram (CD)

![us003-class-diagram-0.svg](svg%2Fus003-class-diagram-0.svg)