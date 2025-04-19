package com.example.MachineCodingQuestions.Linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private User sender;
    private User receiver;
    private Timestamp timestamp;
    private String context;
}
