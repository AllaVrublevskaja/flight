package org.example.entity;

import java.io.Serializable;

public class SeatsPK implements Serializable {
    protected String aircraft_code;
    protected  String seat_no;
    SeatsPK(){}

    public SeatsPK(String aircraft_code, String seat_no) {
        this.aircraft_code = aircraft_code;
        this.seat_no = seat_no;
    }
}
