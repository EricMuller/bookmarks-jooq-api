# bookmarks-jooq-api


[![N|Solid](https://cdn.travis-ci.org/images/favicon-076a22660830dc325cc8ed70e7146a59.png)](https://travis-ci.org/) 


[![Build Status](https://travis-ci.com/EricMuller/bookmarks-jooq-api.svg?branch=master)](https://travis-ci.com/EricMuller/bookmarks-jooq-api)

 

bookmarks-jooq-api is a sample Bookmarks Rest API.


You can also:
  
  - Create some Bookmarks.
  - Create some Tag.

### Tech

bookmarks-jooq-api uses a number of open source projects to work properly:


* [SpringBoot] - Create stand-alone backend Spring applications
* [Spring Data JPA]  - provides repository support for the Java Persistence API (JPA)
* [JOOQ]  - generates Java code from your database and lets you build type safe SQL queries through its fluent API
* [MapStruct] - code generator that greatly simplifies the implementation of mappings between Java bean types  
* [keycloak] - an open source identity and access management solution
* [Lombok] - Never write another getter or equals method again
* [Maven] - the build system
* [Springfox] - Automated JSON API documentation for API's built with Spring
* [Travis] - Test and Deploy with Confidence



### Installation

bookmarks-jooq-api requires [MAVEN](https://maven.apache.org/) v3.3+ to run.


Create the database and generate Jooq Java code.

```sh
$ cd bookmarks-jooq-api
$ maven generate-sources -Prun-liquibase -Prun-jooq-codegen
```

Install dependencies and Start the server.

```sh
$ cd bookmarks-jooq-api
$ maven clean install
$ maven spring-boot:run
```


Verify the deployment by navigating to your server address in your preferred browser.

```sh
http://127.0.0.1:8080/swagger-ui.html#/
```


### Todos

 - Write MORE features

License
----

MIT
