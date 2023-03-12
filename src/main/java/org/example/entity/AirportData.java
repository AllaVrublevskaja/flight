package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "airports_data")
public class AirportData {
    @Id
    @Column(name = "airport_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String airport_code;
    @Column(name = "airport_name")
    private String  airport_name;
    @Column(name = "city")
    private String city;
    @Column(name = "coordinates")
    private String coordinates;
    @Column(name = "timezone")
    private String timezone;

    public AirportData(String airport_name,
                       String city,
                       String coordinates,
                       String timezone) {
        this.airport_name = airport_name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }
}
