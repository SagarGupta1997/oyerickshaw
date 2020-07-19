package com.oyerickshaw.app.service.interfaces;

import com.oyerickshaw.app.pojos.DriverInfo;

import java.util.ArrayList;

public interface DriverInfoService {
    ArrayList<DriverInfo> getDriverInfo(Double searchLat, Double searchLong, Double radius);
}
