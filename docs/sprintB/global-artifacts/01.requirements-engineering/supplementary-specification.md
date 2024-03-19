# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._


 * The user requires an email and a password to authenticate himself on the application
 * The application has a permission system which, based on the employee's role, determines what actions he can take  
 * 

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

* Documentation: User Manual

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

(fill in here)

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, instability, scalability and more._ 


* The system will be maintained by the development team.


* Unit tests for all non Input/Output methods.
    * Helps with scalability.


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

* Images/Figures format : SVG

### Implementation Constraints

_Specifies or constraints the code or construction of a system such as: mandatory standards/patterns, implementation languages, database integrity, resource limits, operating system._

* Application Language : English

* Programing Language : Java
  * Graphical Interface : JavaFX 11 (at least)
  * Unit Tests : JUnit 5 framework
  * Coverage Report : JaCoCo (plugin)

* IDE : IntelliJ or NetBeans

* Generate Documentation : Javadoc

* Mandatory Code Standards : CamelCase

### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

(fill in here )

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

* Development oriented to objects to ensure data persistence between two runs of the application 