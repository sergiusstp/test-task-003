# Test Task (July 23, 2018)

## Technical description

The project contains two parts: client and server. Each part is maven project.

Server is located under search-server folder.
Client is located under search-client folder.

Each part is made with the same tech stack: Spring Boot 2.0.3, Spring Web, Spring Test, Thymeleaf (for client)

Communications between client and server parts are done using REST API.

Test coverage is done by 100% for service layer of the server, where business logic is implemented by the specification.

## Multithreaded consideration

Server side is using AtomicLong for key generation for the new documents and ConcurrentHashMap for the in-memory storage.
Objects are located on @Service layer without separate bean.
