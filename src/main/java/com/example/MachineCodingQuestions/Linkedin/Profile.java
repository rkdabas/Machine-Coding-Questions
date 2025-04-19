package com.example.MachineCodingQuestions.Linkedin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private String profilePicture;
    private String summary;
    private String headline;
    private List<Experience>experiences;
    private List<Education>educations;
    private List<Skill>skills;
}
