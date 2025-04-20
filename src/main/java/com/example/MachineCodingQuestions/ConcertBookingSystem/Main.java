package com.example.MachineCodingQuestions.ConcertBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        ConcertBookingService instance=ConcertBookingService.getInstance();

//        create concerts
        List<Seat>concert1Seats=generateSeats(100);
        Concert concert1=new Concert("001","ramanujan","dallas", LocalDateTime.now().plusDays(30),concert1Seats);
        instance.addConcert(concert1);

        List<Seat>concert2Seats=generateSeats(60);
        Concert concert2=new Concert("002","modi","iceland", LocalDateTime.now().plusDays(10),concert2Seats);
        instance.addConcert(concert2);

//        create users
        User user1=new User("U01","dimpy","dimpy@gmail.com");
        User user2=new User("U02","pimpy","pimpy@gmail.com");

//        search concerts
        List<Concert>concerts=instance.searchConcerts("modi","iceland");
        System.out.println("Searched Concert Results: ");
        for(Concert concert:concerts){
            System.out.println("Conert "+concert.getId()+" at "+concert.getVenue());
        }

//        book ticket
        List<Seat>selectedSeats1=selectSeats(concert1,3);
        Booking booking1=instance.bookTickets(user1,concert1,selectedSeats1);

        List<Seat>selectedSeats2=selectSeats(concert2,10);
        Booking booking2=instance.bookTickets(user2,concert2,selectedSeats2);

//        cancel booking
        instance.cancelTickets(booking2.getBookingId());

//        Book tickets again
        List<Seat>selectedSeats3=selectSeats(concert2,10);
        Booking booking3=instance.bookTickets(user2,concert2,selectedSeats3);

    }

    public static List<Seat>generateSeats(int numberOfSeats){
        List<Seat>seats=new ArrayList<>();
        for(int i=1;i<=numberOfSeats;i++){
            String seatNumber="S"+i;
            SeatType seatType=(i<=10)?SeatType.VIP:(i<=30)?SeatType.PREMIUM:SeatType.REGULAR;
            double price=(seatType==SeatType.VIP) ? 50.0 :(seatType==SeatType.PREMIUM)?25.0:10.0;
            seats.add(new Seat(seatNumber,seatNumber,seatType,price));
        }
        return seats;
    }

    public static List<Seat>selectSeats(Concert concert, int numberOfSeats){
        List<Seat> selectedSeats = new ArrayList<>();
        List<Seat> availableSeats = concert.getSeats().stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .limit(numberOfSeats)
                .toList();
        selectedSeats.addAll(availableSeats);
        return selectedSeats;
    }
}
