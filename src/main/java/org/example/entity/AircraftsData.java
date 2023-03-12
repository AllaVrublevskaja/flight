package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "aircrafts_data")
public class AircraftsData {
    @Id
    @Column(name = "aircraft_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String aircraft_code;
    @Column(name = "model")
    private String model;
    @Column(name = "range")
    private int range;

    public AircraftsData(String model, int range) {
        this.model = model;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Код самолета: " + aircraft_code + '\n' +
                "Модель самолета: " + model + '\n' +
                "Максимальная дальность полета, км: " + range;
    }
}
