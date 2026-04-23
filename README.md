# Smart Campus API

## Overview

This project implements a RESTful API for managing a Smart Campus system. It allows management of rooms, sensors, and sensor readings using JAX-RS (Jersey).

The application uses in-memory data structures (HashMap and ArrayList), meaning all data resets when the server restarts.

---

##  Technologies Used

* Java 17
* Jakarta EE 10 (JAX-RS)
* Jersey
* Apache Tomcat 10
* Maven

---

## How to Run the Project

1. Clone the repository:

```
git clone <your-repo-link>
```

2. Open the project in NetBeans

3. Configure Apache Tomcat 10

4. Run the project

5. Access the API:

```
http://localhost:8080/smartcampus-api/api/v1
```

---

##  API Endpoints

###  Discovery

```
GET /api/v1
```

---

###  Rooms

```
GET    /api/v1/rooms
POST   /api/v1/rooms
GET    /api/v1/rooms/{id}
DELETE /api/v1/rooms/{id}
```

---

###  Sensors

```
GET  /api/v1/sensors
GET  /api/v1/sensors?type=Temperature
POST /api/v1/sensors
```

---

###  Sensor Readings

```
GET  /api/v1/sensors/{id}/readings
POST /api/v1/sensors/{id}/readings
```

---

##  Sample curl Commands

### Create Room

```
curl -X POST http://localhost:8080/smartcampus-api/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"LIB-301","name":"Library","capacity":50}'
```

---

### Get Rooms

```
curl http://localhost:8080/smartcampus-api/api/v1/rooms
```

---

### Create Sensor

```
curl -X POST http://localhost:8080/smartcampus-api/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"TEMP-001","type":"Temperature","status":"ACTIVE","currentValue":25,"roomId":"LIB-301"}'
```

---

### Get Sensors

```
curl http://localhost:8080/smartcampus-api/api/v1/sensors
```

---

### Filter Sensors

```
curl http://localhost:8080/smartcampus-api/api/v1/sensors?type=Temperature
```

---

### Add Reading

```
curl -X POST http://localhost:8080/smartcampus-api/api/v1/sensors/TEMP-001/readings \
-H "Content-Type: application/json" \
-d '{"id":"R1","timestamp":1710000000,"value":26.5}'
```

---

##  Notes

* Data is stored in-memory and will be lost when the server restarts
* Ensure a room is created before adding sensors
* Ensure a sensor exists before adding readings
