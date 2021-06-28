# Installation

* Pre-requirements: ......

### builds the project
.\gradlew clean build


### starts the project
.\gradlew bootRun


# Introduction
The *Gate Management Application* is built using Spring boot.

The project has been developed using java 8 and gradle as a build automation tool. 
For database H2 embedded in memory is used, together with Spring JPA and Hibernate.


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

Following endpoint is in charge of occupying a certain gate.
It is expecting to get the `flightNumber` in `RequestBody` as JSON and as a result it should mark a gate with that number as occupied.
In case the gate with that number is not existing in the system 404 HTTP status will be returned.

##### Request example

```
PUT http://localhost:8080/v1/gate/management/working-time/update/{gateNumber}
```

### Delete working hours

Following endpoint is in charge of occupying a certain gate.
It is expecting to get the `flightNumber` in `RequestBody` as JSON and as a result it should mark a gate with that number as occupied.
In case the gate with that number is not existing in the system 404 HTTP status will be returned


##### Request example

```
PUT http://localhost:8080/v1/gate/management/working-time/remove/{gateNumber}
```


###Other technical information

