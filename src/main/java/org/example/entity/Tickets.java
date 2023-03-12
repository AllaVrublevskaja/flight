package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "tickets" )
public class Tickets {
    @Id
    @Column(name = "ticket_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ticket_no;

    @Column(name = "book_ref")
    private String book_ref;

    @Column(name = "contact_data")
    private  String contact_data;

    @Column(name = "passenger_id")
    private String passenger_id;
    @Column(name = "passenger_name")
    private String passenger_name;

    @ManyToOne
    @JoinColumn(name = "book_ref",
            referencedColumnName = "book_ref",
            insertable = false, updatable = false)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Bookings bookings;
    @OneToMany
    @JoinColumn(name = "ticket_no",
            referencedColumnName = "ticket_no",
            insertable = false, updatable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<TicketFlights> ticketFlights;

    @Override
    public String toString() {
        return ticket_no + " "+ book_ref + " " +
                contact_data + " " +
                passenger_id + " " +
                passenger_name + "\n " +
                bookings.getBook_ref() + " " +
                bookings.getBook_date() + " " +
                bookings.getTotal_amount();
       }

    public Tickets(String contact_data, String passenger_id,
                   String passenger_name
                   ) {
        this.contact_data = contact_data;
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;

    }
}
