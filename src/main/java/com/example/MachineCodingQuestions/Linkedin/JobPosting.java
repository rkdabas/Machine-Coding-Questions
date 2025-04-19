package com.example.MachineCodingQuestions.Linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Data
@AllArgsConstructor
public class JobPosting {
    private final String id;
    private final String title;
    private final String description;
    private final List<String> requirements;
    private final String location;
    private final Timestamp postDate;
}
