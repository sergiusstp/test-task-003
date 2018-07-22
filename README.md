# Test Task (July 23, 2018)

## Technical description

The project contains two parts: client and server. Each part is maven project.

Server is located under search-server folder.
Client is located under search-client folder.


Server side is built using Spring Boot 2.0, Spring Web, Spring Test

Client side is built using Spring Boot 2.0, Spring Web, Thymeleaf, Bootstrap 3

Communications between client and server parts are done using REST API.

Client side is heavily relying on RestTemplate to communicate with the server side.

Client side is using thymeleaf template engine to generate web page with buttons and inputs.

Bootstrap makes web page look beautiful.

Test coverage is done by 100% for service layer of the server, where business logic is implemented by the specification.

## Multithreaded consideration

Server side is using AtomicLong for key generation for the new documents and ConcurrentHashMap for the in-memory storage.
Objects are located on @Service layer without separate bean.

## REST API description

* GET /engine (get all documents from the search engine)
* GET /engine/{id} (get document by key from the search engine)
* POST /engine (save new document to the search engine, generated key is returned with response)
* POST /engine/search (get all keys for the documents that match the given condition string)

## Installation video instruction

This is [Youtube video instruction](https://youtu.be/3hW761rBAxs) how to install parts of the search system and check that they are working according to specification.

## Installation text instruction

First you need to clone repository from the github to your computer.

After that you should import maven projects for the client and server to your IDE.

Inside package searchengine you can find start class SearchEngineApplication (for server), ClientSearchApplication (for client).

Run them like general Java SE application, using context menu without parameters provided.

Small configuration is done using application.properties file that is located under resource package.
