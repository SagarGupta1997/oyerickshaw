package com.oyerickshaw.app.repository;

import com.oyerickshaw.app.pojos.DriverInfo;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
@Slf4j
public class DriverDataRepository {

    @Autowired
    private HikariDataSource hikariDataSource;
    public ArrayList<DriverInfo> getDriverInfo(Double searchLat, Double searchLon, Double radius) {
        ArrayList<DriverInfo> driverInfos = new ArrayList<>();
        try {
            String sql = "SELECT driver_id, driver_lat, driver_lon, round(CAST(ST_DistanceSphere(driver_info.geom, ST_GeomFromText('POINT(" + searchLon +" "+  searchLat + ")',4326)) As numeric),2) As dist_meters FROM driver_info WHERE ST_DWithin(geom, 'SRID=4326;POINT(" + searchLon +" "+  searchLat+ ")'::geography, "+  radius +") order by dist_meters asc";
            log.info(sql);
            Connection connection = hikariDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet == null) {
                connection.close();
                return null;
            }
            while(resultSet.next()) {
                DriverInfo driverInfo = DriverInfo.builder()
                        .distance(resultSet.getDouble("dist_meters"))
                        .driverLat(resultSet.getDouble("driver_lat"))
                        .driverLon(resultSet.getDouble("driver_lon"))
                        .driverId(resultSet.getInt("driver_id"))
                        .build();
                log.info(driverInfo.toString());
                driverInfos.add(driverInfo);
            }
            log.info(resultSet.toString());
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return driverInfos;
    }
}
