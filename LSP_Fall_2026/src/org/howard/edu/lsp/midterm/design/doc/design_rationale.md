# Evolving Requirements and Design Rationale

The proposed CRC-card architecture anticipates changing requirements by relying on abstractions and separating concerns, ensuring the system remains flexible and maintainable.

### Supporting Flexible Storage and Notifications
To support both a local file and a database, `RegistrationRepository` will be defined as an interface rather than a concrete class. We can then create two separate implementation classes: `FileRegistrationRepository` and `DatabaseRegistrationRepository`. The `CourseRegistrationService` will depend only on the `RegistrationRepository` interface. At runtime (or during deployment configuration), the system can inject the appropriate implementation. This allows us to switch from text files to a SQL database without altering a single line of the business logic in the registration service.

Similarly, to support different messaging formats, `NotificationService` acts as an interface with concrete implementations like `EmailNotificationService` and `TextNotificationService`. 

### Adherence to SOLID Principles
This design heavily leverages two foundational object-oriented principles:
1. **Single Responsibility Principle (SRP):** Each class now has exactly one reason to change. If the university changes how discounts are applied, only the `TuitionCalculator` is modified. If they change database vendors, only the repository implementation changes. The orchestrating `CourseRegistrationService` only changes if the *workflow* itself changes.
2. **Open/Closed Principle (OCP):** The system is open for extension but closed for modification. If the university decides to add a third storage option (e.g., a Cloud API) or a third notification method (e.g., a mobile push notification), we simply create new classes that implement the existing interfaces. We do not have to modify the existing `CourseRegistrationService` code to accommodate these new features.

### Justification of Responsibility Ownership
A critical design decision was making the `TuitionCalculator` a distinct class rather than giving the `Course` class the responsibility of calculating its own tuition. While a course inherently has credit hours, the financial pricing rules (like flat rates or heavy-load discounts) are business policies that can change independently of the academic definition of the course. By extracting this responsibility into `TuitionCalculator`, we prevent the `Course` class from bloating into a financial object and maintain high cohesion.