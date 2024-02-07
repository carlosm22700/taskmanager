## README

### Group Members
- (Your names will be added here.)

### Java Version
- OpenJDK version "21.0.1" 2023-10-17 LTS
- OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
- OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode)

### IDE Used
- Backend: Eclipse (due to its comprehensive Java support and integrated development environment).
- Client: Visual Studio Code (preferred for client-side development given its extensive extensions for JavaScript and familiarity).

### Challenges Faced
- Encountered a `404 Not Found` error when attempting to connect the client with the backend API, indicating a potential misconfiguration in the servlet mapping or AJAX request URL.
- Experienced issues with Eclipse functionality and integrating libraries, such as JSON processing libraries.
- Found it challenging to integrate JavaScript, HTML, and CSS into the application, given Java's complexities with containers and dependencies, especially in collaborative environments.

### Known Issues
- **Client-Server Communication**: The main issue is the lack of connection and communication between the client and the server. The client fails to connect to the API, preventing the server from processing requests and the client from displaying the data.
- **Library Integration**: Difficulties were encountered in installing and using Java libraries like GSON for JSON processing, which are essential for handling HTTP request and response bodies in the format of JSON.

### Attempts to Resolve Issues
- To address the `404 Not Found` error, we revisited servlet mappings and ensured the AJAX request URLs correctly included the application's context path.
- For issues with libraries, we explored manual installation and configuration but faced challenges due to Eclipse's handling of library dependencies.

### Project Setup Instructions
(Refer to the detailed setup instructions provided in the previous section.)

### How to Run the Project Locally
- Fork and clone the repository.
- Import the project into Eclipse (for backend) and Visual Studio Code (for frontend).
- Set up and start the Tomcat server in Eclipse.
- Access the application via `http://localhost:8080/projectname/`.

### Contributions to Resolution
- We invite anyone who can identify solutions to the challenges mentioned, especially the client-server communication issue, to contribute via pull requests on GitHub.

---

### Assignment Questions

#### What are the names of group members?
- (Your names will be added here.)

#### What Java version are you using?
- We are using OpenJDK 21.0.1 LTS.

#### What IDE are you using?
- We used a combination of Eclipse for the backend development and Visual Studio Code for the client-side development.

#### What challenges were you facing?
- The main challenge was the `404 Not Found` error, which hindered the client from connecting to the backend API. Additionally, integrating JSON and API libraries in Eclipse proved difficult, alongside conceptualizing the integration of JS, HTML, CSS with the Java backend.

#### Is there anything that is not working? If so, what is it and what have you tried to get it to work?
- The connection between the client and server is not working as intended, which seems to stem from either the frontend or backend configuration. Despite attempts to fix servlet mappings and AJAX URLs, the issue persists. The installation and use of essential Java libraries like GSON for JSON processing also presented issues.
