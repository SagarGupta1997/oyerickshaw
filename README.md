# oyerickshaw
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
 
 
##make coonection to postgreSQL;

Swagger link to use Api : http://localhost:8080/swagger-ui.html#/service-controller/getDriversNearUserUsingGET





