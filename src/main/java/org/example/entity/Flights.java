package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flights")
public class Flights {
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_id;
    @Column(name = "flight_no")
    private String flight_no;
    @Column(name = "scheduled_departure")
    private String scheduled_departure;
    @Column(name = "scheduled_arrival")
    private String scheduled_arrival;
    @Column(name = "departure_airport")
    private String departure_airport;
    @Column(name = "arrival_airport")
    private String arrival_airport;
    @Column(name = "status")
    private String status;
    @Column(name = "aircraft_code")
    private String aircraft_code;
    @Column(name = "actual_departure")
    private String actual_departure;
    @Column(name = "actual_arrival")
    private String actual_arrival;

    @OneToMany(mappedBy = "flights")
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<TicketFlights> ticketFlights;

    @ManyToOne
    @JoinColumn(name = "aircraft_code",
            referencedColumnName = "aircraft_code",
            insertable = false, updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private AircraftsData aircraftsData;

    @ManyToOne
    @JoinColumn(name = "arrival_airport",
    referencedColumnName = "airport_code",
            insertable = false, updatable = false)
    AirportData airportData;

    @ManyToOne
    @JoinColumn(name = "departure_airport",
    referencedColumnName = "airport_code",
            insertable = false, updatable = false)
    AirportData airportData1;

    public Flights(String flight_no,
                   String scheduled_departure,
                   String scheduled_arrival,
                   String departure_airport,
                   String arrival_airport,
                   String status,
                   String aircraft_code,
                   String actual_departure,
                   String actual_arrival
                   ) {
        this.flight_no = flight_no;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_arrival = scheduled_arrival;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.status = status;
        this.aircraft_code = aircraft_code;
        this.actual_departure = actual_departure;
        this.actual_arrival = actual_arrival;
    }

    @Override
    public String toString() {
        return  "Номер рейса " + flight_no + "\n" +
                "Время вылета по расписанию " + scheduled_departure + '\n' +
                "Время прилёта по расписанию " + scheduled_arrival + '\n' +
                "Аэропорт отправления " + departure_airport + '\n' +
                "Аэропорт прибытия " + arrival_airport + '\n' +
                "Город " + airportData.getCity() + "\n" +
                "Статус рейса " + status + '\n' +
                "Код самолета, IATA " + aircraft_code + '\n' +
                "Модель самолета " + aircraftsData.getModel() + "\n" +
                "Максимальная дальность полета, км " + aircraftsData.getRange() +"\n" +
                "Фактическое время вылета " + actual_departure + '\n' +
                "Фактическое время прилёта " + actual_arrival + '\n';
    }
}
