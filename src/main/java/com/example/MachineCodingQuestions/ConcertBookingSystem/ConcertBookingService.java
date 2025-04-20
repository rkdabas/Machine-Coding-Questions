package com.example.MachineCodingQuestions.ConcertBookingSystem;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcertBookingService {
    private static ConcertBookingService instance;
    private Object lock=new Object();
    private Map<String,Concert>concerts;
    private Map<String,Booking>bookings;

    public ConcertBookingService(){
        concerts=new ConcurrentHashMap<>();
        bookings=new ConcurrentHashMap<>();
    }

    public static synchronized ConcertBookingService getInstance(){
        if(instance==null){
            instance=new ConcertBookingService();
        }
        return instance;
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getId(),concert);
    }
    public Concert getConcert(String concertId){
        return concerts.get(concertId);
    }
    public List<Concert> searchConcerts(String artist, String venue){
        List<Concert>result=new ArrayList<>();
        for(Concert concert:concerts.values()){
            if(concert.getArtist().equalsIgnoreCase(artist) &&
                    concert.getVenue().equalsIgnoreCase(venue)
            ){
                result.add(concert);
            }
        }
        return result;
    }

    public Booking bookTickets(User user,Concert concert,List<Seat>seats){
        synchronized (lock){
            for(Seat seat:seats){
                if(seat.getStatus()!=SeatStatus.AVAILABLE){
                    throw new SeatNotAvailableException("seat "+seat.getNumber()+ " is not available");
                }
            }
            for(Seat seat:seats){
                seat.book();
            }
            String bookingId=generateBookingId();
            Booking booking=new Booking(bookingId,user,concert,seats);
            bookings.put(bookingId,booking);

            makePayment();
            booking.confirmBooking();

            System.out.println("Booking "+booking.getBookingId()+" - "+booking.getSeats().size() + " seats booked");
            return booking;
        }
    }

    public void cancelTickets(String bookingId){
        Booking booking=bookings.get(bookingId);
        if(booking!=null){
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }

    public void makePayment(){
        System.out.println("making payment");
    }

    public String generateBookingId(){
        return UUID.randomUUID().toString();
    }
}
