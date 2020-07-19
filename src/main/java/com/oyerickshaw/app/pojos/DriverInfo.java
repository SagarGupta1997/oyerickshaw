package com.oyerickshaw.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class DriverInfo {
    Integer driverId;
    Double driverLat;
    Double driverLon;
    Double distance;
}
