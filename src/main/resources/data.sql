DELETE FROM driver_info;
 insert into  driver_info (created_on,updated_on,driver_id,driver_lat,driver_lon,geom) values
('2020-07-19','2020-07-19',8, 26.014474, 79.139902, ST_SetSRID(ST_MakePoint(79.139902 , 26.014474), 4326)),
('2020-07-19','2020-07-19',9, 26.014607, 79.139693, ST_SetSRID(ST_MakePoint(79.139693 , 26.014607), 4326)),
('2020-07-19','2020-07-19',10, 26.014474, 79.139902, ST_SetSRID(ST_MakePoint(79.139902 , 26.014474), 4326)),
('2020-07-19','2020-07-19',11,26.014474, 79.139693, ST_SetSRID(ST_MakePoint(79.139902 , 26.014474), 4326)),
('2020-07-19','2020-07-19',12,25.989028, 79.157685, ST_SetSRID(ST_MakePoint(79.157685 , 25.989028), 4326)),
('2020-07-19','2020-07-19',13,25.988401, 79.158479, ST_SetSRID(ST_MakePoint(79.158479 , 25.988401), 4326)),
('2020-07-19','2020-07-19',14,25.991197, 79.160228  , ST_SetSRID(ST_MakePoint(79.160228  , 25.991197), 4326)),
('2020-07-19','2020-07-19',15,25.990840, 79.160732 , ST_SetSRID(ST_MakePoint(79.160732  , 25.990840), 4326)),
('2020-07-19','2020-07-19',16,25.991110 , 79.160120 , ST_SetSRID(ST_MakePoint(79.160120   ,25.991110 ), 4326))
 ;
