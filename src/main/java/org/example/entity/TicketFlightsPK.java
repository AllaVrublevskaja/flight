package org.example.entity;

import java.io.Serializable;

public class TicketFlightsPK implements Serializable {
    protected int flight_id;
    protected String ticket_no;
    TicketFlightsPK(){}

    public TicketFlightsPK(int flight_id, String ticket_no) {
        this.flight_id = flight_id;
        this.ticket_no = ticket_no;
    }
}
