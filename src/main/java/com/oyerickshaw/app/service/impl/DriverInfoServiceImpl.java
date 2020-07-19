package com.oyerickshaw.app.service.impl;

import com.oyerickshaw.app.pojos.DriverInfo;
import com.oyerickshaw.app.repository.DriverDataRepository;
import com.oyerickshaw.app.service.interfaces.DriverInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class DriverInfoServiceImpl implements DriverInfoService {
    @Autowired
    DriverDataRepository driverDataRepository;
    private final static double RADIUS = 200;
    @Override
    public ArrayList<DriverInfo> getDriverInfo(Double searchLat, Double searchLon, Double radius) {
        ArrayList<DriverInfo> driverInfos = new ArrayList<>();
        try {
            if(radius == null)
                radius = RADIUS;
            driverInfos = driverDataRepository.getDriverInfo(searchLat, searchLon, radius);
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        log.info(driverInfos.toString());
        return driverInfos;
    }
}
