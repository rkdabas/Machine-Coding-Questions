package com.example.MachineCodingQuestions.ConcertBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Booking {
    private String bookingId;
    private User user;
    private Concert concert;
    private double totalBookingPrice;
    private List<Seat>seats;
    private BookingStatus status;

    public Booking(String bookingId, User user, Concert concert, List<Seat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.totalBookingPrice=calculateBookingPrice();
        this.status=BookingStatus.PENDING;
    }

    private double calculateBookingPrice(){
        double cost=0.0;
        for(Seat seat:seats){
            cost=cost+seat.getPrice();
        }
        return cost;
    }

    public void confirmBooking(){
        if(status==BookingStatus.PENDING){
            status=BookingStatus.CONFIRMED;
            System.out.println("Sending mail to customer that seat is bookied");
        }
    }

    public void cancelBooking(){
        if(status==BookingStatus.CONFIRMED){
            status=BookingStatus.CANCELLED;
            for(Seat seat:seats){
                seat.release();
            }
            System.out.println("Booking is canceled and mail is sent");
        }
    }
}
