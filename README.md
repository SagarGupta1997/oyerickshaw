# oyerickshaw
to enable on postgis use on postgre
CREATE EXTENSION postgis;
CREATE EXTENSION postgis_topology;

create a table on Postgres - 

CREATE TABLE driver___info(
ID SERIAL PRIMARY KEY,
created_on TIMESTAMP,
updated_on TIMESTAMP,
driver_id INT NOT NULL,
driver_lat real,
driver_lon real,
geolocation geography(point)
);


