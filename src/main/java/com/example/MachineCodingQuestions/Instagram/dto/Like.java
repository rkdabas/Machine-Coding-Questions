package com.example.MachineCodingQuestions.Instagram.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Like {
    private Profile profile;

    public Like(Profile profile){
        this.profile=profile;
    }
}
