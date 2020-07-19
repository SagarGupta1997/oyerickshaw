# oyerickshaw
to enable on postgis use
create a table on Postgres 

CREATE TABLE driver_info(
ID SERIAL PRIMARY KEY,
created_on TIMESTAMP,
updated_on TIMESTAMP,
driver_id INT NOT NULL,
driver_lat real,
driver_lon real,
geolocation geo(point)
);

