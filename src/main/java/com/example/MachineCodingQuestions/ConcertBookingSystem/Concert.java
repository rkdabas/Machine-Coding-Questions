package com.example.MachineCodingQuestions.ConcertBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
public class Concert {
    private String id;
    private String artist;
    private String venue;
    private LocalDateTime dateTime;
    private List<Seat>seats;
}
