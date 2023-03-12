package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(SeatsPK.class)
@Data
@NoArgsConstructor
@Table(name = "seats")
public class Seats {
    @Id
    @Column(name = "aircraft_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String aircraft_code;

    @Id
    @Column(name = "seat_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String seat_no;

    @Column(name = "fare_conditions")
    private  String fare_conditions;

    @ManyToOne
    @JoinColumn(name = "aircraft_code",
            referencedColumnName = "aircraft_code",
            insertable = false, updatable = false
    )
    AircraftsData aircraftsData;

    public Seats(String fare_conditions) {
        this.fare_conditions = fare_conditions;
    }

    @Override
    public String toString() {
        return  "Код самолета: " + aircraftsData.getAircraft_code() + ", " +
                "Модель: " + getAircraftsData().getModel() + ", " +
                "Дальность полета: " + aircraftsData.getRange() + "\n " +
                "Место: " + seat_no + ", " +
                "Класс обслуживания: " + fare_conditions;
    }
}
