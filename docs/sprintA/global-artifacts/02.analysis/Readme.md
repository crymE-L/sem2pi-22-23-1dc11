# Analysis

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Real Estate

---

**Transaction Line Items**

* Properties

---

**Product/Service related to a Transaction or Transaction Line Item**

*  Lands, apartments, houses

---


**Transaction Records**

*  Database file

---  


**Roles of People or Organizations**

* System Administrator, Employee, Owner, Agent, Network Manager, Store Manager, Store Network


---


**Places**

*  Properties and store's addresses 

---

**Noteworthy Events**

* 

---


**Physical Objects**

* Store, land, house, apartment

---


**Descriptions of Things**

* Store - A real estate company registered on the platform
* Land -
* House -
* Apartment -


---


**Catalogs**

*  List of Properties

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

*  Store, Store Network

---

**Other External/Collaborating Systems**

*    


---


**Records of finance, work, contracts, legal matters**

* 

---


**Financial Instruments**

*  USD

---


**Documents mentioned/used to perform some work/**

* 
---



###**Rationale to identify associations between conceptual classes**###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A) 		          |      Association   	      |        Concept (B) |
|-------------------------|:-------------------------:|-------------------:|
| System Administrator  	 |     register    		 	      | store<br/>employee |
| Owner  	                | submit   <br/>choose 		 	 |  request<br/>agent |
| Agent | publish | sale announcement|
| Unregistered User | display | listed properties |



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![project-domain-model-0.svg](svg%2Fproject-domain-model-0.svg)


