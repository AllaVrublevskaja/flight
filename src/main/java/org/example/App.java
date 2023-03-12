package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Bookings.class)
                .addAnnotatedClass(Tickets.class)
                .addAnnotatedClass(TicketFlights.class)
                .addAnnotatedClass(BoardingPasses.class)
                .addAnnotatedClass(Flights.class)
                .addAnnotatedClass(AircraftsData.class)
                .addAnnotatedClass(AirportData.class)
                .addAnnotatedClass(Seats.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        System.out.println("Выбрать информацию о бронировании билетов");
        System.out.println();
        String hql = "FROM Bookings";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(9);
        List<Bookings> bookings = query.getResultList();
        bookings.forEach(b->System.out.println(b.getBook_ref()+" "+
                b.getBook_date()+" "+b.getTotal_amount()));
        System.out.println();

        System.out.println("Выбрать информацию о номере бронирования CCC5CB");
        System.out.println();
        hql = "from Tickets where book_ref ='CCC5CB'";
        session.createQuery(hql)
                .getResultStream()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выбрать информацию о идентификаторе рейса 24836");
        System.out.println();
        hql = "from TicketFlights tf where tf.flight_id = 24836";
        session.createQuery(hql)
                .getResultStream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выбрать информацию о посадочных талонах");
        System.out.println();
        hql = "from BoardingPasses";
        session.createQuery(hql)
                .getResultStream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выбрать информацию о коде самолета 320");
        System.out.println();
        hql = "from AircraftsData where aircraft_code ='320'";
        session.createQuery(hql)
                .getResultStream()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выбрать информацию о месте 2А");
        System.out.println();
        hql = "from Seats where seat_no = '2A'";
        session.createQuery(hql)
                .getResultStream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Выбрать информацию о рейсе PG0405");
        System.out.println();
        hql = "from Flights where flight_no = 'PG0405'";
        session.createQuery(hql)
                .getResultStream()
                .limit(2)
                .forEach(System.out::println);
        System.out.println();

        session.close();

    }
}
