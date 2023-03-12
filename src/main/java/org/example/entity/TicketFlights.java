package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TicketFlightsPK.class)
@Data
@NoArgsConstructor
@Table(name = "ticket_flights")
public class TicketFlights implements Serializable {
    @Id
    @Column(name = "ticket_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ticket_no;
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_id;
    @Column(name = "fare_conditions")
    private String fare_conditions;
    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "ticket_no",
            referencedColumnName = "ticket_no",
            insertable = false, updatable = false)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Tickets tickets;

    @ManyToOne
    @JoinColumn(name = "flight_id",
            referencedColumnName = "flight_id",
            insertable = false, updatable = false)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Flights flights;

    @OneToOne
    @JoinColumns({
            @JoinColumn(
                    name = "ticket_no",
                    referencedColumnName = "ticket_no"),
            @JoinColumn(
                    name = "flight_id",
                    referencedColumnName = "flight_id")
    })
    private BoardingPasses boardingPasses;

    public TicketFlights(String fare_conditions, double amount) { // , Tickets tickets) {
        this.fare_conditions = fare_conditions;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ticket_no + " " +
               flight_id + " " +
               fare_conditions + " " +
               amount + "\n " +
               tickets.getPassenger_name() + "\n" +
               flights.getStatus() + "\n" +
               "Рейс: " + boardingPasses.getBoarding_no() +
               "  Место: " + boardingPasses.getSeat_no();
    }
}
