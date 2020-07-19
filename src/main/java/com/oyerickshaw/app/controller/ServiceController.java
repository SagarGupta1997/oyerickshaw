package com.oyerickshaw.app.controller;

import com.oyerickshaw.app.dto.BaseResponseDto;
import com.oyerickshaw.app.pojos.DriverInfo;
import com.oyerickshaw.app.service.impl.DriverInfoServiceImpl;
import com.oyerickshaw.app.service.interfaces.DriverInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app/api")
@Slf4j
public class ServiceController {

    @Autowired
    private DriverInfoServiceImpl driverInfoService;

    @GetMapping(value = "/get_driver_info")
    public BaseResponseDto getDriversNearUser(@RequestParam("user_id") Long userId,
                                              @RequestParam("search_lat") Double searchLat,
                                              @RequestParam("search_lon") Double searchLon, @RequestParam("radius") Double radius) {
        try {
            log.info("user_id - " + userId + " search_lat - " + searchLat + " search_lon - " + searchLon);
            ArrayList<DriverInfo> driverInfoArrayList = driverInfoService.getDriverInfo(searchLat, searchLon, radius);
            for (DriverInfo driverInfo: driverInfoArrayList
                 ) {
                log.info(driverInfo.toString());

            }
            Map<String, Object> map = new HashMap<>();
            map.put("data", driverInfoArrayList);
            return new BaseResponseDto("success", 200, map);
        } catch (Exception ex) {
            log.info(String.valueOf(ex.getStackTrace()));
            return new BaseResponseDto("Some Error Occured", 400, new HashMap<String, Object>());
        }
    }

}
