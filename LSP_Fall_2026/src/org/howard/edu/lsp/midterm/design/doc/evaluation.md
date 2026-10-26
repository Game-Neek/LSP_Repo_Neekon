# Design Evaluation of CourseRegistration

The current design of the `CourseRegistration` class suffers from several major structural and object-oriented flaws that severely impact its maintainability, extensibility, and testability. Based on Arthur Riel's Object-Oriented Design Heuristics, the following issues are present:

**1. Violation of Data Hiding (Encapsulation)**
*   **Heuristic violated:** *"All data should be hidden within its class."*
*   **Explanation:** The class exposes all of its fields (`studentId`, `studentName`, `email`, `courseCode`, `creditHours`) as `public`. This breaks encapsulation, allowing any external class to mutate the data directly without validation. This leads to unpredictable state changes and bugs that are difficult to track.

**2. The "God Class" Anti-Pattern (Poor Cohesion)**
*   **Heuristic violated:** *"Do not create god classes/objects in your system."* (and) *"A class should capture one and only one key abstraction."*
*   **Explanation:** The `registerStudent()` method acts as a monolithic script rather than an object-oriented behavior. It is responsible for holding student/course data, calculating tuition and discounts, handling file I/O, formatting UI output, "sending" emails, and logging. A single class should not manage business logic, data access, and presentation simultaneously.

**3. Hardcoded Dependencies and Magic Numbers (Rigid and Untestable)**
*   **Heuristic violated:** *"Keep object-oriented mechanisms separated from non-object-oriented mechanisms"* (isolating I/O and external systems).
*   **Explanation:** The class instantiates `FileWriter` directly inside the method with a hardcoded filename (`registrations.txt`). This tightly couples the business logic to the local file system, making it impossible to unit test the registration logic without actually writing to a disk. Furthermore, the tuition rate (`750.0`), discount threshold (`12`), and discount rate (`0.90`) are "magic numbers" hardcoded into the method. If tuition changes, the core registration code must be modified, violating the Open/Closed Principle.

**4. Failure to Model the Real World**
*   **Heuristic violated:** *"Model the real world whenever possible."*
*   **Explanation:** In the real world, a "Student", a "Course", and a "Registration/Billing" process are distinct entities. This class forcefully merges the attributes of a student and a course into a single transaction object, leading to duplicated data if a student registers for multiple courses.

**Conclusion**
This monolithic design makes the system incredibly rigid. Adding a database, changing the tuition rules, or altering how notifications are sent requires opening and modifying this single method, risking regressions in unrelated functionalities.