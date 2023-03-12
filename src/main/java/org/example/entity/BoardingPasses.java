package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@IdClass(TicketFlightsPK.class)
@Data
@NoArgsConstructor
@Table(name = "boarding_passes")
public class BoardingPasses {
    @Id
    @Column(name = "ticket_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String ticket_no;
    @Id
    @Column(name = "flight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_id;
    @Column(name = "boarding_no")
    private int boarding_no;
    @Column(name = "seat_no")
    private String seat_no;

    @OneToOne
    @JoinColumns({
    @JoinColumn(name = "ticket_no",
            referencedColumnName = "ticket_flights.ticket_no"),
    @JoinColumn(name = "flight_id",
            referencedColumnName = "ticket_flights.flight_id")
    })
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private TicketFlights ticketFlights;

    public BoardingPasses(int boarding_no, String seat_no) {
        this.boarding_no = boarding_no;
        this.seat_no = seat_no;
    }

}
