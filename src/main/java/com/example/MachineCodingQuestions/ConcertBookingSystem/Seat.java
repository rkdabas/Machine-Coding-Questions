package com.example.MachineCodingQuestions.ConcertBookingSystem;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat {
    private String id;
    private String number;
    private double price;
    private SeatType type;
    private SeatStatus status;

    public Seat(String id, String seatNumber, SeatType seatType, double price) {
        this.id = id;
        this.number = seatNumber;
        this.type = seatType;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public synchronized void book(){
        if(status==SeatStatus.AVAILABLE){
            status=SeatStatus.BOOKED;
        }
        else{
            throw new SeatNotAvailableException("Seat is already booked or reserved");
        }
    }

    public synchronized void release(){
        if(status==SeatStatus.BOOKED){
            status=SeatStatus.AVAILABLE;
        }

    }

}
