# Installation

The project is self-contained. There is no need to install additional software. 
Check permissions of gradle scripts before executing gradle commands.

### builds the project
.\gradlew clean build


### starts the project
.\gradlew bootRun


# Introduction
The *Gate Management Application* is built using Java 8 and Spring Boot. Gradle is used as build automation tool.
For managing model layer, H2 emebedded database is used together with Spring JPA and Hibernate frameworks.


I have designed a REST API to deal with gate management. This API consists of following endpoints:
	
* endpoint designed to occupy a certain gate;
* endpoint designed to unbind a certain gate;
* endpoint designed to update working time;
* endpoint designed to remove working time;

### Occupying a gate

Following endpoint is in charge of occupying a certain gate.
It is expecting to get the `flightNumber` in `RequestBody` as JSON and as a result it should mark a gate with that number as occupied.
In case there is no available gate, 409 HTTP status will be returned.


##### Request example

```
POST http://localhost:8080/v1/gate/management/occupy

{
    "flightNumber": "123"
}
```

### Unbind a gate

Following endpoint is in charge of unbinding a certain gate.
It is expecting to get the `gateNumber` as `PathVariable` and as a result it should unbind the gate with that number.
In case the gate with that number is not existing in the system, 404 HTTP status will be returned.

##### Request example

```
PUT http://localhost:8080/v1/gate/management/free/1111
```


### Update working hours

Following endpoint is in charge of removing working hours of a certain gate.
It is expecting to get the `gateNumber` as `PathVariable`, `openingTime` and `closingTime` as `RequestBody`, 
and returns representation of `GateDto` object.
In case the gate with that number is not existing in the system 404 HTTP status will be returned.

##### Request example

```
PUT http://localhost:8080/v1/gate/management/working-time/update/{gateNumber}

{
    "openingTime":360,
    "closingTime":1200
}
```

### Delete working hours

Following endpoint is in charge of removing working hours of a certain gate.
It is expecting to get the `gateNumber` as `PathVariable`, and returns representation of GateDto object.
In case the gate with that number is not existing in the system 404 HTTP status will be returned.


##### Request example

```
PUT http://localhost:8080/v1/gate/management/working-time/remove/{gateNumber}
```

