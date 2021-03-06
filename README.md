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

Each spring boot service (client and server) run on localhost, but with different ports. Server is using port 8010 and client is using 8080.

To access client web page, you may enter localhost:8080 in your browser and you'll see the web page.

There are 4 options provided to access search engine from the client side. Detailed walkthrough what to do with web page is given with Youtube video. Link is provided in the chapter above.

In general, you can
* get all documents and they will be displayed in the table
* get one document and it will be displayed in the table
* save new document to the server and returned key will be displayed on the page
* get document keys by given condition and that keys will be displayed on the page

## Information about time spent

13 hours of pure time.

## Detailed project timeline

5 min (July 20, 5:00-5:05 pm) Obtaining Test Task from company's representative and checking that I fully understand the task content.

60 min (July 20, 10:00-11:00 pm) Thinking about best way to do the test task in time, without actual coding.

45 min (July 21, 12:00-12:45 pm) Creating initial server part, basic endpoints and services from existing code sample.

30 min (July 21, 12:45-01:15 pm) Creating GET REST endpoints with business logic.

60 min (July 21, 01:30-02:30 pm) Creating POST REST endpoint (save document) with business logic.

80 min (July 21, 03:00-04:20 pm) Creating POST REST endpoint (search document) with business logic.

15 min (July 21, 04:30-04:45 pm) Project cleanup.

60 min (July 21, 04:45-05:45 pm) Tests (JUnit4) for the server service layer.

90 min (July 21, 06:30-08:00 pm) Creating initial client part.

90 min (July 21, 08:45-10:15 pm) Working on Thymeleaf html template design.

60 min (July 22, 12:00-01:00 am) Working on REST endpoint for Web MVC using RestTemplate to get data from the server

40 min (July 22, 02:00-02:40 am) Using Bootstrap 3 to make web page look beautiful

30 min (July 22, 08:45-09:15 pm) Doing light redesign for Controller / Service layer on the client

30 min (July 22, 09:15-09:45 pm) Manual tests using web page to check that everything is working as expected.

15 min (July 22, 11:40-11:55 pm) Recording youtube video for the manual.

75 min (July 23, 02:00-03:15 am) Writing detailed description in README.md file.

Total is 785 min or 13 hours of pure time.

## The bottom line

That depends.

In general the realistic time expectation for the task like this is 2-3 business days without the risk of employee burnout in the short term period.

Yes, this task can be done within one business day, but each new task must be very similar to what is done the previous days. Also we need to cut off some documentation to reach the time expectation. Even in that case the realistic expectation should be 1.5 business days.
