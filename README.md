# oyerickshaw
**1) API end-points you have created along with sample request/response**

a) Swagger link to use Api : http://localhost:8080/swagger-ui.html#/service-controller/getDriversNearUserUsingGET
b) curl command to call Api using postman.
curl -X GET \
  'http://localhost:8080/app/api/get_driver_info?user_id=212&=&=&=&search_lat=26.014607&search_lon=79.139693&radius=100' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: b7b0d725-c980-8900-1950-66a3244f63cd'
**Response**
{
  "message": "success",
  "code": 200,
  "data": {
    "data": [
      {
        "driverId": 9,
        "driverLat": 26.014607,
        "driverLon": 79.139693,
        "distance": 0
      },
      {
        "driverId": 8,
        "driverLat": 26.014474,
        "driverLon": 79.139902,
        "distance": 25.59
      },
      {
        "driverId": 10,
        "driverLat": 26.014474,
        "driverLon": 79.139902,
        "distance": 25.59
      },
      {
        "driverId": 11,
        "driverLat": 26.014474,
        "driverLon": 79.139693,
        "distance": 25.59
      }
    ]
  }
}

**2 a) All assumptions you have made**
**1)**   We are goint to call Api in every 5 second from front-end  by using polling concept for  tracking locations of all drivers in real-time.

**2 b) Approach to your solution**
I am storing data(driver_lat,driver_lon, driver_id, point(driver_lon,driver_lat) ) of driver in Postgres. Whenever Front-end call the Api with search_lat , search_lon, radius(default = 200 meter), we fetch data from Postgres in ascending order of distance between driver and search_point. We can do pooling from front_end to track the live location of driver in every 5 seconds.

**2 C) Any DB schema or setup scripts**

to enable on postgis on postgres, use below command.
CREATE EXTENSION postgis;
CREATE EXTENSION postgis_topology;

create a table on Postgres - 

CREATE TABLE driver_info(
ID SERIAL PRIMARY KEY,
created_on TIMESTAMP,
updated_on TIMESTAMP,
driver_id INT NOT NULL,
driver_lat real,
driver_lon real,
geolocation geography(point)
);

Data will be auto inserted by using Data.sql when we run project.
**make coonection to postgreSQL by using application.properties**

**2 d). Steps to run your application**
You should have Postgres, Spring Boot, Java installed on your system.
first of clone the repository.
build the project.
set up the Postgres for postgis.
create database and table in postgres.
run the project.


