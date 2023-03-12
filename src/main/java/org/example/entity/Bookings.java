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
@Table(name = "bookings")
public class Bookings {
    @Id
    @Column(name = "book_ref")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String book_ref;
    @Column(name = "book_date")
    private String book_date;

    @Column(name = "total_amount")
    private double total_amount;

    @OneToMany(mappedBy = "bookings")
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Tickets> tickets;

    public Bookings(String book_date) { this.book_date = book_date;}
}
