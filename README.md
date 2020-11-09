# Slice Message Challenge By [José Kleiton](https://github.com/kleitonOak)


The goal is to create an application that makes a request to a mock API with tweets and print the output of one of the tweets respecting the business rules.
Business rules
- R1. Randomly get the attribute text from one of the tweets at our mock API.
- R2. Respect the limit of 45 characters to make the tweet output.
- R2.a. If the text has more than 45 characters, the tweet needs to be sliced in N parts until the whole text have been presented.

### API Mock

The API has two methods. One to make the authentication and get the JWT token with 60 seconds of duration, that needs to be used to make the request to the timeline endpoint. And the second one that returns the timeline of the tweets.


|Base URL  | https://n8e480hh63o547stou3ycz5lwz0958.herokuapp.com/ |
| ----------- | ------------------------------------------------------------------------------------ |
|**Version**  | **1.1** |
| | [![Run in Postman](https://run.pstmn.io/button.svg)](https://www.getpostman.com/collections/47875da49b734fddadcd)|

#### Auth POST /{version}/auth

| Status Code | Description | Response |
| ----------- | --------- | ---------|
| 200 | Success authentication. | ```{ "token": "..." }``` |
| 500 | Unexpected error. |  |

#### Timeline GET /{version}/statuses/home_timeline.json

| Status Code | Description | Response |
| ----------- | --------- | ---------|
| 200 | Get tweets list. | ```[{"created_at": "Wed Apr 11 22:15:17 +0000 2018" ... }]``` |
| 403 | Occur an error at the token validation. | ```{"message": "Invalid JWT token." }``` |
| 500 | Unexpected error. |  |

### Example

Above there's an example with the output that was expected to be answered after executing the application.

| Text | Output |
| ---- | ------ |
| Interferência na Av. Washington Luis sentido Bairro, próximo Praça. Comte. Linneu Gomes. Ocupa uma faixa. #ZS. | Tweet #1: Interferência na Av. Washington Luis sentido | 
|  | Tweet #2: Bairro, próximo Praça. Comte. Linneu Gomes. |
|  | Tweet #3: Ocupa uma faixa. #ZS.

## Recommended
- Intellij IDE

## Pre requirements
1. Docker.
2. Java versions 11 minimum.

## Build
On console:
`./gradlew clean build`

## Run the project

On console:
`./gradlew bootRun`

## Application Structure

##### Core: Entities
* Represent your domain object
* Apply only logic that is applicable in general to the whole entity (e.g. validating the format of an hostname)
* Plain java objects: no frameworks, no annotations

##### Core: Use Cases
* Represent your business actions, it’s what you can do with the application. Expect one use case for each business action
* Pure business logic, plain java (expect maybe some utils libraries like StringUtils)
* Define interfaces for the data that they need in order to apply some logic. One or more dataproviders will implement the interface, but the use case doesn’t know where the data is coming from
* The use case doesn't know who triggered it and how the results are going to be presented (e.g. could be on a web page, or returned as json, or simply logged, etc.)
* Throws business exceptions

##### Dataproviders
* Retrieve and store data from and to a number of sources (database, network devices, file system, 3rd parties, etc.)
* Implement the interfaces defined by the use case
* Use whatever framework is most appropriate (they are going to be isolated here anyway)
* Note: if using an ORM for database access, here you'd have another set of objects in order to represent the mapping to the tables (don't use the core entities as they might be very different)

##### Entrypoints
* Are ways to interact with the application, and typically involve a delivery mechanism (e.g. REST APIs, scheduled jobs, GUI, other systems)
* Trigger a use case and convert the result to the appropriate format for the delivery mechanism
* A GUI would use MVC (or MVP) in here; the controller would trigger a use case

##### Configuration
* Wires everything together
* Frameworks (e.g. for dependency injection) are isolated here
* Has the "dirty details" like Main class, web server configuration, datasource configuration, etc.

[Source](https://github.com/mattia-battiston)