# Improved Object-Oriented Design (CRC Cards)

The monolithic `CourseRegistration` class has been refactored into distinct, cohesive classes that follow the Single Responsibility Principle. 

**Class:** Student
**Responsibilities:** 
- Maintain student information (student ID, name, email).
- Provide student details to other services.
**Collaborators:** None

**Class:** Course
**Responsibilities:** 
- Maintain course information (course code, credit hours).
- Provide course details to other services.
**Collaborators:** None

**Class:** TuitionCalculator
**Responsibilities:** 
- Calculate the base tuition based on credit hours.
- Apply business rules for discounts (e.g., heavy course load discounts).
**Collaborators:** Course

**Class:** RegistrationRepository
**Responsibilities:** 
- Abstract the data storage mechanism.
- Save the registration record (student, course, calculated tuition) to a persistent data store.
**Collaborators:** Student, Course

**Class:** NotificationService
**Responsibilities:** 
- Abstract the messaging mechanism.
- Send a registration confirmation message to the student.
**Collaborators:** Student, Course

**Class:** CourseRegistrationService
**Responsibilities:** 
- Orchestrate the overall registration workflow.
- Coordinate calculating tuition, saving the record, and sending notifications.
**Collaborators:** Student, Course, TuitionCalculator, RegistrationRepository, NotificationService