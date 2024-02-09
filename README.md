## Project README

### Group Members
- Carlos Martinez, Brian Ramos, Luisa Paredes, Kathleen Porter

### Java Version
- We are utilizing OpenJDK 21.0.1 LTS for this project.

### IDEs Used
- **Backend Development:** Eclipse, chosen for its robust Java support and comprehensive IDE features.
- **Client-Side Development:** Visual Studio Code, selected for its extensive JavaScript support and ease of use for frontend technologies.

### Challenges and Solutions

#### Client-Server Communication
Initially, we faced a `404 Not Found` error, indicating difficulties in the client connecting to the backend API. This issue pointed to potential misconfigurations in servlet mappings or AJAX request URLs. By meticulously revisiting these configurations and ensuring AJAX URLs correctly included the application's context path, we were able to resolve this issue.

#### Library Integration and IDE Challenges
We encountered challenges integrating essential Java libraries, such as GSON for JSON processing, due to Eclipse's management of library dependencies. Additionally, Eclipse presented difficulties with functionality and integration, prompting us to seek alternative methods for library installation and configuration.

### Current Issues
Despite resolving the initial connection issues, we continue to face challenges with seamless client-server communication and library integration within Eclipse. The primary unresolved issue remains the effective use of libraries like GSON for JSON processing, critical for handling HTTP request and response bodies.

Data doesn't persist in our application. This MVP relies on data structures as opposed to integrated databases.

### Attempts to Resolve Ongoing Issues
- **Servlet Mappings:** Adjusted servlet mappings and verified AJAX request URLs for accuracy.
- **Library Integration:** Explored manual library installation and configuration to overcome Eclipse's dependency management challenges.

### Running the Project Locally
1. Fork and clone the repository.
2. Import the project into Eclipse (backend) and Visual Studio Code (frontend).
3. Configure and start the Tomcat server in Eclipse.
4. Access the application via `http://localhost:8080/projectname/`.
