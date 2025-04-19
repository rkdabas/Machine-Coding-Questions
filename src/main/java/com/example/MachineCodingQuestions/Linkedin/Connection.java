package com.example.MachineCodingQuestions.Linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Connection {
    private User user;
    private Timestamp connectionDate;
}
