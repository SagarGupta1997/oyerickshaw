package com.oyerickshaw.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geolatte.geom.Point;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "driver_info")
public class DriverInfoEntity implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_on")
    private Timestamp createdOn;
    @Column(name = "updated_on")
    private Timestamp updatedOn;
    @Column(name = "driver_id" )
    private Integer driverId;
    @Column(name = "driver_lat")
    private Double driverLat;
    @Column(name = "driver_lon")
    private Double driverLon;
    @Column(name = "geom")
    private Point geom;
}
