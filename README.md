# oyerickshaw
**1) API end-points you have created along with sample request/response** <br /> 

a) Swagger link to use Api : http://localhost:8080/swagger-ui.html#/service-controller/getDriversNearUserUsingGET  <br /> <br /> 
b) curl command to call Api using postman. <br /> 
curl -X GET \
  'http://localhost:8080/app/api/get_driver_info?user_id=212&=&=&=&search_lat=26.014607&search_lon=79.139693&radius=100' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: b7b0d725-c980-8900-1950-66a3244f63cd' 
  <br /> <br /> 
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
 <br /> <br /> 
**2 a) All assumptions you have made** <br /> 
**1)**   We are goint to call Api in every 5 second from front-end  by using polling concept for  tracking locations of all drivers in real-time.
 <br /> <br /> 
**2 b) Approach to your solution**  <br /> 
I am storing data(driver_lat,driver_lon, driver_id, point(driver_lon,driver_lat) ) of driver in Postgres. Whenever Front-end call the Api with search_lat , search_lon, radius(default = 200 meter), we fetch data from Postgres in ascending order of distance between driver and search_point. We can do pooling from front_end to track the live location of driver in every 5 seconds.
 <br /> <br /> 
**2 C) Any DB schema or setup scripts**
 <br /> 
to enable on postgis on postgres, use below command. <br /> 
CREATE EXTENSION postgis; <br /> 
CREATE EXTENSION postgis_topology; <br /> 
 <br /> 
create a table on Postgres - 
 <br /> 
CREATE TABLE driver_info( 
ID SERIAL PRIMARY KEY,
created_on TIMESTAMP,
updated_on TIMESTAMP,
driver_id INT NOT NULL,
driver_lat real,
driver_lon real,
geolocation geography(point)
);
 <br /> 

Data will be auto inserted by using Data.sql when we run project. <br /> <br /> 
**make coonection to postgreSQL by using application.properties**
 <br /> <br /> 
**2 d). Steps to run your application** <br /> 
You should have Postgres, Spring Boot, Java installed on your system. <br /> 
first of all clone the repository.  <br /> 
build the project.  <br /> 
set up the Postgres for postgis.  <br /> 
create database and table in postgres.  <br /> 
run the project.  <br /> 


